
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Form extends JFrame implements KeyListener{
	//加载图片资源
	public Image hero = Imagejpgs.herodIcon.getImage();

	JLabel showHP;
	JLabel showatk;
	JLabel showdef;
	JLabel showye;
	JLabel showre;
	JLabel showbr;
	JLabel showfy;
	JPanel attribute;
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
		this.setSize(615,518);
		attribute = new JPanel();
		attribute.setLayout(null);
		attribute.setBounds(480, 0, 120, 320);
		attribute.setBackground(Color.gray);

		showHP = new JLabel(""+h.HP,Imagejpgs.HPIcon,JLabel.LEFT);
		showatk = new JLabel(""+h.atk,Imagejpgs.atkIcon,JLabel.LEFT);
		showdef = new JLabel(""+h.def,Imagejpgs.defIcon,JLabel.LEFT);
		showye = new JLabel(""+h.yellowkey_num, Imagejpgs.yellowkeyIcon, JLabel.LEFT);
		showre = new JLabel(""+h.redkey_num, Imagejpgs.redkeyIcon, JLabel.LEFT);
		showbr = new JLabel(""+h.breakwall_num, Imagejpgs.breakwallIcon, JLabel.LEFT);
		showfy = new JLabel(""+h.cfly_num, Imagejpgs.cflyIcon, JLabel.LEFT);
		showHP.setBounds(0,0,110,70);
		showatk.setBounds(0,70,110,70);
		showdef.setBounds(0,140,110,70);
		showye.setBounds(0,210,60,50);
		showre.setBounds(60, 210, 60, 50);
		showbr.setBounds(0, 260, 60, 50);
		showfy.setBounds(60, 260, 60, 50);
		attribute.add(showHP);
		attribute.add(showatk);
		attribute.add(showdef);
		attribute.add(showbr);
		attribute.add(showfy);
		attribute.add(showre);
		attribute.add(showye);

		this.add(attribute);
		
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
		g.drawImage(hero, x, y, this);
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
				h.front=2;
				hero = Imagejpgs.herouIcon.getImage();
				this.repaint();
				Boolean go=true;
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16||fl.get(fn).fl_item[yp][xp].item_class==23)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						//上楼
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
				this.updateatt();
				break;
			}

			case KeyEvent.VK_DOWN:{			//下
				yp++;
				h.front=0;
				hero = Imagejpgs.herodIcon.getImage();
				this.repaint();
				Boolean go=true;
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16||fl.get(fn).fl_item[yp][xp].item_class==23)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
				this.updateatt();
				break;
			}
			case KeyEvent.VK_LEFT:{			//左
				xp--;
				h.front=1;
				hero = Imagejpgs.herolIcon.getImage();
				this.repaint();
				Boolean go=true;
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16||fl.get(fn).fl_item[yp][xp].item_class==23)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
				this.updateatt();
				break;
			}
			case KeyEvent.VK_RIGHT:{		//右
				xp++;
				h.front=3;
				hero = Imagejpgs.herorIcon.getImage();
				this.repaint();
				Boolean go=true;
				Boolean changefloor = false;
				if(!fl.get(fn).fl_map[yp][xp].is_wall){
					if(fl.get(fn).fl_item[yp][xp].existence){
						fl.get(fn).fl_item[yp][xp].action_in(h);
						fl.get(fn).fl_item[yp][xp].update();
						if((fl.get(fn).fl_item[yp][xp].item_class==12||fl.get(fn).fl_item[yp][xp].item_class==13||fl.get(fn).fl_item[yp][xp].item_class==16||fl.get(fn).fl_item[yp][xp].item_class==23)&&fl.get(fn).fl_item[yp][xp].existence){
							go=false;
						}
						if(fl.get(fn).fl_item[yp][xp].item_class==10){
							if((fn+1)>=fl.size()){
								JOptionPane.showMessageDialog(null, "You win!!!!", "Win", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
						fl.get(fn).fl_enemy[yp][xp].update();
					}
					if(h.death){
						System.out.println("You died");
						JOptionPane.showMessageDialog(null, "You died!Please try again.", "Die", JOptionPane.INFORMATION_MESSAGE,Imagejpgs.herodIcon);
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
				this.updateatt();
				break;
			}
			case KeyEvent.VK_ESCAPE:{
				this.endgame();
				break;
			}
			case KeyEvent.VK_X:{
				new enemybook();
				break;
			}
			case KeyEvent.VK_1:{
				if(h.breakwall_num>0){
					Boolean canuse=false;
					switch(h.front){
						case 0:{
							yp++;
							if(fl.get(fn).fl_map[yp][xp].is_wall&&yp!=14){
								canuse=true;
								fl.get(fn).fl_map[yp][xp].is_wall=false;
								fl.get(fn).fl_map[yp][xp].setIcon(Imagejpgs.groundIcon);
							}
							yp--;
							break;
						}
						case 1:{
							xp--;
							if(fl.get(fn).fl_map[yp][xp].is_wall&&xp!=0){
								canuse=true;
								fl.get(fn).fl_map[yp][xp].is_wall=false;
								fl.get(fn).fl_map[yp][xp].setIcon(Imagejpgs.groundIcon);
							}
							xp++;
							break;
						}
						case 2:{
							yp--;
							if(fl.get(fn).fl_map[yp][xp].is_wall&&yp!=0){
								canuse=true;
								fl.get(fn).fl_map[yp][xp].is_wall=false;
								fl.get(fn).fl_map[yp][xp].setIcon(Imagejpgs.groundIcon);
							}
							yp++;
							break;
						}
						case 3:{
							xp++;
							if(fl.get(fn).fl_map[yp][xp].is_wall&&xp!=14){
								canuse=true;
								fl.get(fn).fl_map[yp][xp].is_wall=false;
								fl.get(fn).fl_map[yp][xp].setIcon(Imagejpgs.groundIcon);
							}
							xp--;
							break;
						}
					}
					if(canuse){
						h.breakwall_num--;
					}
				}
				this.updateatt();
				break;
			}
			case KeyEvent.VK_2:{
				if(h.cfly_num>0){
					xp = 14 - xp;
					yp = 14 - yp;
					if(!fl.get(fn).fl_map[yp][xp].is_wall){
						x = xp*L + Dx;
						y = yp*L + Dy;
						this.repaint();
						h.cfly_num--;
					}
					else{
						xp = 14 - xp;
						yp = 14 - yp;
					}
				}
				this.updateatt();
				break;
			}
		}
	}
 
	@Override
	public void keyTyped(KeyEvent e) {	
	}
	@Override
	public void keyReleased(KeyEvent e) {	
	}

	public void updateatt(){
		this.showHP.setText(""+this.h.HP);
		this.showatk.setText(""+this.h.atk);
		this.showdef.setText(""+this.h.def);
		this.showye.setText(""+this.h.yellowkey_num);
		this.showre.setText(""+this.h.redkey_num);
		this.showbr.setText(""+this.h.breakwall_num);
		this.showfy.setText(""+this.h.cfly_num);
	}
}