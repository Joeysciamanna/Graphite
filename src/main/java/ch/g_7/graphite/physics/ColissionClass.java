package ch.g_7.graphite.physics;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;

import ch.g_7.util.task.TaskCallBuffer;
import ch.g_7.util.task.TaskIntervalBuffer;

public class ColissionClass {

	private List<IBody> bodies;
		
	private PhysicsCalculator calculator;
	
	private Vector3f force;
	
	private TaskIntervalBuffer<Void> calculatorExecutor;
	
	public ColissionClass() {
		this.bodies = new ArrayList<>();
		this.calculator = new PhysicsCalculator(this);
		this.force = new Vector3f();
		this.calculatorExecutor = new TaskIntervalBuffer<>(calculator, 20);
	}
	
	public void add(IBody body) {
		bodies.add(body);
	}
	
	public void remove(IBody body) {
		bodies.remove(body);
	}

	public void setIntervall(int intervall) {
		calculatorExecutor.setIntervall(intervall);
	}
	
	public void setCallBuffer(int callBuffer) {
		calculatorExecutor.setCallBuffer(callBuffer);
	}
	
	public Vector3f getForce() {
		return force;
	}
	
	public void setForce(Vector3f force) {
		this.force = force;
	}
	
	public List<IBody> getBodies() {
		return bodies;
	}
}
