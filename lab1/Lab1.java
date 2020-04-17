package lab1;
import java.util.*;
public class Lab1 
{
    public static void main1(String[] args) 
    {
        Account acc1 = new Account ("Joe", 150);
        Account acc2 = new Account ("Sue", 225);
        System.out.println (acc1);
        System.out.println (acc2);
//      acc1.increaseBalance(100);
//      System.out.println (acc1);

        acc2.transferTo(acc1, 50);
        System.out.println (acc1);
        System.out.println (acc2);
    }
    
    public static void main(String[] args) 
    {
        Account acc1 = new Account ("Joe", 150);
        Account acc2 = new Account ("Sue", 225);
        Account acc3 = new Account ("Kim", 125);
        Account acc4 = new Account ("Jil", 700);
        
        List<Account> accs = new ArrayList<Account>();
        accs.add (acc1);
        accs.add (acc2);
        accs.add (acc3);
        accs.add (acc4);
        
      Collections.sort (accs);
        
        for (Account acc : accs)
            acc.print ();
        
    }
}

class Account implements Comparable<Account>
{
    private String id;
    private double balance;
    
    public Account (String id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }
       
    public int compareTo (Account other)
    {
        
        return this.balance > other.balance ? -1 : 1;
        
    }
    
    public String toString ()
    {
        return id + " " + balance;
    }
    
    public void print ()
    {
        System.out.println (this);
    }
    
    public void increaseBalance (double amount)
    {
        this.balance += amount;
    }
    
    public boolean transferTo (Account other, double amount)
    {
        if (this.balance < amount)
            return false;
        
        this .balance -= amount;
        other.balance += amount;
        return true;
    }
}
