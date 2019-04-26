package in.msitprogram.jntu.paypal;
//import in.msitprogram.jntu.paypal.console;
import java.io.IOException;
import java.io.Serializable;

import in.msitprogram.jntu.paypal.console.MainMenu;


/**
 * @author pg
 *
 */
public class PPSystem implements Serializable
{
	private static final long serialVersionUID = -5203955612264882521L;	
	public static void main(String[] args) throws IOException 
	{
		
		MainMenu.show();
	}

}
