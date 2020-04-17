package post;
import java.util.*;
import java.io.*;
public class Post 
{
    
    List<items> item = new ArrayList<items>();
    public static void main(String[] args) 
    {
         new Post().run();     
    }
    
   String fname = "testt.txt";
    public void run()
    {
       seaItems i1 = new seaItems("a","a","b",8,8,8);
       seaItems i2 = new seaItems("v","a","b",22,22,22);
       seaItems i3 = new seaItems("c","a","b",52,52,52);
	   
       airItems i4 = new airItems("d","a","b",39);
       airItems i5 = new airItems("s","a","b",40);
       airItems i6 = new airItems("f","a","b",60);
           
         
        item.add(i1);
        item.add(i2);
        item.add(i3);
        item.add(i4);
        item.add(i5);
        item.add(i6);
         
 /*       Collections.sort(item);
        
         for(items it: item)
         {
          it.print();
         } 
         
         //shallow copy
         List<items> itemB = new ArrayList<items>();
         for(items it: item)
         itemB.add(it);
         
         //deep copy
         List<items> itemC = new ArrayList<items>();
         for(items it:item)
         itemC.add(it.duplicate()); 
*/        
       
       try{
        output();
        input();  
       }
       catch(IOException e)
       {
       System.out.println(e);  
       }
    }
    
    
    public void output()throws IOException
    {
     BufferedWriter out = new BufferedWriter(new FileWriter(fname));
     for(items it:item)
     out.write(it.toDelimited()+"\n");
     
     out.close();
    }
    
    public void input()throws IOException
    {
    BufferedReader in = new BufferedReader(new FileReader(fname));
    String inf = in.readLine();
    while(inf !=null){
    inf = inf.trim();
    String[] file = inf.split(",");
    String type = file[0];
    String id = file[1];
    String from = file[2];
    String to = file[3];
    if(type == "S"){
    double length = Double.parseDouble(file[4]);
    double width = Double.parseDouble(file[5]);
    double depth = Double.parseDouble(file[6]);
    item.add(new seaItems(id,from,to,length,width,depth));
    inf = in.readLine();
    in.close();
    }
    
    if(type == "A"){
    double weight = Double.parseDouble(file[4]);
       item.add(new airItems(id,from,to,weight));
       inf = in.readLine();
       in.close();
    }
    
    }
    
    }
}

abstract class items implements Comparable<items>
{
 public String id;
 public String from;
 public String to;
 
 public items(String id, String from, String to)
 {
  this.id = id;
  this.from = from;
  this.to = to;
 
 }
 
 public abstract items duplicate();
 
 public abstract double calcFee();
 
 public int compareTo1(items other)
 {
 return this.id.compareTo(other.id);
 }

  public int compareTo(items other)
 {
     if(this.calcFee() == other.calcFee()){
     return 0;
     }
     
  return this.calcFee() > other.calcFee()? -1:1;
 }
  
  public abstract String toDelimited();
 
 public abstract void print();
}


class seaItems extends items
{
    double length;
    double width;
    double depth;

    public seaItems(String id, String from, String to,double length, double width, double depth)
    {
    super(id,from,to);
    this.length = length;
    this.depth = depth;
    this.width = width;
    }
    
    public seaItems duplicate(){
     return new seaItems(id, from, to, length, width, depth );
    }
    
    public double calcFee(){
        int price = 0;
        if(length <= 10 || width <= 10 || depth <=10)
        {
            price = 5;
        }
        if(length > 10 || width > 10|| depth > 10)
        {
          if(length <= 20 || width >= 20|| depth >= 20)
          {
             price = 10;
          }
        }
        if(length > 20 || width > 20|| depth > 20)
        {
          if(length <= 50 || width <= 50|| depth <= 50)
          {
              price = 20;
          }
        }
         return price;
    }
    
      public String toDelimited()
      {
       return "S" + "," + id+ "," + from +","+ to+"," + length+","+ width+","+depth+"\t";
      }
    
    public void print()
    {
        if(length <= 50 || width <= 50|| depth <= 50)
            System.out.println(id +" from "+from + " to " +to+" "+calcFee());
 
        else
        System.out.println(id +" from "+from + " to " +to+" "+"sbsbsbsbsbssb");
    }

}

class airItems extends items
{
  double weight;
  public airItems(String id, String from, String to,double weight)
    {
    super(id,from,to);
    this.weight = weight;
    }
  
      public airItems duplicate(){
     return new airItems(id, from, to, weight);
    }
  
  public double calcFee()
  {
    double price = weight/100*2.5;
    return price;
  }
  
    public String toDelimited()
      {
       return "A" + "," + id+ "," + from +","+ to+"," + weight+"\t";
      }
  
   public void print(){
        System.out.println(id +" from "+from + " to " +to+" "+calcFee());
    
    }
  
}