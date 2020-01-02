package com.kx.designpattern.singleton;

/**
 * 懒汉式/饱汉式 内部内单例模式 线程安全
 * @author kx
 * @date 2020/1/2 11:53
 */
public class InnerClassFullSingletonPatternDemo {

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
	}

	public static class Singleton {
		private Singleton(){
			System.out.println("调用构造方法");
		}

		public static class InnerHolder {
			static {
				System.out.println("静态代码块");
			}
			public static final Singleton instance = new Singleton();
		}

		public static Singleton getInstance() {
			return InnerHolder.instance;
		}

	}

}
