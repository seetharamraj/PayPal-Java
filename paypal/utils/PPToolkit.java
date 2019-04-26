	/**
 * 
 */
package in.msitprogram.jntu.paypal.utils;
import java.io.Serializable;
import java.util.*;
/**
 * @author pg
 *
 */
public class PPToolkit implements Serializable {
	private static final long serialVersionUID = -5203955612264882521L;	
	public static int generateActivationCode() 
	{
		Random r=new Random();
		int rand=r.nextInt(100000);
		return rand;
	    
	}

	public static void sendActivationCode(String phone) 
	{
		
		
	}

}
