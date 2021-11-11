public class Hero {
    //属性
    String name;
    int atk=10;
    int def=10;
    int HP=1000;
    //死亡
    boolean death=false;
    //物品
    int yellowkey_num=0;
    int redkey_num=0;
    int breakwall_num=0;
    int cfly_num=0;
    int front = 0;
    //构造
    public Hero(String na){
        name = new String(na);
    }
    //物品属性加减运算
    public void add_atk(int i){
        this.atk += i;
    }
    public void add_def(int i){
        this.def += i;
    }
    public void add_HP(int i){
        this.HP += i;
    }
    public void add_yk(){
        this.yellowkey_num++;
    }
    public void add_rk(){
        this.redkey_num++;
    }
    public void cost_yk(){
        this.yellowkey_num--;
    }
    public void cost_rk(){
        this.redkey_num--;
    }
    public void cost_HP(int i){
        this.HP-=i;
    }
    //判死
    public void dead(){
        if(this.HP<=0){
            this.death=true;
        }
    }
    //战斗
    public void battle(Enemy em){
        int sp = this.csp(em);
        if(sp==-1){
            this.death=true;
        }
        else{
            this.cost_HP(sp);
            em.defeat();
            this.dead();
        }

    }
    //计算损失
    public int csp(Enemy em){
        int sp;
        int datk = this.atk - em.def;
        int ddef = em.atk - this.def;
        if(datk<=0){
            sp=-1;
        }
        else if(ddef<=0){
            sp=0;
        }
        else{
            int turn = em.HP/datk;
            sp = turn*ddef;
        }
        return sp;
    }
}
