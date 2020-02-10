
package prolab2_1;

public class MasterYoda extends Karakter {
    public int can = 7;

    public MasterYoda() {
        
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

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    } 
}
