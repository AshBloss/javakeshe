import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
public class Form extends JFrame{
    MyPanel mp=null;
	//加载图片资源
	ImageIcon heroIcon = new ImageIcon("jpgs/hero.png");
	ImageIcon groundIcon = new ImageIcon("jpgs/ground.png");
	ImageIcon wallIcon = new ImageIcon("jpgs/wall.png");
	ImageIcon upIcon = new ImageIcon("jpgs/up.png");
	ImageIcon downIcon = new ImageIcon("jpgs/down.png");
	Image hero = heroIcon.getImage();

	//Form st;
	Form ga;
	//窗体与组件加载运行
	public void run()
	{
		mp=new MyPanel();
		mp.setLayout(null);
		this.setLayout(null);
		mp.setBounds(0, 0, 480, 480);
		floor fl=new floor();
		//fl.load(mp);
		mp.load(fl);
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(493,518);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}