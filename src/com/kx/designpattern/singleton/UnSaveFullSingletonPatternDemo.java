package com.kx.designpattern.singleton;

/**
 * 懒汉式单例  线程不安全
 * @author kx
 * @date 2020/1/2 12:21
 */
public class UnSaveFullSingletonPatternDemo {

	public static void main(String[] args) {

	}

	public static class Singleton {

		private static Singleton instance;

		private Singleton() {

		}

		public static Singleton getInstance() {
			// not save
			if (instance == null) {
				instance = new Singleton();
			}
			return instance;
		}

	}

}
