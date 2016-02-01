package com.epam.mentoring.module8.task6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MTRunner {

	private static int ITERATIONS = 10;
	
	public static void main(String... args) {
		Queue<Message> queue = new LinkedList<>();
		AsyncMessageBus asyncMessageBus = new AsyncMessageBus(queue);
		
		for (int i = 0; i < 10; i++) {
			Thread prod = new Thread(new Producer(asyncMessageBus));
			Thread cons = new Thread(new Consumer(asyncMessageBus));
			
			prod.start();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cons.start();
		}
		
		
	
	}

	static public class Message {
		String payload;

		public Message(String payload) {
			this.payload = payload;
		}

		@Override
		public String toString() {
			return "Message [payload= " + payload + "]";
		}
	}

	static public class AsyncMessageBus {

		Queue<Message> queue;

		public AsyncMessageBus(Queue<Message> queue2) {
			queue = queue2;
		}

		public void add(Message integer) {
			synchronized (queue) {
				queue.add(integer);
			}
		}

		public Message remove() {
			synchronized (queue) {
				return queue.remove();
			}
		}

	}

	static class Producer implements Runnable {

		AsyncMessageBus messageBus;

		public Producer(AsyncMessageBus bus) {
			messageBus = bus;
		}

		@Override
		public void run() {
			for (int i = 0; i < ITERATIONS; i++) {
				String payload = "i=" + (new Random().nextInt(990) + 10);
				Message message = new Message(payload);
				messageBus.add(message);

				System.out.println(Thread.currentThread().getName() + " Producer " + message);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static class Consumer implements Runnable {

		AsyncMessageBus messageBus;

		public Consumer(AsyncMessageBus bus) {
			messageBus = bus;
		}

		@Override
		public void run() {
			for (int i = 0; i < ITERATIONS; i++) {
				System.out.println(Thread.currentThread().getName() + " Consumer " + messageBus.remove());
			
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
