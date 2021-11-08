
import javax.swing.*;

//地图
public class MyPanel extends JLayeredPane{	
	//加载地图
	public void loadmap(floor fl){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				//地图层加载
				fl.fl_map[i][j] = new Mapcube(i, j, fl.floor_map[i][j]);
				this.add(fl.fl_map[i][j],JLayeredPane.DEFAULT_LAYER);
				//物品层加载
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
						fl.fl_item[i][j] = new Item(i, j);
						break;
				}
				this.add(fl.fl_item[i][j],JLayeredPane.PALETTE_LAYER);
				//怪兽层加载
				switch (fl.floor_map[i][j]) {
					case 100:
						fl.fl_enemy[i][j] = new greenslm(i, j, fl.floor_map[i][j]);
						break;
					case 101:
						fl.fl_enemy[i][j] = new redslm(i, j, fl.floor_map[i][j]);
						break;
					case 102:
						fl.fl_enemy[i][j] = new smallbf(i, j, fl.floor_map[i][j]);
						break;
					default:
						fl.fl_enemy[i][j] = new Enemy(i, j);
						break;
				}
				this.add(fl.fl_enemy[i][j],JLayeredPane.MODAL_LAYER);
			}
		}
    }
}
