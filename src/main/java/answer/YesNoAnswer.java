package answer;

import views.AnswerView;
import views.ViewFactory;

/**
 * 
 * Class of a YesNoAnswer, extends the object Answer with a boolean type
 *
 */
public class YesNoAnswer extends Answer<Boolean> {

	/**
	 * Constructor of the class with a string argument
	 * @param answerText the answer
	 */
	
	public YesNoAnswer(String answerText) {
		boolean answer = fromString(answerText);
		this.setGoodAnswer(answer);
	}

	/**
	 * Constructor of the class with a boolean argument
	 * @param answer the answer
	 */
	
	public YesNoAnswer(boolean answer) {
		super(answer);
	}

	@Override
	public String getGoodType() { 
		return "yes/no";
	}

	@Override
	public boolean hasGoodType(String answer) {		
		return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no");
	}
	
	/**
	 * Private method, permits to cast the string s to a boolean answer
	 * @param s the string to cast
	 * @return the cast of this string
	 */
	
	private final boolean fromString(String s) {
		return s.equalsIgnoreCase("yes");
	}
	
	/**
	 * Permits to know if this string if correctly associate with the answer 
	 * @param answer the answer to test
	 * @return true if the answer is true and the string is yes or answer is false and the string is no
	 */
	
	public boolean isCorrect(String answer) {
		if(answer==null) {
			return false;
		}else {
			return (answer.toLowerCase().equals("yes") && this.getGoodAnswer()) || (answer.toLowerCase().equals("no") && !this.getGoodAnswer());
		}
	}

	@Override
	public String giveGoodAnswer() {
		return "Wrong, the answer was "+ (this.getGoodAnswer() ? "yes" : "no");
	} 
	
	/**
	 * Permits to create a view of a yes-no answer
	 * @param viewFactory
	 * @return the good view
	 */
	public AnswerView createView(ViewFactory viewFactory) {
		return viewFactory.createYesNoAnswerView(this);
	}
}
