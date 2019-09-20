package questionnaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import answer.Answer;

/**
 * Class of the survey.
 * A survey has a list of questions and has the player number of points
 */

public class Questionnaire {
	
	protected List<Question> questions;
	protected BufferedReader in;
	protected PrintStream out;
	protected int scoreUser;
	
	/**
	 * Constructor of a survey
	 * @param in The place where the survey read informations
	 * @param out The place where the survey write informations
	 */
	
	public Questionnaire(Reader in, PrintStream out){
		this.questions = new ArrayList<Question>();
		this.in = new BufferedReader(in);
		this.out=out; 
	}
	
	/**
	 *Constructor of survey without arguments 
	 */
	
	public Questionnaire(){
		this(new InputStreamReader(System.in) , System.out) ;
	}

	/**
	 * Method permits to add a queestion to the list of questions
	 * @param createQuestion the question to add to the list
	 */
	
	public void addQuestion(Question createQuestion) {
		this.questions.add(createQuestion);
	}

	/**
	 * Private method, permits to ask a question to a user, wait an answer, and add ( or not ) points.
	 * @param question the question asked to the user
	 * @return the value of this question if the user's answer is correct, 0 else
	 */
	
	private int ask(Question question){
		String userAnswer ="";
		Answer<?> answer = question.getBuildAnswer();
		System.out.println(question.getText()+"\n"+answer.getGoodType());
		do{
			try {
				userAnswer = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!answer.hasGoodType(userAnswer));

		if(answer.isCorrect(userAnswer)){
			System.out.println("Correct ("+question.getNbPoints()+" points)\n");
			this.scoreUser += question.getNbPoints();
			System.out.println("Your score : "+format(this.scoreUser));
			return question.getNbPoints();
		}else{
			System.out.println(answer.giveGoodAnswer()); 
			return 0;
		}
	}
	
	/**
	 * Permits to ask to a user all questions of the list of questions
	 */
	
	public void askAll(){
		int res = 0;
		for(Question q : this.questions){
			res += this.ask(q);
		}
		this.scoreUser = res;
		System.out.println("Your final score is "+format(this.scoreUser));
			
	}
	
	/***
	 * Permits to set a display for the user
	 * @param points the number of user's points
	 * @return a String which tell to the user how many points he won during this game
	 */
	
	private static String format(int points){
		return "" + points + " point" + (points > 1?"s":"") + "\n";
	}
	
	/**
	 * Permits to get the number of points the user has
	 * @return the user's points
	 */
	
	public int getScoreUser(){
		return this.scoreUser;
	}
	
	/**
	 * Permits to set the number of points of the user
	 * @param scoreUser the new userScore
	 */
	
	public void setScoreUser(int scoreUser){
		this.scoreUser = scoreUser;
	}

	/***
	 * Permits to get the list of questions the survey has
	 * @return the list of questions
	 */
	
	public List<Question> getQuestions() {
		return questions;
	}

	/***
	 * Permits to set the survey's list of questions 
	 * @param questions the new list of questions
	 */
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
