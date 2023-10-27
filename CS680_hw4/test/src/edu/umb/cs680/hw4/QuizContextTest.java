package edu.umb.cs680.hw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizContextTest {
    QuizContext Qc = new QuizContext(null, 21);
    @Test
    public void TestCase_GiveQuizInprogress_when_QuizIsStarted_ThenQuizResultsState(){
//        First when we call the Currentstate the state will be QuizNotStartedState , if we try to access to submit answers in the QuizNotStartedState it will give an
//        IllegalArgument Exception
        assertTrue(Qc.getCurrentState() instanceof QuizNotStartedState);
        Qc.BeginQuiz();
        assertTrue(Qc.getCurrentState() instanceof QuizInProgressState);
        Qc.AnswerQuestion();
        assertTrue(Qc.getCurrentState() instanceof QuizResultState);
//        Here The current state is the final State and if we try to access to the Questions, it will throw an IllegalArgument Exception
        assertFalse(Qc.getCurrentState() instanceof QuizInProgressState);

    }

    @Test
    public void TestCase_TrySubmitTheQuiz_BeforeStarted(){
        try{
            QuizContext Qc = new QuizContext(null,21);
            Qc.getCurrentState();
            Qc.SubmitQuiz();
            fail("Cannot submit the Quiz before Starting the Quiz");
        }catch (IllegalArgumentException e){
            System.out.println("You cannot submit the Quiz, without starting");
        }
    }

//    TestCase for Singleton class
    @Test
    public void Test_QuizNotStarted_Singleton(){
        QuizNotStartedState obj1 = QuizNotStartedState.getInstance();
        QuizNotStartedState obj2 = QuizNotStartedState.getInstance();
        assertSame(obj1, obj2);
    }


}