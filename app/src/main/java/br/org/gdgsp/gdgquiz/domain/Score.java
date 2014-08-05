package br.org.gdgsp.gdgquiz.domain;

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

    /**
     * Nome com 3 letras que identifica o jogador
     */
    private String name;

    /**
     * Se verdadeiro ele ganhou nesse quiz
     */
    private boolean victory;

    /**
     * Quantidade de perguntas acertadas
     */
    private int qtdQuestions;

    /**
     * Quanto time levou o quiz em minutos
     */
    private int time;

    public int getQtdQuestions() {
        return qtdQuestions;
    }

    public void setQtdQuestions(int qtdQuestions) {
        this.qtdQuestions = qtdQuestions;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", victory=" + victory +
                ", qtdQuestions=" + qtdQuestions +
                ", time=" + time +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
