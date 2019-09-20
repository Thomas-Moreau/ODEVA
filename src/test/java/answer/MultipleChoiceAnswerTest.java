package answer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MultipleChoiceAnswerTest extends AnswerTest<String>{

	@Override
	public Answer<String> createAnswer() {
		return new MultipleChoiceAnswer("answer"); 
	}

	@Override
	public void answerConstructorTest() {
		MultipleChoiceAnswer multiple = new MultipleChoiceAnswer("answer");
		assertEquals("answer", multiple.getGoodAnswer());		
	} 

	@Override
	public void answerGetGoodTypeTest() {
		MultipleChoiceAnswer multiple = new MultipleChoiceAnswer("answer");
		assertEquals("(answer)", multiple.getGoodType());		
	}

	@Override
	public void answerHasGoodTypeTest() {
		MultipleChoiceAnswer multiple = new MultipleChoiceAnswer("answer");
		assertTrue(multiple.hasGoodType("answer"));
		assertFalse(multiple.hasGoodType("answer2"));
	}

	@Override
	public void answerGetSetGoodAnswerTest() {
		List<String> list1 = new ArrayList<String>();
		list1.add("answer1");
		list1.add("answer2");
		MultipleChoiceAnswer multiple1 = new MultipleChoiceAnswer(list1, "answer1");
		assertFalse(multiple1.hasGoodType("answer3"));
		assertTrue(multiple1.hasGoodType("answer2"));
	}
	
	@Test
	public void multipleChoiceAnswerConstructorListTest() {
		List<String> list1 = new ArrayList<String>();
		list1.add("answer1");
		list1.add("answer2");
		MultipleChoiceAnswer multiple = new MultipleChoiceAnswer(list1, "answer1");
		assertEquals(list1, multiple.getChoice());
	} 
	
	@Test
	public void multipleChoiceAnswerSetChoiceTest() {
		List<String> list1 = new ArrayList<String>();
		list1.add("answer1");
		list1.add("answer2");
		MultipleChoiceAnswer multiple = new MultipleChoiceAnswer(list1, "answer1");
		List<String> list2 = new ArrayList<String>();
		list1.add("answer3");
		multiple.setChoice(list2);
		assertEquals(list2,  multiple.getChoice());
	}

	@Override
	public void answerGiveGoodAnswerTest() {
		List<String> list1 = new ArrayList<String>();
		list1.add("answer1");
		list1.add("answer2");
		MultipleChoiceAnswer multiple = new MultipleChoiceAnswer(list1, "answer1");
		assertEquals("Wrong, the answer was "+multiple.getGoodAnswer(), multiple.giveGoodAnswer());
	}

}
