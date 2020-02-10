
package prolab2_1;

import java.io.IOException;
import java.util.ArrayList;

public class Karakter {
    public String ad;
    public String Tur;
   // public int Xyeri;
   // public int Yyeri;
    public String Kapi;
    ArrayList<Node> kisaYol;
    Lokasyon l = new Lokasyon();
    
   
    
    
    public Karakter() {
     kisaYol = new ArrayList();    
    }

    
  public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

    public int getXyeri() {
        return l.x;
    }

    public void setXyeri(int Xyeri) {
        this.l.x = Xyeri;
    }

    public int getYyeri() {
        return l.y;
    }

    public void setYyeri(int Yyeri) {
        this.l.y = Yyeri;
    }
    
    public void EnKisa(int[][] harita, int kx, int ky, int ix, int iy) throws IOException{
         EnKisaYol ek1 =  new EnKisaYol();        
        // Harita, iyi adam, kotu adam yeri     
        kisaYol = ek1.cevir(harita, ix, iy, kx, ky);       
    }
    
    
    
}

