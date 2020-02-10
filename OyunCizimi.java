
package prolab2_1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class OyunCizimi extends JPanel implements KeyListener{
   public int[][] harita = new int[11][14]; 
   int x=5;
   int y=6;
   ArrayList<Karakter> BadGuys = new ArrayList();
   boolean asagi, yukari, sag, sol; 
   boolean ilkBayrak = true;
   int canSayisi;
   int secim;
   Scanner scan1;
   int KupaX = 13*60;
   int KupaY = 9*60;
   int KupaXX = 60;
   int KupaYY = 60;
   DosyaOku o1;
   boolean galip=false;
   
   
   
   public OyunCizimi() throws IOException{

        File file = new File("Harita.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String temp;      
        temp =reader.readLine();
        temp = temp.toLowerCase();
        while( temp!= null){ 
           temp =  temp.toLowerCase();
            if(temp.contains("masteryoda")){
                  canSayisi =new MasterYoda().can;
                  secim = 2;
            }
              
            
            else if(temp.contains("lukeskywalker")){
                  canSayisi = new LukeSkywalker().can;
                secim = 1;
            }
              
            temp =  reader.readLine();  
        
        }
      reader.close();

         Gerekliler();

   }
   
   public void Gerekliler(){
        try {
           DosyaOku1();
       } catch (IOException ex) {
           Logger.getLogger(OyunCizimi.class.getName()).log(Level.SEVERE, null, ex);
       }
             
          o1 = new DosyaOku();
       try {
           o1.oku();
       } catch (IOException ex) {
           Logger.getLogger(OyunCizimi.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       this.BadGuys = o1.BadGuys;
  
    
       
      if(ilkBayrak == true){
        for (int i = 0; i < BadGuys.size(); i++) {               
            if(BadGuys.get(i).ad.equalsIgnoreCase("stormtrooper")) {
                switch(BadGuys.get(i).Kapi){
                    case "A":
                    BadGuys.get(i).setXyeri(0); 
                    BadGuys.get(i).setYyeri(5);
                     break;
                        
                     case "B":
                   BadGuys.get(i).setXyeri(4);
                    BadGuys.get(i).setYyeri(0);
                        break;
                       case "C":
                   BadGuys.get(i).setXyeri(12);
                   BadGuys.get(i).setYyeri(0);
                        break;
                       case "D":
                 BadGuys.get(i).setXyeri(13);
                    BadGuys.get(i).setYyeri(5);
                        break; 
                        
                      case "E":
                    BadGuys.get(i).setXyeri(4);
                    BadGuys.get(i).setYyeri(10);
                        break;
                }
              //  g.drawImage(imgstorm, BadGuys.get(i).Xyeri*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);
            }
            if(BadGuys.get(i).ad.equalsIgnoreCase("kyloren")) {
          
                 switch(BadGuys.get(i).Kapi){
                    case "A":
                    BadGuys.get(i).setXyeri(0); 
                    BadGuys.get(i).setYyeri(5);
                     break;
                        
                     case "B":
                   BadGuys.get(i).setXyeri(4);
                    BadGuys.get(i).setYyeri(0);
                        break;
                       case "C":
                   BadGuys.get(i).setXyeri(12);
                   BadGuys.get(i).setYyeri(0);
                        break;
                       case "D":
                 BadGuys.get(i).setXyeri(13);
                    BadGuys.get(i).setYyeri(5);
                        break; 
                        
                      case "E":
                    BadGuys.get(i).setXyeri(4);
                    BadGuys.get(i).setYyeri(10);
                        break;
                }
                
              // g.drawImage(imgkylo, BadGuys.get(i).Xyeri*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);


            
            }
            
            if(BadGuys.get(i).ad.equalsIgnoreCase("darthvader")) {
                 switch(BadGuys.get(i).Kapi){
                    case "A":
                    BadGuys.get(i).setXyeri(0); 
                    BadGuys.get(i).setYyeri(5);
                     break;
                        
                     case "B":
                   BadGuys.get(i).setXyeri(4);
                    BadGuys.get(i).setYyeri(0);
                        break;
                       case "C":
                   BadGuys.get(i).setXyeri(12);
                   BadGuys.get(i).setYyeri(0);
                        break;
                       case "D":
                 BadGuys.get(i).setXyeri(13);
                    BadGuys.get(i).setYyeri(5);
                        break; 
                        
                      case "E":
                    BadGuys.get(i).setXyeri(4);
                    BadGuys.get(i).setYyeri(10);
                        break;
                }
               // g.drawImage(imgdarth, BadGuys.get(i).Xyeri*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);
            }
        }
             ilkBayrak = false;
           }
      canSayisi--;
      System.out.println(canSayisi);
      
      if(canSayisi==0){
          
          
      }
   }
  
   public void DosyaOku1() throws FileNotFoundException, IOException{
        //KotuAdamlar();
        File file = new File("Harita.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        int x = reader.read();
       // System.out.println(x);
        int i1=0, j1=0;
        while (x!=-1) {         
           // System.out.println(x);
            if(x==48){
                harita[i1][j1] = x-48;
                j1++;
                if(j1==14){
                    i1++;
                    j1=0;
                }
            }
            
            else if(x == 49){
                harita[i1][j1] = x-48;
                j1++;
                if(j1==14){
                    i1++;
                    j1=0;
                }
                
                
            }
            
            x= reader.read();
            
       
       }

         reader.close();
        
               
   }
   
   
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
   
 
   if (e.getKeyCode() == e.VK_DOWN) asagi = true;
   if (e.getKeyCode() == e.VK_UP) yukari = true;
   if (e.getKeyCode() == e.VK_RIGHT) sag = true;
   if (e.getKeyCode() == e.VK_LEFT) sol = true;
   
  
   
   
    }

    @Override
    public void keyReleased(KeyEvent e) {
 
    }
   
    
    //11-14
    @Override
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage imgmaster = null;
            BufferedImage kupa = null;
            BufferedImage imgluke = null;
            BufferedImage imgstorm = null;
            BufferedImage imgkylo = null;
            BufferedImage imgdarth = null;
            BufferedImage gameover = null;
            try {
            imgmaster = ImageIO.read(new File("masteryoda.jpg"));
            imgluke = ImageIO.read(new File("luke.jpg"));
            imgdarth = ImageIO.read(new File("darth.png"));
            imgstorm = ImageIO.read(new File("storm.jpg"));
            imgkylo = ImageIO.read(new File("kylo.jpg"));
            kupa = ImageIO.read(new File("kupa.png"));
            gameover = ImageIO.read(new File("gameover.jpg"));

            

            } catch (IOException e) {
            }

  
      for (int j = 0; j < 14; j++) {  
                for (int i = 0; i < 11 ; i++) {
               //  g.fillRect(0, 0+i*60, 60+j*60, 60); 
               if(harita[i][j] == 0)
               { 
                   g.setColor(Color.BLUE);
                   g.fillRect(j*60, 0+i*60, 60, 60);
                
                  
               }
               else if(harita[i][j] == 1){
                   g.setColor(Color.gray);
                   g.fillRect(j*60, 0+i*60, 60 , 60);
         
                   
               }
               
           //   g.drawRect(0, 0+i*60, 60+j*60, 60);
              
               
                
                }
           } 
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 14; j++) {
                    g.drawRect(0, 0+i*60, 60+j*60, 60);
                    g.setColor(Color.white);
                }               
        }       
           g.drawRect(0, 0, 60, 60);
           
                      
       for (int j = BadGuys.size()-1; j>=0 ;j--) {         
       try {      
           BadGuys.get(j).EnKisa(harita, BadGuys.get(j).getYyeri(),BadGuys.get(j).getXyeri(), x, y);
       } catch (IOException ex) {
           Logger.getLogger(OyunCizimi.class.getName()).log(Level.SEVERE, null, ex);
       }    
        for (int i = 1; i < BadGuys.get(j).kisaYol.size()-1; i++) {
             g.setColor(Color.red);
            g.fillRect(BadGuys.get(j).kisaYol.get(i).y * 60, BadGuys.get(j).kisaYol.get(i).x*60,60, 60);
           
        }
      }
       
    
           
           ///ANA KARAKTER CIZIMI//////
          if(galip==false){ 
           if(secim == 1){
           g.drawImage(imgluke,y*60 , x*60, 60, 60, this); 
           }
          else if(secim==2){
           g.drawImage(imgmaster,y*60 , x*60, 60, 60, this); 
           }
             
          
           
           /////////////////////////////////
            for (int i = 0; i < BadGuys.size(); i++) {
           if(BadGuys.get(i).ad.equalsIgnoreCase("kyloren")){
                g.drawImage(imgkylo, BadGuys.get(i).getXyeri()*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);
           }
           
           else if(BadGuys.get(i).ad.equalsIgnoreCase("darthvader")){
         g.drawImage(imgdarth, BadGuys.get(i).getXyeri()*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);
           }
            
           else if(BadGuys.get(i).ad.equalsIgnoreCase("stormtrooper")){
                g.drawImage(imgstorm, BadGuys.get(i).getXyeri()*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);
               
           }
        }
           g.drawImage(kupa, 13*60, 9*60, 60, 60, this);
           g.drawString("Can Sayısı:"+canSayisi,6*60 ,13*55-10 );
          }
           if(galip==true){
           g.drawImage(kupa, KupaX, KupaY, KupaXX  , KupaYY, this);
   
           }
 
             
                if(canSayisi==0){
                    System.out.println("b");
           g.drawImage(gameover, 0, 0,15*60-38, 12*60-10, this);
       }
             
             
             if(galip==false){
             
             if(yukari){  
                 boolean gecici=true;
                   if(harita[x-1][y]!= 0 && x-1 > 0){
                          x--; 
           for (int i = 0; i < BadGuys.size(); i++) {
            if(  ((x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())) ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                gecici=false;
            break;
        }
             }
                        
                   }
                   for (int i = 0; i < BadGuys.size(); i++) {                    
             if(gecici==false){
                 break;
             }
                         try{         
                       BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).x); 
                  if(BadGuys.get(i).ad.equalsIgnoreCase("Kyloren")){
                          if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                break;
        }
                  g.drawImage(imgkylo, BadGuys.get(i).getXyeri()*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);      
                       BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).x);  
                     if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
            break;
        }                      
                       }
                 }
                 catch(ArrayIndexOutOfBoundsException t){
                //BadGuys.clear();
                x=5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                     break;
                 }
                 
                 finally{
                      BadGuys.get(i).kisaYol.clear();
                 }
                 }
                   yukari = false;
             }
                                      
             else if(asagi){
                 boolean gecici=true;
                 if(harita[x+1][y]!= 0 && x+1 < 10){
                       x++;
        for (int i = 0; i < BadGuys.size(); i++) {
            if(  ((x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())) ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                gecici=false;
             break;
        }
             }
                                    
                 }
                 for (int i = 0; i < BadGuys.size(); i++) {                    
              if(gecici==false){
                  break;
              }
                       try{         
                      BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).x);     
                  if(BadGuys.get(i).ad.equalsIgnoreCase("Kyloren")){
                          if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
             break;
        }
                  g.drawImage(imgkylo, BadGuys.get(i).getXyeri()*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);      
                  BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).x);   
           if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                         break;   
        }  
                  
                  
                       }
                 }
                 catch(ArrayIndexOutOfBoundsException t){
                  
                //BadGuys.clear();
                x=5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                break;
                     
                 }
                 
                 finally{
                      BadGuys.get(i).kisaYol.clear();
                 }
                 }
                     
             asagi = false;               
             }
                
             else if(sag){
                 boolean gecici=true;
                 if(x==9 && y+1 >= 13 && y+1<=13){
                     System.out.println("kazandiniz");
                     KupaX = 0;
                     KupaY=0;
                     KupaXX = 15*60-38 ;
                     KupaYY= 12*60-10;
                     y++;
                     galip=true;
                
                 }
                 
                else if(y!= 13 && harita[x][y+1]!= 0 && y+1 < 13){
             
                     y++;
       for (int i = 0; i < BadGuys.size(); i++) {
            if(  ((x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())) ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
            gecici=false;
             break;
        }
             }
                     
                }
                 
                      for (int i = 0; i < BadGuys.size(); i++) {                    
        if(gecici==false){
            break;
        }
                            try{         
                      BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).x);      
                  if(BadGuys.get(i).ad.equalsIgnoreCase("Kyloren")){
                          if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
             break;
        }
                  g.drawImage(imgkylo, BadGuys.get(i).getXyeri()*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);      
                 BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).x);  
                     if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
             break;
        }                      
                       }
                 }
                 catch(ArrayIndexOutOfBoundsException t){
        
                //BadGuys.clear();
                x=5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                     break;
                 }
                 
                 finally{
                      BadGuys.get(i).kisaYol.clear();
                 }
                 }
                 
               sag = false;
                    
             }
                 
             else if(sol){
                 boolean gecici=true;
                 if(harita[x][y-1]!= 0 && y-1 > 0){
         
                     y--;
           for (int i = 0; i < BadGuys.size(); i++) {
            if(  ((x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())) ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
            gecici=false;
             break;
        }
             }
                 }
                 
                      for (int i = 0; i < BadGuys.size(); i++) {      
                      
                          if(gecici==false){
                      break;
                      }
                 try{         
                      BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-2).x);      
                  if(BadGuys.get(i).ad.equalsIgnoreCase("Kyloren")){
                      
         if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                 break;
            
        }
                  g.drawImage(imgkylo, BadGuys.get(i).getXyeri()*60, BadGuys.get(i).getYyeri()*60, 60, 60, this);      
       BadGuys.get(i).setXyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).y);
                       BadGuys.get(i).setYyeri(BadGuys.get(i).kisaYol.get(BadGuys.get(i).kisaYol.size()-3).x);  
                   
               if(  (x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())  ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
                 break;
        }
                       }
                 }
                 catch(ArrayIndexOutOfBoundsException t){
                  
                //BadGuys.clear();
                x=5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
              break;
                 }
                 
                 finally{
                      BadGuys.get(i).kisaYol.clear();
                 }
  
                 }
           sol = false;
             }
             }
     ////////OYUN BITIMI///////
             for (int i = 0; i < BadGuys.size(); i++) {
            if(  ((x == BadGuys.get(i).getYyeri()) && (y == BadGuys.get(i).getXyeri())) ){
                //BadGuys.clear();
                x= 5;
                y=6;
                ilkBayrak = true;
                Gerekliler();
            
        }
             }
        
            repaint();
        
    }

   

}
