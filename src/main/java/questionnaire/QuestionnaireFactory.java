package questionnaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import answer.AnswerFactory;

/**
 * 
 * The questionnaireFactory class
 *
 */

public class QuestionnaireFactory {
	
	/***
	 * Permits to create a Question
	 * @param text the text of the question
	 * @param answerClassName the classname of the question's answer
	 * @param answer the value of question's answer
	 * @param points the value of this question
	 * @return
	 */
	public Question createQuestion(String text, String answerClassName, String answer, String points) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try{
			int nbPoints = Integer.parseInt(points);
			return new Question(text, AnswerFactory.FACTORY.buildAnswer(answerClassName,answer), nbPoints);
		}catch (NumberFormatException e) {
			throw new NumberFormatException("bad format");
		}
	}
	
	/**
	 * Permits to create a survey with a textFile
	 * @param fileName the file which contains informations for the survey
	 * @return a new Questionnaire
	 */
	public Questionnaire createQuestionnaire(String fileName) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Questionnaire questionnaire = new Questionnaire();
		File source = new File("resources/"+fileName);
		BufferedReader in = null; 
		try{
			in = new BufferedReader(new FileReader(source)); 
			String answerClassName;
			//read block of 4 lines : answerClassName, text, answer and number of points
			while((answerClassName = in.readLine()) != null){
				String text = in.readLine();
				String answer = in.readLine();
				String nbPoints = in.readLine();
				if(answer == null || nbPoints == null){
					throw new IOException("bad format");
				}
				questionnaire.addQuestion(this.createQuestion(text,answerClassName, answer, nbPoints));
			}
		}catch (FileNotFoundException e) {
			throw new IOException(e);
		}
		finally{
			in.close();
		}
		return questionnaire;
	}

}
