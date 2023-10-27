package edu.umb.cs680.hw4;

public class QuizResultState implements JavaQuizState {
    private static QuizResultState instance;
    private QuizResultState(){}

    public static QuizResultState getInstance(){
        if(instance == null){
            instance = new QuizResultState();
        }
        return instance;
    }

    @Override
    public void BeginQuiz(QuizContext QC) {
        throw new IllegalArgumentException("Quiz has ended ");
    }

    @Override
    public void AnswerQuestion(QuizContext QC) {
        throw new IllegalArgumentException("your Quiz has been submitted");
    }

    @Override
    public void SubmitQuiz(QuizContext QC) {
        System.out.println("You Results are Here.!");
        QC.SetCurrentQuizState(QuizResultState.getInstance());
    }
}
