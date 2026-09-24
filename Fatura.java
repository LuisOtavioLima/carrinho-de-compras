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
                this.itens.get(i).getProduto().addEstoque()
                this.itens.remove(i);
                break;
            }
        }
    }

    public void alterarQtd(String codigoDigitado, int novaQtd){
        for(int i = 0; i < this.itens.size(); i++){
            if(this.itens.get(i).getProduto().getCodigo().equals(codigoDigitado)){
                System.out.println("Quantidade alterada com sucesso!");
                System.out.printf("Quantidade antiga: %d\n", this.itens.get(i).getQtd());
                this.itens.get(i).setQtd(novaQtd);
                System.out.printf("Nova quantidade: %d\n", this.itens.get(i).getQtd());
                break;
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
