package lab;

import java.util.*;

public class Lab {
    private static List<taxPayer> tp = new ArrayList<taxPayer>();
    
    public static void main(String[] args) 
    {
      ResidentTaxPayer tp1 = new ResidentTaxPayer("rtp01","a",20000,"NSW");
      ResidentTaxPayer tp2 = new ResidentTaxPayer("rtp02","b",1111,"NSW");
      ResidentTaxPayer tp3 = new ResidentTaxPayer("rtp03","c",200000.0,"NSW");
      
      NonResidentTaxPayer tp4 = new NonResidentTaxPayer("nrtp01","c",2000000.0,"CN");
      
      tp.add(tp1);
      tp.add(tp2);
      tp.add(tp3);
      tp.add(tp4);
      
      
      for(taxPayer tps: tp )
      {
       tps.print();
      }
      
    }
    
    
}

abstract class taxPayer
{
 public String TFN;
 public String name;
 public double income;   
 
public taxPayer(String TFN, String name, double income)
{
 this.TFN = TFN;
 this.name = name;
 this.income = income;
}

public abstract double calcTax();

public abstract void print();

}

class ResidentTaxPayer extends taxPayer
{
 private String state;
 public ResidentTaxPayer(String TFN, String name, double income,String state)
 {
  super(TFN,name,income);
  this.state = state;
          
 }
 public double calcTax()
 {
    double tax = 0.0;
    if(income <= 20000)
    {
     tax = 1000;
    }
    if(income > 20000)
    {
     tax = (income - 20000)*0.3;
    }
    return tax;
}
 public void print()
 {
  System.out.println("ResidentTaxPayer: " + TFN+" "+ name +" "+  income +" "+ state +" "+ calcTax());
 }
}



class NonResidentTaxPayer extends taxPayer
{
 private String country;
 
 public NonResidentTaxPayer(String TFN, String name, double income,String country)
 {
  super(TFN,name,income);
  this.country = country;
 }
 
 public double calcTax(){
    double tax = 0.0;
    tax = income * 0.3;
    return tax;
}
  public void print()
 {
  System.out.println("NonResidentTaxPayer :" + TFN + name +  income + country + calcTax());
 
 }

}