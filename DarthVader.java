
package prolab2_1;

import java.io.IOException;

public class DarthVader extends Karakter {
   int[][] harita2 = new int[11][14];

    public DarthVader() {
        
        
    }
    
   @Override
     public int getXyeri() {
        return l.x;
    }

   @Override
    public void setXyeri(int Xyeri) {
        this.l.x = Xyeri;
    }

   @Override
    public int getYyeri() {
        return l.y;
    }

   @Override
    public void setYyeri(int Yyeri) {
        this.l.y = Yyeri;
    }
  
    @Override
    public void EnKisa(int[][] harita, int kx, int ky, int ix, int iy) throws IOException {  
            for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 14; j++) {
                harita2[i][j] = 1;             
            }
            
        } super.EnKisa(harita2, kx, ky, ix, iy);
    }
   
}