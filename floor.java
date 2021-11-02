import javax.swing.*;
public class floor {
    int n=15;
    int floor_num=1;
    int floor_map[][]=new int[][]{
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    /*
    public void load(MyPanel mp){
        Form f = new Form();
        JLabel map[][]=new JLabel[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(floor_map[i][j]==1){
                    map[i][j] = new JLabel(f.wallIcon);
                    map[i][j].setBounds(32*j, 32*i, f.wallIcon.getIconWidth(), f.wallIcon.getIconHeight());
                    mp.add(map[i][j]);
                }
                else if(floor_map[i][j]==0){
                    map[i][j] = new JLabel(f.groundIcon);
                    map[i][j].setBounds(32*j, 32*i, f.groundIcon.getIconWidth(), f.groundIcon.getIconHeight());
                    mp.add(map[i][j]);
                }
            }
        }   
    }
    */
}
