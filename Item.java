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
                this.setIcon(Imagejpgs.upIcon);
                break;
            case 11:
                this.setIcon(Imagejpgs.downIcon);
                break;
            case 12:
                this.setIcon(Imagejpgs.yellowdoorIcon);
                break;
            case 13:
                this.setIcon(Imagejpgs.reddoorIcon);
                break;
            case 14:
                this.setIcon(Imagejpgs.yellowkeyIcon);
                break;
            case 15:
                this.setIcon(Imagejpgs.redkeyIcon);
                break;
            case 16:
                this.setIcon(Imagejpgs.specialdoorIcon);
                break;
            case 17:
                this.setIcon(Imagejpgs.redstoneIcon);
                break;
            case 18:
                this.setIcon(Imagejpgs.bluestoneIcon);
                break;
            case 19:
                this.setIcon(Imagejpgs.redbottleIcon);
                break;
            case 20:
                this.setIcon(Imagejpgs.bluebottleIcon);
                break;
            case 21:
                this.setIcon(Imagejpgs.breakwallIcon);
                break;
            case 22:
                this.setIcon(Imagejpgs.cflyIcon);
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
        String str=JOptionPane.showInputDialog(this,"一个正方形的边长增加20%后，它的面积增加百分之几?","回答问题，通过此门",JOptionPane.PLAIN_MESSAGE);
        if(str!=null){
            int in=Integer.parseInt(str);
<<<<<<< HEAD
            if(in==44){
                h.add_rk();
=======
            if(in==1){
>>>>>>> 45519b7f80d95bf76bea907a3f47029e5699bcbb
                this.existence=false;
            }

        }
    }
}


class red_stone extends Item{
    public red_stone(){
        super();
    }
    public red_stone(int x,int y,int ic){
        super(x, y, ic);
    }
    @Override
    public void action_in(Hero h){
        h.add_atk(2);
        this.existence=false;
    }
}

class blue_stone extends Item{
    public blue_stone(){
        super();
    }
    public blue_stone(int x,int y,int ic){
        super(x, y, ic);
    }
    @Override
    public void action_in(Hero h){
        h.add_def(2);
        this.existence=false;
    }
}

class red_bottle extends Item{
    public red_bottle(){
        super();
    }
    public red_bottle(int x,int y,int ic){
        super(x, y, ic);
    }
    @Override
    public void action_in(Hero h){
        h.add_HP(100);
        this.existence=false;
    }
}

class blue_bottle extends Item{
    public blue_bottle(){
        super();
    }
    public blue_bottle(int x,int y,int ic){
        super(x, y, ic);
    }
    @Override
    public void action_in(Hero h){
        h.add_HP(250);
        this.existence=false;
    }
}

class breakwall extends Item{
    public breakwall(){
        super();
    }
    public breakwall(int x,int y,int ic){
        super(x, y, ic);
    }
    @Override
    public void action_in(Hero h){
        h.breakwall_num++;
        this.existence=false;
    }
}

class cfly extends Item{
    public cfly(){
        super();
    }
    public cfly(int x,int y,int ic){
        super(x, y, ic);
    }
    @Override
    public void action_in(Hero h){
        h.cfly_num++;
        this.existence=false;
    }
}