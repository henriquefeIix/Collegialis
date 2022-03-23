package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.collegialis.enumeration.DecisaoTipo;
import br.edu.ifpb.collegialis.enumeration.ProcessoStatus;
import br.edu.ifpb.collegialis.model.Aluno;
import br.edu.ifpb.collegialis.model.Processo;
import br.edu.ifpb.collegialis.model.Professor;
import br.edu.ifpb.collegialis.service.ProcessoController;

@Named
@ViewScoped
public class ProcessoBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Inject
    private Processo processo;

    private List<Processo> processos;

    @Inject
    private ProcessoController processoController;

    @Inject
    private UsuarioBean usuarioBean;

    @PostConstruct
    public void init() {
        if (usuarioBean.getUsuario().isCoordenador()) {
            if (this.getRequestURL().contains("listagem")) {
                this.processos = this.processoController.consultar(usuarioBean.getUsuario());
            } else {
                this.processos = this.processoController.consultar(usuarioBean.getUsuario(), ProcessoStatus.DISTRIBUIDO);
            }
        } else {
            if (usuarioBean.getUsuario().isAluno()) {
                this.processos = this.processoController.consultar((Aluno) usuarioBean.getUsuario());
            } else {
                this.processos = this.processoController.consultar((Professor) usuarioBean.getUsuario());
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }
    
    public DecisaoTipo[] getDecisoes() {
        return DecisaoTipo.values();
    }

    public void consultar() {
        this.processo = this.processoController.consultar(id);
    }

    public String cadastrar() {
        if (this.processo.getId() == null) {
            this.processoController.cadastrar(processo);
            return "pretty:listagem-processos";
        } else {
            this.processoController.atualizar(processo);
            return "pretty:listagem-processos";
        }
    }

    public String salvarRelator() {
        this.processo.setStatus(ProcessoStatus.DISTRIBUIDO);
        this.processoController.atualizar(processo);
        return "pretty:listagem-processos";
    }

}
