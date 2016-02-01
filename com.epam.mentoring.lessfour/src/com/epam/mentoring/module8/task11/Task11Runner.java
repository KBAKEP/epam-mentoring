package com.epam.mentoring.module8.task11;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task11Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Collection<Integer> collection = new CopyOnWriteArrayList<>();
//		Collection<Integer> collection = new LinkedList<>();
		Thread thread1 = new Thread(new Thread1(collection));
		thread1.start();
		Thread thread2 = new Thread(new Thread2(collection));
		Thread thread3 = new Thread(new Thread3(collection));
		thread2.start();
		thread3.start();
	}

	static class Thread1 implements Runnable {

		Collection<Integer> collection;

		public Thread1(Collection<Integer> collection) {
			this.collection = collection;
		}

		@Override
		public void run() {
			while (true) {
				int number = new Random().nextInt(100);
//				System.out.println(number);
				collection.add(number);
			}
		}

	}

	static class Thread2 implements Runnable {

		Collection<Integer> collection;

		public Thread2(Collection<Integer> collection) {
			this.collection = collection;
		}

		@Override
		public void run() {

			while (true) {
				System.out.println("SUM=" + sum());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private int sum() {
			int sum = 0;

			for (Iterator<Integer> iterator = collection.iterator(); iterator
					.hasNext();) {
				Integer num = iterator.next();
				sum += num;
			}
			return sum;
		}
	}

	static class Thread3 implements Runnable {

		Collection<Integer> collection;

		public Thread3(Collection<Integer> collection) {
			this.collection = collection;
		}

		@Override
		public void run() {
			NumberFormat formatter = new DecimalFormat("#0.00");

			while (true) {
				System.out.println("SQUARE=" + formatter.format(sqrt()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private double sqrt() {
			Integer sum = 0;

			for (Iterator<Integer> iterator = collection.iterator(); iterator
					.hasNext();) {
				Integer num = iterator.next();
				sum += num * num;
			}
			return Math.sqrt(sum.doubleValue());
		}

	}
}
