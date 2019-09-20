package answer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * The class of AnswerFactory
 * An answerFactory permits to create a type of  answer with an answer in text type
 *
 */

public class AnswerFactory {

	/**
	 * The only object factory, which call the private constructor, as a singleton
	 */
	
	public static final AnswerFactory FACTORY = new AnswerFactory(); 
	
	private AnswerFactory(){}
	
	/**
	 * The method permits to build an object with a class which extends the Object Answer
	 * @param answerText the answer, this sentence permits to know which type is the answer
	 * @return an answer which extends the object Answer.class
	 */
	
	public Answer<?> buildAnswer(String answerText){
		try{
			return new NumericalAnswer(answerText) ;		
		} catch (IllegalArgumentException e1) {
			try{
				return new YesNoAnswer(answerText) ;		
			} catch (IllegalArgumentException e2) {
				try{ 
					return new MultiAnswer(answerText) ;		
				} catch (IllegalArgumentException e3) {
					try{
						return new MultipleChoiceAnswer(answerText) ;		
					} catch (IllegalArgumentException e4) {
						return new TextualAnswer(answerText);
					}
				}
			}	
		}
	}
	
	/**
	 * Another method which permits to build an answer with the className, and the answer in text type
	 * @param answerClassName the className of the new Answer
	 * @param answerText the answer in text type
	 * @return a new Answer, which extends the object Answer
	 */
	
	public Answer<?> buildAnswer(String answerClassName, String answerText) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> c = Class.forName("answer."+answerClassName);
		Constructor<?> constructor = c.getConstructor(String.class);
		return (Answer<?>) constructor.newInstance(answerText);
	}
}
