package com.kx.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者练习
 * @author kx
 * @date 2020/1/11 9:17
 */
public class VisistorPractice_1_11_1 {

	public static void main(String[] args) {

	}

	public interface Visitor {

		void visit(Department department);

	}

	public static class RemoveVisitor implements Visitor {

		/**
		 * 访问者需要处理的事情
		 * @param department 被处理对象
		 */
		@Override
		public void visit(Department department) {
			// 判断对象是否还有子对象, 若有则再将自己(访问者)传给子对象(再访问其子对象)
			if (department.getChildren().size() > 0) {
				for (Department child : department.getChildren()) {
					// 再访问其子类
					child.accept(this);
				}
			}
			// 访问者 真正处理 正在被访问 的 对象
			// 比如说 删除这个对象, 或者给这个对象增加其他属性
			System.out.println("在 " + department.getName() + " 上加了一坨翔!");

		}
	}

	public static class Department {

		private String name;
		private List<Department> children = new ArrayList<>();

		/**
		 * 通过 visitor 访问自己子类
		 * @param visitor 访问者
		 */
		public void accept(Visitor visitor) {
			// 交给访问者处理
			visitor.visit(this);
		}

		public Department(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Department> getChildren() {
			return children;
		}

		public void setChildren(List<Department> children) {
			this.children = children;
		}
	}


}
