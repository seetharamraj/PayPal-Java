package in.msitprogram.jntu.paypal.accounts;
import java.util.Scanner;
import java.io.*;
public class Profile implements Serializable {
	private static final long serialVersionUID = -5203955612264882521L;	
	private String name;
	private String address;
	private String phone;
	//Scanner scan=new Scanner(System.in);
	public Profile()
	{
		
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public String getPhone()
	{
		return phone;
	}
	public String toString()
	{
		return name+"\t"+address+"\t"+phone;
	}
	
}
