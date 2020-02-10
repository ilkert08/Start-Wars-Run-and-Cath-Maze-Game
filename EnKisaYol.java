
package prolab2_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
public class EnKisaYol {
    ArrayList<Node> hepsi = new ArrayList();
    ArrayList<Node> silinenler = new ArrayList();
	public int matris_x= 11;
	public int matris_y = 14;
        
        //4 yöne de ilerleyebilmek için olan toplama iþlemleri
        
         int topla2[] = { 0, -1, 1, 0 };
	  int topla1[] = { -1, 0, 0, 1 };
	

	//uðranýp uðranmadýðýný kontrol eder
	public boolean kontrol(int harita[][], boolean ugrananlar[][],int kontrol1, int kontrol2)
	{
		return (kontrol1 >= 0) && (kontrol1 < matris_x) && (kontrol2 >= 0) && (kontrol2 < matris_y)
		   && harita[kontrol1][kontrol2] == 1 && !ugrananlar[kontrol1][kontrol2];
	}

	public void kisayolubul(int harita[][], int i, int j, int x, int y)
	{
		boolean[][] ugrananlar = new boolean[matris_x][matris_y];
		Queue<Node> sira = new ArrayDeque<>();

                //ilk yeri uðranmýþ olarak alýyoruz
		ugrananlar[i][j] = true;
		sira.add(new Node(i, j, 0));
                hepsi.add(new Node(i, j, 0));
                
                //enkisayi intin en büyük deðeri yaptýk ki kýsa yolu kolay bulabilelim
		int enkisauzaklik = Integer.MAX_VALUE;
                
                //siranýn boþ olmama durumunda en kisa yolu bulma iþlemleri
		while (!sira.isEmpty())
		{
                    
                        //eklediðimiz sýradan birer birer çekme iþlemi
			Node node = sira.poll();
                        //çevirde kontrol edebilmek için silinenlere de ekliyoruz
                        silinenler.add(node);
                        //yer belirleme iþlemi
			i = node.x;
			j = node.y;
			int uzaklik = node.dist;
                        //ilk ulaþtýðý zaman breakliyor
			if (i == x && j == y)
			{
                                //koordinatlar tutarsa en kýsa yolu düzenliyor
				enkisauzaklik = uzaklik;
                                //enkýsayoldan ulaþýldýysa breakler
				break;
			}
                        
                        //4 yön olduðu içine for 4 kez döner
			for (int k = 0; k < 4; k++)
			{
				if (kontrol(harita, ugrananlar, i + topla1[k], j + topla2[k]))
				{
                                    //uðranmýþ mý kontrol iþlemi burada yapýlýr
					ugrananlar[i + topla1[k]][j + topla2[k]] = true;
					sira.add(new Node(i + topla1[k], j + topla2[k], uzaklik + 1));
                                        hepsi.add(new Node(i + topla1[k], j + topla2[k], uzaklik + 1));
				}
			}
		}
                // enkisauzaklýk deðiþmiþse 
		if (enkisauzaklik != Integer.MAX_VALUE) {
			//System.out.print("Yol:"+ min_dist);
                       // System.out.println();
               
		}
                //enkýsauzaklýk deðiþmemiþse
		else {
			System.out.print("Ulaþýlamýyor");
		}
	}

	
public ArrayList<Node> cevir(int[][] harita, int ix, int iy, int kx, int ky) throws IOException
	{

	kisayolubul(harita, kx, ky, ix, iy);    
    
        /*  for (int i = 0; i < silinenler.size(); i++) {
        System.out.println(silinenler.get(i).x+"-"+silinenler.get(i).y+"-"+silinenler.get(i).dist);     
            } */
            ArrayList<Node> asil = new ArrayList();
            int t = 0;
            int i = silinenler.size()-1;//silinenler.get(i).x!=6 && silinenler.get(i).y!= 5
            asil.add(silinenler.get(silinenler.size()-1));
            while(i!=0  && t<silinenler.size()){
                 for (int j = i-1; j >= 0; j--) {
                    if((silinenler.get(i).x+1== silinenler.get(j).x && silinenler.get(i).y == silinenler.get(j).y) 
                   || (silinenler.get(i).x- 1== silinenler.get(j).x && silinenler.get(i).y == silinenler.get(j).y)
                   ||(silinenler.get(i).y + 1 == silinenler.get(j).y && silinenler.get(i).x == silinenler.get(j).x)
                    || (silinenler.get(i).y- 1== silinenler.get(j).y && silinenler.get(i).x == silinenler.get(j).x )){
                     asil.add(silinenler.get(j));
                        i = j;        
                    }
                     
                }
                 t++;
                
            }
            
            silinenler.clear();
            return asil;
	 }
}
