package com.kx.designpattern.chain;

/**
 * 责任链模式
 * @author kx
 * @date 2020/1/3 14:10
 */
public class ChainPatternDemo {

	public static void main(String[] args) {
		// 业务流程1
//		Handler thirdHandler = new Handler3(null);
//		Handler secondHandler = new Handler2(thirdHandler);
//		Handler firstHandler = new Handler1(secondHandler);
//		firstHandler.execute();

		// 业务流程2
		Handler thirdHandler = new Handler3(null);
		Handler secondHandler = new Handler1(thirdHandler);
		Handler firstHandler = new Handler2(secondHandler);
		firstHandler.execute();


	}

	public static abstract class Handler {
		protected Handler successor;

		public Handler(Handler successor) {
			this.successor = successor;
		}

		public abstract void execute();
	}

	public static class Handler1 extends Handler {

		public Handler1(Handler successor) {
			super(successor);
		}

		@Override
		public void execute() {
			System.out.println("执行功能1");
			if (successor != null) {
				successor.execute();
			}
		}
	}

	public static class Handler2 extends Handler {

		public Handler2(Handler successor) {
			super(successor);
		}

		@Override
		public void execute() {
			System.out.println("执行功能2");
			if (successor != null) {
				successor.execute();
			}
		}
	}

	public static class Handler3 extends Handler {

		public Handler3(Handler successor) {
			super(successor);
		}

		@Override
		public void execute() {
			System.out.println("执行功能3");
			if (successor != null) {
				successor.execute();
			}
		}
	}

}
