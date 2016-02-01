package com.epam.mentoring.module8.task6;

import java.util.LinkedList;
import java.util.Queue;

public class MTRunner {

	public class Message {
		String payload;

		public Message(String payload) {
			this.payload = payload;
		}
	}

	public class AsyncMessageBus {

		Queue<Message> queue = new LinkedList<>();

		public void add(Message integer) {
			synchronized (queue) {
				queue.add(integer);
			}
		}

		public void remove() {
			synchronized (queue) {
				queue.remove();
			}
		}

	}

	
}
