import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//角色行为逻辑与地图逻辑
public class MyPanel extends JLayeredPane implements KeyListener
{
	public static final int L=32;		//地图块尺寸
	//主角初始位置
	int x=L;
	int y=L;
	//主角初始地图坐标
	int xp = x/L;
	int yp = y/L;
	Hero h = new Hero("me");
	floor fl = new floor();
	Form ba = new Form();
	//绘制主角
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(Form.hero, x, y, this);
	}
	//键盘控制事件，地图逻辑
	@Override
	public void keyPressed(KeyEvent e) {
		floor fl = new floor();
		switch (e.getKeyCode()){
			case KeyEvent.VK_UP:		//上
				yp--;
				if(fl.floor_map[yp][xp]!=1){
					if(fl.fl_item[yp][xp]!=null){
						fl.fl_item[yp][xp].action_in(h);
						fl.update(fl.fl_item[yp][xp]);
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Form.heroIcon);
						
					}
					else{
						y-=L;
						this.repaint();
					}
				}
				else{
					yp++;
				}
				break;
			case KeyEvent.VK_DOWN:		//下
				yp++;
				if(fl.floor_map[yp][xp]!=1){
					y+=L;
					this.repaint();
				}
				else{
					yp--;
				}
				break;
			case KeyEvent.VK_LEFT:		//左
				xp--;
				if(fl.floor_map[yp][xp]!=1){
					x-=L;
					this.repaint();
				}
				else{
					xp++;
				}
				break;
			case KeyEvent.VK_RIGHT:		//右
				xp++;
				if(fl.floor_map[yp][xp]!=1){
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
	//加载地图
	public void loadmap(){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				fl.fl_map[i][j] = new Mapcube(i, j, fl.floor_map[i][j]);
				this.add(fl.fl_map[i][j],JLayeredPane.DEFAULT_LAYER);
			}
		}
    }
	
	public void loaditem(){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				switch(fl.floor_map[i][j]){
					case 10:
						fl.fl_item[i][j] = new up(i, j, fl.floor_map[i][j]);
						break;
					case 11:
						fl.fl_item[i][j] = new down(i,j,fl.floor_map[i][j]);
						break;
					case 12:
						fl.fl_item[i][j] = new yellow_door(i, j, fl.floor_map[i][j]);
						break;
					case 13:
						fl.fl_item[i][j] = new red_door(i, j, fl.floor_map[i][j]);
						break;
					case 14:
						fl.fl_item[i][j] = new yellow_key(i, j, fl.floor_map[i][j]);
						break;
					case 15:
						fl.fl_item[i][j] = new red_key(i, j, fl.floor_map[i][j]);
						break;
					default:
						fl.fl_item[i][j] = new Item();
						break;
				}
				this.add(fl.fl_item[i][j],JLayeredPane.PALETTE_LAYER);
			}
		}
	}
	
}
