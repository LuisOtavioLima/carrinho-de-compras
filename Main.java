import java.util.Scanner;

public class Main{
    public static void main(String[] args){

    Estoque meuEstoque = new Estoque();
    
        meuEstoque.adicionarProduto(new Produto("Maça", "001", 2.50, 20));
        meuEstoque.adicionarProduto(new Produto("Limão", "002", 0.50, 15));
        meuEstoque.adicionarProduto(new Produto("Sorvete", "003", 29.99, 3));

            System.out.println("Catálogo de produtos: ");
            meuEstoque.listaProdutos();
            System.out.println("-------------------------------\n");

                System.out.println("MENU: ");
                System.out.println("1: Comprar");
                System.out.println("2: Ver fatura");
                System.out.println("3: Excluir item");
                System.out.println("4: Alterar quantidade");
                System.out.println("5: Finalizar");
                System.out.println("6: Consultar produto");
                System.out.println("-------------------------------\n");
    
    Scanner scanner = new Scanner(System.in);

    Fatura minhaFatura = new Fatura(); 
    int opcao = 0;
    String codigoDigitado = "";
    int qtdDigitada = 0;

        do {

        opcao = scanner.nextInt();
        scanner.nextLine();

            switch(opcao){
                //comprar
                case 1:
                    System.out.println("Digite o código do produto: ");
                    codigoDigitado = scanner.nextLine();

                        //substitui o for
                        Produto produtoEncontrado = meuEstoque.buscarProduto(codigoDigitado);

                            if (produtoEncontrado != null){
                                System.out.println("Digite a quantidade desejada: ");
                                qtdDigitada = scanner.nextInt();
                                scanner.nextLine();

                                if (produtoEncontrado.retirarEstoque(qtdDigitada)){

                                    Item itemComprado = new Item(produtoEncontrado, qtdDigitada);
                                    minhaFatura.adicionarItem(itemComprado);
                                    System.out.println("Item comprado com sucesso!");
                                } else {
                                    System.out.println("Erro! Quantidade desejada maior que estoque");
                                }                                
                            } else {
                                System.out.println("Erro! Produto não encontrado no estoque");
                            }
                        break;
                //ver fatura
                case 2:
                    minhaFatura.verFatura();
                    break;
                //excluir item
                case 3:
                    System.out.println("Código do item que deseja excluir: ");
                    codigoDigitado = scanner.nextLine();
                    minhaFatura.excluirItem(codigoDigitado);
                    //o parâmetro da função não necessariamente deve ser atributo da classe
                    
                    break;
                //alterar quantidade item
                case 4:
                    System.out.println("Código do item que deseja alterar a quantidade: ");
                    codigoDigitado = scanner.nextLine();
                    System.out.println("Nova quantidade que deseja pro item: ");
                    qtdDigitada = scanner.nextInt();
                    scanner.nextLine();
                    minhaFatura.alterarQtd(codigoDigitado, qtdDigitada);       
                        
                    break;
                //finalizar programa
                case 5:
                    System.out.printf("Programa finalizado, fatura total: %.2f", minhaFatura.faturaTotal());
                        
                    break;
                //consultar produto
                case 6: 
                    System.out.println("Digite o código do produto para consulta: ");
                    codigoDigitado = scanner.nextLine();

                            Produto produtoConsultado = meuEstoque.buscarProduto(codigoDigitado);

                            if (produtoConsultado != null){
                                System.out.println("\n---Detalhes do produto:---\n");
                                System.out.printf("Nome: %s\n", produtoConsultado.getNome());
                                System.out.printf("Código: %s\n", produtoConsultado.getCodigo());
                                System.out.printf("Preço: %.2f\n", produtoConsultado.getPreco());
                                System.out.printf("Quantidade em estoque: %d\n", produtoConsultado.getEmEstoque());
                            } else {
                                System.out.println("Erro! Produto não existente no estoque");
                            }
                    break;
                default: 
                    System.out.println("Opção Inválida");
            }

        }while(opcao != 5);
        
        scanner.close();
    }
}
