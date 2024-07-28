package carrinhocompras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Observer {

    void update(String produtoNome, int quantidade);
}

class Estoque {

    private List<Observer> observers = new ArrayList<>();
    private Map<String, Integer> produtoEstoque = new HashMap<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void updateEstoque(String produtoNome, int quantidade) {
        produtoEstoque.put(produtoNome, quantidade);
        notifyObservers(produtoNome, quantidade);
    }

    private void notifyObservers(String produtoNome, int quantidade) {
        for (Observer observer : observers) {
            observer.update(produtoNome, quantidade);
        }
    }
}

class EstoqueObserver implements Observer {

    private String nome;

    public EstoqueObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String produtoNome, int quantidade) {
        System.out.println("Estoque " + nome + ": Produto " + produtoNome + " agora tem a quantidade " + quantidade);
    }
}
