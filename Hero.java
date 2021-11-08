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
        int turn,sp;
        if(em.atk<=this.def){
            turn=0;
            sp=0;
            em.defeat();
        }
        else if(em.def>=this.atk){
            turn=0;
            sp=this.HP+100;
            this.cost_HP(sp);
            this.dead();
        }
        else{
            turn = em.HP/(this.atk-em.def);
            sp = turn*(em.atk-this.def);
            this.cost_HP(sp);
            this.dead();
            if(!this.death){
                em.defeat();
            }
        }
    }
}
