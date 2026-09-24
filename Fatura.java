import java.util.ArrayList;

public class Fatura {
     
    private ArrayList<Item> itens;

    public Fatura(){
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item novoItem){
        this.itens.add(novoItem);
    }

    public void excluirItem(String codigoDesejado){
        for(int i = 0; i < this.itens.size(); i++){
            if(this.itens.get(i).getProduto().getCodigo().equals(codigoDesejado)){

                int qtdDevolvida = this.itens.get(i).getQtd();

                    this.itens.get(i).getProduto().addEstoque(qtdDevolvida);
                
                        this.itens.remove(i);
                        System.out.println("Item removido e estoque restaurado");
                break;
            }
        }
    }

    public void alterarQtd(String codigoDigitado, int novaQtd){
        for(int i = 0; i < this.itens.size(); i++){
            if(this.itens.get(i).getProduto().getCodigo().equals(codigoDigitado)){

                Item atual = this.itens.get(i);
                int qtdAntiga = atual.getQtd();

                    if(novaQtd > (atual.getProduto().getEmEstoque() + qtdAntiga)){
                        System.out.println("Erro, estoque insuficiente");
                    } else {

                        //diff positiva, quero mais, tenho menos, retira estoque
                        if(novaQtd > qtdAntiga){
                            int diff = novaQtd - qtdAntiga;
                            atual.getProduto().retirarEstoque(diff);
                            System.out.println("Quantidade acrescida com sucesso!");

                        //diff "negativa", quero menos, tenho mais, adiciona estoque
                        } else if (novaQtd < qtdAntiga){
                            int diff = qtdAntiga - novaQtd;
                            atual.getProduto().addEstoque(diff);
                            System.out.println("Quantidade reduzida com sucesso!");
                        } else {
                            System.out.println("Nova quantidade igual à antiga!");
                        }
                
                                System.out.printf("\nQuantidade antiga: %d\n", qtdAntiga);
                                atual.setQtd(novaQtd);
                                System.out.printf("\nNova quantidade: %d\n", atual.getQtd());
                                break;
                        
                    }
            }
        }                   
    }
    

    public double faturaTotal(){

        double total = 0;

        for(int i = 0; i < this.itens.size(); i++){
            total+= this.itens.get(i).valorTotal();
        }
    return total;
    }

    public void verFatura(){
        System.out.println("Sua fatura: ");
        
        for(int i = 0; i < this.itens.size(); i ++){
            System.out.println("Item: " + this.itens.get(i).getProduto().getNome());
            System.out.println("Quantidade: " + this.itens.get(i).getQtd());
        }
        System.out.printf("Valor total da fatura: %.2f", (faturaTotal()));
    }    
}
