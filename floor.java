import javax.swing.*;
//地图第一层
public class floor {
    int n=15;                                   //地图尺寸
    int floor_num=1;                            //地图层数
    int floor_map[][]=new int[][]{              //地图代码
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,3,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,1,1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,0,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,1,1,0,1,1,1,0,1,0,0,0,1,0,1},
        {1,0,0,0,1,0,0,0,1,1,1,0,1,1,1},
        {1,1,1,0,1,0,0,0,0,1,0,0,0,0,1},
        {1,0,1,0,1,1,1,0,0,1,0,1,1,1,1},
        {1,0,1,0,0,0,0,0,0,1,1,1,0,0,1},
        {1,0,1,1,1,0,1,1,0,1,0,0,0,1,1},
        {1,0,0,0,0,0,0,1,0,0,0,1,1,1,1},
        {1,1,1,0,1,1,0,1,1,1,1,1,0,0,1},
        {1,0,1,0,0,1,0,0,0,0,0,0,0,1,1},
        {1,0,0,0,0,1,1,1,1,0,1,1,0,2,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    Mapcube fl_map[][] = new Mapcube[n][n];

    Item fl_item[][] = new Item[n][n];

}
