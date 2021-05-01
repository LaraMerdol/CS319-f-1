package com.project.cs319.Entity;
import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question
{
    private ArrayList<String> choices;
   // private ArrayList<Integer> answers;

    public MultipleChoiceQuestion(String question, ArrayList<String> choices)
    {
        super(question,"multiple-choice");
        setChoices(choices);
       // setAnswers(answers);
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    /*
    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Integer> answers) {
        this.answers = answers;
    }

     */
}
