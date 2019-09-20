package questionnaire;

import answer.Answer;

/**
 * 
 * The Question class 
 *
 */

public class Question {
	
	protected String text;
	protected Answer<?> buildAnswer;
	protected int nbPoints;
	
	public Question(){}
	
	/**
	 * Constructor of this class with all arguments 
	 * @param text the text of this question
	 * @param buildAnswer the answer of this question
	 * @param nbPoints the number of points the user win when he asks correctly to the question
	 */
	
	public Question(String text, Answer<?> buildAnswer, int nbPoints) {
		this.text = text;
		this.buildAnswer = buildAnswer;
		this.nbPoints = nbPoints; 
	}

	/**
	 * Permits to get the text of this question
	 * @return the text of the question
	 */
	
	public String getText() {
		return text;
	}

	/**
	 * Permits to set the text of this question
	 * @param text the new text of this question
	 */
	
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Permits to get the answer of this question
	 * @return the answer of this question
	 */
	
	public Answer<?> getBuildAnswer() {
		return buildAnswer;
	}

	/**
	 * Permits to set the answer of this question
	 * @param buildAnswer the new answer
	 */
	
	public void setBuildAnswer(Answer<?> buildAnswer) {
		this.buildAnswer = buildAnswer;
	}

	/**
	 * Permits to get the value of this question
	 * @return the question's number of points
	 */
	
	public int getNbPoints() {
		return nbPoints;
	}

	/**
	 * Permits to set the value of this question
	 * @param nbPoints the new number of points this question give
	 */
	
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}
	
}
