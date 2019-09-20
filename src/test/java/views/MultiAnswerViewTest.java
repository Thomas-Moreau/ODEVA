package views;

import static org.junit.Assert.*;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.junit.Test;

import answer.MultiAnswer;

public class MultiAnswerViewTest extends AnswerViewTest{

	@Override
	public void answerGetUserAnswerTest() {
		MultiAnswer multi = new MultiAnswer();
		MultiAnswerView m = new MultiAnswerView(multi);
		JTextArea text = new JTextArea("texte");
		m.setText(text);
		assertEquals("texte", m.getUserAnswer());
	}
	
	@Test
	public void multiAnswerViewConstructorTest(){
		MultiAnswer multi = new MultiAnswer();
		MultiAnswerView m = new MultiAnswerView(multi);
		assertEquals(multi, m.getAnswer());
		assertEquals(3, m.getText().getRows());
		assertEquals(30, m.getText().getColumns());
	}

	@Override
	public void answerDisplayTest() {
		MultiAnswer multi = new MultiAnswer();
		MultiAnswerView m = new MultiAnswerView(multi);
		JPanel p = new JPanel();
		m.display(p);
		assertTrue(m.getText().isEditable());
		assertTrue(m.getText().getAutoscrolls());
		assertTrue(m.getText().getLineWrap());
	}

	
}
