package com.kx.designpattern.factory;

/**
 * @author kx
 * @date 2019/12/31 14:38
 */
public class FactoryMethodPatternDemo {

	public static void main(String[] args) {

		Product product1 = Product1Factory.getInstance().createProduct();
		product1.execute();

		Product product2 = Product1Factory.getInstance().createProduct();
		product2.execute();

		Product product3 = Product1Factory.getInstance().createProduct();
		product3.execute();
	}

	public interface Product {

		/**
		 * 产品逻辑
		 */
		void execute();

	}

	public static abstract class AbstractTemplateMethodFactory {

		public Product createProduct() {
			// 公共创建方法
			commonCreateProduct();

			// 特定创建方法
			return createSpecific();
		}

		public void commonCreateProduct() {
			System.out.println("获取原料");
			System.out.println("加工原料");
			System.out.println("生产产品");
		}

		public abstract Product createSpecific();

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

	public static class Product1Factory extends AbstractTemplateMethodFactory {

		private static final Product1Factory instance = new Product1Factory();

		private Product1Factory() {

		}

		public static Product1Factory getInstance() {
			return instance;
		}

		@Override
		public Product createSpecific() {
			return new Product1();
		}
	}

	public static class Product2Factory extends AbstractTemplateMethodFactory {
		private static final Product2Factory instance = new Product2Factory();

		private Product2Factory() {

		}

		public static Product2Factory getInstance() {
			return instance;
		}
		@Override
		public Product createSpecific() {
			return new Product2();
		}
	}

	public static class Product3Factory extends AbstractTemplateMethodFactory {

		private static final Product3Factory instance = new Product3Factory();

		private Product3Factory() {

		}

		public static Product3Factory getInstance() {
			return instance;
		}

		@Override
		public Product createSpecific() {
			return new Product3();
		}
	}
}
