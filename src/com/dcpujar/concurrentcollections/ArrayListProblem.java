package com.dcpujar.concurrentcollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListProblem extends Thread{
	static CopyOnWriteArrayList<String> courses = new CopyOnWriteArrayList<String>();
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		courses.add("Kubernates");
	}

	public static void main(String[] args) throws InterruptedException {
//		ArrayList<String> courses = new ArrayList<String>();
		ArrayListProblem arrayListProblem = new ArrayListProblem();
		arrayListProblem.start();
		
		courses.add("Java");
		courses.add("Python");
		courses.add("AWS");
		courses.add("Docker");

		Iterator<String> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Thread.sleep(2000);
			String course = iterator.next();
			System.out.println(course);
			if (course.equals("Docker")) {
				courses.remove("Docker");
			}
			

		}
//		courses.add("Node");
		System.out.println(courses);

	}

}
