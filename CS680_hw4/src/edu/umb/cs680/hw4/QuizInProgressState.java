package edu.umb.cs680.hw4;

public class QuizInProgressState implements JavaQuizState {
//  Making class as Singleton
    private static QuizInProgressState instance;
    private QuizInProgressState(){}
    public static QuizInProgressState getInstance(){
        if(instance==null){
            instance = new QuizInProgressState();
        }
        return instance;
    }


    @Override
    public void BeginQuiz(QuizContext QC) {
        throw new IllegalArgumentException("Quiz has already begun , you cannot start again.");
    }

    @Override
    public void AnswerQuestion(QuizContext QC) {
        System.out.println("Completed answering the questions");
        QC.SetCurrentQuizState(QuizResultState.getInstance());
    }


    @Override
    public void SubmitQuiz(QuizContext QC) {
        throw new IllegalArgumentException("Cannot sumbit the Quiz, without answering all the Questions ");
    }
}
