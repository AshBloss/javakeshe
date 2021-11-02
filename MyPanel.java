import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyPanel extends JPanel implements KeyListener
{
	public static final int L=32;
	int x=L;
	int y=L;
	int xp = x/L;
	int yp = y/L;
	public void paint(Graphics g)
	{
		super.paint(g);
		Form ba = new Form();
		g.drawImage(ba.hero, x, y, this);
	}
 
	@Override
	public void keyPressed(KeyEvent e) {
		floor fl = new floor();
		switch (e.getKeyCode()){
			case KeyEvent.VK_UP:
				yp--;
				if(fl.floor_map[yp][xp]==0){
					y-=L;
					this.repaint();
				}
				else{
					yp++;
				}
				break;
			case KeyEvent.VK_DOWN:
				yp++;
				if(fl.floor_map[yp][xp]==0){
					y+=L;
					this.repaint();
				}
				else{
					yp--;
				}
				break;
			case KeyEvent.VK_LEFT:
				xp--;
				if(fl.floor_map[yp][xp]==0){
					x-=L;
					this.repaint();
				}
				else{
					xp++;
				}
				break;
			case KeyEvent.VK_RIGHT:
				xp++;
				if(fl.floor_map[yp][xp]==0){
					x+=L;
					this.repaint();
				}
				else{
					xp--;
				}
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
                    map[i][j].setBounds(L*j, L*i, f.wallIcon.getIconWidth(), f.wallIcon.getIconHeight());
					this.add(map[i][j]);
                }
                else if(fl.floor_map[i][j]==0){
                    map[i][j] = new JLabel(f.groundIcon);
                    map[i][j].setBounds(L*j, L*i, f.groundIcon.getIconWidth(), f.groundIcon.getIconHeight());
                    this.add(map[i][j]);
                }
            }
        }   
    }
}
