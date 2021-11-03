public class Hero {
    //属性
    int atk=10;
    int def=10;
    int HP=1000;
    //死亡
    boolean death=false;
    //物品
    int yellowkey_num;
    int redkey_num;
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
        if(this.yellowkey_num>=1)
            this.yellowkey_num--;
    }
    public void cost_rk(){
        if(this.redkey_num>=1)
            this.redkey_num--;
    }
    //判死
    public void dead(){
        if(this.HP<=0){
            this.death=true;
        }
    }
}
