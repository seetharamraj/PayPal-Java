package in.msitprogram.jntu.paypal.console;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;

import java.io.IOException;
import java.util.Scanner;

public class PPAccountActivationScreen {
	
	public static void show() throws IOException {
		Scanner sc=new Scanner(System.in);
		String email; //change to get console input
		 System.out.println("enter your email");
		 email=sc.next();
		 PPAccount a=DataStore.lookupAccount(email);
		 if(a==null)
		 {
			 System.out.println("there is no existing account create one");
		 }
		 else
			 System.out.println();
		/*
		 * TODO
		 * fetch the account object using email address
		 * check if the account is suspended
		 * if suspended then activate it
		 * if activation code invalid, retry for 2 more attempts
		 * on successful activation show main menu
		 * on failure show the error message and continue to main menu
		 */				
		
		//PPAccount account = DataStore.lookupAccount(email);
		
		//check if account is active. if yes then ask for suspending it
		
		// if yes suspend it if not go back to main menu
		
		// accept activation code, check if valid, if not give 2 more attempts
		
		//proceed to main menu
		MainMenu.show();
	
	}

}