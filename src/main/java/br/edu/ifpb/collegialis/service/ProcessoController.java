package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.enumeration.ProcessoStatus;
import br.edu.ifpb.collegialis.interceptor.Transactional;
import br.edu.ifpb.collegialis.model.Aluno;
import br.edu.ifpb.collegialis.model.Processo;
import br.edu.ifpb.collegialis.model.Professor;
import br.edu.ifpb.collegialis.model.Usuario;
import br.edu.ifpb.collegialis.persistence.dao.ProcessoDAO;

public class ProcessoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProcessoDAO processoDAO;

    @Transactional
    public Processo atualizar(Processo processo) {
        return this.processoDAO.update(processo);
    }

    @Transactional
    public Processo cadastrar(Processo processo) {
        processo.setDataRecepcao(new Date());
        processo.setStatus(ProcessoStatus.CRIADO);
        return this.processoDAO.insert(processo);
    }

    public Processo consultar(Long id) {
        return this.processoDAO.find(id);
    }

    public List<Processo> consultar(Aluno aluno) {
        return this.processoDAO.findByRequisitante(aluno);
    }

    public List<Processo> consultar(Professor professor) {
        return this.processoDAO.findByRelator(professor);
    }

    public List<Processo> consultar(Usuario usuario) {
        return this.processoDAO.findByCoordenador(usuario);
    }

    public List<Processo> consultar(Usuario usuario, ProcessoStatus status) {
        return this.processoDAO.findByCoordenador(usuario, status);
    }

}
