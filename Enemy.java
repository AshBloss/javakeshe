import javax.swing.JLabel;

public class Enemy extends JLabel {
    int atk,def,HP,ex,ey,enemy_cl;
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
        super.setatk(8);
        super.setdef(0);
        super.setHP(50);
        super.setIcon(Imagejpgs.greenslmIcon);
    }
    public greenslm(int x, int y, int cl){
        super(x,y,cl);
        super.setatk(8);
        super.setdef(0);
        super.setHP(50);
        super.setIcon(Imagejpgs.greenslmIcon);
    }
}

class redslm extends Enemy{
    public redslm(){
        super();
        super.setatk(12);
        super.setdef(0);
        super.setHP(50);
        super.setIcon(Imagejpgs.redslmIcon);
    }
    public redslm(int x,int y, int cl){
        super(x, y, cl);
        super.setatk(12);
        super.setdef(0);
        super.setHP(50);
        super.setIcon(Imagejpgs.redslmIcon);
    }
}

class smallbf extends Enemy{
    public smallbf(){
        super();
        super.setatk(30);
        super.setdef(0);
        super.setHP(100);
        super.setIcon(Imagejpgs.smallbfIcon);
    }
    public smallbf(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(30);
        super.setdef(0);
        super.setHP(100);
        super.setIcon(Imagejpgs.smallbfIcon);
    }
}

class blackslm extends Enemy{
    public blackslm(){
        super();
        super.setatk(40);
        super.setdef(0);
        super.setHP(120);
        super.setIcon(Imagejpgs.blackslmIcon);
    }
    public blackslm(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(40);
        super.setdef(0);
        super.setHP(120);
        super.setIcon(Imagejpgs.blackslmIcon);
    }
}

class smallkl extends Enemy{
    public smallkl(){
        super();
        super.setatk(53);
        super.setdef(5);
        super.setHP(200);
        super.setIcon(Imagejpgs.smallklIcon);
    }
    public smallkl(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(53);
        super.setdef(5);
        super.setHP(200);
        super.setIcon(Imagejpgs.smallklIcon);
    }
}

class bigbf extends Enemy{
    public bigbf(){
        super();
        super.setatk(50);
        super.setdef(10);
        super.setHP(150);
        super.setIcon(Imagejpgs.bigbfIcon);
    }
    public bigbf(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(50);
        super.setdef(10);
        super.setHP(150);
        super.setIcon(Imagejpgs.bigbfIcon);
    }
}

class shouren extends Enemy{
    public shouren(){
        super();
        super.setatk(60);
        super.setdef(10);
        super.setHP(600);
        super.setIcon(Imagejpgs.shourenIcon);
    }
    public shouren(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(60);
        super.setdef(10);
        super.setHP(600);
        super.setIcon(Imagejpgs.shourenIcon);
    }
}

class bigkl extends Enemy{
    public bigkl(){
        super();
        super.setatk(70);
        super.setdef(30);
        super.setHP(800);
        super.setIcon(Imagejpgs.bigklIcon);
    }
    public bigkl(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(70);
        super.setdef(30);
        super.setHP(800);
        super.setIcon(Imagejpgs.bigklIcon);
    }
}

class bigslm extends Enemy{
    public bigslm(){
        super();
        super.setatk(120);
        super.setdef(10);
        super.setHP(300);
        super.setIcon(Imagejpgs.bigslmIcon);
    }
    public bigslm(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(120);
        super.setdef(10);
        super.setHP(300);
        super.setIcon(Imagejpgs.bigslmIcon);
    }
}

class redbf extends Enemy{
    public redbf(){
        super();
        super.setatk(90);
        super.setdef(30);
        super.setHP(400);
        super.setIcon(Imagejpgs.redbfIcon);
    }
    public redbf(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(90);
        super.setdef(30);
        super.setHP(400);
        super.setIcon(Imagejpgs.redbfIcon);
    }
}

class blackqs extends Enemy{
    public blackqs(){
        super();
        super.setatk(80);
        super.setdef(40);
        super.setHP(600);
        super.setIcon(Imagejpgs.blackqsIcon);
    }
    public blackqs(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(80);
        super.setdef(40);
        super.setHP(600);
        super.setIcon(Imagejpgs.blackqsIcon);
    }
}

class blackking extends Enemy{
    public blackking(){
        super();
        super.setatk(90);
        super.setdef(50);
        super.setHP(1000);
        super.setIcon(Imagejpgs.blackkingIcon);
    }
    public blackking(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(90);
        super.setdef(50);
        super.setHP(1000);
        super.setIcon(Imagejpgs.blackkingIcon);
    }
}

class redqs extends Enemy{
    public redqs(){
        super();
        super.setatk(80);
        super.setdef(50);
        super.setHP(1200);
        super.setIcon(Imagejpgs.redqsIcon);
    }
    public redqs(int x, int y,int cl){
        super(x, y, cl);
        super.setatk(80);
        super.setdef(50);
        super.setHP(1200);
        super.setIcon(Imagejpgs.redqsIcon);
    }
}