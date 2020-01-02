package com.kx.designpattern.template;

/**
 * @author kx
 * @date 2019/12/31 11:50
 */
public class WithoutTemplateMethodPatternDemo {

	public static void main(String[] args) {

		DiscountCalculator1 discountCalculator1 = new DiscountCalculator1();
		DiscountCalculator2 discountCalculator2 = new DiscountCalculator2();
		DiscountCalculator3 discountCalculator3 = new DiscountCalculator3();

		discountCalculator1.calculate();
		discountCalculator2.calculate();
		discountCalculator3.calculate();

	}

	public static class DiscountCalculator1 {

		public void calculate() {
			System.out.println("处理商品信息");
			System.out.println("查看商品状况");
			System.out.println("处理风险信息");
			System.out.println("开始处理优惠计算器1的特殊逻辑");
		}

	}

	public static class DiscountCalculator2 {

		public void calculate() {
			System.out.println("处理商品信息");
			System.out.println("查看商品状况");
			System.out.println("处理风险信息");
			System.out.println("开始处理优惠计算器2的特殊逻辑");
		}
	}

	public static class DiscountCalculator3 {
		public void calculate() {
			System.out.println("处理商品信息");
			System.out.println("查看商品状况");
			System.out.println("处理风险信息");
			System.out.println("开始处理优惠计算器3的特殊逻辑");
		}
	}

}
