package edu.umb.cs680.hw4;

public class QuizSetupState implements QuizState {
    @Override
    public void action(QuizAction QuizAction) {
        QuizAction.LoadQuestions();
        QuizAction.GiveParameters();
        QuizAction.StartQuiz();
    }
}
