package edu.umb.cs680.hw4;

public interface JavaQuizState {
    public void BeginQuiz(QuizContext QC);
    public void AnswerQuestion(QuizContext QC);
    public void SubmitQuiz(QuizContext QC);
}

