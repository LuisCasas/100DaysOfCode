package processes;

import clients.DeviceProduction;

public class Laptop extends DeviceProduction{
	
	private String deviceType;
	private String manufacturer;
	
	public Laptop(String deviceName) {
		super(deviceName);
		this.deviceType = this.getClass().getSimpleName();
		this.manufacturer = "HP";
	}

	protected void assemblyDevice() {
		System.out.println("Assembling " + deviceType + " manufactured by " + manufacturer);
	};
	
	protected void packageDevice() {
		System.out.println("Pacakging " + deviceType + " manufactured by " + manufacturer);
	};
	
	protected void sendDevice() {
		System.out.println("Sending " + deviceType + " manufactured by " + manufacturer);
	};

}
