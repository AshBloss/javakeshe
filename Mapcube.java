import javax.swing.JLabel;
import javax.swing.Icon;

public class Mapcube extends JLabel{
    int mx;
    int my;
    int cube_class;
    Form f=new Form();
    public Mapcube(int mx1, int my1, int cl){
        mx=mx1;
        my=my1;
        cube_class = cl;
        this.setBounds(MyPanel.L*my, MyPanel.L*my, MyPanel.L, MyPanel.L);
        switch(cube_class){
            case 0:
                this.setIcon(f.groundIcon);
                break;
            case 1:
                this.setIcon(f.wallIcon);
                break;
            case 2:
                this.setIcon(f.upIcon);
                break;
            case 3:
                this.setIcon(f.downIcon);
                break;
        }
    }
}
