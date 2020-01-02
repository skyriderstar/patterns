package com.kx.designpattern.adapter;

/**
 * @author kx
 * @date 2019/12/31 11:04
 */
public class WithoutAdapterPatternDemo {

	public static void main(String[] args) {

		OldInterface oldInterface = new OldInterfaceImpl();
		NewInterface newInterface = new NewInterfaceImpl();
		oldInterface.oldExecute();
		newInterface.newExecute();

	}

	/**
	 * 老版本接口
	 */
	public interface OldInterface {
		/**
		 * old execute方法
		 */
		void oldExecute();
	}

	/**
	 * 老版本接口实现类
	 */
	public static class OldInterfaceImpl implements OldInterface {

		@Override
		public void oldExecute() {
			System.out.println("老版本接口实现的功能逻辑");
		}
	}

	/**
	 * 新版本接口
	 */
	public interface NewInterface {
		/**
		 * new execute方法
		 */
		void newExecute();
	}

	/**
	 * 新版本实现类
	 */
	public static class NewInterfaceImpl implements NewInterface {

		@Override
		public void newExecute() {
			System.out.println("新版本接口实现的功能逻辑");
		}
	}

}
