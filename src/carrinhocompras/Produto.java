package carrinhocompras;

abstract class Produto {

    protected String nome;
    protected double preco;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Eletronicos extends Produto {

    public Eletronicos(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

class Roupas extends Produto {

    public Roupas(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

class ProdutoFactory {

    public static Produto createProduto(String tipo, String nome, double preco) {
        switch (tipo) {
            case "Eletronicos":
                return new Eletronicos(nome, preco);
            case "Roupas":
                return new Roupas(nome, preco);
            default:
                throw new IllegalArgumentException("Não temos esse tipo de produto");
        }
    }
}
