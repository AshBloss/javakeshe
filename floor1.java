public class floor1 extends floor{
    public floor1(){
        super();
        super.floor_map=new int[][]{
        {1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
        {1,  0,  0, 21,  0,  0,  1,  0,  0,  0,  0,  0,  0,  0,  1},
        {1,  1,  1, 21,  1,  0,  0,  0,  1,  0,  1,  1,  1,  0,  1},
        {1,  0,  0, 21,  1,  0,  1,  1,  1,  0,  1,  0,  0,  0,  1},
        {1,  1,  1, 22,  1,  1,  1,  0,  1,  0,  0,  0,  1,  0,  1},
        {1,  0,  0, 22,  1,  0,  0,  0,  1,  1,  1,  0,  1,  1,  1},
        {1,  1,  1,  0,  1,  0,  0,  0,  0,  1,  0,  0,  0, 14,  1},
        {1,  0,  1,  0,  1,  1,  1,  0,  0,  1,  0,  1,  1,  1,  1},
        {1,  0,  1,  0,  0,  0,  0,  0,  0,  1,  1,  1,  0, 15,  1},
        {1,  0,  1,  1,  1,  0,  1,  1,  0,  1,  0,  0,  0,  1,  1},
        {1,  0,  0,  0,  0,  0,  0,  1,  0, 16,  0,  1,  1,  1,  1},
        {1,  1,  1,  0,  1,  1,  0,  1,  1,  1,  1,  1,  0,  0,  1},
        {1, 14,  1,  0,  0,  1,  0,  0,100,101,  0,  13,  0,  1,  1},
        {1,  0,  0,  0,  0,  1,  1,  1,  1,102,  1,  1,  0, 10,  1},
        {1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1}};
        super.floor_num=0;
    }
}
