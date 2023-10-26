package edu.umb.cs680.hw4;

public class QuizProgreeState implements QuizState {

    @Override
    public void action(QuizAction QuizAction) {
        QuizAction.DisplayQuestions();
        QuizAction.Answer();
        QuizAction.QuizProgress();
        QuizAction.Navigate();
        QuizAction.Submit();
    }
}
