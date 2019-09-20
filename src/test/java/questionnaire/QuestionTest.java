package questionnaire;

import static org.junit.Assert.*;

import org.junit.Test;

import answer.Answer;

public class QuestionTest<T> {

	@Test
	public void QuestionConstructorTest(){
		String text = "text";
		Answer<T> answer = null;//new Answer<T>();
		int nbPoints = 10;
		Question question = new Question(text, answer, nbPoints);
		assertEquals(text, question.getText());
		assertEquals(answer,  question.getBuildAnswer());
		assertEquals(nbPoints,  question.getNbPoints()); 
	}
	
	@Test
	public void QuestionGetSetTextTest(){
		Question question = new Question();
		String text = "text";
		question.setText(text);
		assertEquals(text,  question.getText());
	}
	
	@Test
	public void QuestionGetSetAnswerTest(){
		Question question = new Question();
		Answer<T> answer = null;//new Answer<T>();
		question.setBuildAnswer(answer);
		assertEquals(answer,  question.getBuildAnswer());
	}
	
	@Test
	public void QuestionGetSetNbPointsTest(){
		Question question = new Question();
		int nbPoints = 10;
		question.setNbPoints(nbPoints);
		assertEquals(nbPoints,  question.getNbPoints());
	}

}
