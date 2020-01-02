package com.kx.designpattern.factory;

/**
 * @author kx
 * @date 2019/12/31 17:03
 */
public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {

		// 若定义了100个产品组合, 只需修改一个工厂即可

		// 产品 A1 + 产品 B1    ->    产品 A1 + 产品 B3
		ProductA productA1 = Factory1.getInstance().createProductA();
		ProductB productB1 = Factory1.getInstance().createProductB();
		productA1.execute();
		productB1.execute();

		ProductA productA2 = Factory2.getInstance().createProductA();
		ProductB productB2 = Factory2.getInstance().createProductB();
		productA2.execute();
		productB2.execute();

		ProductA productA3 = Factory3.getInstance().createProductA();
		ProductB productB3 = Factory3.getInstance().createProductB();
		productA3.execute();
		productB3.execute();

	}

	public interface ProductA {

		/**
		 * 产品 A 逻辑
		 */
		void execute();

	}


	public static class ProductA1 implements ProductA {

		@Override
		public void execute() {
			System.out.println("产品A1的功能逻辑");
		}
	}

	public static class ProductA2 implements ProductA {

		@Override
		public void execute() {
			System.out.println("产品A2的功能逻辑");
		}
	}

	public static class ProductA3 implements ProductA {

		@Override
		public void execute() {
			System.out.println("产品A3的功能逻辑");
		}
	}

	public interface ProductB {

		/**
		 * 产品 B 逻辑
		 */
		void execute();

	}

	public static class ProductB1 implements ProductB {

		@Override
		public void execute() {
			System.out.println("产品B1的功能逻辑");
		}
	}

	public static class ProductB2 implements ProductB {

		@Override
		public void execute() {
			System.out.println("产品B2的功能逻辑");
		}
	}

	public static class ProductB3 implements ProductB {

		@Override
		public void execute() {
			System.out.println("产品B3的功能逻辑");
		}
	}

	public interface Factory {

		/**
		 * 生产 A
		 * @return 产品A
		 */
		ProductA createProductA();

		/**
		 * 生产 A
		 * @return 产品B
		 */
		ProductB createProductB();
	}

	public static class Factory1 implements Factory {

		private static final Factory1 instance = new Factory1();

		private Factory1() {

		}

		public static Factory getInstance() {
			return instance;
		}

		@Override
		public ProductA createProductA() {
			return new ProductA1();
		}

		@Override
		public ProductB createProductB() {
			return new ProductB1();
		}
	}

	public static class Factory2 implements Factory {

		private static final Factory2 instance = new Factory2();

		private Factory2() {

		}

		public static Factory2 getInstance() {
			return instance;
		}

		@Override
		public ProductA createProductA() {
			return new ProductA2();
		}

		@Override
		public ProductB createProductB() {
			return new ProductB2();
		}
	}

	public static class Factory3 implements Factory {

		private static final Factory3 instance = new Factory3();

		private Factory3() {}

		public static Factory3 getInstance() {
			return instance;
		}

		@Override
		public ProductA createProductA() {
			return new ProductA3();
		}

		@Override
		public ProductB createProductB() {
			return new ProductB3();
		}
	}

}
