import java.util.HashMap;

public class Estoque {
    
    HashMap<String, Produto> produtos = new HashMap<>();
    private int tamanho = 0;

    public boolean adicionarProduto(Produto novoProduto){
        if (this.produtos.containsKey(novoProduto.getCodigo())){
            System.out.println("Produto já existente no estoque")
            return false;
        } else {
            this.produtos.put(novoProduto.getCodigo(), novoProduto);
            this.tamanho++;
            System.out.println("Produto adicionado com sucesso!");
            return true;
        }
    }   
    

    public Produto buscarProduto(String codigo){
        return this.produtos.get(codigo);
    }

    public void removerProduto(String codigo){
        if (this.produtos.containsKey(codigo)){
            this.produtos.remove(codigo);
            this.tamanho--;
        } else {
            System.out.println("Produto não existe no estoque");
        }
    }

    public boolean verificarExistencia(String codigo){
        if (this.produtos.containsKey(codigo)){
            return true;
        } else {
            return false;
        }
    }

    public void listaProdutos(){
        for (var entrada : produtos.entrySet()){
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }
        
}

