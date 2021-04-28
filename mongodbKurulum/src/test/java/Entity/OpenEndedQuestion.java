package Entity;
public class OpenEndedQuestion extends Question
{
    private String answer;

    public OpenEndedQuestion(String question, String answer)
    {
        super(question,"open-ended");
        setAnswer(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
