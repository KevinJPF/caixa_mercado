package Classes;

public class Produto {

    String _nome;
    double _preco;
    
    public Produto(String nome, double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O preco do produto deve ser maior que zero");
        }
        _nome = nome;
        _preco = preco;
    }

    public String getNome() {
        return _nome;
    }

    public double getPreco() {
        return _preco;
    }
}