package com.kx.designpattern.state;

/**
 * 状态模式练习
 * @author kx
 * @date 2020/1/11 9:53
 */
public class StatePractice_1_11_1 {

	public static void main(String[] args) {
		Context context = new Context();
		context.execute(1);
		context.execute(2);
		context.execute(3);
		context.execute(4);
		context.execute(5);
		context.execute(3);
		context.execute(5);
		context.execute(1);
	}



	public static class Context {

		public void execute(int stateType) {

			StateStrategyFactory.getStateStrategy(stateType).execute();

		}
	}

	public static class StateStrategyFactory {

		public static State getStateStrategy(int stateType) {
			if (stateType == 1) {
				return new NewState();

			} else if (stateType == 2) {
				return new ApprovingState();

			} else if (stateType == 3) {
				return new ApprovedState();

			} else if (stateType == 4) {
				return new FinishedState();
			} else {
				return new NewState();
			}
		}

	}

	public interface State {

		void execute();

	}

	public static class NewState implements State {

		@Override
		public void execute() {
			System.out.println("执行新建状态逻辑");
		}

	}

	public static class ApprovingState implements State {

		@Override
		public void execute() {
			System.out.println("执行待审批逻辑");
		}
	}

	public static class ApprovedState implements State {

		@Override
		public void execute() {
			System.out.println("执行已审批逻辑");
		}
	}

	public static class FinishedState implements State {

		@Override
		public void execute() {
			System.out.println("执行已完成逻辑");
		}
	}
}
