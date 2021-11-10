import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Item extends JLabel{
    int ix;
    int iy;
    int item_class;
    boolean existence = true;
    public Item(){
        super();
    }
    public Item(int x, int y){
        this.ix=x;
        this.iy=y;
        this.existence=false;
        this.setBounds(Form.L*iy,Form.L*ix,Form.L,Form.L);
    }
    public Item(int x,int y,int ic){
        super();
        this.ix=x;
        this.iy=y;
        this.item_class=ic;
        this.setBounds(Form.L*iy,Form.L*ix,Form.L,Form.L);
        switch(ic){
            case 10:
                this.setIcon(Form.upIcon);
                break;
            case 11:
                this.setIcon(Form.downIcon);
                break;
            case 12:
                this.setIcon(Form.yellowdoorIcon);
                break;
            case 13:
                this.setIcon(Form.reddoorIcon);
                break;
            case 14:
                this.setIcon(Form.yellowkeyIcon);
                break;
            case 15:
                this.setIcon(Form.redkeyIcon);
                break;
            case 16:
                this.setIcon(Form.specialdoorIcon);
                break;
        }
    }
    public void update(){
        if(!this.existence){
            this.setIcon(null);
        }
    }
    public void action_in(Hero h){}
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
    @Override
    public void action_in(Hero h){
        if(h.yellowkey_num>0){
            h.cost_yk();
            this.existence=false;
        }
    }
}

class red_door extends Item{
    public red_door(){
        super();
    }
    public red_door(int x,int y,int ic){
        super(x,y,ic);
    }
    @Override
    public void action_in(Hero h){
        if(h.redkey_num>0){
            h.cost_rk();
            this.existence=false;
        }
    }
}

class yellow_key extends Item{
    public yellow_key(){
        super();
    }
    public yellow_key(int x,int y,int ic){
        super(x,y,ic);
    }
    @Override
    public void action_in(Hero h){
        h.add_yk();
        this.existence=false;
    }
}

class red_key extends Item{
    public red_key(){
        super();
    }
    public red_key(int x,int y,int ic){
        super(x,y,ic);
    }
    @Override
    public void action_in(Hero h){
        h.add_rk();
        this.existence=false;
    }
}
class special_door extends Item {
    public special_door(){
        super();
    }
    public special_door(int x,int y,int ic){
        super(x,y,ic);
    }
    @Override
    public void action_in(Hero h) {
        String str=JOptionPane.showInputDialog(this,"梓萱是不是最帅的人 1=是 0=否","回答问题，通过此门",JOptionPane.PLAIN_MESSAGE);
        if(str!=null){
            int in=Integer.parseInt(str);
            if(in==1){
                h.add_rk();
                this.existence=false;
            }

        }
    }
}
