package edu.umb.cs680.hw4;

public class QuizNotStartedState implements JavaQuizState {

//    Singleton class
    private static QuizNotStartedState instance;
//    Creating an empty constructor, SO that it will prevent to instantiate Singleton class from any other class
    private QuizNotStartedState(){}
    public static QuizNotStartedState getInstance(){
        if (instance == null){
            instance =new QuizNotStartedState();
        }
        return instance;
    }
    @Override
    public void BeginQuiz(QuizContext QC) {
        System.out.println("Quiz started..");
        QC.SetCurrentQuizState(QuizInProgressState.getInstance());
    }

    @Override
    public void AnswerQuestion(QuizContext QC) {
        System.out.println("You cannot answer the ques without starting the quiz");
        throw new IllegalArgumentException("Quiz not yet started ");
    }


    @Override
    public void SubmitQuiz(QuizContext QC) {
        throw new IllegalArgumentException("You cannot submit the Quiz, without starting");
    }
}
