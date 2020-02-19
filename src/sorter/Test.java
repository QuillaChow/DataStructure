package sorter;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = scan.nextInt();
        }
        Sorter sort = new Sorter();
        Integer[] b = sort.intToInteger(array);
        int[] shell = {5, 2, 1};
        sort.mergeSort(b, 0, n-1);
        for (int i = 0; i < b.length; ++i)
            System.out.print(b[i] + "  ");
    }

}
