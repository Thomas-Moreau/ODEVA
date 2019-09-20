package views;

import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import answer.MultipleChoiceAnswer;

public class MultipleChoiceAnswerView extends TextualAnswerView {

	protected JComboBox<String> combo;

	/**
	 * The constructor of a MultipleChoiceAnswerView
	 * @param a MultipleChoiceAnswer
	 */
	public MultipleChoiceAnswerView(MultipleChoiceAnswer a) {
		super(a);
		this.combo = new JComboBox<String>();
		this.combo.addItem("A choisir");
		List<String> tmp = a.getChoice();
		Collections.shuffle(tmp); 
		for (String s : tmp) {
			this.combo.addItem(s);
		}
	}
	
	@Override
	public void display(JPanel p) { 
		p.add(this.combo);
	}
	
	/**
	 * Permits to get the JComboBox
	 * @return a JComboBox
	 */
	public JComboBox<String> getCombo() {
		return combo;
	}

	/**
	 * Permits to set the JComboBox
	 * @param combo
	 */
	public void setCombo(JComboBox<String> combo) {
		this.combo = combo;
	}

	@Override
	public String getUserAnswer() {
		if(this.combo.getSelectedItem().toString().equals("A choisir")) {
			return null; 
		}else {
			return this.combo.getSelectedItem().toString();
		}
	}

}
