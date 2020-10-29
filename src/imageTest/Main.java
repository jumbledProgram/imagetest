package imageTest;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	static int W = 1;
	static int O = 0;
	static int B = 2;
	static int[][][] levels = {
			{
				{W,W,W,W,W,W,W,W,W,W},
				{W,O,O,O,O,O,O,O,O,W},
				{W,W,W,W,O,O,B,O,O,W},
				{W,W,W,W,O,O,O,O,O,W},
				{W,W,W,W,O,O,O,O,O,W},
				{W,O,O,O,O,O,O,O,O,W},
				{W,O,O,O,O,O,O,O,O,W},
				{W,O,O,O,O,O,O,O,O,W},
				{W,O,O,O,O,O,O,O,O,W},
				{W,W,W,W,W,W,W,W,W,W}
			}
	};
	
	static Image picCrate = null;
	static Image picCrateLit = null;
	static Image picGround1 = null;
	static Image picWall1 = null;
	public static void main(String[] args) throws InterruptedException {

		try {
			picGround1 = ImageIO.read(new File("src/images/ground1.png")).getScaledInstance(16*4, 16*4, Image.SCALE_SMOOTH);
			picCrateLit = ImageIO.read(new File("src/images/crateLit.png")).getScaledInstance(16*4, 16*4, Image.SCALE_SMOOTH);
			picCrate = ImageIO.read(new File("src/images/crate.png")).getScaledInstance(16*4, 16*4, Image.SCALE_SMOOTH);
			picWall1 = ImageIO.read(new File("src/images/wall1.png")).getScaledInstance(16*4, 16*4, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.print("Failed loading images\n");
			e.printStackTrace();
		}

		JPanel jPanel = new JPanel(new GridLayout(10, 10));;
		
		
		JFrame f = new JFrame();
		f.setSize(new Dimension(picGround1.getWidth(f)*10+25, picGround1.getHeight(f)*10+40));
		f.setLocation(100, 100);
		f.add(jPanel);
		f.setIconImage(picCrate);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setTitle("Sokoban");
		f.setVisible(true);
		
		
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 10; x++) {
				switch (levels[0][y][x]) {
					case 1:
						jPanel.add(new JLabel(new ImageIcon(picWall1)));
						break;
					case 2:
						jPanel.add(new JLabel(new ImageIcon(picCrate)));
						break;
					default:
						jPanel.add(new JLabel(new ImageIcon(picGround1)));
						break;
				}
			}
			
		}
	}
}
