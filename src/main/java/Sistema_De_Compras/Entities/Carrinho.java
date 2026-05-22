package Sistema_De_Compras.Entities;

public class Carrinho {
    private double valorTotal;
    private int idPedidoBase;

    public Carrinho(double valorTotal, int idPedidoBase) {
        this.valorTotal = valorTotal;
        this.idPedidoBase = idPedidoBase;
    }

    public void adicionarProduto(double preco) {
        valorTotal = valorTotal + preco;
    }

    public double calcularFrete() {
        double frete;
        if (valorTotal > 500.00) {
            frete = 0.0;
        } else {
            frete = 25.00;
        }
        return frete;
    }

    public double calcularValorFinal() {
        double valorFinal = valorTotal + calcularFrete();
        return valorFinal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getIdPedidoBase() {
        return idPedidoBase;
    }
}
