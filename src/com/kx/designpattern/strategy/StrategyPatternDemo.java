package com.kx.designpattern.strategy;

/**
 * 策略模式
 * @author kx
 * @date 2020/1/3 11:01
 */
public class StrategyPatternDemo {

	public static void main(String[] args) {
		int discount = 1;

		DiscountCalculateStrategy strategy = DiscountCalculateStrategyFactory.getDiscountCalculatorStrategy(discount);

		Context context = new Context();
		context.setStrategy(strategy);
		context.calculate();
	}

	public interface DiscountCalculateStrategy {
		void calculate();
	}

	public static class Context {
		private DiscountCalculateStrategy strategy;

		public void calculate() {
			strategy.calculate();
		}

		public DiscountCalculateStrategy getStrategy() {
			return strategy;
		}

		public void setStrategy(DiscountCalculateStrategy strategy) {
			this.strategy = strategy;
		}
	}

	public static class DiscountCalculateStrategyFactory {
		public static DiscountCalculateStrategy getDiscountCalculatorStrategy(int discountStrategy) {
			if (discountStrategy == 1) {
				return new DiscountCalculateStrategyA();
			} else if (discountStrategy == 2) {
				return new DiscountCalculateStrategyB();
			} else if (discountStrategy == 3) {
				return new DiscountCalculateStrategyC();
			} else if (discountStrategy == 4) {
				return new DiscountCalculateStrategyD();
			} else {
				return new DiscountCalculateStrategyDefault();
			}
		}
	}

	public static class DiscountCalculateStrategyA implements DiscountCalculateStrategy {

		@Override
		public void calculate() {
			System.out.println("执行优惠1策略");
		}
	}

	public static class DiscountCalculateStrategyB implements DiscountCalculateStrategy {

		@Override
		public void calculate() {
			System.out.println("执行优惠2策略");
		}
	}

	public static class DiscountCalculateStrategyC implements DiscountCalculateStrategy {

		@Override
		public void calculate() {
			System.out.println("执行优惠3策略");
		}
	}

	public static class DiscountCalculateStrategyD implements DiscountCalculateStrategy {

		@Override
		public void calculate() {
			System.out.println("执行优惠4策略");
		}
	}

	public static class DiscountCalculateStrategyDefault implements DiscountCalculateStrategy {

		@Override
		public void calculate() {
			System.out.println("执行默认策略");
		}
	}

}
