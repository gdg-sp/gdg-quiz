package gdgquiz.gdgsp.org.br.domain;

/**
 * Created by pveronezi on 29/07/14.
 */
public class Resposta {
    private long id;
    private String descricao;
    private boolean respostaCerta;

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

    public boolean isRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(boolean respostaCerta) {
        this.respostaCerta = respostaCerta;
    }
}
