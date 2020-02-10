

package prolab2_1;

import java.io.IOException;

public class StormTrooper extends Karakter{

    public StormTrooper() {
        
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
        super.EnKisa(harita, kx, ky, ix, iy); //To change body of generated methods, choose Tools | Templates.
    }

    
}






