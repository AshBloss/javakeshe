
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Form extends JFrame implements KeyListener{
	//加载图片资源
<<<<<<< HEAD
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
	public static ImageIcon specialdoorIcon = new ImageIcon("jpgs/specialdoor.png");
	public static ImageIcon enemybookIcon = new ImageIcon("jpgs/enemybook.png");
	public static ImageIcon HPIcon = new ImageIcon("jpgs/HP.png");
	public static ImageIcon atkIcon = new ImageIcon("jpgs/atk.png");
	public static ImageIcon defIcon = new ImageIcon("jpgs/def.png");
	public static Image hero = heroIcon.getImage();
=======
	public static Image hero = Imagejpgs.heroIcon.getImage();
>>>>>>> 118c0cd143961a2b5bdc5ffded419eea935d7e45

	public static int L = 32;			//地图块大小
	public static int Dx=7;				//窗口x差值
	public static int Dy=29;			//窗口y差值
	MyPanel mp=new MyPanel();
	//主角初始位置
	int x = L+7;
	int y = L+29;
	//主角初始地图坐标
	int xp = (x-7)/L;
	int yp = (y-29)/L;

	Hero h=new Hero("me");
	ArrayList<floor> fl = new ArrayList<floor>();
	int fn = 0;				//当前楼层

	//窗体与组件加载运行
	public void run(){
		this.loadfloor();
		mp.setLayout(null);
		this.setLayout(null);
		mp.setBounds(0, 0, 480, 480);
		mp.showmap(fl.get(0));
		this.addKeyListener(this);
		this.add(mp);
		this.setSize(580,518);
		JLabel sx1 = new JLabel(Hero.update(),HPIcon,JLabel.LEFT);
		JLabel sx2 = new JLabel(Hero.atk, atkIcon,JLabel.LEFT);
		JLabel sx3 = new JLabel(Hero.def,defIcon,JLabel.LEFT); 
		
		
		
		sx1.setBounds(480,0,110,172);
		sx2.setBounds(480,30,110,345);
		sx3.setBounds(480,60,110,518);
		this.add(sx1);
		this.add(sx2);
		this.add(sx3);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//初始化楼层
	public void loadfloor(){
		fl.add(new floor1());
		fl.get(0).loadmap();
		fl.add(new floor2());
		fl.get(1).loadmap();
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
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						//上楼
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
								this.endgame();
							}
							else {
								changefloor=true;
								this.fn++;
								mp.changemap(fl.get(fn));
								yp = fl.get(fn).yst;
								xp = fl.get(fn).xst;
								x = xp*L+Dx;
								y = xp*L+Dy;
								this.repaint();
							}
						}
						//下楼
						else if(fl.get(fn).fl_item[yp][xp].item_class==11){
							changefloor=true;
							this.fn--;
							mp.changemap(fl.get(fn));
							yp = fl.get(fn).ynx;
							xp = fl.get(fn).xnx;
							x = xp*L+Dx;
							y = xp*L+Dy;
							this.repaint();
						}
					}
					if(fl.get(fn).fl_enemy[yp][xp].existence){
						h.battle(fl.get(fn).fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
						this.endgame();
					}
				}
				else{
					go=false;
				}
				if(changefloor){}
				else if(go){
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
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);;
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
								this.endgame();
							}
							else {
								changefloor=true;
								this.fn++;
								mp.changemap(fl.get(fn));
								yp = fl.get(fn).yst;
								xp = fl.get(fn).xst;
								x = xp*L+Dx;
								y = xp*L+Dy;
								this.repaint();
							}
						}
						else if(fl.get(fn).fl_item[yp][xp].item_class==11){
							changefloor=true;
							this.fn--;
							mp.changemap(fl.get(fn));
							yp = fl.get(fn).ynx;
							xp = fl.get(fn).xnx;
							x = xp*L+Dx;
							y = xp*L+Dy;
							this.repaint();
						}
					}
					if(fl.get(fn).fl_enemy[yp][xp].existence){
						h.battle(fl.get(fn).fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
						this.endgame();
					}
				}
				else{
					go=false;
				}
				if(changefloor){}
				else if(go){
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
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
								this.endgame();
							}
							else {
								changefloor=true;
								this.fn++;
								mp.changemap(fl.get(fn));
								yp = fl.get(fn).yst;
								xp = fl.get(fn).xst;
								x = xp*L+Dx;
								y = xp*L+Dy;
								this.repaint();
							}
						}
						else if(fl.get(fn).fl_item[yp][xp].item_class==11){
							changefloor=true;
							this.fn--;
							mp.changemap(fl.get(fn));
							yp = fl.get(fn).ynx;
							xp = fl.get(fn).xnx;
							x = xp*L+Dx;
							y = xp*L+Dy;
							this.repaint();
						}
					}
					else if(fl.get(fn).fl_enemy[yp][xp].existence){
						h.battle(fl.get(fn).fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
						this.endgame();	
					}
				}
				else{
					go=false;
				}
				if(changefloor){}
				else if(go){
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
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>=fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
								this.endgame();
							}
							else {
								changefloor=true;
								this.fn++;
								mp.changemap(fl.get(fn));
								yp = fl.get(fn).yst;
								xp = fl.get(fn).xst;
								x = xp*L+Dx;
								y = xp*L+Dy;
								this.repaint();
							}
						}
						else if(fl.get(fn).fl_item[yp][xp].item_class==11){
							changefloor=true;
							this.fn--;
							mp.changemap(fl.get(fn));
							yp = fl.get(fn).ynx;
							xp = fl.get(fn).xnx;
							x = xp*L+Dx;
							y = xp*L+Dy;
							this.repaint();
						}
					}
					if(fl.get(fn).fl_enemy[yp][xp].existence){
						h.battle(fl.get(fn).fl_enemy[yp][xp]);
						System.out.println(h.HP);
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.heroIcon);
						this.endgame();
						
					}
				}
				else{
					go=false;
				}
				if(changefloor){}
				else if(go){
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
			case KeyEvent.VK_X:{
				new enemybook();
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