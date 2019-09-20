package views;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import answer.YesNoAnswer;

public class YesNoAnswerView extends AnswerView {
	
	protected ButtonGroup bg; 
	protected JRadioButton buttonYes;
	protected JRadioButton buttonNo;

	/**
	 * The constructor of a YesNoAnswerView
	 * @param a YesNoAnswer
	 */
	public YesNoAnswerView(YesNoAnswer a) {
		super(a);
		this.bg = new ButtonGroup();
		this.buttonYes = new JRadioButton("Yes");
		this.buttonNo = new JRadioButton("No");
}

	@Override
	public void display(JPanel p) {
		this.bg.add(this.buttonYes);
		this.bg.add(this.buttonNo);
		p.add(this.buttonYes);
		p.add(this.buttonNo);
	}

	/**
	 * Permits to get the JRadioButton yes
	 * @return a JRadioButton yes
	 */
	public JRadioButton getButtonYes() {
		return buttonYes;
	}

	/**
	 * Permits to set the JRadioButton yes
	 * @param buttonYes
	 */
	public void setButtonYes(JRadioButton buttonYes) {
		this.buttonYes = buttonYes;
	}

	/**
	 * Permits to get the JRadioButton no
	 * @return a JRadioButton no
	 */
	public JRadioButton getButtonNo() {
		return buttonNo;
	}

	/**
	 * Permits to set the JRadioButton no
	 * @param buttonNo
	 */
	public void setButtonNo(JRadioButton buttonNo) {
		this.buttonNo = buttonNo;
	}

	@Override
	public String getUserAnswer() {
		if(this.buttonNo.isSelected()) {
			return this.buttonNo.getText();
		}else if(this.buttonYes.isSelected()) {
			return this.buttonYes.getText();
		}else {
			return null;
		}
	}

	
}
