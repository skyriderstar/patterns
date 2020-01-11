package com.kx.designpattern.template;

/**
 * 模板方法练习
 * @author kx
 * @date 2020/1/11 9:31
 */
public class TemplateMethodPractice_1_11_1 {

	public static void main(String[] args) {
		Calculator calculator1 = new AbstractCalculator1();
		calculator1.calculate();

		Calculator calculator2 = new AbstractCalculator2();
		calculator2.calculate();
	}

	public interface Calculator {
		/**
		 * 计算器计算步骤
		 */
		void calculate();
	}

	public static abstract class AbstractCalculatorTemplate implements Calculator {

		/**
		 * 每个计算器必须的方法: 计算
		 */
		@Override
		public void calculate() {
			// 通用准备过程
			commonCreate();
			// 不同计算器特定计算过程
			concreteCalculate();
		}

		/**
		 * 特定计算步骤
		 */
		public abstract void concreteCalculate();

		public void commonCreate() {
			System.out.println("步骤一");
			System.out.println("步骤二");
			System.out.println("步骤三");
		}
	}

	public static class AbstractCalculator1 extends AbstractCalculatorTemplate {

		@Override
		public void concreteCalculate() {
			System.out.println("计算器1 的 特定步骤");
		}
	}

	public static class AbstractCalculator2 extends AbstractCalculatorTemplate {

		@Override
		public void concreteCalculate() {
			System.out.println("计算器2 的 特定步骤");
		}
	}

	public static class AbstractCalculator3 extends AbstractCalculatorTemplate {

		@Override
		public void concreteCalculate() {
			System.out.println("计算器3 的 特定步骤");
		}
	}

}
