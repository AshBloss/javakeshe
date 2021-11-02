

import javax.swing.*;
import java.awt.event.*;


public class startForm extends JFrame implements ActionListener{
    ImageIcon bgImg=new ImageIcon("jpgs/background.jpg");
    ImageIcon icon1=new ImageIcon("jpgs/startgame.jpg");
    ImageIcon icon2=new ImageIcon("jpgs/Load.jpg");
    ImageIcon icon3=new ImageIcon("jpgs/exit.jpg");

    public static void main(String[] args) {
        new startForm();
    }
    public startForm(){
        this.setBounds(400,300,480,480);
        this.setResizable(false);

        JButton button1=new JButton("开始游戏");
        JButton button2=new JButton("读取存档");
        JButton button3=new JButton("退出");
        

        this.setLayout(null);

        button1.setBounds(180,220,110,50);
        button2.setBounds(180,280,110,50);
        button3.setBounds(180,340,110,50);
        button1.addActionListener(this);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        button1.setIcon(icon1);
        button2.setIcon(icon2);
        button3.setIcon(icon3);
        JLabel jl=new JLabel(bgImg);
        jl.setSize(480,480);
        this.add(jl);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        this.dispose();
        Form ga = new Form();
        ga.run();
    }
}
