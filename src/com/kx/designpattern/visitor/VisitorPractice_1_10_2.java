package com.kx.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式练习
 * @author kx
 * @date 2020/1/10 9:57
 */
public class VisitorPractice_1_10_2 {

	public static void main(String[] args) {
		Department son1 = new Department("子部门1");
		Department son2 = new Department("子部门2");
		Department son3 = new Department("子部门3");

		Department par1 = new Department("父部门1");
		Department par2 = new Department("父部门2");
		par1.getChildren().add(son1);
		par1.getChildren().add(son2);
		par2.getChildren().add(son3);

		Department big1 = new Department("大部门1");
		big1.getChildren().add(par1);
		big1.getChildren().add(par2);

		big1.accept(new RemoveVisitor());
		System.out.println();
		big1.accept(new UpdateVisitor());
	}

	public interface Visitor {
		void visit(Department department);
	}

	public static class RemoveVisitor implements Visitor {


		@Override
		public void visit(Department department) {
			if (department.getChildren().size() > 0) {
				for (Department child : department.getChildren()) {
					child.accept(this);
				}
			}
			// 自己要真正处理的事情
			System.out.println("删除了我自己: " + department.getName());
		}
	}

	public static class UpdateVisitor implements Visitor {


		@Override
		public void visit(Department department) {
			if (department.getChildren().size() > 0) {
				for (Department child : department.getChildren()) {
					child.accept(this);
				}
			}
			// 自己要真正处理的事情
			System.out.println("更新了我自己: " + department.getName());
		}
	}

	public static class Department {

		private String name;
		private List<Department> children = new ArrayList<>();

		public Department(String name) {
			this.name = name;
		}

		public void accept(Visitor visitor) {
			visitor.visit(this);
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
