package edu.umb.cs680.hw4;

public class QuizAction {
    public int LoadQuestions(){
        System.out.println("The questions are getting loaded...");
        return 10;
    }
    public void GiveParameters(){
        System.out.println("Setup the time limit and difficulty level of the quizz..");

    }
    public void StartQuiz(){
        System.out.println("Start the quiz..");
    }
    public void DisplayQuestions(){
        System.out.println("Displayed the questions..");
    }
    public char Answer(){
        System.out.println("Select the answer..");
        return 'a';
    }
    public void QuizProgress(){
        System.out.println("Will show the number of questions answerd and the time remainning.");
    }
    public void Navigate(){
        System.out.println("Allows to navigate forward or backward ");
    }
    public void Submit(){
        System.out.println("This will end the Quiz.");
    }
    public int Score(){
        System.out.println("The Score is 100 ");
        return 95;
    }
    public void Feedback(){
        System.out.println("Feedback on correct and incorrect answers ");
    }
    public void Performance(){
        System.out.println("you will get the users performance..");
    }
    public void ReviewQuiz(){
        System.out.println("Review all the questions in the quiz");
    }


}
