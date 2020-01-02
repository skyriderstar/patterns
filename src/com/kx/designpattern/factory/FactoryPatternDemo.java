package com.kx.designpattern.factory;

/**
 * 简单工厂
 * @author kx
 * @date 2019/12/31 14:15
 */
public class FactoryPatternDemo {

	public static void main(String[] args) {

		Product product = ProductFactory.create();
		product.execute();

	}

	public interface Product {

		/**
		 * 产品套路
		 */
		void execute();
	}

	public static class ProductImpl implements Product {

		@Override
		public void execute() {
			System.out.println("产品的功能实现");
		}
	}

	public static class ProductFactory {

		public static Product create() {
			return new ProductImpl();
		}
	}


}
