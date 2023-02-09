package com.dcpujar.concurrentcollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ArraySetProblem extends Thread{
	static CopyOnWriteArraySet<String> courses = new CopyOnWriteArraySet<String>();
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
		ArraySetProblem arrayListProblem = new ArraySetProblem();
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
