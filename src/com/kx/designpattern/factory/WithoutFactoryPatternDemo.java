package com.kx.designpattern.factory;

/**
 * 无简单工厂
 * @author kx
 * @date 2019/12/31 14:12
 */
public class WithoutFactoryPatternDemo {

	public static void main(String[] args) {

		// 我们如果对Product，要更换一个类，换一个类的实现
		// 此时就必须在创建这个类实例的地方，都要修改一下这个代码
		// 如果你有100个地方，都创建了Product这个类的实例
		// 你需要在100个地方都去修改这个new Product()的这段代码
		// 代码可维护性和可扩展性之差，惨不忍睹，垃圾代码
		// Product1 product = new Product1("apple");
		Product product = new Product("apple");
		System.out.println(product);

	}

	/**
	 * 产品类
	 */
	public static class Product {

		private String name;

		public Product(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Product{" +
					"name='" + name + '\'' +
					'}';
		}
	}

}
