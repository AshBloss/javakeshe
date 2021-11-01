import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
//已实现控制图片移动

public class playBall extends JFrame{
 
	MyPanel mp=null;
	ImageIcon hero = new ImageIcon("jpgs/hero1.png");
	Image image = hero.getImage();
	public static void main(String[] args) {
		playBall pb=new playBall();
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

class MyPanel extends JPanel implements KeyListener
{
	int x=320;
	int y=320;
	public void paint(Graphics g)
	{
		super.paint(g);
		playBall ba = new playBall();
		g.drawImage(ba.image, x, y, this);
	}
 
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				y-=32;
				this.repaint();
				break;
			case KeyEvent.VK_DOWN:
				y+=32;
				this.repaint();
				break;
			case KeyEvent.VK_LEFT:
				x-=32;
				this.repaint();
				break;
			case KeyEvent.VK_RIGHT:
				x+=32;
				this.repaint();
				break;
		}
		
	}
 
	@Override
	public void keyTyped(KeyEvent e) {	
	}
	@Override
	public void keyReleased(KeyEvent e) {	
	}
}