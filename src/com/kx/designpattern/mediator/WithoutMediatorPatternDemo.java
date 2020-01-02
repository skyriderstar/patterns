package com.kx.designpattern.mediator;

/**
 * 无中介者模式
 * @author kx
 * @date 2020/1/2 16:27
 */
public class WithoutMediatorPatternDemo {

	public static void main(String[] args) {
		ModuleA moduleA = new ModuleA();
		moduleA.execute();

		ModuleB moduleB = new ModuleB();
		moduleB.execute();

		ModuleC moduleC = new ModuleC();
		moduleC.execute();

		// 问题: 模块之间调用复杂混乱,耦合严重
		// 单个模块修改代码 影响其它A B模块的调用
	}

	public static class ModuleA {

		public void execute() {
			ModuleB moduleB = new ModuleB();
			ModuleC moduleC = new ModuleC();
			moduleB.execute("模块A");
			moduleC.execute("模块A");
		}

		public void execute(String invoker) {
			System.out.println(invoker + "在调用模块A的功能");
		}

	}

	public static class ModuleB {

		public void execute(){
			ModuleA moduleA = new ModuleA();
			ModuleC moduleC = new ModuleC();
			moduleA.execute("模块B");
			moduleC.execute("模块B");
		}

		public void execute(String invoker) {
			System.out.println(invoker + "在调用模块B的功能");
		}

	}

	public static class ModuleC {

		public void execute(){
			ModuleA moduleA = new ModuleA();
			ModuleC moduleC = new ModuleC();
			moduleA.execute("模块C");
			moduleC.execute("模块C");
		}

		public void execute(String invoker) {
			System.out.println(invoker + "在调用模块C的功能");
		}
	}

}
