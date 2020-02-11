package list;

public class Test {
    public static void main(String [] args){
        List list=new ArrayList();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        list.remove(9);
        System.out.println("size:"+list.size()+"\n");
        System.out.println("isEmpty:"+list.isEmpty());
        System.out.println("7:"+list.get(7)+"\n");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)+" ");
        }
        System.out.println("" + "\n");
        list.add(31);
        list.add(32);
        list.set(3,5);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)+" ");
        }

    }
}
