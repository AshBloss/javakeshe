import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
public class Form extends JFrame{
    MyPanel mp=null;
	//加载图片资源
	ImageIcon heroIcon = new ImageIcon("jpgs/hero.png");
	ImageIcon groundIcon = new ImageIcon("jpgs/ground.png");
	ImageIcon wallIcon = new ImageIcon("jpgs/wall.png");
	ImageIcon upIcon = new ImageIcon("jpgs/up.png");
	ImageIcon downIcon = new ImageIcon("jpgs/down.png");
	ImageIcon redkeyIcon = new ImageIcon("jpgs/redkey.png");
	ImageIcon reddoorIcon = new ImageIcon("jpgs/reddoor.png");
	ImageIcon yellowkeyIcon = new ImageIcon("jpgs/yellowkey.png");
	ImageIcon yellowdoorIcon = new ImageIcon("jpgs/yellowdoor.png");
	ImageIcon greenslmIcon = new ImageIcon("jpgs/greenslm.png");
	ImageIcon redslmIcon = new ImageIcon("jpgs/redslm.png");
	ImageIcon smallbfIcon = new ImageIcon("jpgs/smallbf.png");
	Image hero = heroIcon.getImage();
	//窗体与组件加载运行
	public void run()
	{
		mp=new MyPanel();
		mp.setLayout(null);
		this.setLayout(null);
		mp.setBounds(0, 0, 480, 480);
		floor fl=new floor();
		//fl.load(mp);
		mp.loadmap();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(493,518);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}