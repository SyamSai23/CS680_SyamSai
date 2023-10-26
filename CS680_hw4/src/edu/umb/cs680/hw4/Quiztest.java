package edu.umb.cs680.hw4;

public class Quiztest {
    public static void main(String[] args) {
//      Here we have to create the instance of QuizContext and call setState method and call the actions in
//      that particular State .
//      When ever we add new State or new Actions/Behaviors, we just need to Implement the particular state from the interface
//      and write the behaviors of the particular state in Quizaction class.
        QuizContext context = new QuizContext();
        context.setState(new QuizSetupState());
        context.Quiz();
        System.out.println(" ");

        context.setState(new QuizProgreeState());
        context.Quiz();
        System.out.println(" ");

        context.setState(new QuizResultsState());
        context.Quiz();
        System.out.println(" ");
    }
}
