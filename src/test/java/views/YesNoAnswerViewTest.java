package views;

import static org.junit.Assert.*;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.junit.Test;

import answer.YesNoAnswer;

public class YesNoAnswerViewTest extends AnswerViewTest{

	@Override
	public void answerGetUserAnswerTest() {
		YesNoAnswer yes = new YesNoAnswer(true);
		YesNoAnswerView yesNo = new YesNoAnswerView(yes);
		
		yesNo.getButtonYes().setSelected(true);
		assertEquals("Yes", yesNo.getUserAnswer());
		
		yesNo.getButtonYes().setSelected(false);
		yesNo.getButtonNo().setSelected(true);
		assertEquals("No", yesNo.getUserAnswer());
		
		yesNo.getButtonNo().setSelected(false);
		assertEquals(null, yesNo.getUserAnswer());
		
	}
	
	@Test
	public void yesNoAnswerViewConstructorTest(){
		YesNoAnswer yes = new YesNoAnswer(true);
		YesNoAnswerView yesNo = new YesNoAnswerView(yes);
		assertEquals(yes,yesNo.getAnswer());
		assertEquals("Yes", yesNo.getButtonYes().getText());
		assertEquals("No", yesNo.getButtonNo().getText());
	}
	
	@Test
	public void yesNoAnswerViewSetButtonsTest(){
		YesNoAnswer yes = new YesNoAnswer(true);
		YesNoAnswerView yesNo = new YesNoAnswerView(yes);
		JRadioButton nouveauYes = new JRadioButton("OUI");
		JRadioButton nouveauNo = new JRadioButton("NON");
		yesNo.setButtonYes(nouveauYes);
		assertEquals(nouveauYes, yesNo.getButtonYes());
		yesNo.setButtonNo(nouveauNo);
		assertEquals(nouveauNo, yesNo.getButtonNo());
	}

	@Override
	public void answerDisplayTest() {
		YesNoAnswer yes = new YesNoAnswer(true);
		YesNoAnswerView yesNo = new YesNoAnswerView(yes);
		JPanel panel = new JPanel();
		yesNo.display(panel);
		assertEquals(2,yesNo.bg.getButtonCount());
	}
	
	

}
