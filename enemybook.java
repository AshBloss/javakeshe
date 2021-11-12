import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class enemybook extends JFrame {
    public static int lo = 100;
    ArrayList<enemybookPanel> empa = new ArrayList<enemybookPanel>();
    public enemybook(Hero h){

        empa.add(new enemybookPanel(new greenslm(),h));
        empa.add(new enemybookPanel(new redslm(),h));
        empa.add(new enemybookPanel(new smallbf(),h));
        empa.add(new enemybookPanel(new blackslm(),h));
        empa.add(new enemybookPanel(new smallkl(),h));
        empa.add(new enemybookPanel(new bigbf(),h));
        empa.add(new enemybookPanel(new shouren(),h));
        empa.add(new enemybookPanel(new bigkl(),h));
        empa.add(new enemybookPanel(new bigslm(),h));
        empa.add(new enemybookPanel(new redbf(),h));
        empa.add(new enemybookPanel(new blackqs(),h));
        empa.add(new enemybookPanel(new blackking(),h));
        empa.add(new enemybookPanel(new redqs(),h));
        for(int i=0;i<empa.size();i++){
            empa.get(i).setBounds(20, 20+40*i, 400, 40);
        }

        this.setTitle("怪物手册");
        this.setLayout(null);
        this.setBounds(0,0,450,600);
        for(int i=0;i<empa.size();i++){
            this.add(empa.get(i));
        }
        this.setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

class enemybookPanel extends JPanel{
    JLabel icon;
    JLabel atk;
    JLabel def;
    JLabel HP;
    JLabel sp;

    public enemybookPanel(Enemy enemy,Hero h){
        this.atk = new JLabel("攻击："+enemy.atk);
        this.atk.setForeground(Color.WHITE);
        this.def = new JLabel("防御："+enemy.def);
        this.def.setForeground(Color.WHITE);
        this.HP = new JLabel("生命："+enemy.HP);
        this.HP.setForeground(Color.WHITE);
        this.icon = new JLabel(enemy.getIcon());
        this.icon.setBounds(20, 0, Form.L, Form.L);
        if(h.csp(enemy)==-1){
            this.sp = new JLabel("你无法攻击");
            this.sp.setForeground(Color.RED);
        }
        else if(h.csp(enemy)>=h.HP){
            this.sp = new JLabel("损失："+h.csp(enemy));
            this.sp.setForeground(Color.YELLOW);
        }
        else{
            this.sp = new JLabel("损失："+h.csp(enemy));
            this.sp.setForeground(Color.WHITE);
        }
        this.HP.setBounds(60, 0, 100, 20);
        this.atk.setBounds(140, 0, 100, 20);
        this.def.setBounds(220, 0, 100, 20);
        this.sp.setBounds(300, 0, 100, 20);
        this.setLayout(null);
        this.add(this.atk);
        this.add(this.def);
        this.add(this.HP);
        this.add(this.icon);
        this.add(this.sp);
        this.setBackground(Color.BLACK);
    }
}