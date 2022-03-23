package br.edu.ifpb.collegialis.enumeration;

public enum ProcessoStatus {

    CRIADO("Aguardando Distribuição"), DISTRIBUIDO("Distribuído"), PAUTADO("Pautado"), JULGADO("Julgado");

    private String descricao;

    private ProcessoStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
