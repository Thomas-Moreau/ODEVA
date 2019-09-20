package views;

import javax.swing.JPanel;

import answer.Answer;

public abstract class AnswerView {
	
	protected Answer<?> answer;
	
	/**
	 * The constructor of AnswerView with an answer
	 * @param an answer a
	 */
	public AnswerView(Answer<?> a) {
		this.answer=a;
	}
	
	
	/**
	 * Permits to display the view for some kind of response
	 * @param a JPanel panel
	 */
	public abstract void display(JPanel p);
	
	/**
	 * Permits to get the answer
	 * @return a answer
	 */
	public Answer<?> getAnswer() {return this.answer;}
	
	/**
	 * @return the user input
	 */
	public abstract String getUserAnswer();
}
