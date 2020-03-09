//package ch.g_7.graphite.ui.util;
//
//import org.joml.Vector2ic;
//
//public class ScaledScreenDimension implements IScreenDimension{
//
//
//	private IScreenDimension dimension;
//	private float factor;
//
//	public ScaledScreenDimension(IScreenDimension dimension, float factor) {
//		this.dimension = dimension;
//		this.factor = factor;
//	}
//
//	public void setFactor(float factor) {
//		this.factor = factor;
//	}
//
//	@Override
//	public ScaledScreenDimension recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
//		dimension.recalculate(screenSize, fatherSize);
//		return this;
//	}
//
//	@Override
//	public ScaledScreenDimension recalculate(int screenSize, int fatherSize) {
//		dimension.recalculate(screenSize, fatherSize);
//		return this;
//	}
//
//	@Override
//	public int getValue() {
//		return (int) (dimension.getValue() * factor);
//	}
//
//
//
//
//}
