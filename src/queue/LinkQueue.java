package queue;

public class LinkQueue implements Queue {
    private Node front;
    private Node rear;
    private int size;

    public LinkQueue() {
        this.front = (this.rear = new Node());
        this.size = 0;
    }

    public void clear() {
        this.front.next = null;
        this.rear = this.front;
        this.size = 0;
    }

    public Object deQueue() {
        if(this.isEmpty())return null;
        Node p = this.front.next;
        this.front.next = p.next;
        //this.rear = p.next;
        this.size -= 1;
        return p.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public Object peek() {
        return this.front.next.data;
    }

    public void push(Object e) {
        Node p = new Node(e);
        this.rear.next = p;
        this.rear = p;
        this.size += 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        Node p = this.front;
        while((p=p.next)!=null) {
            sb.append(p.data+" ");
        }
        sb.append("]");
        return sb.toString();
    }



}
