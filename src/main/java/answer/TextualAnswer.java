package answer;

import views.AnswerView;
import views.ViewFactory;

/**
 * 
 * Class of a TextualAnswer, extends the object Answer with a String type
 *
 */

public class TextualAnswer extends Answer<String> {
	
	public TextualAnswer() {}

	/**
	 * The only constructor of this class, permits to set the answer 
	 * @param answerText the new answer
	 */
	
	public TextualAnswer(String answerText) {
		super(answerText);
	}

	@Override
	public String getGoodType() {
		return "symbolique";
	}
 
	@Override
	public boolean hasGoodType(String answer) {
		return true;
	}

	@Override
	public String giveGoodAnswer() {
		return "Wrong, the answer was "+this.getGoodAnswer();
	}

	/**
	 * Permits to create a view of a textual answer
	 * @param viewFactory
	 * @return the good view
	 */
	public AnswerView createView(ViewFactory viewFactory) {
		return viewFactory.createTextualAnswerView(this);
	}
}
