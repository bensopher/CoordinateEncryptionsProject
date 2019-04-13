package graphics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OutputEncryptionPanel extends JPanel {
	private static JTextArea theOutput;
	public OutputEncryptionPanel(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.insets = new Insets(0, 40, 0, 40);
//		c.weightx = 1;
//		c.weighty = 10/2;
//		c.gridx = 0;
//		c.gridy = 0;
		JLabel messageInserting = new JLabel("Output:");
		add(messageInserting,c);
		theOutput = new JTextArea();
		theOutput.setEditable(false);
		JScrollPane outputScrolling = new JScrollPane(theOutput);
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 40, 100, 40);
		add(outputScrolling,c);
		setOpaque(false);
//		setPreferredSize(new Dimension(MainPanel.getBackgroundSize().width/2,MainPanel.getBackgroundSize().height));
	}
	public static void setOutput(String output){
		theOutput.setText(theOutput.getText()+output);
	}
	public static void clearOutput(){theOutput.setText("");}
}
