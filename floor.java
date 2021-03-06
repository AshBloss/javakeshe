
public class floor {
    int n=15;                                   //地图尺寸
    int floor_num=-1;                           //地图层数
    int xst,yst;								//下楼点
    int xnx,ynx;								//上楼点
    int floor_map[][];              			//地图代码
    Mapcube fl_map[][] = new Mapcube[n][n];     //底层地图
    Item fl_item[][] = new Item[n][n];          //物品图
    Enemy fl_enemy[][] = new Enemy[n][n];       //怪物图
	//加载地图至三层
    public void loadmap(){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				//地图层加载
				this.fl_map[i][j] = new Mapcube(i, j, this.floor_map[i][j]);
				//物品层加载
				switch(this.floor_map[i][j]){
					case 10:
						this.fl_item[i][j] = new up(i, j, this.floor_map[i][j]);
                        this.xnx=j;
                        this.ynx=i;
						break;
					case 11:
						this.fl_item[i][j] = new down(i, j, this.floor_map[i][j]);
                        this.xst = j;
                        this.yst = i;
						break;
					case 12:
						this.fl_item[i][j] = new yellow_door(i, j, this.floor_map[i][j]);
						break;
					case 13:
						this.fl_item[i][j] = new red_door(i, j, this.floor_map[i][j]);
						break;
					case 14:
						this.fl_item[i][j] = new yellow_key(i, j, this.floor_map[i][j]);
						break;
					case 15:
						this.fl_item[i][j] = new red_key(i, j, this.floor_map[i][j]);
						break;
					case 16:
					    this.fl_item[i][j] = new special_door(i, j, this.floor_map[i][j]);
						break;
					case 17:
						this.fl_item[i][j] = new red_stone(i, j, this.floor_map[i][j]);
						break;
					case 18:
						this.fl_item[i][j] = new blue_stone(i, j, this.floor_map[i][j]);
						break;
					case 19:
						this.fl_item[i][j] = new red_bottle(i, j, this.floor_map[i][j]);
						break;
					case 20:
						this.fl_item[i][j] = new blue_bottle(i, j, this.floor_map[i][j]);
						break;
					case 21:
						this.fl_item[i][j] = new breakwall(i, j, this.floor_map[i][j]);
						break;
					case 22:
						this.fl_item[i][j] = new cfly(i, j, this.floor_map[i][j]);
						break;
					case 23:
					    this.fl_item[i][j] = new special_door1(i, j, this.floor_map[i][j]);
						break;
					case 24:
						this.fl_item[i][j] = new yellow_bottle(i, j, this.floor_map[i][j]);
						break;
					default:
						this.fl_item[i][j] = new Item(i, j);
						break;
				}
				//怪兽层加载
				switch (this.floor_map[i][j]) {
					case 100:
						this.fl_enemy[i][j] = new greenslm(i, j, this.floor_map[i][j]);
						break;
					case 101:
						this.fl_enemy[i][j] = new redslm(i, j, this.floor_map[i][j]);
						break;
					case 102:
						this.fl_enemy[i][j] = new smallbf(i, j, this.floor_map[i][j]);
						break;
					case 103:
						this.fl_enemy[i][j] = new blackslm(i, j, this.floor_map[i][j]);
						break;
					case 104:
						this.fl_enemy[i][j] = new smallkl(i, j, this.floor_map[i][j]);
						break;
					case 105:
						this.fl_enemy[i][j] = new bigbf(i, j, this.floor_map[i][j]);
						break;
					case 106:
						this.fl_enemy[i][j] = new shouren(i, j, this.floor_map[i][j]);
						break;
					case 107:
						this.fl_enemy[i][j] = new bigkl(i, j, this.floor_map[i][j]);
						break;
					case 108:
						this.fl_enemy[i][j] = new bigslm(i, j, this.floor_map[i][j]);
						break;
					case 109:
						this.fl_enemy[i][j] = new redbf(i, j, this.floor_map[i][j]);
						break;
					case 110:
						this.fl_enemy[i][j] = new blackqs(i, j, this.floor_map[i][j]);
						break;
					case 111:
						this.fl_enemy[i][j] = new blackking(i, j, this.floor_map[i][j]);
						break;
					case 112:
						this.fl_enemy[i][j] = new redqs(i, j, this.floor_map[i][j]);
						break;
					default:
						this.fl_enemy[i][j] = new Enemy(i, j);
						break;
				}
			}
		}
    }
}
