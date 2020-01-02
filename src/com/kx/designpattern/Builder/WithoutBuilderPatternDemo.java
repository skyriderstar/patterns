package com.kx.designpattern.Builder;

/**
 * @author kx
 * @date 2020/1/2 14:32
 */
public class WithoutBuilderPatternDemo {

	public static void main(String[] args) {
		// 构造这个复杂的 product 对象
		Product product = new Product();
		// 设置 field1 属性
		System.out.println("在设置 field1 之前进行复杂的校验逻辑");
		product.setField1("1");

		// 设置 filed2 属性
		System.out.println("在设置 field2 之前进行格式转换");
		product.setField2("2");

		// 设置 field3 属性
		System.out.println("在设置 field3 之前进行复杂的数据处理逻辑");
		product.setField3("3");

		// 问题: 如果有几十个字段, 并且这中对象的构建不止一处
		// 结果: 多个地方存在大量相同的代码


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

}
