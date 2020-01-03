package com.kx.designpattern.singleton;

/**
 * @author kx
 * @date 2020/1/3 9:03
 */
public class SingletonPractice1_3 {

	public static class UnSaveFullSingleton {
		private static UnSaveFullSingleton instance;

		private UnSaveFullSingleton() {
		}

		public static UnSaveFullSingleton getInstance() {
			if (instance == null) {
				instance = new UnSaveFullSingleton();
			}
			return instance;
		}
	}

	public static class DoubleCheckLockFullSingleton {

		private volatile static DoubleCheckLockFullSingleton instance;

		private DoubleCheckLockFullSingleton() {
		}

		public static DoubleCheckLockFullSingleton getInstance() {
			if (instance == null) {
				synchronized (DoubleCheckLockFullSingleton.class) {
					if (instance == null) {
						instance = new DoubleCheckLockFullSingleton();
					}
				}
			}
			return instance;
		}
	}

	public static class HeavyFullSingleton {

		private static HeavyFullSingleton instance;

		private HeavyFullSingleton() {
		}

		public static HeavyFullSingleton getInstance() {
			synchronized (HeavyFullSingleton.class) {
				if (instance == null) {
					instance = new HeavyFullSingleton();
				}
			}
			return instance;
		}
	}

	public static class InnerClassFullSingleton {

		private InnerClassFullSingleton() {
		}

		public static class InnerHolder {
			public static final InnerClassFullSingleton instance = new InnerClassFullSingleton();
		}

		public static InnerClassFullSingleton getInstance() {
			return InnerHolder.instance;
		}
	}

	public static class HungrySingleton {
		private static final HungrySingleton instance = new HungrySingleton();

		private HungrySingleton() {
		}

		public static HungrySingleton getInstance() {
			return instance;
		}
	}

}
