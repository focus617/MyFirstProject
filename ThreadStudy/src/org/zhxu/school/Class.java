package org.zhxu.school;

import java.util.ArrayList;

public class Class {
	protected Integer grade;
	protected Integer numOfClass;
	protected ArrayList<Student> studentList;
	protected int studentNum;

	/**
	 * Initial a new class without student
	 */
	public Class() {
		grade = 1;
		numOfClass = 1;
		studentList = new ArrayList<Student>();
		studentNum = 0;
	}

	/**
	 * @param studentList
	 */
	public Class(ArrayList<Student> studentList) {
		super();
		grade = 1;
		numOfClass = 1;
		this.studentList = studentList;
		this.studentNum = studentList.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Class [grade:" + grade + ", No." + numOfClass + ", studentNumber="
				+ studentNum + "]";
	}

	public void addNewStudent(Student st) {
		studentList.add(st);
		studentNum = studentList.size();
		System.out.println("New student: " + st.getName() + " is added.");
		System.out.println(st);
		System.out.println("This class has "+ studentNum + " students now.\n");
	}

	public void deleteStudent(Student st) {
		studentList.remove(st);
		studentNum = studentList.size();
		System.out.println("The student: " + st.getName() + " is removed.");
		System.out.println("This class has "+ studentNum + " students now.\n");
	}
	
	public void printNameList() {
		int i=1;
		
		System.out.println(this);
		System.out.println("\nStudent Name List:");
		
		System.out.println("#\tName\tAge\tAddress");

		for (Student s : studentList) {
			System.out.println(i + "\t"+ s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
			i++;
		}
		System.out.println();

	}

}
