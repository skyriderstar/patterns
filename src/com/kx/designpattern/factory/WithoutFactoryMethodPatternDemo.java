package com.kx.designpattern.factory;

/**
 * 无工厂方法
 * @author kx
 * @date 2019/12/31 14:39
 */
public class WithoutFactoryMethodPatternDemo {

	public static void main(String[] args) {
		Product product1 = Product1Factory.createProduct();
		Product product2 = Product1Factory.createProduct();
		Product product3 = Product1Factory.createProduct();

		product1.execute();
		product2.execute();
		product3.execute();
	}

	public interface Product {

		/**
		 * 产品逻辑
		 */
		void execute();

	}

	public static class Product1 implements Product {

		@Override
		public void execute() {
			System.out.println("产品1的功能逻辑");
		}
	}

	public static class Product2 implements Product {

		@Override
		public void execute() {
			System.out.println("产品2的功能逻辑");
		}
	}

	public static class Product3 implements Product {

		@Override
		public void execute() {
			System.out.println("产品3的功能逻辑");
		}
	}

	public static class Product1Factory {

		public static Product createProduct() {
			System.out.println("获取原料");
			System.out.println("加工原料");
			System.out.println("生产产品");
			return new Product1();
		}
	}

	public static class Product2Factory {

		public static Product createProduct() {
			System.out.println("获取原料");
			System.out.println("加工原料");
			System.out.println("生产产品");
			return new Product2();
		}
	}

	public static class Product3Factory {

		public static Product createProduct() {
			System.out.println("获取原料");
			System.out.println("加工原料");
			System.out.println("生产产品");
			return new Product3();
		}
	}
}
