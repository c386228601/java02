/**
* CSIT111 Assignment 2
* 
* Student name: Egor Kalinin
* Student user ID: ek446	
* Student number: 5060436
*/ 


package mycalendar;

import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;



public class MyCalendar {
    myDate Md;
    public static void main(String[] args) 
    {
       Scanner scanner = new Scanner(System.in);
            
        System.out.print("Enter the day, month and year: ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        
        myDate theDay = new myDate (day, month, year);
        MyCalendar Mc = new MyCalendar(theDay);
         Mc.printDateInfo();
    }
    
    public MyCalendar(myDate Md)
    {
     this.Md = Md;
    }
     
    
    public int getDayOfWeek () 
    {
        int q  = this.Md.getDay();
        int m = 0;
        int k = 0;
        int j  = 0;
        
        // System.out.println("j"+j);
        if(this.Md.getMonth() == 1)
        {
           m = 13;
           k = (this.Md.getYear()-1)%100;
           j = (this.Md.getYear()-1)/100;
        }
        
        if(this.Md.getMonth() == 2)
        {
           m = 14;
            k = (this.Md.getYear()-1)%100;
           j = (this.Md.getYear()-1)/100;
        }
        
        else if(this.Md.getMonth() != 1 && this.Md.getMonth() != 2)
        {
           m = this.Md.getMonth();
           k = (this.Md.getYear())%100;
           j = (this.Md.getYear())/100;
        }
        
        int dayOfWeek = (q+(13*(m+1)/5)+k+(k/4)+(j/4)+(5*j))%7;
        return dayOfWeek;
        
        
    }
    public int getWeekOfMonth ()
    {
       int weekOfMonth = 0;
       
       if(this.Md.getDay()<=7)
       {
          weekOfMonth = 1;
       }
       if(this.Md.getDay()>7&&this.Md.getDay()<=14)
       {
        weekOfMonth = 2;
       }
       if(this.Md.getDay()>14&&this.Md.getDay()<=21)
       {
         weekOfMonth = 3;
       }
       if(this.Md.getDay()>21&&this.Md.getDay()<=28)
       {
         weekOfMonth = 4;
       
       }
       if(this.Md.getDay()>28)
       {
         weekOfMonth = 5;
       
       }

                          
       return weekOfMonth;
    }
    public void printDateInfo ()
    {     
        String month = "";
        String week = "";
        String m = " ";
        
        switch(getWeekOfMonth())
        {
            case 1:
                month = "First";
        break;
            case 2:
                month = "Seonde";
                break;
            case 3:
                month = "Third";
                break;
            case 4:
                month = "Fourth";
                break;
         case 5:
                month = "Fifth";
                break;
        }
        
        
        switch(getDayOfWeek())
        {
            case 0:
                week = "Saturday";
                break;
            case 1:
                week = "Sunday";
                break;
            case 2:
                week = "Monday";
                break;
            case 3:
                week = "Tuesday";
                break;
            case 4:
                week = "Wednesday";
                break;
            case 5:
                week = "Thursday";
                break;
            case 6:
                week = "Friday";
                break;
        }
        
         switch(this.Md.getMonth())
        {
            case 1:
                m = "January";
                break;
            case 2:
                m = "February";
                break;
            case 3:
                m = "March";
                break;
            case 4:
                m = "April";
                break;
            case 5:
                m = "May";
                break;
            case 6:
                m = "June";
                break;
            case 7:
                m = "July";
                break;
            case 8:
                m = "August";
                break;
            case 9:
                m = "September";
                break;
            case 10:
                m = "October";
                break;
            case 11:
                m = "November";
                break;
            case 12:
                m = "December";
                break;
        }
              
        System.out.println(this.Md.getDay()+"/"+this.Md.getMonth()+"/"+ this.Md.getYear()+ " is a " + week + " and located in the "+ month +" week of "+ m + " "+this.Md.getYear());
        System.out.println();
        System.out.println("The Calendar of "+ m + " "+this.Md.getYear()+" is:");
        System.out.println();
        printCalendar();
        
    }
    public void printCalendar ()
    {
            System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5s %-5s %n","SUN","MON","TUE","WED","THU","FRI","SAT");
            
            for(int i = 0 ; i <= 31; i++)
            {
                        myDate theDay = new myDate (i, this.Md.getMonth(), this.Md.getYear());
                         MyCalendar m = new MyCalendar(theDay);
                         
                            //System.out.printf("%-6s",i);
                            if(i!=0)
                if (m.getDayOfWeek() == 1) {
                    System.out.printf("%-6s", i);
                }
                if (m.getDayOfWeek() == 2) {
                    System.out.printf("%-12s", i);
                }
                if (m.getDayOfWeek() == 3) {
                    System.out.printf("%-18s", i);
                }
                if (m.getDayOfWeek() == 4) {
                   System.out.printf("%-24s", i);
                }
                  if(m.getDayOfWeek() == 5)
                {
                    System.out.printf("%-30s", i);
                     System.out.println();
                }
                if(m.getDayOfWeek() == 6)
                {
                    System.out.printf("%-30s", i);
                     System.out.println();
                }
               if(m.getDayOfWeek() == 0)
                {
                    System.out.printf("%-36s", i);
                     System.out.println();
                }
            }
            
    }
       

}

class myDate {
    
    int day, month, year;
 
    myDate(int day, int month, int year) 
    { 
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int getDay()
    {
     return this.day;
    }
    
    public int getMonth()
    {
     return this.month;
    
    }
    
    public int getYear()
    {
       return this.year;
    }
    
//    public boolean isDateValid()
//    {
//
//    
//    }  
}
    
    