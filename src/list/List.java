package list;

public interface List<E> {
    public void add(Object paramObjet);

    public void clear();

    public Object get(int paramInt);

    public int indexOf(Object paramObject);

    public boolean isEmpty();

    public int lastIndexOf(Object paramObject);

    public void remove(int paramInt);

    public void set(int paramInt, Object paramObject);

    public int size();
}
