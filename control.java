import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class control{

}
class MyPanel extends JPanel implements KeyListener
{
	int x=320;
	int y=320;
	public void paint(Graphics g)
	{
		super.paint(g);
		Form ba = new Form();
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
