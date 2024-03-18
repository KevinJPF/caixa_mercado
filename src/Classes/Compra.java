package Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    
    List<ItemCompra> _itensCompra;
    String _caixaResponsavel;
    String _dataCompra;
    double _valorPalpite;

    public Compra(String caixaResponsavel) {
        _itensCompra = new ArrayList<>();
        _dataCompra = LocalDateTime.now().toString();
        _caixaResponsavel = caixaResponsavel;
    }

    public void adicionarProduto(ItemCompra produto) {
        _itensCompra.add(produto);
    }

    public void removerProduto(ItemCompra produto) {
        _itensCompra.remove(produto);
    }
    
    public List<ItemCompra> getItensCompra() {
        return _itensCompra;
    }
    
    public double getValorTotalCompra() {
        double valorTotalCompra = 0;

        for (ItemCompra itemCompra : _itensCompra) {
            valorTotalCompra += itemCompra.getPrecoTotal();
        }

        return valorTotalCompra;
    }

    public void setValorPalpite(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do palpite deve ser maior que zero");
        }
        _valorPalpite = valor;
    }

    public double getValorPalpite() {
        return _valorPalpite;
    }

    public ResultadoPromocao resultadoPalpite() {
        double valorTotalCompra = getValorTotalCompra();
        
        if (_valorPalpite == valorTotalCompra) {
            return ResultadoPromocao.descontoTotal;
        } else if (((int) _valorPalpite) == ((int) valorTotalCompra)) {
            return ResultadoPromocao.descontoParcial;
        } else {
            return ResultadoPromocao.descontoZero;
        }
    }

}
