package com.kx.designpattern.template;

/**
 * 模板方法练习
 * @author kx
 * @date 2020/1/10 12:40
 */
public class TemplateMethodPractice_1_10_1 {

	public static void main(String[] args) {
		DiscountCalculator1 calculator1 = new DiscountCalculator1();
		calculator1.calculate();

		DiscountCalculator2 calculator2 = new DiscountCalculator2();
		calculator2.calculate();
	}

	public static abstract class AbstractCalculatorTemplate {

		/**
		 * 整个计算过程
		 */
		public void calculate() {

			commonCalculate();

			concreteCalculate();
		}

		/**
		 * 通用的处理步骤
		 */
		public void commonCalculate() {
			System.out.println("处理商品信息");
			System.out.println("查看商品状况");
			System.out.println("处理风险信息");
		}

		/**
		 * 特定的步骤
		 */
		public abstract void concreteCalculate();

	}

	public static class DiscountCalculator1 extends AbstractCalculatorTemplate {

		@Override
		public void concreteCalculate() {
			System.out.println("开始处理优惠计算器1的特殊逻辑");
		}

	}

	public static class DiscountCalculator2 extends AbstractCalculatorTemplate {

		@Override
		public void concreteCalculate() {
			System.out.println("开始处理优惠计算器2的特殊逻辑");
		}

	}

	public static class DiscountCalculator3 extends AbstractCalculatorTemplate {

		@Override
		public void concreteCalculate() {
			System.out.println("开始处理优惠计算器3的特殊逻辑");
		}

	}

}
