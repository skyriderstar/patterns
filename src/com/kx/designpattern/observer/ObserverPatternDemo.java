package com.kx.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * @author kx
 * @date 2020/1/2 17:22
 */
public class ObserverPatternDemo {

	public static void main(String[] args) {
		Subject subject = new Subject(0);

		Observer observer = new ConcreteObserver();
		subject.addObserver(observer);

		subject.setState(1);
		subject.setState(2);
	}

	public static class Subject extends Observable {

		private Integer state;

		public Subject(Integer state) {
			this.state = state;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			// 在这里状态改变了
			this.state = state;
			this.setChanged();
			this.notifyObservers();
		}
	}

	public static class ConcreteObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			Subject subject = (Subject) o;
			Integer state = subject.getState();
			System.out.println("目标对象的状态变化成: " + state);
		}
	}



}
