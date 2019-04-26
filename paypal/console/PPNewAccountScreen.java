package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPBusinessAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.jntu.paypal.accounts.Profile;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;
import java.io.*;
public class PPNewAccountScreen implements Serializable {
	Profile profile;
	PPAccount account;
	String email;
	Scanner scan;
	private static final long serialVersionUID = -5203955612264882521L;
	public PPNewAccountScreen(String email) {
		profile = new Profile();
		scan = new Scanner(System.in);
		this.email = email;
	}

	public void show() throws IOException	 {
		//check if the account with the given email address exists 
		
		//if not create the user profile
		
		//show the account types
		
		//based on the given account type selected create the account object
		//profile=new Profile();
		if(DataStore.lookupAccount(email)==null)
		{
		profile=createProfile();
		}
		else
			System.out.println("account already exists");
		//System.out.println("profile "+profile);
		System.out.println("choose your account 1:Business acouunt 2:Student account 3:Personal account");
		int ch=scan.nextInt();
		switch(ch)
		{
		case 1:
			break;
		case 2:createStudentAccount();
			break;
		case 3:createPersonalAccount();
		break;
			
		}
	}

	private Profile createProfile() {
		// use this for creating the profile
		Profile p=new Profile();
		System.out.println("enter your name");
		String name=scan.next();
		p.setName(name);
		System.out.println("enter your address");
		String address=scan.next();
		p.setAddress(address);
		System.out.println("enter phone number");
		String phone=scan.next();
		p.setPhone(phone);
		/*name=p.getName();
		address=p.getAddress();
		phone=p.getPhone();*/
		/*System.out.println(p.getName());
		System.out.println(p.getAddress());
		System.out.println(p.getPhone());*/
		return p;
	}

	private void createBusinessAccount() throws IOException {
		//use this for creating the business account
	}

	private void createStudentAccount() throws IOException {
		//use this for creating the student account 
	}

	/*
	 * this method create the personal account, saves it to the file system
	 * and redirects the users to the next screen
	 */
	private void createPersonalAccount() throws IOException {
		//use this for creating the personal account
		
		completeAccountCreation();
	}
	
	private void completeAccountCreation() throws IOException{
		//generate activation code and set it to account
		
		//send activation code to the phone
		
		//ask & redirect the user to the activation screen or the main menu
		
		int n=PPToolkit.generateActivationCode();
		account=new PPAccount(profile);
		//account.email=email;
		account.setEmail(email);
		account.setAccountBal(0);
		//account.toString();
		account.activate(n);
		account.suspend();
		account.getEmail();
		//System.out.println("enter withdraw amount");
		//float wrAmount=scan.nextFloat();
		//account.withdraw(wrAmount);
		//account=DataStore.lookupAccount(email);
		DataStore.writeAccount(account);
		//System.out.println("account ===="+account);
		
	}

}
