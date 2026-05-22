package Sistema_De_Compras.Applications;


import Sistema_De_Compras.Entities.Carrinho;
import Sistema_De_Compras.Entities.Cliente;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Cliente cliente = new Cliente();
    Carrinho carrinho = new Carrinho(0.0, 1000);

    public void menuPrincipal() {
        System.out.print("Quantos produtos deseja adicionar? ");
        int qtd = sc.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Preço do produto " + (i + 1) + ": ");
            carrinho.adicionarProduto(sc.nextDouble());
        }

        System.out.print("Informe seu CPF: ");
        String cpf = sc.next();

        if (cliente.verificarCliente(cpf)) {
            // AJUSTADO: Usando o método que criamos na classe Cliente
            System.out.println("Cliente: " + cliente.getNomeLogado());

            if (cliente.PagamentoAutorizado()) {
                double frete = carrinho.calcularFrete();

                System.out.println("Valor Produtos: R$ " + carrinho.getValorTotal());
                System.out.println("Frete: R$ " + (frete == 0 ? "Grátis" : frete));
                System.out.println("Total: R$ " + carrinho.calcularValorFinal());

                // AJUSTADO: Usando métodos para o cálculo do pedido
                int numPedido = carrinho.getIdPedidoBase() + cliente.getUsuarioLogado();

                System.out.println("Número do pedido: #" + numPedido);
                // AJUSTADO: Usando o método de endereço do Cliente
                System.out.println("Enviando para: " + cliente.getEnderecoLogado());
                System.out.println("Compra realizada com sucesso.");
            } else {
                System.out.println("Pagamento não autorizado.");
                System.out.println("Pedido encerrado.");
            }
        } else {
            System.out.println("CPF não encontrado!");
        }
    }
}
