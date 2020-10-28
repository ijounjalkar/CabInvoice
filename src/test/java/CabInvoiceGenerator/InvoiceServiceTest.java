package CabInvoiceGenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class InvoiceServiceTest {
	
	static InvoiceGenerator test = null;
	static Ride[] rides = null;
	static RideRepository rideRepository = new RideRepository();
	static InvoiceSummary expectedInvoiceSummary = null;

	@BeforeAll
	public static void setUp() {
		test = new InvoiceGenerator();
		rides = new Ride[] { new Ride(CabRide.NORMAL, 3.0, 10), new Ride(CabRide.PREMIUM, 1.0, 5) };
		expectedInvoiceSummary = new InvoiceSummary(2, 65);
	}

	@Test
	public void givenDifferentRides_shouldReturnInvoiceSummary() {
		InvoiceSummary invoiceSummary = test.calculateFare(rides);
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "abc@d.com";
		rideRepository.addRides(userId, rides);
		test.setRideRepository(rideRepository);
		InvoiceSummary invoiceSummary = test.getInvoiceSummary(userId);
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
