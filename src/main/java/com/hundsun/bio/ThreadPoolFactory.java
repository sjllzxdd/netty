package com.hundsun.bio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工厂
 */
public class ThreadPoolFactory {
	
	private static final ExecutorService ec;

	static {
		int coreCount = Runtime.getRuntime().availableProcessors();
		ec = new ThreadPoolExecutor(coreCount * 10, coreCount * 10 + 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}

	private  ThreadPoolFactory() {}

	public static void execute(Runnable task) {
		ec.execute(task);
	}
}