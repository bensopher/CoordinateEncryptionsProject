package graphics;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.simple.parser.ParseException;

import Encryption.Decrypt;

public class DecryptingPanel extends JPanel {
	private static JTextArea thecode;
	private static JTextField keyField;
	public DecryptingPanel(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.insets = new Insets(20, 40, 0, 40);
//		c.weightx = 1;
//		c.weighty = 10/2;
		c.gridx = 0;
		c.gridy = 0;
		JLabel codeInserting = new JLabel("Insert Your Code:");
		add(codeInserting,c);
		thecode = new JTextArea();
//		thecode.setLineWrap(true);
		JScrollPane codeScrolling = new JScrollPane(thecode);
		
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 40, 0, 40);
		add(codeScrolling,c);
		
		
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
		
		c.gridx = 0;
		JButton Submit = new JButton("Decrypt");
		Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(thecode.getText().equals("")){
					JOptionPane.showMessageDialog(new JFrame(), "The message is empty.", "Dialog",JOptionPane.ERROR_MESSAGE);
				}
				else if(keyField.getText().equals("")){
					JOptionPane.showMessageDialog(new JFrame(), "The key field should be filled.", "Dialog",JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						Decrypt.Decryption(keyField.getText(), thecode.getText());
					} catch (ParseException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 0;
		c.insets = new Insets(0, 40, 10, 40);
		add(Submit,c);
		setOpaque(false);
//		setPreferredSize(new Dimension(MainPanel.getBackgroundSize().width/2,MainPanel.getBackgroundSize().height));
	}
	public static void clearOutput(){thecode.setText("");keyField.setText("");}
}
