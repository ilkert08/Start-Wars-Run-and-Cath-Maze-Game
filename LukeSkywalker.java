

package prolab2_1;

public class LukeSkywalker  extends Karakter{
    public int can = 4;

    public LukeSkywalker() {
        
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
