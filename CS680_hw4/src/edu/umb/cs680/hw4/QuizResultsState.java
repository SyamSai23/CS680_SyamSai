package edu.umb.cs680.hw4;

public class QuizResultsState implements QuizState {

    @Override
    public void action(QuizAction QuizAction) {
        QuizAction.Score();
        QuizAction.Feedback();
        QuizAction.Performance();
        QuizAction.ReviewQuiz();
    }
}
