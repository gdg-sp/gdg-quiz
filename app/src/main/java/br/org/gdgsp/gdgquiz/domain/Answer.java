package br.org.gdgsp.gdgquiz.domain;

/**
 * Representa uma possivel resposta de uma questão.
 *
 * Created by pveronezi on 29/07/14.
 */
public class Answer {
    /**
     * Id da Resposta
     */
    private long id;

    /**
     * Descreve a resposta
     */
    private String description;

    /**
     * Se é a resposta certa.
     */
    private boolean rightAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
