package MVVM;
import java.awt.event.ActionListener;



public interface View {
	public void addViewActionListener(ActionListener listener);
	public void setViewModel(ViewModel viewModel);
	public ViewModel getViewModel();
	public void gui();
}
