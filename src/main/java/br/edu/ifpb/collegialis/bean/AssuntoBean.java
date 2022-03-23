package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.collegialis.model.Assunto;
import br.edu.ifpb.collegialis.service.AssuntoController;

@Named
@ViewScoped
public class AssuntoBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Assunto> assuntos;

    @Inject
    private AssuntoController assuntoController;

    @PostConstruct
    public void init() {
        this.assuntos = this.assuntoController.consultar();
    }

    public List<Assunto> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }

}
