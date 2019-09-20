package answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import views.AnswerView;
import views.ViewFactory;

/**
 * 
 * Class of a MultipleChoiceAnswer
 * This class extends TextualAnswer
 * This class permits to give to the user a list of choices, then he has to choose the correctAnswer in this list
 *
 */

public class MultipleChoiceAnswer extends TextualAnswer {
	
	protected List<String> choice;

	/**
	 * Constructor with a single String
	 * In this case, the size of choice's list is 1
	 * @param answer the goodAnswer
	 */
	
	public MultipleChoiceAnswer(String answer) {
		this.choice = new ArrayList<String>(); 
		String[] choices = answer.split(" \\| ");
		for (String a : choices) {
			this.choice.add(a.toLowerCase());
		}
		this.setGoodAnswer(choices[0]);
	}
	
	/**
	 * Full constructor of this class
	 * @param choice the list of choice which is given to the user
	 * @param answer the correct answer
	 */
	
	public MultipleChoiceAnswer(List<String> choice, String answer) {
		super(answer);
		this.choice = choice; 
	}
	
	
	/**
	 * Permits to get the list of choices the user have 
	 * @return the list of choices
	 */
	
	public List<String> getChoice(){
		return this.choice;
	}
	
	/**
	 * Permits to set the list of choices
	 * @param choice the new list of choices
	 */
	
	public void setChoice(List<String> choice) {
		this.choice = choice;
	}
	
	@Override
	public boolean hasGoodType(String answer) {
		return choice.contains(answer.toLowerCase());
	}
	
	@Override
	public String getGoodType() {
		List<String> tmp = this.choice;
		String rep = "(";
		Collections.shuffle(tmp);
		for(String s : tmp) {
			rep +=s+" - "; 
		}
		rep = rep.substring(0, rep.length()-3); // suppression du dernier - 
		rep += ")";
		return rep;
	}
	
	/**
	 * Permits to create a view of a multiple choice answer
	 * @param viewFactory
	 * @return the good view
	 */
	public AnswerView createView(ViewFactory viewFactory) {
		return viewFactory.createMultipleChoiceAnswerView(this);
	}
}
