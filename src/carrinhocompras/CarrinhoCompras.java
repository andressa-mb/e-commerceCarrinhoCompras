package carrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

    private static CarrinhoCompras instance;
    private List<Produto> produtos;

    private CarrinhoCompras() {
        produtos = new ArrayList<>();
    }

    public static CarrinhoCompras getInstance() {
        if (instance == null) {
            instance = new CarrinhoCompras();
        }
        return instance;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
