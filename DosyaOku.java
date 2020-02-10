package prolab2_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author ilkertinkir
 */
public class DosyaOku extends JFrame {
    ArrayList<Karakter> BadGuys = new ArrayList();
    public void oku() throws IOException{
        
        File file = new File("Harita.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String temp;
        String temp2;    
        temp =reader.readLine();
       // System.out.println(temp);
        while( temp!= null){         
          if(temp.contains("0") || temp.contains("1")){
              break;}
          int t1;
          int t2;
          t2 = temp.lastIndexOf(':');
          String kapi = temp.substring(t2+1);
          t1 = temp.indexOf(',');
          temp2 = temp.substring(9, t1);
       
         if(temp2.equalsIgnoreCase("stormtrooper")){         
              StormTrooper k1 = new StormTrooper();
              k1.Kapi  = kapi;      
              k1.ad= "stormtrooper";
              k1.Tur = "kotu";         
              BadGuys.add(k1);
          }
              
         else if(temp2.equalsIgnoreCase("kyloren"))
          {
              
             KyloRen k1 = new KyloRen();
              k1.Kapi  = kapi;
              k1.ad= "kyloren";
              k1.Tur = "kotu"; 
              BadGuys.add(k1);
          }
          
         else if(temp2.equalsIgnoreCase("darthvader")){
             DarthVader k1 = new DarthVader();
               k1.ad= "darthvader";
              k1.Tur = "kotu"; 
              k1.Kapi  = kapi;
              BadGuys.add(k1);
    }
            temp =  reader.readLine();      
        }
      reader.close();
        
        
    }
       
}
