package views;

import answer.Answer;
import answer.MultiAnswer;
import answer.MultipleChoiceAnswer;
import answer.NumericalAnswer;
import answer.TextualAnswer;
import answer.YesNoAnswer;

/**
 * 
 * The class of ViewFactory
 * An viewFactory permits to create a type of answer view with an answer
 *
 */
public class ViewFactory {
	
	public ViewFactory() {}
	
	/**
	 * Permits to choose the good view
	 * @param an answer
	 * @return an answerView
	 */
	public AnswerView createView(Answer<?> a) {
		return a.createView(this);
	}
	
	/**
	 * Permits to create the view of a YesNoAnswer
	 * @param a YesNoAnswer
	 * @return an answerView
	 */
	public AnswerView createYesNoAnswerView(YesNoAnswer a) {
		return new YesNoAnswerView(a);
	}
	
	/**
	 * Permits to create the view of a MultiAnswer
	 * @param a MultiAnswer
	 * @return an answerView
	 */
	public AnswerView createMultiAnswerView(MultiAnswer a) {
		return new MultiAnswerView(a);
	}
	
	/**
	 * Permits to create the view of a TextualAnswer
	 * @param a TextualAnswer
	 * @return an answerView
	 */
	public AnswerView createTextualAnswerView(TextualAnswer a) {
		return new TextualAnswerView(a);
	}
	
	/**
	 * Permits to create the view of a MultipleChoiceAnswer
	 * @param a MultipleCHoiceAnswer
	 * @return an answerView
	 */
	public AnswerView createMultipleChoiceAnswerView(MultipleChoiceAnswer a) {
		return new MultipleChoiceAnswerView(a);
	}
	
	/**
	 * Permits to create the view of a NumericalAnswer
	 * @param a NumericalAnswer
	 * @return an answerView
	 */
	public AnswerView createNumericalAnswerView(NumericalAnswer a) {
		return new NumericalAnswerView(a);
	}

}
