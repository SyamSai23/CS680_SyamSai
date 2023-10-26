package edu.umb.cs680.hw4;

// we have to create a class that will use the  QuizState interface for connecting with the different types of states.

// Then we have to call the actions that are there in the specific state .
public class QuizContext {
    private QuizState state = null;
    private QuizAction QuizAction = new QuizAction();
    public void setState(QuizState state) {
        this.state = state;
    }
    public QuizState getState() {
        return state;
    }

    public void Quiz() {
        state.action(QuizAction);
    }


}
