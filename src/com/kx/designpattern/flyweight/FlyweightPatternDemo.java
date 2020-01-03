package com.kx.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * @author kx
 * @date 2020/1/3 12:54
 */
public class FlyweightPatternDemo {

	public static void main(String[] args) {

		Flyweight flyweight1 = FlyweightFactory.get("1");
		flyweight1.execute();

	}

	public interface Flyweight {
		void execute();
		String getName();
		void setName(String name);
	}

	public static class ConcreteFlyweight implements Flyweight {
		private String name;

		public ConcreteFlyweight(String name) {
			this.name = name;
		}

		@Override
		public void execute() {
			System.out.println(name + "执行功能逻辑");
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}
	}

	public static class FlyweightFactory {
		private static Map<String, Flyweight> cachePool = new HashMap<>();

		public static Flyweight get(String name) {
			Flyweight flyweight = cachePool.get(name);
			if (flyweight == null) {
				flyweight = new ConcreteFlyweight(name);
				cachePool.put(name, flyweight);
			}
			return flyweight;
		}
	}

}
