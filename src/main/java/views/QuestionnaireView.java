package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import answer.Answer;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireFactory;

public class QuestionnaireView implements ActionListener{

	private JFrame frame;
	protected Questionnaire questionnaire;
	protected List<Question> questions;
	protected ViewFactory vf;
	protected List<AnswerView> answersView;
	protected int nbPoints;

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 */
	public QuestionnaireView() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		QuestionnaireFactory qf = new QuestionnaireFactory();
		this.questionnaire = qf.createQuestionnaire("question_tolkien_3.txt");
		this.questions = this.questionnaire.getQuestions();
		this.vf = new ViewFactory();
		this.answersView = new ArrayList<AnswerView>();
		nbPoints = 0;
		initialize();
	}
	
	/**
	 * Create the application.
	 * @param a questionnaire
	 */
	public QuestionnaireView(Questionnaire q) {
		this.questionnaire = q;
		this.questions = this.questionnaire.getQuestions();
		this.vf = new ViewFactory();
		this.answersView = new ArrayList<AnswerView>();
		nbPoints = 0;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Questionnaire2"); 
		frame.setSize(1000, this.questionnaire.getQuestions().size()+1*430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		JButton button = new JButton("Fini");
		
		panel.setLayout(new GridLayout(this.questions.size(), 1,3,3));
		
		for (int i=0; i<this.questionnaire.getQuestions().size();i++) {
			createQuestionsView(i,panel);
		}
		
		button.addActionListener(this);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	/**
	 * Permits to create the view of a question
	 * @param an index i
	 * @param a JPanel panel
	 */
	public void createQuestionsView(int i, JPanel panel) {
		Question q = this.questions.get(i);
		JPanel pQuestionReponse = new JPanel(); 
		JPanel pQuestion = new JPanel();
		JPanel pReponse = new JPanel();
		Answer<?> answer = q.getBuildAnswer();
		AnswerView av = vf.createView(answer);
		JTextArea text = new JTextArea(q.getText()+" : \n"+answer.getGoodType()+" : ");
		
		this.answersView.add(av);
	
		pQuestionReponse.setBorder(BorderFactory.createMatteBorder(1, 1, 1,1, Color.BLACK));
		text.setEditable(false);
		text.setOpaque(false);
		pQuestionReponse.setLayout(new GridLayout(1, 2));
		pQuestion.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		av.display(pReponse);				
		
		pQuestion.add(text,BorderLayout.EAST);
		pQuestionReponse.add(pQuestion);
		pQuestionReponse.add(pReponse);
		panel.add(pQuestionReponse);
	}

	
	/**
	 * Permits to check the answers and display the final score
	 */
	public void actionPerformed(ActionEvent arg0) {
		Answer<?> answer;
		int cpt = 0;
		for (AnswerView answerView : this.answersView) {
			answer = answerView.getAnswer();
			if(answer.isCorrect(answerView.getUserAnswer())) {
				this.nbPoints+=this.questionnaire.getQuestions().get(cpt).getNbPoints();
			}
			cpt++;
		}	
		
		JOptionPane.showMessageDialog(this.frame, "Vous avez obtenu "+this.nbPoints+" points.", "Arrêt de l'animation", JOptionPane.CLOSED_OPTION);
		System.exit(0);
	
	}

}
