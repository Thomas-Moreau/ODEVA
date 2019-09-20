package answer;

import views.AnswerView;
import views.ViewFactory;

/**
 * 
 * The abstract class of an Answer.
 * In this project, there are few answer's types, so we had to develop abstracts methods to use Answers
 *
 * @param <T> the type of Answer
 */
public abstract class Answer<T> {
	
	private T goodAnswer;
	
	/**
	 * The empty constructor of an Answer
	 */
	
	public Answer() {}
	
	/**
	 * The constructor of Answer with the answer 
	 * @param goodAnswer the answer of a Question
	 */
	
	public Answer(T goodAnswer) {
		this.goodAnswer=goodAnswer;  
	}
	
	/**
	 * Permits to get the answer of this question
	 * @return the good answer
	 */
	
	public T getGoodAnswer() {
		return this.goodAnswer;
	}
	
	/**
	 * Permits to set the good answer
	 * @param goodAnswer the new good answer
	 */
	
	public void setGoodAnswer(T goodAnswer) {
		this.goodAnswer = goodAnswer;
	}
	
	/**
	 * Permits to know the type of answer the user have to give
	 * @return the good type of answer
	 */
	
	public abstract String getGoodType() ;
	
	/**
	 * Permits to know if the answer given by the user has a good type or not
	 * @param answer the user answer
	 * @return true if this answer has a good type
	 */
	
	public abstract boolean hasGoodType(String answer);
	
	/**
	 * Permits to know if an answer is the good answer
	 * @param answer the user answer
	 * @return true if the user answer is the good answer
	 */
	
	public boolean isCorrect(String answer) {
		if(answer == null) {
			return false;
		}else {
			return answer.equalsIgnoreCase(this.goodAnswer.toString());
		}
	}  

	public String toString() {
		return this.goodAnswer.toString();
	}

	/**
	 * Permits to give the goodAnswer with a sentence 
	 * This method is called if the user give a good type answer but a wrong answer
	 * @return the sentence which give the good answer
	 */
	
	public abstract String giveGoodAnswer();

	
	/**
	 * Permits to create a view of an answer
	 * @param viewFactory
	 * @return the good view
	 */
	public abstract AnswerView createView(ViewFactory viewFactory) ;
	
}
