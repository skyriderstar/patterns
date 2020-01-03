package com.kx.designpattern.state;

/**
 * 状态模式
 * @author kx
 * @date 2020/1/3 11:20
 */
public class StatePatternDemo {

	public static void main(String[] args) {
		Context context = new Context(new NewState());
		context.execute(1);
		context.execute(2);
		context.execute(3);
	}


	public static class Context {

		private State state;

		public Context(State state) {
			this.state = state;
			this.state.execute();
		}

		public void execute(int stateType) {
			if (stateType == 1) {
				this.state = new ApprovingState();
				this.state.execute();
			} else if (stateType == 2) {
				this.state = new ApprovedState();
				this.state.execute();
			} else if (stateType == 3) {
				this.state = new FinishedState();
				this.state.execute();
			}
		}
	}

	public interface State {

		void execute();

	}

	public static class NewState implements State {

		@Override
		public void execute() {
			System.out.println("销售单新建状态的逻辑");
		}
	}

	public static class ApprovingState implements State {

		@Override
		public void execute() {
			System.out.println("待审批逻辑");
		}
	}

	public static class ApprovedState implements State {

		@Override
		public void execute() {
			System.out.println("已审批逻辑");
		}
	}

	public static class FinishedState implements State {

		@Override
		public void execute() {
			System.out.println("已完成逻辑");
		}
	}

}
