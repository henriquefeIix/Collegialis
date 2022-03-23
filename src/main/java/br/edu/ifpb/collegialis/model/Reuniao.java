package br.edu.ifpb.collegialis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpb.collegialis.enumeration.ProcessoStatus;
import br.edu.ifpb.collegialis.enumeration.ReuniaoStatus;

@Entity
public class Reuniao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reuniao_sequence")
    @SequenceGenerator(name = "reuniao_sequence", sequenceName = "reuniao_seq_id", initialValue = 4, allocationSize = 1)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private String descricao;

    @ManyToOne
    private Colegiado colegiado;

    @OneToMany(mappedBy = "reuniao", cascade = { CascadeType.MERGE })
    private List<Processo> processos = new ArrayList<Processo>();

    @Enumerated(EnumType.STRING)
    private ReuniaoStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Colegiado getColegiado() {
        return colegiado;
    }

    public void setColegiado(Colegiado colegiado) {
        this.colegiado = colegiado;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public ReuniaoStatus getStatus() {
        return status;
    }

    public void setStatus(ReuniaoStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        Reuniao other = (Reuniao) obj;
        return this.id == other.id;
    }

    @PostPersist
    public void postPersist() {
        this.processos.forEach(processo -> {
            processo.setReuniao(this);
            processo.setStatus(ProcessoStatus.PAUTADO);
        });
    }

}
