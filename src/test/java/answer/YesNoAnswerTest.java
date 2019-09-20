package answer;

import static org.junit.Assert.*;

import org.junit.Test;

public class YesNoAnswerTest extends AnswerTest<Boolean> {

	
	@Override
	public Answer<Boolean> createAnswer() {
		return new YesNoAnswer(true);
	}

	@Override
	public void answerConstructorTest() {
		YesNoAnswer yesNoAnswer = new YesNoAnswer(true);
		assertTrue(yesNoAnswer.getGoodAnswer());
		
	}
	
	@Test
	public void yesNoAnswerConstructorStringTest() {
		YesNoAnswer yesAnswer = new YesNoAnswer("yes");
		YesNoAnswer noAnswer = new YesNoAnswer("no");
		assertTrue(yesAnswer.getGoodAnswer());
		assertFalse(noAnswer.getGoodAnswer());
	}

	@Override
	public void answerGetGoodTypeTest() {
		YesNoAnswer yesNoAnswer = new YesNoAnswer(true);
		assertEquals("yes/no", yesNoAnswer.getGoodType());
	}

	@Override
	public void answerHasGoodTypeTest() {
		YesNoAnswer yesNoAnswer = new YesNoAnswer(true);
		assertTrue(yesNoAnswer.hasGoodType("yes"));
		assertTrue(yesNoAnswer.hasGoodType("no"));
		assertFalse(yesNoAnswer.hasGoodType("true"));
		assertFalse(yesNoAnswer.hasGoodType("false"));
	} 

	@Override
	public void answerGetSetGoodAnswerTest() {
		YesNoAnswer yesNoAnswer = new YesNoAnswer("yes");
		assertEquals(true, yesNoAnswer.getGoodAnswer());
		yesNoAnswer.setGoodAnswer(false);
		assertEquals(false, yesNoAnswer.getGoodAnswer()); 
	}
	
	@Test
	public void yesNoAnswerIsCorrectTest() {
		YesNoAnswer yesNoAnswer = new YesNoAnswer("yes");   
		assertTrue(yesNoAnswer.isCorrect("yes"));
		assertFalse(yesNoAnswer.isCorrect("true"));
		yesNoAnswer.setGoodAnswer(false);
		assertTrue(yesNoAnswer.isCorrect("no"));
		assertFalse(yesNoAnswer.isCorrect("false"));
	}

	@Override
	public void answerGiveGoodAnswerTest() {
		YesNoAnswer yesNoAnswer = new YesNoAnswer("yes"); 
		assertEquals("Wrong, the answer was yes", yesNoAnswer.giveGoodAnswer());
		yesNoAnswer.setGoodAnswer(false);
		assertEquals("Wrong, the answer was no", yesNoAnswer.giveGoodAnswer());
	}

}
