package carrinhocompras;

public class Main {

    public static void main(String[] args) {
        // Criando produtos
        Produto produto1 = ProdutoFactory.createProduto("Eletronicos", "Laptop", 1500.00);
        Produto produto2 = ProdutoFactory.createProduto("Roupas", "T-shirt", 20.00);

        // Adicionando produtos ao carrinho
        CarrinhoCompras carrinho = CarrinhoCompras.getInstance();
        carrinho.addProduto(produto1);
        carrinho.addProduto(produto2);

        // Atualizando estoque
        Estoque estoque = new Estoque();
        EstoqueObserver observer = new EstoqueObserver("Observer1");
        estoque.addObserver(observer);
        estoque.updateEstoque("Laptop", 10);
        estoque.updateEstoque("T-shirt", 50);

        // Realizando pagamento
        ContextoPagamento contextoPagamento = new ContextoPagamento();
        contextoPagamento.setStrategy(new CartaoCreditoPagamento("1234-5678-9876-5432"));
        contextoPagamento.executaPagamento(1520.00);
    }
}
