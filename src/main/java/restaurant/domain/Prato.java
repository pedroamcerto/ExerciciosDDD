package restaurant.domain;

public class Prato {
    private String nome;
    private double preco;
    private String descricao;

    public Prato(String nome, double preco, String descricao) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do prato não pode ser vazio");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição do prato não pode ser vazia");
        }
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }


    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
