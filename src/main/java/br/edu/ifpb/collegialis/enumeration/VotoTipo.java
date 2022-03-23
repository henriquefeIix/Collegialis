package br.edu.ifpb.collegialis.enumeration;

public enum VotoTipo {

    DEFERIDO("Deferido"), INDEFERIDO("Indeferido"), AUSENTE("Ausente");

    private String descricao;

    private VotoTipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
