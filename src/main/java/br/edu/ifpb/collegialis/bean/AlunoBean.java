package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.collegialis.model.Aluno;
import br.edu.ifpb.collegialis.service.AlunoController;

@Named
@ViewScoped
public class AlunoBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Aluno> alunos;

    @Inject
    private AlunoController alunoController;

    @PostConstruct
    public void init() {
        this.alunos = this.alunoController.consultar();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
