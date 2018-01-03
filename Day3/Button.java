
public class Button {
	
	private String title;
	private onClickListener onClickListener;
	
	public Button(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setOnClickListener(onClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}
	
	public void onClick() {
		this.onClickListener.onClick(this.title);
	}
	
	public interface onClickListener{
		public void onClick(String title);
	}
	
}
