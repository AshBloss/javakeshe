import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;

public class Form extends JFrame{
    MyPanel mp=null;
	ImageIcon hero = new ImageIcon("jpgs/hero.png");
	ImageIcon ground = new ImageIcon("jpgs/ground.png");
	ImageIcon wall = new ImageIcon("jpgs/wall.png");
	Image image = hero.getImage();
	public static void main(String[] args) {
		Form pb=new Form();
		pb.run();
	}
	public void run()
	{
		mp=new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}