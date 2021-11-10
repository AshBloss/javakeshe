import javax.swing.JLabel;

public class Enemy extends JLabel {
    int atk;
    int def;
    int HP;
    int ex;
    int ey;
    int enemy_cl;
    Boolean existence = true;
    //构造函数
    public Enemy(){
        super();
    }
    public Enemy(int x,int y){
        this.ex = x;
        this.ey = y;
        this.existence=false;
        this.setBounds(Form.L*ey, Form.L*ex, Form.L, Form.L);
    }
    public Enemy(int x,int y,int cl){
        super();
        this.ex = x;
        this.ey = y;
        this.enemy_cl = cl;
        this.setBounds(Form.L*ey, Form.L*ex, Form.L, Form.L);
    }

    public void update(){
        if(!this.existence){
            this.setIcon(null);
        }
    }

    public void defeat(){
        this.existence=false;
    }

    public void setatk(int i){
        this.atk=i;
    }

    public void setdef(int i){
        this.def = i;
    }

    public void setHP(int i){
        this.HP=i;
    }
}

class greenslm extends Enemy{
    public greenslm(){
        super();
        super.setatk(15);
        super.setdef(5);
        super.setHP(50);
        super.setIcon(Form.greenslmIcon);
    }
    public greenslm(int x, int y, int cl){
        super(x,y,cl);
        super.setatk(15);
        super.setdef(5);
        super.setHP(50);
        super.setIcon(Form.greenslmIcon);
    }
}

class redslm extends Enemy{
    public redslm(){
        super();
        super.setatk(20);
        super.setdef(6);
        super.setHP(100);
        super.setIcon(Form.redslmIcon);
    }
    public redslm(int x,int y, int cl){
        super(x, y, cl);
        super.setatk(20);
        super.setdef(6);
        super.setHP(100);
        super.setIcon(Form.redslmIcon);
    }
}

class smallbf extends Enemy{
    public smallbf(){
        super();
        super.setatk(50);
        super.setdef(20);
        super.setHP(1000);
        super.setIcon(Form.smallbfIcon);
    }
    public smallbf(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(50);
        super.setdef(20);
        super.setHP(1000);
        super.setIcon(Form.smallbfIcon);
    }
}
