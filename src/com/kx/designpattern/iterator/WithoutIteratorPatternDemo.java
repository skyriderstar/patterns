package com.kx.designpattern.iterator;

import java.util.HashMap;
import java.util.Map;

/**
 * 不使用迭代器模式, 代码修改过多
 * @author kx
 * @date 2019/12/31 10:10
 */
public class WithoutIteratorPatternDemo {

	public static void main(String[] args) {

		Student studentA = new Student("A");
		Student studentB = new Student("B");

//		Student[] students = new Student[]{studentA, studentB};

		Map<String, Student> students = new HashMap<>();
		students.put("A", studentA);
		students.put("B", studentB);



		Classroom classroom = new Classroom();
		classroom.setStudents(students);

//		Student[] resultStudents = classroom.getStudents();
//		for (Student student : resultStudents) {
//			System.out.println(student);
//		}

		Map<String, Student> resultStudents = classroom.getStudents();
		for (Student resultStudent : resultStudents.values()) {
			System.out.println(resultStudent);
		}

	}

	/**
	 * 学生类
	 */
	public static class Student {

		private String name;

		public Student(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student{" +
					"name='" + name + '\'' +
					'}';
		}
	}

//	/**
//	 * 教室类
//	 */
//	public static class Classroom {
//
//		private Student[] students;
//
//		public Student[] getStudents() {
//			return students;
//		}
//
//		public void setStudents(Student[] students) {
//			this.students = students;
//		}
//	}

	/**
	 * 教室类
	 */
	public static class Classroom {

		private Map<String, Student> students;

		public Map<String, Student> getStudents() {
			return students;
		}

		public void setStudents(Map<String, Student> students) {
			this.students = students;
		}
	}



}
