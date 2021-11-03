import javax.swing.JLabel;

public class Item extends JLabel{
    int ix;
    int iy;
    int item_class;
    Form f=new Form();
    public void action(){}
}

class up extends Item{
    int item_class=10;
    public up(int x,int y){
        ix=x;
        iy=y;
        this.setIcon(f.upIcon);
        this.setBounds(MyPanel.L*iy,MyPanel.L*ix,MyPanel.L,MyPanel.L);
    }
}

class down extends Item{
    int item_class=11;
}

class yellow_wall extends Item{
    int item_class=12;
}

class red_wall extends Item{
    int item_class=13;
}