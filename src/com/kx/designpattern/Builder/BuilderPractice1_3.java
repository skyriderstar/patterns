package com.kx.designpattern.Builder;

/**
 * @author kx
 * @date 2020/1/3 9:47
 */
public class BuilderPractice1_3 {

	public static void main(String[] args) {
		// 构造这个复杂的 product 对象
		Product product = new Product();
		// 设置 field1 属性
//		System.out.println("在设置 field1 之前进行复杂的校验逻辑");
//		product.setField1("1");
//
//		// 设置 filed2 属性
//		System.out.println("在设置 field2 之前进行格式转换");
//		product.setField2("2");
//
//		// 设置 field3 属性
//		System.out.println("在设置 field3 之前进行复杂的数据处理逻辑");
//		product.setField3("3");

		// 问题: 如果有几十个字段, 并且这中对象的构建不止一处
		// 结果: 多个地方存在大量相同的代码

		Product normalProduct = new Director(new ConcreteBuilder()).create("1", "2", "3");

		Product optimizedProduct = new OptimizedBuilder().field1("1").field2("2").field3("3").create();

		System.out.println(normalProduct);
		System.out.println(optimizedProduct);

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
	}

	public static class OptimizedBuilder {

		private Product product = new Product();

		public OptimizedBuilder field1(String value) {
			System.out.println("进行字段1的复杂校验填充逻辑");
			product.setField1(value);
			return this;
		}

		public OptimizedBuilder field2(String value) {
			System.out.println("进行字段2的复杂校验填充逻辑");
			product.setField2(value);
			return this;
		}

		public OptimizedBuilder field3(String value) {
			System.out.println("进行字段3的复杂校验填充逻辑");
			product.setField3(value);
			return this;
		}

		public Product create() {
			return product;
		}

	}


	public interface Builder {
		void setField1(String value);

		void setField2(String value);

		void setField3(String value);

		Product create(String field1, String field2, String field3);
	}

	public static class ConcreteBuilder implements Builder {

		private Product product;

		@Override
		public Product create(String field1, String field2, String field3) {
			product = new Product();
			product.setField1(field1);
			product.setField2(field2);
			product.setField3(field3);
			return product;
		}

		@Override
		public void setField1(String value) {
			System.out.println("进行字段1的复杂校验填充逻辑");
			product.setField1(value);
		}

		@Override
		public void setField2(String value) {
			System.out.println("进行字段2的复杂校验填充逻辑");
			product.setField2(value);
		}

		@Override
		public void setField3(String value) {
			System.out.println("进行字段3的复杂校验填充逻辑");
			product.setField3(value);
		}

	}

	public static class Director {
		private Builder builder;

		public Director(Builder builder) {
			this.builder = builder;
		}

		public Product create(String field1, String field2, String field3) {
			return builder.create(field1, field2, field3);
		}
	}


}
