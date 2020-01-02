package com.kx.designpattern.prototype;

/**
 * 原型模式
 * @author kx
 * @date 2020/1/2 16:14
 */
public class PrototypePatternDemo {

	public static void main(String[] args) {
		// 此对象需要拷贝
		Product product = new Product("1", new Component("1"));

		try {
			Product copyProduct = (Product) product.clone();
			System.out.println(product);
			System.out.println(copyProduct);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// 手动拷贝
//		Product copyProduct = new Product(product.getName(), product.getComponent());

//		System.out.println(product);
//		System.out.println(copyProduct);

//		System.out.println(product.getComponent());
//		System.out.println(copyProduct.getComponent());

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

		@Override
		public Object clone() throws CloneNotSupportedException {
			return new Component(getName());
		}
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

		@Override
		public Object clone() throws CloneNotSupportedException {
			return new Product(getName(), (Component) getComponent().clone());
		}
	}

}
