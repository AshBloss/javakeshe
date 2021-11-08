import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//地图
public class MyPanel extends JLayeredPane{	
	floor fl = new floor();

	//加载地图
	public void loadmap(){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				fl.fl_map[i][j] = new Mapcube(i, j, fl.floor_map[i][j]);
				this.add(fl.fl_map[i][j],JLayeredPane.DEFAULT_LAYER);
			}
		}
    }
	
	public void loaditem(){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				switch(fl.floor_map[i][j]){
					case 10:
						fl.fl_item[i][j] = new up(i, j, fl.floor_map[i][j]);
						break;
					case 11:
						fl.fl_item[i][j] = new down(i,j,fl.floor_map[i][j]);
						break;
					case 12:
						fl.fl_item[i][j] = new yellow_door(i, j, fl.floor_map[i][j]);
						break;
					case 13:
						fl.fl_item[i][j] = new red_door(i, j, fl.floor_map[i][j]);
						break;
					case 14:
						fl.fl_item[i][j] = new yellow_key(i, j, fl.floor_map[i][j]);
						break;
					case 15:
						fl.fl_item[i][j] = new red_key(i, j, fl.floor_map[i][j]);
						break;
					default:
						fl.fl_item[i][j] = new Item();
						break;
				}
				this.add(fl.fl_item[i][j],JLayeredPane.PALETTE_LAYER);
			}
		}
	}
	
}
