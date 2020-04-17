//Haoran Cheng 
//5044194
//Excercise 7

package ex7;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ex7 {

    graph[] queue = new graph[1];
    //String[] visited = new String[10000];
    graph[] pending = new graph[1000];
    graph[] glist = new graph[1000];
    graph[] visited;
    map[] map = new map[1000];
    public static void main(String[] args)
    {
        Ex7 e7 = new Ex7();
            int length = 0;
    
            Scanner input = new Scanner(System.in);
            System.out.print("input file name: ");
       String fname = input.next();
       
       try {
            BufferedReader in = new BufferedReader(new FileReader(fname));
            String line = in.readLine();

            int c =0;
            while (line != null) 
            {
                 c++;
                line = line.trim();
                String[] data = line.split("\\s+");
                     if(c == 1)
                     {
                        length = Integer.parseInt(data[0]);
                     }
                     if(c>1)
                     {
                        graph g = new graph(Integer.parseInt(data[0]),Integer.parseInt(data[1]));
                        graph h = new graph(Integer.parseInt(data[1]),Integer.parseInt(data[0]));
                        e7.insert_graph(g);
                         e7.insert_graph(h);
                     }                     
                line = in.readLine();
            }
            in.close();
        }
        catch (IOException e) 
        {
            System.out.println("error info: " + e);
        }
e7.visited = new graph[length];
       graph g = new graph(0,0);
 e7.traversal(g);

// for(int i= 1; i < e7.visited.length;i++)
// {
//    if(e7.visited[i]!= null)
//         System.out.println( e7.visited[i].node1 +" "+e7.visited[i].node2);  
// }
// 
e7.print();
 
//  for(int i= 0; i < e7.visited.length;i++)
//  {
//    if(e7.visited[i]!=null)
//        for(int c = 0; c < e7.get_nodes(e7.visited[i]).length;c++)
//            if(e7.get_nodes(e7.visited[i])[c] !=null)
//         System.out.println(e7.visited[i]+" "+ e7.get_nodes(e7.visited[i])[c]);  
//  }

}
    
    
    int count_0 = 0;
    public void insert_map(map m)
    {  
       map[count_0] = m;
       count_0++;
    }
    
    
   int count_1 = 0;
    public void insert_graph(graph g)
    {  
       glist[count_1] = g;
       count_1++;
    }
    
    
   public void traversal(graph g)
    {
       queue[0] = g;
        //System.out.println(queue[0]);
       insert_visited(g);
       
       while(queue[0] != null)
       {
           get_nodes(queue[0].node2);
             for(int i = 0; i < pending.length;i++)
             {
                int count = 0;
                if(pending[i] != null)
                {
                    for(int c = 0; c<visited.length; c++)
                    {
                        if(visited[c] !=null)
                        {  
                            if(pending[i].node2 == visited[c].node2||pending[i].node2 == visited[c].node1)
                            {
                                  count= 1;    
                            } 
                        }
                     }
                   if(count == 0)
                    {
                         //System.out.println(pending[i]);
                      traversal(pending[i]);
                      
                   }
                 }
            }
             queue[0] = null;
       }
    }
    
    int count_2 = 0;
    public void insert_pending(graph n)           
    {
         pending[count_2] = n;
         count_2++;
    }
    
    
    public void get_nodes(int node)
    {
        for (int i = 0; i < glist.length; i++) 
        {
            if (glist[i] != null) 
            {
                if (glist[i].node1 == node) 
                {
                    insert_pending(glist[i]);
                }
                if (glist[i].node2 == node) 
                {
                   // swap(glist[i]);
                    insert_pending(glist[i]);
                }
            }
        }
    }
    
    public void swap(graph g)
    {
       int i =0;
       i = g.node1;
       g.node1 = g.node2;
       g.node2 = i;
       
       
        
    }
       
    int count_3 = 0;
    public void insert_visited(graph n)
    {  
       visited[count_3] = n;
       count_3++;
    }
    
    public void print()
    {
        for(int i = 0; i < visited.length;i++)
        {
               map m = new map(i);
               insert_map(m);
        }
    
        for(int i = 0; i < map.length;i++)
        {
            if(map[i] != null)
                for(int c = 0; c < visited.length;c++)
                {
                    if(visited[c] != null)
                    {
                        if(visited[c].node1 == map[i].key)
                        {
                            map[i].insert_value(visited[c].node2);
                        }
                    }
                }
        }
        
        for(int i = 0; i < map.length;i++)
        {
              if(map[i] != null)
              
              for(int q = 0; q <map.length; q++ )
              {
                  for (int c = 0; c < map[i].value.length; c++)
                  {
                      if (map[i].value[c] != 0) 
                      {
                          if (map[i].value[c] == q)
                          {
                              System.out.println(map[i].key + " " + map[i].value[c]);
                          }
                      }

                  } 
              }
        }
    }  
}

class graph
{
   int node1;
   int node2;
   
   public graph(int node1, int node2)
   {
    this.node1 = node1;
    this.node2 = node2;
   }

}

class map
{
   int key;
   int[] value = new int[20];
   
   public map(int key)
   {
      this.key = key;
   }
   
   public void ini()
   {
        for(int i = 0 ; i < value.length; i++)
        {
          value[i] = -1;
        }
   }
   
   int count  =0;
   public void insert_value(int v)
   {
     value[count] = v;
     count++;
   }
}
