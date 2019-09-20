package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import answer.MultiAnswer;

public class MultiAnswerView extends AnswerView {

	protected JTextArea text;

	/**
	 * The constructor of a MultiAnswerView
	 * @param a MultiAnswer
	 */
	public MultiAnswerView(MultiAnswer a) {
		super(a);
		this.text = new JTextArea(3,30);
	}

	@Override
	public void display(JPanel p) {
		this.text.setEditable(true);
		this.text.setAutoscrolls(true);
		this.text.setLineWrap(true);
		this.text.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		p.add(this.text);
	}

	/**
	 * Permits to get the JTextArea
	 * @return a JTextArea
	 */
	public JTextArea getText() {
		return this.text;
	}

	/**
	 * Permits to set the JTextArea
	 * @param text
	 */
	public void setText(JTextArea text) {
		this.text = text;
	}

	@Override
	public String getUserAnswer() {
		return this.text.getText();	
	}


}
