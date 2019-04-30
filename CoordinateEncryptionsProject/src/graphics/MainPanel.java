package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainPanel extends JPanel {
	private BufferedImage background = loadImage();
	private JComponent[] panels = new JComponent[2];
	private String[] panelTitles = {"Encryption","Decryption"};
	private static Dimension backgroundSize;
	public MainPanel(){
		super(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		for(int i=0;i<panels.length;i++){
			panels[i] = panel(panelTitles[i]);
			tabbedPane.addTab(panelTitles[i], panels[i]);
	        tabbedPane.setMnemonicAt(i, KeyEvent.VK_1);
		}
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	public JComponent panel(String whichOne) {
        JPanel panel = new JPanel(false);
        panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();//for configure the buttons
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 4;
		if(whichOne.equals("Encryption")){
			panel.add(new EncryptingPanel(),c);
			c.weighty = 6;
			c.gridy = 1;
			panel.add(new OutputEncryptionPanel(),c);
		}
		else{
			panel.add(new DecryptingPanel(),c);
			c.weighty = 6;
			c.gridy = 1;
			panel.add(new OutputDecryptionPanel(),c);
		}
        return panel;
    }
	private BufferedImage loadImage(){
        URL imagePath = getClass().getResource("/Images/background.jpg");
        BufferedImage result = null;
        try {
            result = ImageIO.read(imagePath);//read the image file with ImageIO class.
            backgroundSize = new Dimension(result.getWidth(),result.getHeight());
        } catch (IOException e) {//Catch due to try to read the image file.
            System.err.println("Error, the image is not found.");
        }
        return result;
    }
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//Call the default method due to overriding.
        setPreferredSize(backgroundSize);
        Dimension size = getSize();//get the size of this panel and set it into Dimension(size) object.
        g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), null);//set the background in 0,0 location (drawing the background)
    }
	public static Dimension getBackgroundSize(){return backgroundSize;}
}
