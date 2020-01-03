package com.kx.designpattern.command;

/**
 * 命令模式
 * @author kx
 * @date 2020/1/2 17:58
 */
public class CommandPatternDemo {

	public static void main(String[] args) {

	}

	public interface Command {

		void execute();
	}

	public static class CommandA implements Command {


		@Override
		public void execute() {
			System.out.println("命令A执行");
		}
	}

	public static class CommandB implements Command {


		@Override
		public void execute() {
			System.out.println("命令B执行");
		}
	}

	public static class Invoker {
		private Command command;

		public Command getCommand() {
			return command;
		}

		public void setCommand(Command command) {
			this.command = command;
		}

		public void execute() {
			System.out.println("别的A逻辑");
			command.execute();
			System.out.println("别的B逻辑");
		}
	}

}
