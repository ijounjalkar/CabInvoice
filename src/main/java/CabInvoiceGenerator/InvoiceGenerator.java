package CabInvoiceGenerator;

public class InvoiceGenerator {
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final double MINIMUM_FARE = 5;
	private RideRepository rideRepository;

	public InvoiceGenerator() {
		rideRepository = new RideRepository();
	}
	
	public double calculateFare(double distance, int time) {
		double totalfare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalfare, MINIMUM_FARE);
	}
	
	private RideRepository rideRepository;

	/**
	 * Modified method to get InvoiceSummary for multiple rides 
	 * according to the ride category
	 * 
	 * @param multipleRides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += ride.cabRide.calcCostOfCabRide(ride);
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}



}
