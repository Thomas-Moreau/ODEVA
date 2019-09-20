package questionnaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import answer.TextualAnswer;

public class QuestionnaireTest {
	
	@Test
	public void questionnaireGetSetScoreUserTest() {
		Questionnaire q = new Questionnaire();
		q.setScoreUser(10);
		assertEquals(10, q.getScoreUser());
	}
	
	@Test
	public void questionnaireAddQuestionTest(){
		Questionnaire q = new Questionnaire();
		assertTrue(q.questions.isEmpty());
		Question question = new Question("question1", new TextualAnswer("answer1"), 10);
		q.addQuestion(question);
		assertEquals(1, q.questions.size());
	}
	
	@Test
	public void questionnaireSetQuestionsTest(){
		Questionnaire q = new Questionnaire();
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question());
		q.setQuestions(questions);
		assertEquals(questions, q.getQuestions());
	}
	
}
