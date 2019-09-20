package questionnaire;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;


public class QuestionnaireFactoryTest {

	@Test
	public void questionnaireFactoryCreateQuestionTest(){
		QuestionnaireFactory factory = new QuestionnaireFactory();
		Question q = new Question();
		try {
			q = factory.createQuestion("text", "TextualAnswer", "answer", "10");
		} catch (ClassNotFoundException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		} catch (SecurityException e) {
			fail();
		} catch (InstantiationException e) { 
			fail();
		} catch (IllegalAccessException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		} catch (InvocationTargetException e) {
			fail();
		} catch (IOException e) {
			fail();   
		}
		assertEquals( 10 , q.getNbPoints());
		assertEquals( "text" , q.getText());
		assertEquals( "answer", q.getBuildAnswer().getGoodAnswer());
		
	}
	
	@Test (expected = NumberFormatException.class)
	public void questionnaireFactoryCreateQuestionExceptionTest() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		QuestionnaireFactory factory = new QuestionnaireFactory();
		Question q = new Question();
		q = factory.createQuestion("text", "TextualAnswer", "answer", "points");
		fail();	
		
	}
	
	@Test
	public void questionnaireFactoryCreateQuestionnaireTest() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		QuestionnaireFactory factory = new QuestionnaireFactory();
		Questionnaire questionnaire = factory.createQuestionnaire("question_tolkien_3.txt");
		assertEquals(7, questionnaire.getQuestions().size());
	}
}
