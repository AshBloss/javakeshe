import javax.swing.JLabel;

public class Mapcube extends JLabel{
    int mx;
    int my;
    int cube_class;
    public Mapcube(int mx1, int my1, int cl){
        mx=mx1;
        my=my1;
        cube_class = cl;
        this.setBounds(MyPanel.L*my, MyPanel.L*mx, MyPanel.L, MyPanel.L);
        switch(cube_class){
            case 0:
                this.setIcon(Form.groundIcon);
                break;
            case 1:
                this.setIcon(Form.wallIcon);
                break;
            
            default:
                this.setIcon(Form.groundIcon);
            
        }
    }

    public Mapcube(){

    }
}
