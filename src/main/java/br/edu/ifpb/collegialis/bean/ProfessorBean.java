package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.collegialis.model.Professor;
import br.edu.ifpb.collegialis.service.ProfessorController;

@Named
@ViewScoped
public class ProfessorBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Professor> professores;

    @Inject
    private ProfessorController professorController;

    @PostConstruct
    public void init() {
        this.professores = this.professorController.consultar();
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

}
