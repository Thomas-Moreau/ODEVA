package views;

import static org.junit.Assert.*;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.junit.Test;

import answer.MultipleChoiceAnswer;

public class MultipleChoiceAnswerViewTest extends TextualAnswerViewTest{
	
	@Test
	public void multipleChoiceAnswerViewConstructorTest() {
		MultipleChoiceAnswer multi = new MultipleChoiceAnswer("answer");
		MultipleChoiceAnswerView multiview = new MultipleChoiceAnswerView(multi);
		assertEquals("A choisir", multiview.getCombo().getItemAt(0));
		assertEquals(multi.getChoice().size()+1, multiview.getCombo().getItemCount());
	} 
	
	@Test
	public void multipleChoiceAnswerViewSetComboTest() {
		MultipleChoiceAnswer multi = new MultipleChoiceAnswer("answer");
		MultipleChoiceAnswerView multiview = new MultipleChoiceAnswerView(multi);
		JComboBox<String> combo = new JComboBox<String>();
		multiview.setCombo(combo);
		assertEquals(combo, multiview.getCombo());
	}
	
	@Test
	public void multipleChoiceAnswerViewGetUserAnswerTest() {
		MultipleChoiceAnswer multi = new MultipleChoiceAnswer("answer");
		MultipleChoiceAnswerView multiview = new MultipleChoiceAnswerView(multi);
		multiview.getCombo().setSelectedItem("A choisir");
		assertEquals(null, multiview.getUserAnswer());
		multiview.getCombo().setSelectedItem("answer"); 
		assertEquals("answer", multiview.getUserAnswer());
	}
	
	@Test
	public void multipleChoiceAnswerViewDisplayTest() {
		MultipleChoiceAnswer multi = new MultipleChoiceAnswer("answer");
		MultipleChoiceAnswerView multiview = new MultipleChoiceAnswerView(multi);
		JPanel panel = new JPanel();
		multiview.display(panel);
		assertEquals(1, panel.getComponentCount());
	} 
	
	

}
