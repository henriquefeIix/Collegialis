package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.collegialis.enumeration.ReuniaoStatus;
import br.edu.ifpb.collegialis.model.Reuniao;
import br.edu.ifpb.collegialis.service.ReuniaoController;

@Named
@ViewScoped
public class ReuniaoBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Inject
    private Reuniao reuniao;

    private List<Reuniao> reunioes;

    @Inject
    private ReuniaoController reuniaoController;

    @Inject
    private UsuarioBean usuarioBean;

    @PostConstruct
    private void init() {
        if (this.getRequestURL().contains("listagem")) {
            this.reunioes = this.reuniaoController.consultar(usuarioBean.getUsuario());
        } else {
            this.reunioes = this.reuniaoController.consultar(usuarioBean.getUsuario(), ReuniaoStatus.PLANEJADA);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reuniao> getReunioes() {
        return reunioes;
    }

    public void setReunioes(List<Reuniao> reunioes) {
        this.reunioes = reunioes;
    }

    public Reuniao getReuniao() {
        return reuniao;
    }

    public void setReuniao(Reuniao reuniao) {
        this.reuniao = reuniao;
    }

    public void consultar() {
        this.reuniao = this.reuniaoController.consultar(id);
    }

    public String cadastrar() {
        this.reuniao.setStatus(ReuniaoStatus.PLANEJADA);
        this.reuniao = this.reuniaoController.cadastrar(reuniao);
        this.reuniaoController.atualizar(reuniao);
        return "pretty:listagem-reunioes";
    }

}
