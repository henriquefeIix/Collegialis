package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.collegialis.model.Curso;
import br.edu.ifpb.collegialis.service.CursoController;

@Named
@ViewScoped
public class CursoBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Curso> cursos;

    @Inject
    private CursoController cursoController;

    @PostConstruct
    public void init() {
        this.cursos = this.cursoController.consultar();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
