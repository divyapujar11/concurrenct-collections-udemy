package com.dcpujar.concurrentcollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentHashMapDemo extends Thread{
	static ConcurrentHashMap<String,String> courses = new ConcurrentHashMap<String,String>();
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		courses.put("Kubernates","4.8");
	}

	public static void main(String[] args) throws InterruptedException {
//		ArrayList<String> courses = new ArrayList<String>();
		ConcurrentHashMapDemo arrayListProblem = new ConcurrentHashMapDemo();
		arrayListProblem.start();
		
		courses.put("Java","5.0");
		courses.put("Python","4.7");
		courses.put("AWS","4.8");
		courses.put("Docker","4.5");

		Iterator<String> iterator = courses.keySet().iterator();
		while (iterator.hasNext()) {
			Thread.sleep(2000);
			String course = iterator.next();
			System.out.println(courses.get(course));
			if (course.equals("Docker")) {
				courses.remove("Docker");
			}
			

		}
//		courses.add("Node");
		System.out.println(courses);

	}

}
