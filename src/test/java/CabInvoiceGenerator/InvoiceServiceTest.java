package CabInvoiceGenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvoiceServiceTest {
	
	/**
	 * UC1_CalucalteFare
	 */
	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		InvoiceGenerator test  = new InvoiceGenerator();
		double dist = 2.0;
		int time = 5;
		double fare = test.calculateFare(dist, time);
		assertEquals(25, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTime_shouldReturnMinimumFare() {
		InvoiceGenerator test  = new InvoiceGenerator();
		double dist = 0.0;
		int time = 1;
		double fare = test.calculateFare(dist, time);
		assertEquals(5, fare, 0.0);
	}
	
	/**
	 * UC2_CalculateFareForMultipleRides
	 */
	@Test
	public void givenMultipleRides_shouldReturnTotalFare() {
		InvoiceGenerator test  = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5),
				new Ride(2.0, 8),
				new Ride(0.2, 1),
				new Ride(3.0, 6),			
		};
		double fare = test.calculateFare(rides);
		assertEquals(94, fare, 0.0);
	}
	
	/**
	 * UC3_CalculateFareForMultipleRides and return summary
	 */
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		InvoiceGenerator test  = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5),
				new Ride(2.0, 8),
				new Ride(0.2, 1),
				new Ride(3.0, 6),			
		};
		InvoiceSummary summary = test.calculateFare(rides);
		InvoiceSummary expected = new InvoiceSummary(4, 94.0);
		assertEquals(expected, summary);
	}
	
	/**
	 * UC4_Invoice Service
	 */
	@Test
	public void givenUserIDAndRides_shouldReturn_InvoiceSummary() {
		String userId = "abc@xyz";
		Ride[] rides = { new Ride(3.0, 5),
				new Ride(0.1, 2)
		};
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(expectedInvoiceSummary, summary);
	}

}
