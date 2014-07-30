package gdgquiz.gdgsp.org.br.domain;

import java.util.List;

/**
 * Created by pveronezi on 29/07/14.
 */
public class Questao {
    private long id;
    private String descricao;
    private List<Resposta> respostas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
}
