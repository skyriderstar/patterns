package com.kx.designpattern.adapter;

/**
 * @author kx
 * @date 2019/12/31 11:26
 */
public class AdapterPatternDemo {

	public static void main(String[] args) {

		NewInterface oldInterface = new NewInterfaceAdapter(new OldInterfaceImpl());
		NewInterface newInterface = new NewInterfaceImpl();
		oldInterface.newExecute();
		newInterface.newExecute();

	}

	public static class NewInterfaceAdapter implements NewInterface {

		private OldInterface oldInterface;

		public NewInterfaceAdapter(OldInterface oldInterface) {
			this.oldInterface = oldInterface;
		}

		@Override
		public void newExecute() {
			oldInterface.oldExecute();
		}
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
