package queue;

public interface Queue {
    public void clear();

    public Object deQueue();

    public boolean isEmpty();

    public void push(Object paramObject);

    public int size();
}
