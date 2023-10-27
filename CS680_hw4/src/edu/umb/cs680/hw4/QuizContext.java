package edu.umb.cs680.hw4;

public class QuizContext {

    private JavaQuizState CurrentState;
    private int BeaconId;

    public QuizContext(JavaQuizState CurrentState, int BeaconId){
        super();
//      here super() method will call the object of Parent  class first and this method will give the object of current class
        this.CurrentState = CurrentState;
        this.BeaconId = BeaconId;

        if(CurrentState == null) {
            this.CurrentState = QuizNotStartedState.getInstance();
        }
    }
// implement Getter and Setter method for interface to get the currentState value
    public JavaQuizState getCurrentState(){
        return CurrentState;
    }

    public void SetCurrentQuizState(JavaQuizState currentState) {
        this.CurrentState =currentState;
    }

    public int getBeaconId(){
        return BeaconId;
    }

    public void BeginQuiz(){
        CurrentState.BeginQuiz(this);
    }
    public void AnswerQuestion(){
        CurrentState.AnswerQuestion(this);
    }
    public void SubmitQuiz(){
        CurrentState.SubmitQuiz(this);
    }

    public static void main(String[] args){
        QuizContext Qc = new QuizContext(null, 21);
        Qc.getCurrentState();
        Qc.BeginQuiz();
    }

}

