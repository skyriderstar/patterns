package com.kx.designpattern.mediator;

/**
 * 中介者模式练习
 * @author kx
 * @date 2020/1/12 22:19
 */
public class MediatorPractice_1_12_1 {

	public static void main(String[] args) {
		Mediator mediator = new Mediator();
		ModuleC moduleC = new ModuleC(mediator);
		ModuleB moduleB = new ModuleB(mediator);
		ModuleA moduleA = new ModuleA(mediator);

		moduleA.execute();
		moduleB.execute();
		moduleC.execute();
	}

	public static class Mediator {

		private ModuleA moduleA;
		private ModuleB moduleB;
		private ModuleC moduleC;

		public void moduleAInvoke() {
			moduleB.execute("模块A");
			moduleC.execute("模块A");
		}

		public void moduleBInvoke() {
			moduleB.execute("模块B");
			moduleC.execute("模块B");
		}

		public void moduleCInvoke() {
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
			this.mediator.moduleAInvoke();
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
			this.mediator.moduleBInvoke();;
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
			this.mediator.moduleCInvoke();
		}

		public void execute(String invoker) {
			System.out.println(invoker + "在调用模块C的功能");
		}
	}

}
