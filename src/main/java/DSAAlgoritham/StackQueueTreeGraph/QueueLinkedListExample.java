package DSAAlgoritham.StackQueueTreeGraph;

public class QueueLinkedListExample {

    public static void main(String[] args) {


        int[] intArr = new int[5];
        System.out.println(intArr.length);

        intArr[0] = 1;
        intArr[1] = 2;
        intArr[2] = 3;
        intArr[3] = 4;
        intArr[4] = 5;

        System.out.println(intArr.length);
    }
}

class QueueLinkedList {

    QNode qNode;
    int front;
    int rear;

    public QueueLinkedList() {
        qNode = null;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }
    public void enqueue(int value) {
        QNode node = new QNode(value);
        node.setData(value);

        if(rear == -1){
        node.next = qNode;
        }



    }

    /*public int dequeue() {}

    public int front() {}
    public int rear() {}
    public void print() {}
    */

}

class QNode {
    int data;
    QNode next;

    QNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public QNode getNext() {
        return next;
    }

    public void setNext(QNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "QNode{" +
                "data=" + data +
                '}';
    }
}
