package carrinhocompras;

interface PagamentoStrategy {

    void pagamento(double valor);
}

class CartaoCreditoPagamento implements PagamentoStrategy {

    private String numeroCartao;

    public CartaoCreditoPagamento(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void pagamento(double valor) {
        System.out.println("Pago " + valor + " usando Cartão de Crédito.");
    }
}

class PixPagamento implements PagamentoStrategy {

    private String email;

    public PixPagamento(String email) {
        this.email = email;
    }

    @Override
    public void pagamento(double valor) {
        System.out.println("Pago " + valor + " usando Pix.");
    }
}

class ContextoPagamento {

    private PagamentoStrategy strategy;

    public void setStrategy(PagamentoStrategy strategy) {
        this.strategy = strategy;
    }

    public void executaPagamento(double valor) {
        strategy.pagamento(valor);
    }
}
