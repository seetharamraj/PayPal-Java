/**
 * 
 */
package in.msitprogram.jntu.paypal.console;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import in.msitprogram.jntu.paypal.console.PPAccountScreen;
import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;
/**
 * @author 
 *
 */
public class MainMenu implements Serializable  {
	private static final long serialVersionUID = -5203955612264882521L;	
	public static void show() throws IOException{
		PPAccount a=new PPAccount();
		int ch;
		String email;
		Scanner sc=new Scanner(System.in);
		try
		{
		System.out.println("1:create account 2:sign in");
		ch=sc.nextInt();
		switch(ch)
		{
		 case 1:
			 System.out.println("enter your email");
			 email=sc.next();
			 a=DataStore.lookupAccount(email);
			 if(a==null)
			 {
				 PPNewAccountScreen na=new PPNewAccountScreen(email);
			 	 na.show();
				 PPAccountActivationScreen.show();
			 }
			 else
			 {
				 System.out.println("account already exists please sign in");
			 }
			 break;
		 case 2:
			 System.out.println("enter your email");
			 email=sc.next();
			 a=DataStore.lookupAccount(email);
			 if(a==null)
			 {
				 System.out.println("there is no existing account create one");
			 }
			 else
			 {
				 PPAccountScreen as=new PPAccountScreen(email);
				 as.show();
			 }
			 break;
		}
		sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
			//default : System.out.println("wrong choice");
		}
		//show the welcome message with the main menu options
		
		//take the menu option as input from the console
		
		//take email address as input from the console
		
		//based on the given menu option instantiate the respective screens
	}

