package views;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import answer.NumericalAnswer;

public class NumericalAnswerView extends AnswerView {

	protected JSpinner spinner;
	
	/**
	 * The constructor of a NumericalAnswerView
	 * @param a numericalAnswer
	 */
	public NumericalAnswerView(NumericalAnswer a) {
		super(a);
		this.spinner = new JSpinner(new SpinnerNumberModel());
		this.spinner.setAutoscrolls(true);
		this.spinner.setEditor(new JSpinner.NumberEditor(spinner));
	}

	@Override
	public void display(JPanel p) {
		((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setColumns(10);
		((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setColumns(10);
		p.add(spinner);
	}

	/**
	 * Permits to get the JSpinner
	 * @return a JSpinner
	 */
	public JSpinner getSpinner() {
		return spinner;
	}

	/**
	 * Permits to set the JSpinner
	 * @param spinner
	 */
	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	@Override
	public String getUserAnswer() {
		return this.spinner.getValue().toString();
	}

}
