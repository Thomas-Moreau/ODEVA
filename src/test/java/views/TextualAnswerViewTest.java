package views;

import answer.TextualAnswer;
import static org.junit.Assert.*;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.junit.Test;

public class TextualAnswerViewTest extends AnswerViewTest{

	@Override
	public void answerGetUserAnswerTest() {
		TextualAnswerView textual = new TextualAnswerView(new TextualAnswer());
		JTextArea text = new JTextArea("texte");
		textual.setTextArea(text);
		assertEquals("texte", textual.getUserAnswer());
	}

	@Override
	public void answerDisplayTest() {
		TextualAnswer answer = new TextualAnswer();
		TextualAnswerView textual = new TextualAnswerView(answer);
		JPanel panel = new JPanel();
		textual.display(panel);
		assertTrue(textual.getTextArea().isEditable()); 
		assertTrue(textual.getTextArea().getAutoscrolls());
		assertTrue(textual.getTextArea().getLineWrap());
		
	}
	
	@Test
	public void textualAnswerViewConstructorTest() {
		TextualAnswer answer = new TextualAnswer();
		TextualAnswerView textual = new TextualAnswerView(answer);
		assertEquals(answer,textual.getAnswer());
		assertEquals(3, textual.getTextArea().getRows());
		assertEquals(30, textual.getTextArea().getColumns()); 
	}
	
	@Test
	public void textualAnswerViewGetSetTextAreaTest() {
		TextualAnswerView textual = new TextualAnswerView(new TextualAnswer());
		JTextArea text = new JTextArea("texte");
		textual.setTextArea(text);
		assertEquals(text, textual.getTextArea());
	}

}
