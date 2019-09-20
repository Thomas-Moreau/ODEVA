package answer;

import java.util.ArrayList;
import java.util.List;

import views.AnswerView;
import views.ViewFactory;

/**
 * 
 * Class of a MultiAnswer
 * This class extends Answer with the type String 
 * A MultiAnswer is an Answer with few possibilities, but the user don't know these
 *
 */

public class MultiAnswer extends Answer<String> {
	
	List<String> possibleAnswers;
	
	/**
	 * Constructor without parameters of a MultiAnswer
	 */
	
	public MultiAnswer() { 
		this.possibleAnswers = new ArrayList<String>();
	}

	/**
	 * Constructor with a single answer.
	 * In this case, the good answer is this string and the string is add to the array of possiblesAnswer
	 * @param answer the good answer
	 */
	
	public MultiAnswer(String answer) {
		super(answer);
		this.possibleAnswers = new ArrayList<String>(); 
		String[] answers = answer.split(" ; ");
		for (String a : answers) {
			this.possibleAnswers.add(a.toLowerCase());
		}
	}
	 
	/**
	 * Constructor with an array of answers
	 * In this case, good answers are on the possibles answers list
	 * @param answers the array of good answers
	 */
	
	public MultiAnswer(String[] answers) {
		super(answers[0]);
		this.possibleAnswers = new ArrayList<String>();
		if(answers != null) {
			for(String s : answers) {
				this.possibleAnswers.add(s.toLowerCase());
			}
		}
	}
	
	/**
	 * Constructor with a List of goodAnswers
	 * In this case, good answers are on the possibles answers list
	 * @param answers the list of good Answers
	 */
	
	public MultiAnswer(List<String> answers) {
		super(answers.get(0));
		this.possibleAnswers = new ArrayList<String>();
		this.possibleAnswers = answers;
	}
	
	/**
	 * Permits to get the list of goodAnswers
	 * @return the list of good Answers
	 */
	
	public List<String> getPossibleAnswers(){
		return this.possibleAnswers;
	}
	
	/**
	 * Permits to set the list of goodAnswers
	 * @param possible the new list of possible Answers
	 */
	
	public void setPossibleAnswers(List<String> possible) {
		this.possibleAnswers = possible;
	}

	@Override
	public String getGoodType() {
		return possibleAnswers.size()+" possible answers";
	}

	@Override
	public boolean hasGoodType(String answer) {
		return true;
	}
	
	/**
	 * Permits to know if the user answer is correct or not
	 * @return true if the user answer is in the possible Answers list of this MultiAnswer
	*/
	
	public boolean isCorrect(String answer) {
		return possibleAnswers.contains(answer.toLowerCase());
	}
	

	@Override
	public String giveGoodAnswer() {
		String rep = "";
		rep += "Wrong, possible responses were ";
		for(String s : possibleAnswers) {
			rep +=s+" - "; 
		}
		rep = rep.substring(0, rep.length()-2); // suppression du dernier - 
		return rep;
	}
	
	/**
	 * Permits to create a view of a multi answer
	 * @param viewFactory
	 * @return the good view
	 */
	public AnswerView createView(ViewFactory viewFactory) {
		return viewFactory.createMultiAnswerView(this);
	}

}
