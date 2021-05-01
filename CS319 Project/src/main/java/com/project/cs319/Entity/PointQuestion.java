package com.project.cs319.Entity;
import java.util.ArrayList;

public class PointQuestion extends Question
{
    private int outOfGrade;
    //private int answerGrade;

    public PointQuestion(String question, int outOfGrade)
    {
        super(question,"point-type");
        setOutOfGrade(outOfGrade);
        //setAnswerGrade(answerGrade);
    }

    public int getOutOfGrade() {
        return outOfGrade;
    }

    public void setOutOfGrade(int outOfGrade) {
        this.outOfGrade = outOfGrade;
    }

    /*
    public int getAnswerGrade() {
        return answerGrade;
    }

    public void setAnswerGrade(int answerGrade) {
        this.answerGrade = answerGrade;
    }

     */
}
