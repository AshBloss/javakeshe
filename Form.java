import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Form{
    public static void main(String[] args) {
        JFrame game = new JFrame("mota");
        ImageIcon hero = new ImageIcon("jpgs/hero1.png");
        JLabel label = new JLabel(hero);
        label.setSize(hero.getIconWidth(), hero.getIconHeight());
        game.setBounds(300, 300, 500, 500);
        game.setLayout(new FlowLayout());
        game.add(label);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}