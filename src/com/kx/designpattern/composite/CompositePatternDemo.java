package com.kx.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * @author kx
 * @date 2020/1/3 10:44
 */
public class CompositePatternDemo {

	public static void main(String[] args) {
		Department subdp1 = new Department("子1");
		Department subdp2 = new Department("子2");
		Department subdp3 = new Department("子3");

		Department dp1 = new Department("父1");
		dp1.getChildren().add(subdp1);
		dp1.getChildren().add(subdp2);

		Department dp2 = new Department("父2");
		dp2.getChildren().add(subdp3);

		Department parent = new Department("爷");
		parent.getChildren().add(dp1);
		parent.getChildren().add(dp2);

		// 现在删除
//		for (Department dp : parent.getChildren()) {
//			if (dp.getChildren().size() > 0) {
//				for (Department subdp : dp.getChildren()) {
//					subdp.remove();
//				}
//			}
//			dp.remove();
//		}
		parent.remove();
	}

	public static class Department {

		private String name;
		private List<Department> children = new ArrayList<>();

		public Department(String name) {
			this.name = name;
		}

		public void remove() {
			if (children.size() > 0) {
				for (Department child : children) {
					child.remove();
				}
			}
			System.out.println("删除部门 [ " + name + " ]");
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
