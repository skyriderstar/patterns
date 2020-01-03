package com.kx.designpattern.decorator;

/**
 * 装饰器模式
 * @author kx
 * @date 2020/1/3 13:59
 */
public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		Component decorator = new Decorator(component);
		decorator.execute();
	}

	public interface Component {

		void execute();

	}

	public static class ConcreteComponent implements Component {

		@Override
		public void execute() {
			System.out.println("执行基础功能");
		}
	}

	public static class Decorator implements Component {

		private Component component;

		public Decorator(Component component) {
			this.component = component;
		}

		@Override
		public void execute() {
			System.out.println("before");
			component.execute();
			System.out.println("after");
		}

	}

}
