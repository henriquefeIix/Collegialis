package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.collegialis.model.Colegiado;
import br.edu.ifpb.collegialis.service.ColegiadoController;

@Named
@ViewScoped
public class ColegiadoBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Inject
    private Colegiado colegiado;

    private List<Colegiado> colegiados;

    @Inject
    private ColegiadoController colegiadoController;

    @PostConstruct
    public void init() {
        this.colegiados = this.colegiadoController.consultar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Colegiado> getColegiados() {
        return colegiados;
    }

    public void setColegiados(List<Colegiado> colegiados) {
        this.colegiados = colegiados;
    }

    public Colegiado getColegiado() {
        return colegiado;
    }

    public void setColegiado(Colegiado colegiado) {
        this.colegiado = colegiado;
    }

    public String cadastrar() {
        if (this.colegiadoController.isAtivo(colegiado.getCurso())) {
            this.addMessage(FacesMessage.SEVERITY_ERROR, "Desative o colegiado do curso selecionado.", null);
            return "pretty:listagem-colegiados";
        } else {
            colegiado.setDataInicio(new Date());
            this.colegiadoController.cadastrar(colegiado);
            this.addMessage(FacesMessage.SEVERITY_INFO, "Colegiado cadastrado com sucesso.", null);
            return "pretty:listagem-colegiados";
        }
    }

    public String finalizar() {
        if ((this.colegiado = this.colegiadoController.consultar(id)) == null) {
            this.addMessage(FacesMessage.SEVERITY_ERROR, "O colegiado não foi encontrado.", null);
            return "pretty:listagem-colegiados";
        } else {
            this.colegiado.setDataTermino(new Date());
            this.colegiadoController.cadastrar(colegiado);
            this.addMessage(FacesMessage.SEVERITY_INFO, "Colegiado desativado com sucesso.", null);
            return "pretty:listagem-colegiados";
        }
    }

}
