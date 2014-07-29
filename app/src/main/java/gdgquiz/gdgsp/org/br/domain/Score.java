package gdgquiz.gdgsp.org.br.domain;

import android.media.Image;

import java.util.Date;

/**
 * Classe que representa o Score do jogador
 *
 * Created by pveronezi on 27/07/14.
 */
public class Score {
    /**
     * Numero de identificação do objeto.
     */
    private long id;

    // TODO verificar que tipo de imagem é essa
    /**
     *
     */
    private byte[] imagem;

    /**
     * Nome com 3 letras que identifica o jogador
     */
    private String nome;

    /**
     * Se verdadeiro ele ganhou nesse quiz
     */
    private boolean vitoria;

    /**
     * Quanto tempo levou o quiz em minutos
     */
    private int tempo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVitoria() {
        return vitoria;
    }

    public void setVitoria(boolean vitoria) {
        this.vitoria = vitoria;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
