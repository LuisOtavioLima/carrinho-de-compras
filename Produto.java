public class Produto {

    private String nome;
    private String codigo;
    private double preco;
    private int emEstoque;

    public Produto(){
    }

    public Produto(String nome, String codigo, double preco, int emEstoque){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.emEstoque = emEstoque;

    }

    //substitui getValue, o código já é fornecido por getKey
    @Override 
    public String toString(){
        return this.nome + "| Preço:  " + this.preco + "| Em estoque: " + this.emEstoque;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getEmEstoque(){
        return emEstoque;
    }

    public void setEmEstoque(int emEstoque){
        this.emEstoque = emEstoque;
    }

    public void addEstoque(int emEstoque){
        this.emEstoque += emEstoque;
        System.out.println("Estoque incrementado com sucesso!");
    }

    public boolean retirarEstoque(int emEstoque){
        if (emEstoque > this.emEstoque){
            return false;
        } else {
            this.emEstoque -= emEstoque;
            System.out.println("Estoque decrementado com sucesso!");
            return true;
        }
    }
}
