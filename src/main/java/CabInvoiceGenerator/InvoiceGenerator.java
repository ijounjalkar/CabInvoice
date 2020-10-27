package CabInvoiceGenerator;

public class InvoiceGenerator {
	private double MIN_COST_PER_KILOMETER = 10.0;
	private int COST_PER_TIME = 1;
	private double MIN_FARE = 5.0;

	public double calculateFare(double dist, int time) {
		double fare = (dist*MIN_COST_PER_KILOMETER + time*COST_PER_TIME);
		if (fare < MIN_FARE) {
			System.out.println("Total Fare: "+fare);
			return MIN_FARE;
		}
	System.out.println("Total Fare: "+fare);
	return fare;
	}

}
