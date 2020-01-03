package com.kx.designpattern.memento;

/**
 * 备忘录模式
 * @author kx
 * @date 2020/1/3 11:34
 */
public class MementoPatternDemo {

	public static void main(String[] args) {

		Originator originator = new Originator();

		// 准备中间数据
		originator.prepare();

		//将中间数据保存到备忘录中去
		Memento memento = originator.createMemento();

		//将备忘录保存到备忘录管理器中去
		Caretaker caretaker = new Caretaker();
		caretaker.saveMemento(memento);

		//基于中间数据执行了 A 方法,但是此时中间数据已经改变了
		originator.executeA();

		// 从备忘录管理器中获取备忘录
		memento = caretaker.retrieveMemento();

		// 将备忘录中保存好的中间数据重新设置到原发器中去,将中间数据恢复成之前备忘的状态
		originator.setMemento(memento);

		// 接着在执行方法B
		originator.executeB();





	}

	public interface Memento {

	}

	public static class Originator {

		private String state;

		public void prepare() {
			this.state = "中间数据";
		}

		public void executeA() {
			System.out.println("基于中间数据 [" + state + "] 执行了A方法的逻辑");
			// 将 state 所代表的中间数据做出了修改
			state += ",A方法的结果数据";
			System.out.println(state);
		}

		public void executeB() {
			System.out.println(state);
			System.out.println("基于中间数据 [" + state + "] 执行了B方法的逻辑");
			state += ",B方法的结果数据";

		}

		public Memento createMemento() {
//			return new M
			return new MementoImpl(state);
		}

		public void setMemento(Memento memento) {
			MementoImpl mementoImpl = (MementoImpl)memento;
			this.state = mementoImpl.getState();
		}

		private static class MementoImpl implements Memento {

			private String state;

			public MementoImpl(String state) {
				this.state = state;
			}

			public String getState() {
				return state;
			}
		}
	}

	public static class Caretaker {
		private Memento memento;

		public void saveMemento(Memento memento) {
			this.memento = memento;
		}

		public Memento retrieveMemento() {
			return this.memento;
		}
	}

}






















