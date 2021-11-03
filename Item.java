import javax.swing.JLabel;

public class Item extends JLabel{
    int ix;
    int iy;
    int item_class;
    boolean existence = true;
    Form f=new Form();
    public Item(){
        super();
    }
    public Item(int x,int y,int ic){
        super();
        this.ix=x;
        this.iy=y;
        this.item_class=ic;
        this.setBounds(MyPanel.L*iy,MyPanel.L*ix,MyPanel.L,MyPanel.L);
        switch(ic){
            case 10:
                this.setIcon(f.upIcon);
                break;
            case 11:
                this.setIcon(f.downIcon);
                break;
            case 12:
                this.setIcon(f.yellowdoorIcon);
                break;
            case 13:
                this.setIcon(f.reddoorIcon);
                break;
            case 14:
                this.setIcon(f.yellowkeyIcon);
                break;
            case 15:
                this.setIcon(f.redkeyIcon);
                break;
        }
    }
    public void action(){}
}

class up extends Item{
    public up(){
        super();
    }
    public up(int x,int y,int ic){
        super(x,y,ic);
    }
}

class down extends Item{
    public down(){
        super();
    }
    public down(int x,int y,int ic){
        super(x,y,ic);
    }
}

class yellow_door extends Item{
    public yellow_door(){
        super();
    }
    public yellow_door(int x,int y,int ic){
        super(x,y,ic);
    }
}

class red_door extends Item{
    public red_door(){
        super();
    }
    public red_door(int x,int y,int ic){
        super(x,y,ic);
    }
}

class yellow_key extends Item{
    public yellow_key(){
        super();
    }
    public yellow_key(int x,int y,int ic){
        super(x,y,ic);
    }
}

class red_key extends Item{
    public red_key(){
        super();
    }
    public red_key(int x,int y,int ic){
        super(x,y,ic);
    }
}