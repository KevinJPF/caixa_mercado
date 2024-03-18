package Classes;

public class ItemCompra {
    
    Produto _item;
    int _quantidade;

    public ItemCompra(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
        _item = produto;
        _quantidade = quantidade;
    }

    public Produto getProdutoItem() {
        return _item;
    }

    public double getPrecoTotal() {
        return (_quantidade * _item._preco);
    }

    public int getQuantidade() {
        return _quantidade;
    }

}
