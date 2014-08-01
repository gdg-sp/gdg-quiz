package gdgquiz.gdgsp.org.br.domain;

/**
 * Created by pveronezi on 29/07/14.
 */
public class Answer {
    private long id;
    private String description;
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
