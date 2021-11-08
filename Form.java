import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
public class Form extends JFrame{
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
	//窗体与组件加载运行
	public void run(){
		MyPanel mp=new MyPanel();
		mp.setLayout(null);
		this.setLayout(null);
		mp.setBounds(0, 0, 480, 480);
		//floor fl=new floor();
		//fl.load(mp);
		mp.loadmap();
		mp.loaditem();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(493,518);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void endgame(){
		this.dispose();
		new startForm();
	}
}