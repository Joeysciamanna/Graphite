package ch.g_7.graphite.entity.ui;

import org.lwjgl.glfw.GLFW;

import ch.g_7.graphite.core.window.MouseAction;
import ch.g_7.graphite.core.window.MouseListner;
import ch.g_7.util.task.Task;
import ch.g_7.util.task.Task.VoidTask;
import ch.g_7.util.task.TaskList;

public class UIButton extends UIPanel implements IUIButton{

	private TaskList<ButtonAction> buttonListner;
	
	
	public UIButton() {
		this.buttonListner = new TaskList<IUIButton.ButtonAction>();
	}
	
	@Override
	public void init() {
		super.init();
		getWindow().addMouseListner(new MouseListner() {
			@Override
			public void onMouseClick(MouseAction a) {
				if(UIButton.this.getPixelBounds().contains(a.getX(), a.getY())) {
					buttonListner.run(new ButtonAction(a.getWindow(), UIButton.this, a.getButton(), a.getAction(), a.getMods(), a.getX(), a.getY()));
				}
			}
		});
		addClickListner(new VoidTask<IUIButton.ButtonAction>(){
			@Override
			public void runVoid(ButtonAction e) {
				if(e.getAction() == GLFW.GLFW_PRESS) {
					e.getButtonPanel().getColor().darker(10);
				}else if(e.getAction() == GLFW.GLFW_RELEASE) {
					e.getButtonPanel().getColor().lighter(10);
				}
			
			}
		});
	}
	
	
	@Override
	public void addClickListner(Task<ButtonAction, Void> buttonListner) {
		this.buttonListner.add(buttonListner);
	}

	@Override
	public void removeClickListner(Task<ButtonAction, Void> buttonListner) {
		this.buttonListner.remove(buttonListner);
	}

	@Override
	public void clearClickListner() {
		this.buttonListner.clear();
	}


}
