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
        switch(cube_class){
            case 0:
                this.setIcon(f.groundIcon);
                break;
            case 1:
                this.setIcon(f.wallIcon);
                break;
        }
    }
}
