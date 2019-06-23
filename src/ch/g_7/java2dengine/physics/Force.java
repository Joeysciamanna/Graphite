package ch.g_7.java2dengine.physics;

public class Force {

	private double xForce, yForce;
	
	public Force(double xForce, double yForce) {
		this.xForce = xForce;
		this.yForce = yForce;
	}
	
	public Force() {}
	
	public double getxForce() {
		return xForce;
	}
	
	public double getyForce() {
		return yForce;
	}
	
	public void addForce(Force force) {
		this.xForce += force.getxForce();
		this.yForce += force.getyForce();
	}
	
}
