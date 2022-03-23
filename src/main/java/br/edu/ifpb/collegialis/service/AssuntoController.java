package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.model.Assunto;
import br.edu.ifpb.collegialis.persistence.dao.AssuntoDAO;

public class AssuntoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AssuntoDAO assuntoDAO;

    public List<Assunto> consultar() {
        return this.assuntoDAO.findAll();
    }

}
