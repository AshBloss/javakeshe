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
    public void add_atk(int i,Hero h){
        h.atk += i;
    }
    public void add_def(int i,Hero h){
        h.def += i;
    }
    public void add_HP(int i,Hero h){
        h.HP += i;
    }
    public void add_yk(Hero h){
        h.yellowkey_num++;
    }
    public void add_rk(Hero h){
        h.redkey_num++;
    }
    public void cost_yk(Hero h){
        h.yellowkey_num--;
    }
    public void cost_rk(Hero h){
        h.redkey_num--;
    }
    //判死
    public void dead(Hero h){
        if(h.HP<=0){
            h.death=true;
        }
    }
}
