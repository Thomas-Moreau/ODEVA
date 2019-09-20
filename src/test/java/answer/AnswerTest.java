package answer;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class AnswerTest<T>{
	
	Answer<T> answer;
	
	@Test
	public void answerToStringTest() {
		Answer <T> answer = this.createAnswer();
		assertEquals(answer.getGoodAnswer().toString(), answer.toString());
	}

	public abstract Answer<T> createAnswer();
	
	@Test
	public abstract void answerConstructorTest();
	
	@Test
	public abstract void answerGetGoodTypeTest();
	
	@Test
	public abstract void answerHasGoodTypeTest();
	
	@Test
	public abstract void answerGetSetGoodAnswerTest();
	
	@Test
	public abstract void answerGiveGoodAnswerTest();

}
