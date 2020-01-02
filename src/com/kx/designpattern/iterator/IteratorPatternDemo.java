package com.kx.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 * @author kx
 * @date 2019/12/31 10:31
 */
public class IteratorPatternDemo {

	public static void main(String[] args) {

		Student studentA = new Student("A");
		Student studentB = new Student("B");

		Classroom classroom = new Classroom(2);
		classroom.addStudent(studentA);
		classroom.addStudent(studentB);

		java.util.Iterator<Student> iterator = classroom.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 自定义迭代接口
	 */
	public interface Iterator {
		/**
		 * 下一个对象存在
		 * @return true false
		 */
		boolean hasNext();

		/**
		 * 下一个对象
		 * @return object
		 */
		Object next();
	}

	/**
	 * 自定义集合类
	 */
	public interface Aggregate {
		java.util.Iterator<Student> iterator();
	}

	/**
	 * 学生类
	 */
	public static class Student {
		private String name;

		public Student(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "Student{" +
					"name='" + name + '\'' +
					'}';
		}
	}

	/**
	 * 教室类
	 */
	public static class Classroom implements Aggregate {

		private List<Student> students;

		private int last = 0;

		public Classroom(int size) {
			this.students = new ArrayList<>(2);
		}

		public Student getStudent(int index) {
			return students.get(index);
		}

		public void addStudent(Student student) {
			this.students.add(student);
			last++;
		}

		public int getLength() {
			return last;
		}

		@Override
		public java.util.Iterator<Student> iterator() {
			return students.iterator();
		}
	}

	/**
	 * 教师迭代器
	 */
	public static class ClassroomIterator implements Iterator {

		private Classroom classroom;
		private int index;

		public ClassroomIterator(Classroom classroom) {
			this.classroom = classroom;
			this.index = 0;
		}

		@Override
		public boolean hasNext() {
			return index < classroom.getLength();
		}

		@Override
		public Object next() {
			Student student = classroom.getStudent(index);
			index++;
			return student;
		}
	}
}
