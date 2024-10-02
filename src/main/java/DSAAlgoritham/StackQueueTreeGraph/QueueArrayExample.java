package DSAAlgoritham.StackQueueTreeGraph;

public class QueueArrayExample {
    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.display();
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.enqueue(60);
        q.display();

        // Dequeue elements
        q.dequeue();
        q.dequeue();
        q.display();
        // Print front of the queue
        q.front();
    }
}

class Queue{
    int front, rear, capacity;
    int[] queue;

    public Queue(int c){
        front = 0;                  // will update when data is removed
        rear = -1;                  // wll update when data is pushed
        capacity = c;
        queue = new int[capacity];
    }

    public void enqueue(int data){
        if(rear == capacity-1){
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = data;
    }

    public void dequeue(){
        if(front > rear){
            System.out.println("Queue is empty");
            return;
        }
        // Shift all elements from index 1 till rear to the left by one
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        // Decrement rear
        rear--;
    }
    // Function to print queue elements
    void display() {
        if (front > rear) {
            System.out.println("Queue is Empty");
            return;
        }

        // Traverse front to rear and print elements
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " <-- ");
        }
        System.out.println();
    }

    // Function to print the front of the queue
    void front() {
        if (rear == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
    }
}
