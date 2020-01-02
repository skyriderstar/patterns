package com.kx.designpattern.template;

/**
 * @author kx
 * @date 2019/12/31 13:50
 */
public class TemplateMethodPatternDemo {

	public static void main(String[] args) {

		DiscountCalculator1 discountCalculator1 = new DiscountCalculator1();
		DiscountCalculator2 discountCalculator2 = new DiscountCalculator2();
		DiscountCalculator3 discountCalculator3 = new DiscountCalculator3();

		discountCalculator1.calculate();
		discountCalculator2.calculate();
		discountCalculator3.calculate();

	}

	public interface DiscountCalculator {

		/**
		 * 执行过程
		 */
		void calculate();
	}

	public static abstract class AbstractDiscountCalculator implements DiscountCalculator {

		/**
		 * 执行模板
		 */
		@Override
		public void calculate() {
			// 完成通用的逻辑处理
			commonConcrete();

			// 完成自定义的逻辑处理
			specificCalculate();
		}

		public void commonConcrete() {
			System.out.println("处理商品信息");
			System.out.println("查看商品状况");
			System.out.println("处理风险信息");
		}

		/**
		 * 特定的逻辑处理
		 */
		public abstract void specificCalculate();
	}

	public static class DiscountCalculator1 extends AbstractDiscountCalculator {

		@Override
		public void specificCalculate() {
			System.out.println("开始处理优惠计算器1的特殊逻辑");
		}

	}


	public static class DiscountCalculator2 extends AbstractDiscountCalculator {

		@Override
		public void specificCalculate() {
			System.out.println("开始处理优惠计算器2的特殊逻辑");
		}
	}

	public static class DiscountCalculator3 extends AbstractDiscountCalculator {

		@Override
		public void specificCalculate() {
			System.out.println("开始处理优惠计算器3的特殊逻辑");
		}
	}

}
