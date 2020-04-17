/*
Virtual Initialization
Haoran Cheng
hc633
 */
package ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {

    static  int size = 100;
    static int count = 0;
    static int[] data = new int[size];
    static int[] backward = new int[size];
    static int[] forward = new int[size];
     
    public static void main(String[] args) {
     String fname = "numbers.txt";
    
     //input file data ----start
     try
     {
        BufferedReader in = new BufferedReader (new FileReader (fname));
        String line = in.readLine();
       
        //read in data till -1 appear 
        while(line !=null&&!line.contains("-"))
        { 
          line = line.trim();
          String[] filed = line.split( "\\s+");

          int f = 0;
          int d = 0; 
          //get data
          for(int i = 0; i < filed.length;i++)
          { 
              //array data data
              d = Integer.parseInt(filed[0]);
              //array forward data
              f = Integer.parseInt(filed[1]);                 
          }
           //pass data into method allocate to filter data
           allocate(d,f);
           line = in.readLine();
        }
        
        //read in test data
        
        while(line!=null)
        {
         int v = 0;
         line = line.trim();
         String[] filed = line.split( "\\s+");
         v = Integer.parseInt(filed[0]);
         
        if(v!=-1)
        for(int i = 0; i < filed.length;i++)
         { 
             print(v);            
         }
         line = in.readLine();
        }
         in.close();
          
     }
     //input file data ----end
     //catch error info 
    catch(IOException e)
    {
         System.out.println("error info: " + e);
    }             
    }

    //filter data
    public static void allocate(int d, int f)
    {  
     forward[count] = f;
     data[forward[count]] = d;
     backward[forward[count]] = count;
     count++;
    }
   
    //print result
    public static void print(int i)
    {    

        if(backward[i]>0&&backward[i]<=count&&forward[backward[i]]==i)
         System.out.println("position "+ i+" has been initialized to value: "+ data[i]);
       else 
           System.out.println("position " + i + " has not been initialized");
    }   
}
