package clients;

public abstract class DeviceProduction {
	
	private String deviceName;

	public DeviceProduction(String deviceName) {
		this.deviceName = deviceName;
		System.out.println("Device production for " + this.deviceName);
	}
	
	public String getDeviceName() {
		return this.deviceName;
	}
	
	protected abstract void assemblyDevice();
	protected abstract void packageDevice();
	protected abstract void sendDevice();
	
	public void startProcess() {
		assemblyDevice();
		packageDevice();
		sendDevice();
	}

}
