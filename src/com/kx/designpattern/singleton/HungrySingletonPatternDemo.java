package com.kx.designpattern.singleton;

/**
 * @author kx
 * @date 2020/1/2 9:37
 */
public class HungrySingletonPatternDemo {

	public static void main(String[] args) {
//		Singleton singleton = new Singleton();

//		System.out.println(singleton);
//		System.out.println(Singleton.instance);
		System.out.println(Singleton.getInstance());
	}

	public static class Singleton {

		/**
		 * 直接创建此类的实例
		 *
		 */
		private static final Singleton instance = new Singleton();

		/**
		 * 将构造函数设置成为私有的
		 * 除了类本身，其它任何实体不能创建这个对象的实例对象
		 */
		private Singleton() {
		}


		public static Singleton getInstance() {
			return instance;
		}

	}

}
