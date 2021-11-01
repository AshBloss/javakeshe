import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
public class Form extends JFrame{
    MyPanel mp=null;
	ImageIcon heroIcon = new ImageIcon("jpgs/hero.png");
	ImageIcon groundIcon = new ImageIcon("jpgs/ground.png");
	ImageIcon wallIcon = new ImageIcon("jpgs/wall.png");
	Image hero = heroIcon.getImage();
	int floornow = 1;
	public static void main(String[] args) {
		Form pb=new Form();
		pb.run();
	}
	public void run()
	{
		mp=new MyPanel();
		mp.setLayout(null);
		this.setLayout(null);
		mp.setBounds(0, 0, 480, 480);
		floor fl=new floor1();
		fl.load(mp);
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(493,518);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}