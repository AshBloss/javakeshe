import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//角色行为逻辑与地图逻辑
public class MyPanel extends JPanel implements KeyListener
{
	public static final int L=32;		//地图块尺寸
	//主角初始位置
	int x=L;
	int y=L;
	//主角初始地图坐标
	int xp = x/L;
	int yp = y/L;
	Hero me = new Hero("me");
	floor fl = new floor();
	//绘制主角
	public void paint(Graphics g)
	{
		super.paint(g);
		Form ba = new Form();
		g.drawImage(ba.hero, x, y, this);
	}
	//键盘控制事件，地图逻辑
	@Override
	public void keyPressed(KeyEvent e) {
		floor fl = new floor();
		switch (e.getKeyCode()){
			case KeyEvent.VK_UP:		//上
				yp--;
				if(fl.floor_map[yp][xp]!=1){
					y-=L;
					this.repaint();
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
				this.add(fl.fl_map[i][j]);
			}
		}
    }

	public void loaditem(){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				switch(fl.floor_map[i][j]){
					case 10:
						fl.fl_item[i][j] = new yellow_door(i, j, fl.floor_map[i][j]);

				}
			}
		}
	}
}
