package Sistema_De_Compras.Entities;

public class Cliente {
    private String[] nomes;
    private String[] cpfs;
    private String[] enderecos;
    private boolean[] cartaoAprovado;
    private int usuarioLogado;

    public Cliente() {
        this.nomes = new String[]{"João Silva", "Maria Oliveira"};
        this.cpfs = new String[]{"123", "456"};
        this.enderecos = new String[]{"Rua A, 123", "Av. B, 456"};
        this.cartaoAprovado = new boolean[]{true, false};
    }

    public boolean verificarCliente(String cpf) {
        boolean temCliente = false;
        for (int i = 0; i < cpfs.length; i++) {
            if (cpf.equals(cpfs[i])) {
                temCliente = true;
                this.usuarioLogado = i;
                break;
            }
        }
        return temCliente;
    }

    public boolean PagamentoAutorizado() {
        return cartaoAprovado[usuarioLogado];
    }
    public String getNomeLogado() {
        return nomes[usuarioLogado];
    }

    public String getEnderecoLogado() {
        return enderecos[usuarioLogado];
    }

    public int getUsuarioLogado() {
        return usuarioLogado;
    }
}

