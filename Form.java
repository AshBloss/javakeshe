import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;
public class Form extends JFrame implements KeyListener{
	//加载图片资源
	public static ImageIcon heroIcon = new ImageIcon("jpgs/hero.png");
	public static ImageIcon groundIcon = new ImageIcon("jpgs/ground.png");
	public static ImageIcon wallIcon = new ImageIcon("jpgs/wall.png");
	public static ImageIcon upIcon = new ImageIcon("jpgs/up.png");
	public static ImageIcon downIcon = new ImageIcon("jpgs/down.png");
	public static ImageIcon redkeyIcon = new ImageIcon("jpgs/redkey.png");
	public static ImageIcon reddoorIcon = new ImageIcon("jpgs/reddoor.png");
	public static ImageIcon yellowkeyIcon = new ImageIcon("jpgs/yellowkey.png");
	public static ImageIcon yellowdoorIcon = new ImageIcon("jpgs/yellowdoor.png");
	public static ImageIcon greenslmIcon = new ImageIcon("jpgs/greenslm.png");
	public static ImageIcon redslmIcon = new ImageIcon("jpgs/redslm.png");
	public static ImageIcon smallbfIcon = new ImageIcon("jpgs/smallbf.png");
	public static Image hero = heroIcon.getImage();
	public static int L = 32;
	MyPanel mp=new MyPanel();
	//主角初始位置
	int x = L+7;
	int y = L+29;
	//主角初始地图坐标
	int xp = (x-7)/L;
	int yp = (y-29)/L;

	Hero h=new Hero("me");
	floor fl=new floor();

	//窗体与组件加载运行
	public void run(){
		mp.setLayout(null);
		this.setLayout(null);
		mp.setBounds(0, 0, 480, 480);
		mp.loadmap(fl);
		this.addKeyListener(this);
		this.add(mp);
		this.setSize(493,518);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//绘制主角
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(Form.hero, x, y, this);
	}
	//返回主菜单
	public void endgame(){
		this.dispose();
		new startForm();
	}
	//控制逻辑与地图行走逻辑，以及事件触发逻辑
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
			case KeyEvent.VK_UP:{			//上
				yp--;
				Boolean go=true;
				if(fl.floor_map[yp][xp]!=1){
					if(fl.fl_item[yp][xp].existence){
						fl.fl_item[yp][xp].action_in(h);
						fl.fl_item[yp][xp].update();
						if((fl.fl_item[yp][xp].item_class==12||fl.fl_item[yp][xp].item_class==13)&&fl.fl_item[yp][xp].existence){
							go=false;
						}
					}
					if(fl.fl_enemy[yp][xp].existence){
						h.battle(fl.fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.fl_enemy[yp][xp].update();
					}
					if(h.death){
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Form.heroIcon);
						this.endgame();
					}
				}
				else{
					go=false;
				}
				if(go){
					y-=L;
					this.repaint();
				}
				else{
					yp++;
				}
				break;
			}
			case KeyEvent.VK_DOWN:{			//下
				yp++;
				Boolean go=true;
				if(fl.floor_map[yp][xp]!=1){
					if(fl.fl_item[yp][xp].existence){
						fl.fl_item[yp][xp].action_in(h);;
						fl.fl_item[yp][xp].update();
						if((fl.fl_item[yp][xp].item_class==12||fl.fl_item[yp][xp].item_class==13)&&fl.fl_item[yp][xp].existence){
							go=false;
						}
					}
					if(fl.fl_enemy[yp][xp].existence){
						h.battle(fl.fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Form.heroIcon);
						this.endgame();
					}
				}
				else{
					go=false;
				}
				if(go){
					y+=L;
					this.repaint();
				}
				else{
					yp--;
				}
				break;
			}
			case KeyEvent.VK_LEFT:{			//左
				xp--;
				Boolean go=true;
				if(fl.floor_map[yp][xp]!=1){
					if(fl.fl_item[yp][xp].existence){
						fl.fl_item[yp][xp].action_in(h);
						fl.fl_item[yp][xp].update();
						if((fl.fl_item[yp][xp].item_class==12||fl.fl_item[yp][xp].item_class==13)&&fl.fl_item[yp][xp].existence){
							go=false;
						}
					}
					if(fl.fl_enemy[yp][xp].existence){
						h.battle(fl.fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Form.heroIcon);
						this.endgame();	
					}
				}
				else{
					go=false;
				}
				if(go){
					x-=L;
					this.repaint();
				}
				else{
					xp++;
				}
				break;
			}
			case KeyEvent.VK_RIGHT:{		//右
				xp++;
				Boolean go=true;
				if(fl.floor_map[yp][xp]!=1){
					if(fl.fl_item[yp][xp].existence){
						fl.fl_item[yp][xp].action_in(h);
						fl.fl_item[yp][xp].update();
						if((fl.fl_item[yp][xp].item_class==12||fl.fl_item[yp][xp].item_class==13)&&fl.fl_item[yp][xp].existence){
							go=false;
						}
					}
					if(fl.fl_enemy[yp][xp].existence){
						h.battle(fl.fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Form.heroIcon);
						this.endgame();
						
					}
				}
				else{
					go=false;
				}
				if(go){
					x+=L;
					this.repaint();
				}
				else{
					xp--;
				}
				break;
			}
			case KeyEvent.VK_ESCAPE:{
				this.endgame();
			}
		}
	}
 
	@Override
	public void keyTyped(KeyEvent e) {	
	}
	@Override
	public void keyReleased(KeyEvent e) {	
	}
}