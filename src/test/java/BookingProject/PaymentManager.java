package BookingProject;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager {

	@Test
	public void applyDiscount()
	{
		System.out.println("appy discount");
	}
	
//	@Parameters({ "datasource", "jdbcDriver" })

//	@Parameters({"actionInvalid"})
	@Parameters({"action"})
	@Test
	public void makePayment(@Optional("Default -no discount") String paymentType)
	{
		System.out.println("paymentType="+paymentType);
		if(paymentType.equals("instantPay"))
		{
			System.out.println("instantPay");
		}
		else if(paymentType.equals("pay@hotel"))
		{			
			System.out.println("pay@hotel booking");
		}
		
	}
	
}
