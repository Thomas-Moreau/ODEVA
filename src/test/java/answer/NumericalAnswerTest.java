package answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumericalAnswerTest extends AnswerTest<Integer> {

	@Override
	public Answer<Integer> createAnswer() {
		return new NumericalAnswer(2);
	}

	@Override
	public void answerConstructorTest() {
		NumericalAnswer num = new NumericalAnswer(2);
		assertEquals(Integer.valueOf(2), num.getGoodAnswer());
	} 
	
	@Test
	public void numericalAnswerConstructorStringTest() {
		NumericalAnswer num = new NumericalAnswer("2");
		assertEquals(Integer.valueOf(2), num.getGoodAnswer());
	}

	@Override
	public void answerGetGoodTypeTest() {
		NumericalAnswer num = new NumericalAnswer(2);
		assertEquals("numerical", num.getGoodType());
	}

	@Override
	public void answerHasGoodTypeTest() {
		NumericalAnswer num = new NumericalAnswer(2);
		assertTrue(num.hasGoodType("10"));
		assertFalse(num.hasGoodType("deux"));
	}

	@Override
	public void answerGetSetGoodAnswerTest() {
		NumericalAnswer num = new NumericalAnswer(2);
		num.setGoodAnswer(2);
		assertEquals(Integer.valueOf(2), num.getGoodAnswer());
	}

	@Override
	public void answerGiveGoodAnswerTest() {
		NumericalAnswer num = new NumericalAnswer(2);
		assertEquals("Wrong, the answer was "+num.getGoodAnswer(), num.giveGoodAnswer());
	}
	
	@Test
	public void numericalFromStringFailTest(){
		NumericalAnswer num = new NumericalAnswer("answer");
		assertEquals(Integer.valueOf(0),  num.getGoodAnswer());
		
	}
	
	

}
