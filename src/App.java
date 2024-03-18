import java.text.DecimalFormat;
import java.util.Scanner;

import Classes.Compra;
import Classes.ItemCompra;
import Classes.Produto;
import Classes.ResultadoPromocao;

public class App {
    public static void main(String[] args) {
        // Criar produtos
        Produto arroz = new Produto("Arroz", 10.0);
        Produto feijao = new Produto("Feijão", 8.3);
        Produto macarrao = new Produto("Macarrão", 5.0);

        // Criar uma compra
        Compra compra = new Compra("Caixa 1");

        // Adicionar produtos à compra
        compra.adicionarProduto(new ItemCompra(arroz, 2));
        compra.adicionarProduto(new ItemCompra(feijao, 1));
        compra.adicionarProduto(new ItemCompra(macarrao, 3));

        // Informar o valor do palpite
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o valor do palpite para o total da compra:");
        double palpite = scanner.nextDouble();
        compra.setValorPalpite(palpite);

        // Calcular o resultado do palpite e o valor a ser pago
        ResultadoPromocao resultado = compra.resultadoPalpite();
        double valorTotalCompra = compra.getValorTotalCompra();
        double valorPago;

        switch (resultado) {
            case descontoTotal:
                valorPago = 0.0;
                break;
            case descontoParcial:
                valorPago = valorTotalCompra * 0.7;
                break;
            case descontoZero:
            default:
                valorPago = valorTotalCompra;
                break;
        }
        
        DecimalFormat df = new DecimalFormat("#.##");

        // Imprimir o valor a ser pago
        System.out.println("O cliente deverá pagar: R$ " + df.format(valorPago));

        // Imprimir recibo de compra
        System.out.println("Recibo de compra:");
        for (ItemCompra item : compra.getItensCompra()) {
            System.out.println("Produto: " + item.getProdutoItem().getNome() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Preço total: R$ " + item.getPrecoTotal());
        }
    }
}
