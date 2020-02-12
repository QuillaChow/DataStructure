package queue;

public class Test {

    public static void main(String[] args) {
        LinkQueue array = new LinkQueue();
        array.push(1);
        array.push(3);
        array.push(6);
        System.out.println(array.toString());
        System.out.println(array.peek());
        System.out.println(array.deQueue());
        for(int i=3;i<20;i++){
            array.push(i);
        }
        System.out.println(array.toString());
        for(int i=0;i<15;i++){
            array.deQueue();
        }
        for(int i=6;i<10;i++){
            array.push(i);
        }
        System.out.println(array.toString());
        System.out.println(array.size());
    }

}
