package ch.g_7.graphite.util;

public class Counter {

	private int value = 0;

	public Counter increase() {
		value++;
		return this;
	}

	public Counter decrease() {
		value--;
		return this;
	}

	public int getValue() {
		return value;
	}

	public Counter setValue(int value) {
		this.value = value;
		return this;
	}
}
