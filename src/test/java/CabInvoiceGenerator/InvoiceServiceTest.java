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
		assertEquals(5, fare);
	}

}
