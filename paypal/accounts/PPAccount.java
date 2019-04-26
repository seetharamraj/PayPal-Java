package in.msitprogram.jntu.paypal.accounts;
import in.msitprogram.jntu.paypal.accounts.PPAccount;


import java.util.ArrayList;

import in.msitprogram.jntu.paypal.persistance.DataStore;
import java.util.*;
import java.io.*;
public class PPAccount implements Serializable
{
	private static final long serialVersionUID = -5203955612264882521L;
	/**
	 * 
	 */
	private Profile profile;
	private String email;
	private float accountBal;
	private boolean isActivated;
	private int activationCode;
	private ArrayList<Transaction> transactions;
	private PPAccount account;
	//PPAccount pa=new PPAccount();
	public PPAccount()
	{
		
	}
	public PPAccount(Profile profile) {
		// TODO Auto-generated constructor stub
		this.profile=profile;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setAccountBal(float bal)
	{
		accountBal=bal;
	}
	public String toString()
	{
		// implement this function to return a beautiful looking string
		// to display the summary of the account
		
		return profile+"\t"+email+"\t"+accountBal;
	}

	public void activate(int activationCode) 
	{
	    
		// TODO Auto-generated method stub
		this.activationCode=activationCode;
		System.out.println("activation code is "+activationCode);
	}
	public int getActivationcode()
	{
		return activationCode;
	}
	
	public void suspend() 
	{
		// TODO Auto-generated method stub
		
	}


	public boolean withdraw(float withdrawAmount) {
		float withdraw;
		withdraw=withdrawAmount;
		if(accountBal>withdraw)
		{
			accountBal=accountBal-withdraw;
			//write(account)
			return true;
		}
		else
			System.out.println("no funds");
		return false;
	}


	public boolean addFunds(float creditAmount) throws IOException 
	{
		float credit=creditAmount;
		accountBal=accountBal+credit;
		//DataStore.writeAccount(pa);
		return true;
	}

	public boolean sendMoney(float creditAmount) throws IOException 
	{	
		Scanner sc=new Scanner(System.in);

		float credit=creditAmount;
		if(accountBal<credit)
		{
			System.out.println("no funds");
			
		}
		else
		{
			System.out.println("enter receiver email");
			String mail=sc.nextLine();
			PPAccount na;
			na=DataStore.lookupAccount(mail);
			//System.out.println("entered"+na.getEmail());
			if(na==null)
			{
				System.out.println("please enter valid email");
			}
			else
			{
			accountBal=accountBal-credit;
			na.accountBal=na.accountBal+credit;
			DataStore.writeAccount(na);
			}
			return true;
		}
		return false;
	}
	
	public boolean requestMoney(float creditAmount) 
	{
		Scanner sc=new Scanner(System.in);
		float credit;
		credit=creditAmount;
		System.out.println("enter email");
		String mail=sc.nextLine();
		PPAccount na;
		na=DataStore.lookupAccount(mail);
		//System.out.println("entered"+na.getEmail());
		if(na==null)
		{
			System.out.println("please enter valid email");
		}
		else
		{
			System.out.println("please send money "+credit);
			return true;
		}
		return false;

	}
	public boolean viewTransactions()
	{
		transactions=new ArrayList<Transaction>();
		return false;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	
}
