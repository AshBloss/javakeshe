import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class floor {
    int n;
    int floor_num;
    int floor_map[][] = new int[n][n];
    public floor(int num,int [][] map){
        n=15;
        floor_num=num;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                floor_map[i][j]=map[i][j];
            }
        }
    }
    void load(){
    }
}
