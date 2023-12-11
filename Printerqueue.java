package Printerqueue;

public class printer {

	 public static void main(String[] args) {
	        PrintQueueSystem system = new PrintQueueSystem();

	        
	        system.enqueue(new PrintTask("hello"));
	        system.enqueue(new PrintTask("you"));
	        system.enqueue(new PrintTask("!"));
	        
	        system.dequeue();
	        
	        while (!system.isEmpty()) {
	            PrintTask task = system.dequeue();
	            System.out.println("Printing: " + task.document);
	        }
	    }
	}

	class PrintTask {
	    String document;

	    PrintTask(String document) {
	        this.document = document;
	    }
	}

	class PrintQueueSystem {
	    private PrintTask[] queue;
	    private int head, tail, size;

	    PrintQueueSystem() {
	        size = 10; 
	        queue = new PrintTask[size];
	        head = tail = -1;
	    }

	    void enqueue(PrintTask task) {
	        if (tail >= size - 1) {
	            System.out.println("Queue is full");
	            return;
	        }
	        if (isEmpty()) {
	            head = tail = 0;
	        } else {
	            tail++;
	        }
	        queue[tail] = task;
	    }


	    PrintTask dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty");
	            return null;
	        }
	        PrintTask task = queue[head];
	        if (head == tail) {
	            head = tail = -1;
	        } else {
	            head++;
	        }
	        return task;
	    }

	   
	    boolean isEmpty() {
	        return head == -1;
	    }
	}


