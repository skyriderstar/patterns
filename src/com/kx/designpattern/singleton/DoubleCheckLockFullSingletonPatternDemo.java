package com.kx.designpattern.singleton;


import java.util.concurrent.*;

/**
 * @author kx
 * @date 2020/1/2 12:37
 */
public class DoubleCheckLockFullSingletonPatternDemo {


	public static void main(String[] args) {
		ExecutorService pool = new ThreadPoolExecutor(100,100, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

		for (int i = 0; i < 1000; i++) {
			pool.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(Singleton.getInstance());
				}
			});
		}
	}

	public static class Singleton {

		private static volatile Singleton instance;

		private Singleton() {

		}

		public static Singleton getInstance() {
			// 此处简单校验过滤掉大部分请求,不必阻塞住
			if (instance == null) {
				synchronized (DoubleCheckLockFullSingletonPatternDemo.class) {
					// 保证上个线程一定是初始化成功了
					if (instance == null) {
						instance = new Singleton();
					}
				}
			}
			return instance;
		}


	}



}
