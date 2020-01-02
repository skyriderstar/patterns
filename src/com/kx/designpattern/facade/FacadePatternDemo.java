package com.kx.designpattern.facade;

/**
 * @author kx
 * @date 2020/1/2 14:23
 */
public class FacadePatternDemo {

	public static void main(String[] args) {

		SystemFacade facade = new SystemFacade();
		facade.execute();

	}

	/**
	 * 子系统1的门面
	 */
	public static class SystemFacade {
		// 封装了自己的多个模块, ABC, 基于自己多个模块的功能,对外统一暴露出去一个功能
		public void execute() {
			ModuleA moduleA = new ModuleA();
			ModuleB moduleB = new ModuleB();
			ModuleC moduleC = new ModuleC();

			moduleA.execute();
			moduleB.execute();
			moduleC.execute();
			System.out.println("新增的一段逻辑");
		}
	}

	public static class ModuleA {

		public void execute() {
			System.out.println("子系统1的模块A的功能");
		}

	}

	public static class ModuleB {

		public void execute(){
			System.out.println("子系统1的模块B的功能");
		}

	}

	public static class ModuleC {

		public void execute() {
			System.out.println("子系统1的模块C的功能");
		}
	}

}
