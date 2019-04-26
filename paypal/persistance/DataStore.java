package in.msitprogram.jntu.paypal.persistance;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.jntu.paypal.console.MainMenu;

//import java.util.Vector;
//import java.util.Iterator;
import java.util.*;
import java.io.*;
public class DataStore implements Serializable
{
	private static final long serialVersionUID = -5203955612264882521L;	
	@SuppressWarnings("unchecked")
	
	public static PPAccount lookupAccount(String email) 
	{
		Vector<PPAccount> v=new Vector<PPAccount>();
		int i;
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personal.txt"));
			v=(Vector<PPAccount>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{}
		for(i=0;i<v.size();i++)
		{
			//System.out.println(v.get(i).getEmail()+v.size());
			if(v.get(i).getEmail().equalsIgnoreCase(email))
			{
				return v.get(i);
			}
		}
			return null;
	}

		//System.out.println("account ===="+account);
		@SuppressWarnings("unchecked")
		public static void writeAccount(PPAccount account) throws IOException
		{
			Vector<PPAccount> v=new Vector<PPAccount>();
			try
			{
			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personal.txt"));
				v=(Vector<PPAccount>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{}
			
			for(int k=0;k<v.size();k++)
			{
				if(v.get(k).getEmail().equals(account.getEmail()))
				{
					v.remove(v.get(k));
				}	
			}
			
			
			v.add(account);
			//ois.close();
		
				ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("personal.txt"));
				obj1.writeObject(v);
				System.out.println("done");
				obj1.close();
			
			try
			{
			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personal.txt"));
				v=(Vector<PPAccount>)ois.readObject();
				/*Iterator<PPAccount> iterator = v.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				//System.out.println(account);*/
				ois.close();
			//}
			}
			catch(Exception e)
			{}
			//MainMenu.show();
			
		}
		
	
}
