package com.kx.designpattern.proxy;

/**
 * @author kx
 * @date 2020/1/2 17:14
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();

		Subject proxy = new Proxy(subject);
		proxy.request();

	}

	public interface Subject {

		void request();

	}

	public static class ConcreteSubject implements Subject {

		@Override
		public void request() {
			System.out.println("我执行完了...哈哈哈");
		}
	}

	public static class Proxy implements Subject {

		private Subject subject;

		public Proxy(Subject subject) {
			this.subject = subject;
		}

		@Override
		public void request() {
			System.out.println("代理了,然后我现在先加钱");
			boolean invoke = true;
			if (invoke) {
				subject.request();
			}
		}
	}


}
