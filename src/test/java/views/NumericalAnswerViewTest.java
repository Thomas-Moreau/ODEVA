package views;

import javax.swing.JPanel;
import javax.swing.JSpinner;

import org.junit.Test;

import static org.junit.Assert.*;

import answer.NumericalAnswer;

public class NumericalAnswerViewTest extends AnswerViewTest{


	@Override
	public void answerGetUserAnswerTest() {
		NumericalAnswerView n = new NumericalAnswerView(new NumericalAnswer(10));
		JSpinner spinner = new JSpinner();
		spinner.setValue(40);
		n.setSpinner(spinner);
		assertEquals("40", n.getUserAnswer());
	}
	
	@Test
	public void numericalAnswerViewGetSpinnerTest(){
		NumericalAnswerView n = new NumericalAnswerView(new NumericalAnswer(10));
		JSpinner spinner = new JSpinner();
		n.setSpinner(spinner);
		assertEquals(spinner, n.getSpinner());
	}

	@Override
	public void answerDisplayTest() {
		NumericalAnswerView n = new NumericalAnswerView(new NumericalAnswer(10));
		JPanel panel = new JPanel();
		n.display(panel);
		assertEquals(10,((JSpinner.DefaultEditor)n.getSpinner().getEditor()).getTextField().getColumns());
	}
	

}
