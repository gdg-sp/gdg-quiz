package br.org.gdgsp.gdgquiz.domain;

import java.util.List;

/**
 * Representa uma questão
 *
 * Created by pveronezi on 29/07/14.
 */
public class Question {
    /**
     * Id da questão
     */
    private long id;

    /**
     * A questão propriamente dita.
     */
    private String description;

    /**
     * As possiveis respostas
     */
    private List<Answer> answers;

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
