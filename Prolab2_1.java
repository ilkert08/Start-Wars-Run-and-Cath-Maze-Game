

package prolab2_1;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Prolab2_1 extends JFrame{
      public Prolab2_1() throws IOException{
          this.setSize(new Dimension(15*60-38, 13*60-10));        
         
          this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
          OyunCizimi cizim1 = new OyunCizimi();
          
          cizim1.addKeyListener(cizim1);
          cizim1.setFocusable(true);
          this.getContentPane().add(cizim1);          
         
          this.setVisible(true);
      }
   
    
    public static void main(String[] args) throws IOException  {
      new Prolab2_1();     
        
    }
    
}


