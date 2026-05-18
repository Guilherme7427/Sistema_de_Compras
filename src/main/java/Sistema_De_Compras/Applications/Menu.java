package Sistema_De_Compras.Applications;


import Sistema_De_Compras.Entities.Carrinho;
import Sistema_De_Compras.Entities.Cliente;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Cliente cliente = new Cliente();
    Carrinho carrinho = new Carrinho();

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
            System.out.println("Cliente: " + cliente.nomes[cliente.usuarioLogado]);

            if (cliente.PagamentoAutorizado()) {
                double frete = carrinho.calcularFrete();

                System.out.println("Valor Produtos: R$ " + carrinho.valorTotal);
                System.out.println("Frete: R$ " + (frete == 0 ? "Grátis" : frete));
                System.out.println("Total: R$ " + carrinho.calcularValorFinal());

                // Gera um número de pedido simples
                int numPedido = carrinho.idPedidoBase + cliente.usuarioLogado;

                System.out.println("Número do pedido: #" + numPedido);
                System.out.println("Enviando para: " + cliente.enderecos[cliente.usuarioLogado]);
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
