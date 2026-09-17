import java.util.Scanner;

public class Main{
    public static void main(String[] args){

    Produto[] catalogo = new Produto[3];
    
        catalogo[0] = new Produto("Maça", "001", 2.50);
        catalogo[1] = new Produto("Limão", "002", 0.50);
        catalogo[2] = new Produto("Sorvete", "003", 29.99);

            System.out.printf("\n%-15s %-15s %-15s\n", "PRODUTO", "CÓDIGO", "PREÇO");
            for (int i = 0; i < catalogo.length; i++){
                System.out.printf("%-15s %-15s %-15.2f\n", catalogo[i].getNome(), catalogo[i].getCodigo(), catalogo[i].getPreco());
                System.out.printf("\n");
            }

                System.out.println("MENU: ");
                System.out.println("1: Comprar");
                System.out.println("2: Ver fatura");
                System.out.println("3: Excluir item");
                System.out.println("4: Alterar quantidade");
                System.out.println("5: Finalizar");
                System.out.printf("\n");
    
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
                    System.out.println("Digite a quantidade: ");
                    qtdDigitada = scanner.nextInt();
                    scanner.nextLine();

                        for(int i = 0; i < catalogo.length; i++){
                            if(catalogo[i].getCodigo().equals(codigoDigitado)){
                                
                                //instância do novo item
                                Item itemComprado = new Item();
                                itemComprado.setProduto(catalogo[i]);
                                itemComprado.setQtd(qtdDigitada);

                                minhaFatura.adicionarItem(itemComprado);
                                System.out.println("Item comprado com sucesso!");
                                
                                break;
                            }
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
                default: 
                    System.out.println("Opção Inválida");
            }

        }while(opcao != 5);
        
        scanner.close();
    }
}
