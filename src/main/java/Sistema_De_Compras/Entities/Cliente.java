package Sistema_De_Compras.Entities;

public class Cliente {
    public String[] nomes = {"João Silva", "Maria Oliveira"};
    public String[] cpfs = {"123", "456"};
    public String[] enderecos = {"Rua A, 123", "Av. B, 456"};
    public boolean[] cartaoAprovado = {true, false};
    public int usuarioLogado;

    public boolean verificarCliente(String cpf) {
        boolean temCliente = false;
        for (int i = 0; i < cpfs.length; i++) {
            if (cpf.equals(cpfs[i])) {
                temCliente = true;
                usuarioLogado = i;
                break;
            }
        }
        return temCliente;
    }

    public boolean PagamentoAutorizado() {
        boolean autorizado = false;
        if (cartaoAprovado[usuarioLogado]) {
            autorizado = true;
        }
        return autorizado;
    }
}

