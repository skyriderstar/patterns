package com.kx.designpattern.singleton;

/**
 * 懒汉式单例 线程安全
 * @author kx
 * @date 2020/1/2 12:27
 */
public class HeavySaveFullSingletonPatternDemo {

	public static class Singleton {

		private static Singleton instance;

		private Singleton() {
		}

		// 线程全部阻塞住
		public static synchronized Singleton getInstance() {
			if (instance == null) {
				instance = new Singleton();
			}
			return instance;
		}

	}

}
