package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private BufferedImage background = loadImage();
	private static Dimension backgroundSize;
	public MainPanel(){
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();//for configure the buttons
//		c.insets = new Insets(1, 1, 1, 1);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 4;
//		c.gridx = 0;
//		c.gridy = 0;
		add(new EncryptingPanel(),c);
		c.weighty = 6;
//		c.gridx = 1;
		c.gridy = 1;
		add(new OutputPanel(),c);
	}
//	private void setBackground(BufferedImage background){this.background = background;}
//	private BufferedImage getBackgroundImage(){return this.background;}
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
