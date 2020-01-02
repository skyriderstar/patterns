package com.kx.designpattern.prototype;

/**
 * 无原型模式
 * @author kx
 * @date 2020/1/2 15:39
 */
public class WithoutPrototypePatternDemo {

	public static void main(String[] args) {

		// 如果需要拷贝这个对象很多次, 则相同的拷贝逻辑在多处

		// 此对象需要拷贝
		Product product = new Product("1", new Component("1"));

		// 手动拷贝
		Product copyProduct = new Product(product.getName(), product.getComponent());

		System.out.println(product);
		System.out.println(copyProduct);

		System.out.println(product.getComponent());
		System.out.println(copyProduct.getComponent());


	}

	public static class Component {
		private String name;

		public Component(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

//		@Override
//		public String toString() {
//			return "Component{" +
//					"name='" + name + '\'' +
//					'}';
//		}
	}

	public static class Product {
		private String name;
		private Component component;

		public Product(String name, Component component) {
			this.name = name;
			this.component = component;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Component getComponent() {
			return component;
		}

		public void setComponent(Component component) {
			this.component = component;
		}

		@Override
		public String toString() {
			return "Product{" +
					"name='" + name + '\'' +
					", component=" + component +
					'}';
		}
	}


}
