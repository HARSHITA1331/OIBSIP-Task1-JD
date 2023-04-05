package OIBSIP;

import java.util.ArrayList;

import java.util.Scanner;

class bankAccount {
	  Scanner sc = new Scanner(System.in);
	  public static void register() {
		System.out.println("------------------------------------------------------------------------");
  		Scanner sc = new Scanner(System.in);
  		System.out.print("\nEnter Your Name - ");
  		atm_interface.name = sc.nextLine();
  		System.out.print("\nEnter Your Username - ");
  		atm_interface.userName = sc.nextLine();
  		System.out.print("\nEnter Your Password - ");
  		atm_interface.password = sc.nextLine();
  		System.out.print("\nEnter Your Account Number - ");
  		atm_interface.accountNo = sc.nextLine();
  		System.out.println("\nRegistration completed..kindly login");
  		System.out.println("------------------------------------------------------------------------");
  		atm_interface.ask();
  		while(true){
            display(atm_interface.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(atm_interface.userName,atm_interface.password);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Bad value! Enter again!");
                }
            }
        }sc.close();
	  }
	  static void display(String name){}
	  static void login(String user,String pass){}
 	
}
class transaction{
	public static void withdraw() {
		Scanner sc=new Scanner(System.in);
		System.out.println("------------------------------------------------------------------------");
        System.out.println("Enter amount to withdraw :");
        float amount=sc.nextFloat();
        if(amount<=atm_interface.balance){
            atm_interface.balance=atm_interface.balance-amount;
            atm_interface.list.add(Float.toString(amount));
            atm_interface.list.add("Withdraw");
            System.out.println("Amount Rs"+amount+"/- withdraw successfully");
            System.out.println("------------------------------------------------------------------------");
        }
        else{
            System.out.println("Insufficient balance to withdraw the cash");
            System.out.println("------------------------------------------------------------------------");
        }
        atm_interface.ask();
        sc.close();
    } 
	 public static void deposit() {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("------------------------------------------------------------------------");
	        System.out.print("Enter amount to deposit :");
	        float amount=sc.nextFloat();
         if (amount >= 0) {
             atm_interface.balance =atm_interface.balance + amount;
             System.out.println("Transaction successful \n Current balance is " + atm_interface.balance);
             atm_interface.list.add(amount + " Rupee/'s deposited!");
             atm_interface.ask();
             System.out.println("------------------------------------------------------------------------");
         } else {
             System.out.print("Enter a valid amount(greater than equal to zero): ");
             deposit();
             System.out.println("------------------------------------------------------------------------");
         }sc.close();
     }
	 
	 public static void transfer() {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("------------------------------------------------------------------------");
	        System.out.println("Enter the receiving body:");
	        String s=sc.nextLine();
	        System.out.println("Enter the account number of the receiving body");
	        long num=sc.nextLong();
	        System.out.println("Enter the amount to be transferred :");
	        float amount=sc.nextFloat();
	        if ((amount <= atm_interface.balance) && (amount >= 0)) {
	        	atm_interface.balance = atm_interface.balance - amount;
	        	System.out.println(amount + " Rupee/s sent to " + s);
	        	System.out.println("Transaction successful \n Current balance is " + atm_interface.balance);
	        	atm_interface.list.add(amount + " transferred to account " + s+" with account number "+num);
	        	atm_interface.ask();
	        	System.out.println("------------------------------------------------------------------------");
	        } else {
	        	System.out.print("Enter a valid amount(greater than equal to zero): ");
	        	transfer();sc.close();
	        	System.out.println("------------------------------------------------------------------------");
         }
     }
	
}
class check{
    static void checkbalance(){
    	System.out.println("------------------------------------------------------------------------");
        System.out.println("The available balance in the bank account :");
        atm_interface.showbalance();
        System.out.println("------------------------------------------------------------------------");
        atm_interface.ask();
    }
}
class history{
	 static void transactionhistory(){
         System.out.println("Your Transaction History is :");
         int k=0;
         if(atm_interface.balance>0){
         for(int i=0;i<(atm_interface.list.size()/2);i++)
         {
             for(int j=0;j<2;j++)
             {
                 System.out.print(atm_interface.list.get(k)+"\n");
                 k++;
             }
             
         }
         }
         else {
             System.out.println("Your account is empty.");
         }
         atm_interface.ask();
 }
}

public class atm_interface {
				

		        public static Scanner sc = new Scanner(System.in);
		        public static ArrayList<String> list = new ArrayList<String>();
		        
		        static String name;
		    	static String userName;
		    	static String password;
		    	static String accountNo;
		    	static float balance = 100000f;

		    	static void updatebalance(int dcash){
		            balance=balance+dcash;
		        }
		        static void showbalance(){
		            System.out.println(balance);
		        }
		        
		        
		        public static void login() {
		        	Scanner sc=new Scanner(System.in);
		            System.out.println("WELCOME TO ATM INTERFACE");
		            System.out.println("--------------------------");
		            System.out.println("Select option :");
		            System.out.println("1. Register");
		            System.out.println("2. Exit");
		            System.out.println("Enter choice: ");
		            int choice =sc.nextInt();
		            if (choice==1){
		                    bankAccount.register();
		            }
		            else {
		                if(choice==2){
		                    System.exit(0);
		                }
		                else{
		                    System.out.println("Select a value only from the given options :");
		                    login();
		                    sc.close();
		                }
		            }
		        }

		        // "ask" function presents the user with a list of options and allows them to choose one of the actions
		        public static void ask() {
		        	System.out.println("Welcome "+atm_interface.name+"! to ATM System");
		            System.out.println("----------------------------------------------------");
		            System.out.println("Select option: ");
		            System.out.println("1) Withdraw");
		            System.out.println("2) Deposit");
		            System.out.println("3) Transfer");
		            System.out.println("4) Check Balance");
		            System.out.println("5) Transaction History");
		            System.out.println("6) Quit");
		            System.out.print("Choose one of the following actions: ");
		            int opt = sc.nextInt();
		            System.out.println();
		            if (1 > opt || opt > 6) {
		                System.out.println("Enter valid input!");
		                ask();
		            } else {
		                switch (opt) {
		                    case 1:
		                        transaction.withdraw();
		                        break;
		                        
		                    case 2:
		                        transaction.deposit();
		                        break;
		                        
		                    case 3:
		                        transaction.transfer();
		                        break;
		                        
		                    case 4:
		                        check.checkbalance();
		                        break;
		                        
		                    case 5:
		                        history.transactionhistory();
		                        break;

		                    case 6:
		                        System.exit(0);
		                }
		            }
		        }

		        public static void main(String[] args) {
		            login();
		            sc.close();
		        }
}
