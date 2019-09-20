package answer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiAnswerTest extends AnswerTest<String>{

	@Override
	public Answer<String> createAnswer() {
		List<String> list = new ArrayList<String>();
		for(int i=1; i<=5; i++) {
			list.add(String.valueOf(i)); 
		}
		return new MultiAnswer(list); 
	}

	@Override
	public void answerConstructorTest() {
		String answer = "answer";
		List<String> list = new ArrayList<String>();
		list.add(answer);
		MultiAnswer multi = new MultiAnswer(list);
		assertEquals(list,multi.getPossibleAnswers());
	}
	
	@Test
	public void multiAnswerConstructorListTest() {
		List<String> list = new ArrayList<String>();
		list.add("answer1");
		list.add("answer2");
		MultiAnswer multi = new MultiAnswer(list);
		assertEquals(list,multi.getPossibleAnswers());
	}
	
	@Test
	public void multiAnswerConstructorArrayTest() {
		String[] array = {"answer1", "answer2"};
		MultiAnswer multi = new MultiAnswer(array);
		List<String> list = new ArrayList<String>();
		for(String s : array) {
			list.add(s);
		}
		assertEquals(list,multi.getPossibleAnswers()); 
	}
	
	@Test
	public void multiAnswerGetSetPossibleAnswerTest() {
		MultiAnswer multi = new MultiAnswer();
		List<String> list = new ArrayList<String>();
		for(int i = 1; i<4; i++) {
			list.add("answer"+i);
		}
		multi.setPossibleAnswers(list);
		assertEquals(list,multi.getPossibleAnswers());
	}
	
	@Test
	public void multiAnswerIsCorrectTest() {
		String answer = "answer";
		MultiAnswer multi = new MultiAnswer("answer");
		assertTrue(multi.isCorrect(answer));
	}

	@Override
	public void answerGetGoodTypeTest() {
		MultiAnswer multi = new MultiAnswer();
		assertEquals(multi.possibleAnswers.size()+" possible answers", multi.getGoodType());
	}

	@Override
	public void answerHasGoodTypeTest() {
		MultiAnswer multi = new MultiAnswer();
		assertTrue(multi.hasGoodType("answer1"));
		assertTrue(multi.hasGoodType("145857"));
	}

	@Override
	public void answerGetSetGoodAnswerTest() {
		MultiAnswer multi = new MultiAnswer();
		multi.setGoodAnswer("answer");
		assertEquals("answer", multi.getGoodAnswer());
	}

	@Override
	public void answerGiveGoodAnswerTest() {
		List<String> list1 = new ArrayList<String>();
		list1.add("answer1");
		list1.add("answer2");
		MultiAnswer multi = new MultiAnswer(list1);
		assertEquals("Wrong, possible responses were answer1 - answer2 ", multi.giveGoodAnswer());
	}

}
