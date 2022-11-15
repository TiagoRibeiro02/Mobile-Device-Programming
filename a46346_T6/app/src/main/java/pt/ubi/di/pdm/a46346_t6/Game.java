package pt.ubi.di.pdm.a46346_t6;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Question> questions;
    private int numbercorretans;
    private int score;



    private Question currentQuestion;
    private int totalquestions;

    public Game() {
        questions = new ArrayList<Question>();
        numbercorretans = 0;
        score = 0;
        totalquestions = 0;
        currentQuestion = new Question(10, 1);
    }

    public void makeNewQuestionPlus(){
        currentQuestion = new Question(totalquestions * 2 + 3, 1);
        totalquestions++;
        questions.add(currentQuestion);
    }

    public void makeNewQuestionMinus(){
        currentQuestion = new Question(totalquestions * 2 + 3, 2);
        totalquestions++;
        questions.add(currentQuestion);
    }

    public void makeNewQuestionTimes(){
        currentQuestion = new Question(totalquestions * 2 + 3, 3);
        totalquestions++;
        questions.add(currentQuestion);
    }

    public void makeNewQuestionDivision(){
        currentQuestion = new Question(totalquestions * 2 + 3, 4);
        totalquestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int subAnswer){
        boolean iscorrect;
        if (currentQuestion.getAnswer() == subAnswer){
            numbercorretans++;
            iscorrect = true;
        }
        else {
            iscorrect = false;
        }
        score = numbercorretans;
        return iscorrect;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumbercorretans() {
        return numbercorretans;
    }

    public void setNumbercorretans(int numbercorretans) {
        this.numbercorretans = numbercorretans;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getTotalquestions() {
        return totalquestions;
    }

    public void setTotalquestions(int totalquestions) {
        this.totalquestions = totalquestions;
    }

}
