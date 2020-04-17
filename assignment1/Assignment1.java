package assignment1;
import java.util.Scanner;

public class Assignment1 
{
    public static void main(String[] args) 
    {
        //create new bank object for calling their methods
        Bank bank = new Bank ();
        
        //call enterCustomer()
        bank.enterCustomer();
        
        //print account list
        System.out.println();
        System.out.println("==========================");
        System.out.println("Opening account balance");
        bank.printbalance();
        
        System.out.println();
        
        //call banking
        bank.banking();
        
        //print account list
        System.out.println();
        System.out.println("==========================");
        System.out.println("Closing account balance");
        bank.printbalance();
    }  
}

class Bank 
{  
    //create a list to store accounts
    Account[] alist = new Account[1000];
    
     //create accounts
    public void enterCustomer()
    {
        int count = 0;
        System.out.println("Enter customer names or q to quit entering names");
        Scanner input = new Scanner(System.in);
        do
        {
            //input account name
            System.out.print("Enter a customer name: ");
            String name = input.next();
            
            //if name = q then break
            if(name.equals("q"))
            {
             break;
            }
            
            //input account balance
             System.out.print("Enter openning balance: ");
            double balance = input.nextDouble();
          
        //using the name and balance inputed above to create a new account    
        Account account = new Account(name,balance);
        alist[count] = account;
        count++;    
        }     
        while (true);
    }  
    
    //print methods
    public void printbalance()
    {
        System.out.println("==========================");
        System.out.println("Customer"+"     "+"Balance");
        System.out.println("==========================");
        //print all instances
        for (int i = 0; i < alist.length; i++) {
            //avoid nullpoint error
            if (alist[i] != null) {
                System.out.println(alist[i].getName() +"              "+ "$"+alist[i].getBalance());
            }
        }
        System.out.println("==========================");   
}
    public void banking()
    {
        Scanner input = new Scanner(System.in);
        do {
            //select serverce
            System.out.print("1:Deposit 2:Withdraw 0:Quit");
            int code = input.nextInt();
            
            //deposit service
            if(code == 1)
            {
              System.out.print("Customer name:");
              String name = input.next();
              System.out.print("Deposit amout:");
              double amount = input.nextDouble();

              //find the account and increase balance
                for (int i = 0; i < alist.length; i++) 
                {
                    if (alist[i] != null)
                    if (alist[i].name.equals(name)) 
                    {
                        alist[i].balance = alist[i].balance + amount;
                    }
                }
            }
            //withdraw service
            if(code == 2)
            {
              System.out.print("Customer name:");
              String name = input.next();
              System.out.print("Withdraw amount:");
              double amount = input.nextDouble();
              
              for (int i = 0; i < alist.length; i++) 
              {
                   if (alist[i] != null)
                    if (alist[i].name.equals(name)) 
                    {       
                        //if balance < amount warning
                        if(alist[i].balance - amount < 0)
                        {
                         System.out.println("Insufficient balance");
                        }
                        //else withdraw
                        else
                        {
                        alist[i].balance = alist[i].balance - amount;
                        }
                        
                    }
                } 
            }
            
            //end service
            if(code ==0)
            {
               break;
            }        
        } 
        while (true);
    }
}

//account class
class Account
{
    //account name
    String name;
    //account balance
    double balance;
    
    //constructer
    public Account(String name, double balance)   
    {
      this.name = name;
      this.balance = balance;
    }
         
    //return name
    public String getName ()
    {    
        return name;
    }
    //return balance
    public double getBalance ()
    {
        return balance;
    }    
       
}