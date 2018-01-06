
public class Songs {

	private String name;
	private Double duration;
	public Songs(String name, Double duration) {
		this.name = name;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public Double getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return this.name + ": "+this.duration;
	}
	
}
