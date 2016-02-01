package com.epam.mentoring.module8.task7;

import java.util.concurrent.atomic.AtomicInteger;

import com.epam.mentoring.module8.task7.Task7Runner.Resource;

public class Task7Runner {

	private static int ITERATIONS = 1000;

	public static void main(String... args) {

		Resource resource = new Resource();

		Thread prod = new Thread(new Producer(resource));
		Thread cons = new Thread(new Consumer(resource));

		prod.start();

		cons.start();

	}

	static public class Resource {

		AtomicInteger counter = new AtomicInteger(10);

		public int get() {
			return counter.get();
		}

		public int increment() {
			return counter.incrementAndGet();
		}

		public int decrement() {
			return counter.decrementAndGet();
		}

		@Override
		public String toString() {
			return "[counter= " + counter.get() + "]";
		}
	}

	static class Producer implements Runnable {

		Resource resource;

		public Producer(Resource resource) {
			this.resource = resource;
		}

		@Override
		public void run() {

			for (int i = 0; i < ITERATIONS; i++) {
				increase();

				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

		public synchronized void increase() {

			while (resource.get() > 10) {
				try {
					notifyAll();
					System.out.println("waiting at Producer " + resource.get());
					wait();
				} catch (InterruptedException e) {
				}
			}
			int counter = resource.increment();
			System.out.println(Thread.currentThread().getName() + " Producer "
					+ counter);
		}
	}

	static class Consumer implements Runnable {

		Resource resource;

		public Consumer(Resource resource) {
			this.resource = resource;
		}

		@Override
		public void run() {
			for (int i = 0; i < ITERATIONS; i++) {
				decrease();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public synchronized void decrease() {

			while (resource.get() < 5) {
				try {
					notifyAll();
					System.out.println("waiting at Consumer " + resource.get());
					wait();
				} catch (InterruptedException e) {
				}
			}
			int counter = resource.decrement();
			System.out.println(Thread.currentThread().getName() + " Consumer "
					+ counter);
			
		}
	}

}