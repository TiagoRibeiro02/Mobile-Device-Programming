package pt.ubi.di.pdm.a46346_t6;

import java.util.Random;

public class Question {
    private int fnumber;
    private int snumber;
    private int answer;

    //signal of the questions: + - * /
    private int signal;

    //maximum value of the numbers
    private int limit;

    //display e.g 1+2
    private String  questionPhrase;

    //generate random question
    public Question(int limit, int signal){
        this.limit = limit;
        Random random = new Random();

        this.fnumber = random.nextInt(limit);
        this.snumber = random.nextInt(limit);
        if (signal == 1) {
            this.answer = this.fnumber + this.snumber;
            this.questionPhrase = fnumber + "+" + snumber;
        }
        else if (signal == 2){
            this.answer = this.fnumber - this.snumber;
            this.questionPhrase = fnumber + "-" + snumber;
        }
        else if (signal == 3){
            this.answer = this.fnumber * this.snumber;
            this.questionPhrase = fnumber + "x" + snumber;
        }
        else if (signal == 4){
            this.answer = this.fnumber / this.snumber;
            this.questionPhrase = fnumber + "/" + snumber;
        }
    }

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public int getFnumber() {
        return fnumber;
    }

    public void setFnumber(int fnumber) {
        this.fnumber = fnumber;
    }

    public int getSnumber() {
        return snumber;
    }

    public void setSnumber(int snumber) {
        this.snumber = snumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
