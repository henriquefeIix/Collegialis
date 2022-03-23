package br.edu.ifpb.collegialis.enumeration;

public enum ReuniaoStatus {

    ENCERRADA("Encerrada"), PLANEJADA("Planejada");

    private String descricao;

    private ReuniaoStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
