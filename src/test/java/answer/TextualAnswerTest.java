package answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TextualAnswerTest extends AnswerTest<String> {

	@Override
	public Answer<String> createAnswer() {
		return new TextualAnswer("test");
	}

	@Override
	public void answerConstructorTest() {
		TextualAnswer ta = new TextualAnswer("test");
		assertEquals("test", ta.getGoodAnswer()); 
		assertTrue(ta.isCorrect("test"));
	}

	@Override
	public void answerGetGoodTypeTest() {
		TextualAnswer ta = new TextualAnswer("test");
		assertEquals("symbolique", ta.getGoodType());
	}

	@Override
	public void answerHasGoodTypeTest() {
		TextualAnswer ta = new TextualAnswer("test");
		assertTrue(ta.hasGoodType("2"));
	}

	@Override
	public void answerGetSetGoodAnswerTest() {
		TextualAnswer ta = new TextualAnswer("test");
		ta.setGoodAnswer("text");
		assertEquals("text", ta.getGoodAnswer());
	}

	@Override
	public void answerGiveGoodAnswerTest() {
		TextualAnswer ta = new TextualAnswer("test");
		assertEquals("Wrong, the answer was "+ta.getGoodAnswer(), ta.giveGoodAnswer());
	}
	
	

	

}
