package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.Transaction;
import in.msitprogram.jntu.paypal.persistance.DataStore;

public class PPAccountScreen implements Serializable {
	private static final long serialVersionUID = -5203955612264882521L;	
	PPAccount account;
	Scanner scan;
	String email;
	public PPAccountScreen(String email) {
		this.email=email;
		scan = new Scanner(System.in);
		account = DataStore.lookupAccount(email);
	}

	public void show() throws IOException {
		
		//check if account is active
		
		//if active
			int activationCode=account.getActivationcode();
			for(int i=0;i<3;i++)
			{
				System.out.println("enter code"+activationCode);
				int code=scan.nextInt();
				scan.nextLine();
				if(activationCode==code)
				{
					System.out.println("1:withdraw 2:request money 3:send money 4:add money 5: view transactions");
					int ch=scan.nextInt();
					switch(ch)
					{
					case 1:withdrawFunds();
							break;
					case 2:requestMoney();
							break;
					case 3:sendMoney();
							break;
					case 4:addFunds();
							break;
					case 5:viewTransactions();
							break;
					default:System.out.println("wrong choice");
							break;
					}
					break;
					
				}
			}
			// print the account summary
			System.out.println(account);
			MainMenu.show();
			
			// print menu and accept menu options
			// for all the paypal account operations
			
		
	}
	Transaction ts=new Transaction();
	private void withdrawFunds() throws IOException {
		System.out.println("enter amount");
		float a=scan.nextFloat();
		account.withdraw(a);
		ts.setDate();
		DataStore.writeAccount(account);
		// implement the withdraw funds user interface here
		
		//use the account object as needed for withdraw funds
		
	}

	private void requestMoney() throws IOException {
		System.out.println("enter amount");
		float a=scan.nextFloat();
		account.requestMoney(a);
		ts.setDate();
		DataStore.writeAccount(account);
		// 	implement the request money user interface here
		
		//use the account object as needed for request money funds
	}

	private void sendMoney() throws IOException {
		// implement the send moeny user interface here
		
		//use the account object as needed for send money funds
		System.out.println("enter amount");
		float a=scan.nextFloat();
		account.sendMoney(a);
		ts.setDate();
		DataStore.writeAccount(account);
	}

	private void addFunds() throws IOException {
		System.out.println("enter amount");
		float a=scan.nextFloat();
		account.addFunds(a);
		ts.setDate();
		DataStore.writeAccount(account);
		// implement the add funds user interface here
		
		//use the account object as needed for add funds
	}
	private void viewTransactions()
	{
		account.viewTransactions();
	}

}