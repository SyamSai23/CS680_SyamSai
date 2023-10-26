package edu.umb.cs680.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizContextTest {
    private static QuizContext context;
    private static QuizAction QuizAction;

    @BeforeAll
    public static void setUp(){
        context = new QuizContext();
        QuizAction = new QuizAction();
    }
// Verifying State whether expected and actual are same
    @Test
    public void TestQuizSetUpState(){
        QuizSetupState expectedState = new QuizSetupState();
        context.setState(expectedState);
        assertSame(expectedState, context.getState());
//       Checking whether , when you call the action , the actual value and expected value are same.
        QuizAction quizaction = new QuizAction();
        expectedState.action(quizaction);
        int expectedACtion = 10;
        assertEquals(expectedACtion, QuizAction.LoadQuestions());
    }

    @Test
    public void TestQuizProgressState(){
        QuizProgreeState expectedState = new QuizProgreeState();
        context.setState(expectedState);
        assertSame(expectedState, context.getState());

        QuizAction quizAction = new QuizAction();
        expectedState.action(quizAction);
        char expectedAction = 'a';
        assertEquals(expectedAction,quizAction.Answer());
    }
    @Test
    public void TestQuizResultsState(){
        QuizResultsState expectedState = new QuizResultsState();
        context.setState(expectedState);
        assertSame(expectedState, context.getState());

        QuizAction quizAction = new QuizAction();
        expectedState.action(quizAction);
        int ExpectedScore = 95;
        assertEquals(ExpectedScore, quizAction.Score());
    }

}