package com.kx.designpattern.mediator;

/**
 * @author kx
 * @date 2020/1/3 9:28
 */
public class MediatorPractice1_3 {

	public static void main(String[] args) {
//		ModuleA moduleA = new ModuleA();
//		moduleA.execute();
//
//		ModuleB moduleB = new ModuleB();
//		moduleB.execute();
//
//		ModuleC moduleC = new ModuleC();
//		moduleC.execute();

		// 问题: 模块之间调用复杂混乱,耦合严重
		// 单个模块修改代码 影响其它A B模块的调用

		Mediator mediator = new Mediator();
		ModuleA moduleA = new ModuleA(mediator);
		ModuleB moduleB = new ModuleB(mediator);
		ModuleC moduleC = new ModuleC(mediator);

		moduleA.execute();
		moduleB.execute();
		moduleC.execute();
	}

	public static class Mediator {

		private ModuleA moduleA;
		private ModuleB moduleB;
		private ModuleC moduleC;

		public void moduleAInvoke(){
			moduleB.execute("模块A");
			moduleC.execute("模块A");
		}

		public void moduleBInvoke(){
			moduleB.execute("模块B");
			moduleC.execute("模块B");
		}

		public void moduleCInvoke(){
			moduleB.execute("模块C");
			moduleC.execute("模块C");
		}

		public ModuleA getModuleA() {
			return moduleA;
		}

		public void setModuleA(ModuleA moduleA) {
			this.moduleA = moduleA;
		}

		public ModuleB getModuleB() {
			return moduleB;
		}

		public void setModuleB(ModuleB moduleB) {
			this.moduleB = moduleB;
		}

		public ModuleC getModuleC() {
			return moduleC;
		}

		public void setModuleC(ModuleC moduleC) {
			this.moduleC = moduleC;
		}
	}

	public static class ModuleA {

		private Mediator mediator;

		public ModuleA(Mediator mediator) {
			this.mediator = mediator;
			this.mediator.setModuleA(this);
		}

		public void execute() {
//			ModuleB moduleB = new ModuleB();
//			ModuleC moduleC = new ModuleC();
//			moduleB.execute("模块A");
//			moduleC.execute("模块A");
			mediator.moduleAInvoke();
		}

		public void execute(String invoker) {
			System.out.println(invoker + "在调用模块A的功能");
		}

	}

	public static class ModuleB {

		private Mediator mediator;

		public ModuleB(Mediator mediator) {
			this.mediator = mediator;
			this.mediator.setModuleB(this);
		}

		public void execute() {
//			ModuleA moduleA = new ModuleA();
//			ModuleC moduleC = new ModuleC();
//			moduleA.execute("模块B");
//			moduleC.execute("模块B");
			mediator.moduleBInvoke();
		}

		public void execute(String invoker) {
			System.out.println(invoker + "在调用模块B的功能");
		}

	}

	public static class ModuleC {

		private Mediator mediator;

		public ModuleC(Mediator mediator) {
			this.mediator = mediator;
			this.mediator.setModuleC(this);
		}

		public void execute() {
//			ModuleA moduleA = new ModuleA();
//			ModuleC moduleC = new ModuleC();
//			moduleA.execute("模块C");
//			moduleC.execute("模块C");
			mediator.moduleCInvoke();
		}

		public void execute(String invoker) {
			System.out.println(invoker + "在调用模块C的功能");
		}
	}

}
