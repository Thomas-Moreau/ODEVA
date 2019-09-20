package answer;

import views.AnswerView;
import views.ViewFactory;

/**
 * 
 * Class of NumericalAnswer, extends Answer with an Integer type
 *
 */

public class NumericalAnswer extends Answer<Integer>{

	/**
	 * The constructor of a numericalAnswer with a String argument
	 * @param answerText the answer to cast in integer
	 */
	
	public NumericalAnswer(String answerText) {
		int answer = fromString(answerText);
		this.setGoodAnswer(answer);
	}
	
	/**
	 * The constructor of a numericalAnswer with an Integer argument
	 * @param answer the answer
	 */
	
	public NumericalAnswer(int answer) {
		super(answer);
	}

	@Override
	public String getGoodType() {
		return "numerical";
	}

	@Override
	public boolean hasGoodType(String answer) {
		try {
			Integer.parseInt(answer);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * Method to case String in an Integer.
	 * @param s the string to cast in integer
	 * @return the string cast in integer, 0 else
	 */
	
	private final int fromString(String s) {
		int res;
		try {
			res = Integer.parseInt(s);
		}catch (Exception e) {
			res = 0;
		}
		return res;
	}

	@Override
	public String giveGoodAnswer() {
		return "Wrong, the answer was "+this.getGoodAnswer(); 
	}
	
	/**
	 * Permits to create a view of a numerical answer
	 * @param viewFactory
	 * @return the good view
	 */
	public AnswerView createView(ViewFactory viewFactory) {
		return viewFactory.createNumericalAnswerView(this);
	}
}
