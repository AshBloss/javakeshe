
import javax.swing.*;

//地图
public class MyPanel extends JLayeredPane{	
	//显示地图
	public void showmap(floor fl){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				this.add(fl.fl_map[i][j],JLayeredPane.DEFAULT_LAYER);
				this.add(fl.fl_item[i][j],JLayeredPane.PALETTE_LAYER);
				this.add(fl.fl_enemy[i][j],JLayeredPane.MODAL_LAYER);
			}
		}
	}
	//切换地图
	public void changemap(floor fl){
		this.removeAll();
		this.repaint();
		this.showmap(fl);
		this.revalidate();
	}
}
