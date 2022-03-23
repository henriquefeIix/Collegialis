package br.edu.ifpb.collegialis.enumeration;

public enum DecisaoTipo {

    DEFERIDO("Deferido"), INDEFERIDO("Indeferido");

    private String descricao;

    private DecisaoTipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
