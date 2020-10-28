package CabInvoiceGenerator;

public class Ride {
	
		public double distance;
		public int time;
		public CabRide cabRide;
		public Ride(CabRide cabRide, double distance, int time) {
			this.distance = distance;
			this.time = time;
			this.cabRide = cabRide;
		}
	

}
