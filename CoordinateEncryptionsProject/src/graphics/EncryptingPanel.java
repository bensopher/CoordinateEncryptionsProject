package graphics;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.simple.parser.ParseException;

import Encryption.EncryptMessage;

public class EncryptingPanel extends JPanel{
	private static JTextArea theMessage;
	private static JTextField keyField;
	public EncryptingPanel(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.insets = new Insets(20, 40, 0, 40);
//		c.weightx = 1;
//		c.weighty = 10/2;
		c.gridx = 0;
		c.gridy = 0;
		JLabel messageInserting = new JLabel("Insert Your Massage:");
		add(messageInserting,c);
		theMessage = new JTextArea();
		theMessage.setLineWrap(true);
		JScrollPane messageScrolling = new JScrollPane(theMessage);
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 40, 0, 40);
		add(messageScrolling,c);
		
		
		JLabel key = new JLabel("Key:");
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 0;
//		c.insets = new Insets(10, 40, 0, 40);
		add(key,c);
		
		keyField = new JTextField();
		c.insets = new Insets(0, 80, 0, 40);
		c.gridx = 1;
//		keyField.setSize(new Dimension(10,10));
		add(keyField,c);
//		JProgressBar progressBar = new JProgressBar();
		
		JButton Submit = new JButton("Encrypt");
		Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(theMessage.getText().equals("")){
					String message = "The message is empty.";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
				else if(keyField.getText().equals("")){
					String message = "The key field should be filled.";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}else{
//					EncryptMessage massege = new EncryptMessage(keyField.getText(),theMessage.getText());
					try {
						OutputEncryptionPanel.clearOutput();
						new EncryptMessage(keyField.getText(),theMessage.getText()).Encrypting();
						clearOutput();
					} catch (IOException | ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		c.gridy = 3;
		c.gridx = 0;
		c.weightx = 0;
		c.weighty = 0;
		c.insets = new Insets(0, 40, 10, 40);
		add(Submit,c);
		setOpaque(false);
//		setPreferredSize(new Dimension(MainPanel.getBackgroundSize().width/2,MainPanel.getBackgroundSize().height));
	}
	public static void clearOutput(){theMessage.setText("");keyField.setText("");}
}
