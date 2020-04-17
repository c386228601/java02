/*
 * Haoran Cheng
 * 5044194
 * Crazy Eights 
 */
package ex8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.max;
import java.util.*;
import java.math.*;


public class Ex8 {

    card[] clist = new card[52];
    int maxLength,len;
    public static void main(String[] args)
    {
//        Scanner input = new Scanner(System.in);
//        System.out.print("input file name: ");
//        String filename = input.next();
        String filename = "source.txt";
    
        Ex8 e8 = new Ex8();
        
        try
        {
         BufferedReader in = new BufferedReader(new FileReader(filename));
         String line = in.readLine();
         
         while(line != null)
         {
              line = line.trim();             
              String[] l = line.split("");
              
              if(l.length == 2)
              {
                 card v1 = new card(l[0],l[1]);
                 e8.insert_clist(v1);
              }
              
              if(l.length == 3)
              {
                 String link = l[0]+l[1];
                 card v2 = new card(link,l[2]);
                 e8.insert_clist(v2);
              }
              
              line = in.readLine();
         }
        in.close();
        }
        catch(IOException e)
        {
           System.out.print("Error: "+e);
        }
        
        
        int last,maxde;
	e8.maxLength=0;
	int max = e8.crazyUp(51);
	maxde=0;
        last = 0;
	for(int i=0;i<51;i++)//find last
	{
		if(maxde<e8.clist[i].degree)
		{
			maxde=e8.clist[i].degree;
			last=i;
		}
	}
	int first=0;
	int minde=51;
	for(int i=51;i>=0;i--)
	{//find first
		if(minde>=e8.clist[i].degree)
		{
			minde=e8.clist[i].degree;
			first=i;
			
		}
	}
        
         System.out.println("The length of the longest sequence: "+max);
         System.out.println("The first card in the sequence: "+e8.clist[first].R+e8.clist[first].S);
         System.out.println("The last card in the sequence: "+e8.clist[last].R+e8.clist[last].S);
   
        
    }  
 
    public boolean find_likes(int c1, int c2)
    {
	if(clist[c1].R.equals("8"))
            return true;
	else if(clist[c2].R.equals("8"))
            return true;
	else if(clist[c1].R.equals(clist[c2].R))
            return true;
	else if(clist[c1].S.equals(clist[c2].S))
            return true;
        
	else return false;
    }
    
    int count_1 = 0;
    public void insert_clist(card v)
    {
        clist[count_1] = v;
        count_1++; 
    }
    
    
    
 public  int crazyUp(int N)
{
	//find max length
	for(int i=0;i<=N;i++)
	{
		len=1;
		for(int j=i-1;j>=0;j--)
		{
			if(find_likes(i,j))
			{
				len=max(len, clist[j].degree+1);
			}
			clist[i].degree=len;
			maxLength = max(maxLength, len);
		}
	}
	return maxLength;
}
    
       
}

class card
{
  String R;
  String S;
  int degree = 0;
  
  public card(String R, String S)
  {
     this.R = R;
     this.S = S;
  }
  
}
