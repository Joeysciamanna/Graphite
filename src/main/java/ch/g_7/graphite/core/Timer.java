package ch.g_7.graphite.core;

public class Timer {

	// Kerzahl von 120 fps in f/millisecond
	private float frameLockTime = 1f / 120f * 1000f;
	private long lastLoopTime;

	private int updateCallCount;
	private double sleepTime;
	
	private long lastFPSCount;
	private float fpsCount;
	private float fps;

	public void recalculate() {
		long time = System.currentTimeMillis();

	
		double expectedTime = (double)lastLoopTime + frameLockTime;
		if (expectedTime > time) {
			sleepTime = (double) (expectedTime - time);
//			System.out.println(" -> " + sleepTime);
		} else {
			updateCallCount = (int) ((time - lastLoopTime) / frameLockTime);
		}

//		System.out.println("-------------------------------------");
//		System.out.println("time:            " + time);
//		System.out.println("lastLoopTime:    " + lastLoopTime);
//		System.out.println("fpmsLock:        " + fpmsLock);
//		System.out.println("sleepTime:       " + sleepTime);
//		System.out.println(" exp sleepTime:       " + (long)(double) (lastLoopTime + ((double) fpmsLock) - time));
//		System.out.println("updateCallCount: " + updateCallCount);
//		System.out.println(" exp updateCallCount: " + ((time - lastLoopTime) / fpmsLock));
//		System.out.println();
//		System.out.println(new BigDecimal(lastLoopTime).add(new BigDecimal(fpmsLock)).longValue());
//		System.out.println(new BigDecimal(lastLoopTime + fpmsLock));
		
//		long res = lastLoopTime + ((long) fpmsLock);
//		System.out.println(res);
//		System.out.println((long) (lastLoopTime + ((double) fpmsLock)));
		
		
		
//		fps = (1f / lastLoopTime * 1000);
		
		if(lastFPSCount + 1000 < time) {
			fps = fpsCount;
			fpsCount = 0;
			System.out.println(fps);
			lastFPSCount = time;
		}else {
			fpsCount++;
		}
		
		
		lastLoopTime = time;
	}

	public void reset() {
		lastLoopTime = System.currentTimeMillis();
	}

	public int getUpdateCallCount() {
		return updateCallCount;
	}

	public double getSleepTime() {
		return sleepTime;
	}

	public float getFPS() {
		return fps;
	}

	public double getLastLoopTime() {
		return lastLoopTime;
	}
	
	public void setFpsLock(int fps){
		this.frameLockTime = 1 / fps * 1000;
	}

}
