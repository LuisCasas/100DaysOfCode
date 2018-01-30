
public class App {

	public static void main(String[] args) {
		
		VehicleFactory vehicle = new VehicleFactory();
		Vehicle car = vehicle.getVehicle(VehicleType.CAR);
		Vehicle truck = vehicle.getVehicle(VehicleType.TRUCK);
		
		car.startEngine();
		truck.startEngine();
	}

}
