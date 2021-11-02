import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyPanel extends JPanel implements KeyListener
{
	int x=448;
	int y=448;
	public void paint(Graphics g)
	{
		super.paint(g);
		Form ba = new Form();
		g.drawImage(ba.hero, x, y, this);
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
	public void load(floor fl){
        Form f = new Form();
		int n=15;
        JLabel map[][]=new JLabel[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(fl.floor_map[i][j]==1){
                    map[i][j] = new JLabel(f.wallIcon);
                    map[i][j].setBounds(32*j, 32*i, f.wallIcon.getIconWidth(), f.wallIcon.getIconHeight());
					this.add(map[i][j]);
                }
                else if(fl.floor_map[i][j]==0){
                    map[i][j] = new JLabel(f.groundIcon);
                    map[i][j].setBounds(32*j, 32*i, f.groundIcon.getIconWidth(), f.groundIcon.getIconHeight());
                    this.add(map[i][j]);
                }
            }
        }   
    }
}
