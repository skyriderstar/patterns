package com.kx.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式刻意练习 01/06
 * @author kx
 * @date 2020/1/6 9:59
 */
public class VisitorPractice_1_6_1 {

	public static void main(String[] args) {
		Department l1 = new Department("l1");
		Department l2 = new Department("l2");
		Department l3 = new Department("l3");

		Department s1 = new Department("s1");
		s1.getChildren().add(l1);
		s1.getChildren().add(l2);

		Department s2 = new Department("s2");
		s2.getChildren().add(l3);

		Department p = new Department("p");
		p.getChildren().add(s1);
		p.getChildren().add(s2);

		Visitor removeVisitor = new RemoveVisitor();
		p.accept(removeVisitor);

		Visitor updateStatusVisitor = new UpdateStatusVisitor("禁用");
		p.accept(updateStatusVisitor);
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
			System.out.println("删除部门 [" + department.getName() + "]");
		}
	}

	public static class UpdateStatusVisitor implements Visitor {

		private String status;

		public UpdateStatusVisitor(String status) {
			this.status = status;
		}

		@Override
		public void visit(Department department) {
			if (department.getChildren().size() > 0) {
				for (Department child : department.getChildren()) {
					child.accept(this);
				}
			}
			System.out.println("将部门 [" + department.getName() + "] 的状态修改为:" + status);
		}

	}

}
