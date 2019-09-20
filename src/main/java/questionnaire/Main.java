package questionnaire;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import views.QuestionnaireView;

/**
 * The main class of the project, where the user launches textual or graphical mode of the survey
 *
 */
public class Main 
{
	public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{
		System.out.println( "Hello World!" );
		QuestionnaireFactory qf = new QuestionnaireFactory();
		Questionnaire q = qf.createQuestionnaire("question_star-wars.txt");
		//Questionnaire q = qf.createQuestionnaire("question_test_ihm.txt");

		System.out.println("Choisir un mode\n1-Mode texte\n2-Mode graphique\n");
		Scanner scanner = new Scanner(System.in);
		int choosen = 0;
		while(choosen<1 || choosen>2) {
			choosen = scanner.nextInt();
			if(choosen==1) {
				q.askAll();  
			}else if(choosen==2) {
				System.out.println("graphique");
				new QuestionnaireView(q);
			}
		}
		scanner.close();
	}
}
