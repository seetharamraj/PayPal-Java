package in.msitprogram.jntu.paypal.accounts;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
public class Transaction
{
	String tTime;
	String tDate;
	PPAccount account;
	String narration;
	String reference;
	String status;
	float debit;
	float credit;
	public void setDate()
	{  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		//tTime=dtf.format(now);
	}
	public String toString()
	{
		//return the description of the transaction 
		return tTime;
	}
	
}
