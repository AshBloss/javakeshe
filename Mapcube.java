import javax.swing.JLabel;

public class Mapcube extends JLabel{
    int mx;
    int my;
    int cube_class;
    Boolean is_wall;
    public Mapcube(int mx1, int my1, int cl){
        mx=mx1;
        my=my1;
        cube_class = cl;
        this.setBounds(Form.L*my, Form.L*mx, Form.L, Form.L);
        switch(cube_class){
            case 0:
                this.setIcon(Imagejpgs.groundIcon);
                this.is_wall=false;
                break;
            case 1:
                this.setIcon(Imagejpgs.wallIcon);
                this.is_wall=true;
                break;
            default:
                this.setIcon(Imagejpgs.groundIcon);
                this.is_wall=false;
                break;
        }
    }

    public Mapcube(){
    }
}
