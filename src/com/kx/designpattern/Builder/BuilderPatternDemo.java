package com.kx.designpattern.Builder;

/**
 * 构造者模式
 * @author kx
 * @date 2020/1/2 14:50
 */
public class BuilderPatternDemo {

	public static void main(String[] args) {
		Director director = new Director(new ConcreteBuilder());
		Product product = director.build("1", "2", "3");
		System.out.println(product);
	}

	public static class Product {

		private String field1;
		private String field2;
		private String field3;

		public String getField1() {
			return field1;
		}

		public void setField1(String field1) {
			this.field1 = field1;
		}

		public String getField2() {
			return field2;
		}

		public void setField2(String field2) {
			this.field2 = field2;
		}

		public String getField3() {
			return field3;
		}

		public void setField3(String field3) {
			this.field3 = field3;
		}

		@Override
		public String toString() {
			return "Product{" +
					"field1='" + field1 + '\'' +
					", field2='" + field2 + '\'' +
					", field3='" + field3 + '\'' +
					'}';
		}
	}

	public interface Builder {

		void field1(String value);

		void field2(String value);

		void field3(String value);

		Product create();

	}

	public static class ConcreteBuilder implements Builder {

		private Product product = new Product();

		@Override
		public void field1(String value) {
			// 设置 field1 属性
			System.out.println("在设置 field1 之前进行复杂的校验逻辑");
			product.setField1(value);


		}

		@Override
		public void field2(String value) {
			// 设置 filed2 属性
			System.out.println("在设置 field2 之前进行格式转换");
			product.setField2(value);

		}

		@Override
		public void field3(String value) {
			// 设置 field3 属性
			System.out.println("在设置 field3 之前进行复杂的数据处理逻辑");
			product.setField3(value);
		}

		@Override
		public Product create() {
			return product;
		}
	}

	public static class Director {

		private Builder builder;

		public Director(Builder builder) {
			this.builder = builder;
		}

		public Product build(String field1, String field2, String field3) {
			builder.field1(field1);
			builder.field2(field2);
			builder.field3(field3);
			return builder.create();
		}
	}

}
