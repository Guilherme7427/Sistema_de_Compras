package Sistema_De_Compras.Entities;

public class Carrinho {
    public double valorTotal;
    public int idPedidoBase = 1000;

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
    }
