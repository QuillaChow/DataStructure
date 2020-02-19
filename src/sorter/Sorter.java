package sorter;

import common.Strategy;

import javax.naming.PartialResultException;

public class Sorter implements Strategy {

    public void insertSort(Object[] r, int low, int high) {
        for (int i = low + 1; i <= high; ++i) {
            if (compare(r[i], r[i - 1]) < 0) {
                Object temp = r[i];
                r[i] = r[i - 1];
                int j = i - 2;
                for (; (j >= low) && (compare(temp , r[j]) < 0); --j) {
                    r[j + 1] = r[j];
                }
                r[j + 1] = temp;
            }
        }
    }

    public void binInsetSort(Object[] r, int low, int high) {
        for (int i = low + 1; i <= high; ++i) {
            Object temp = r[i];
            int hi = i - 1;
            int lo = low;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (compare(temp, r[mid]) < 0)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            for (int j = i - 1; j > hi; ) {
                r[j + 1] = r[j];
                --j;
            }
            r[hi + 1] = temp;
        }
    }

    // 希尔排序
    public void shellSort(Object[] r, int low, int high, int[] delta) {
        for (int k = 0; k < delta.length; ++k)
            shellInsert(r, low, high, delta[k]);
    }

    private void shellInsert(Object[] r, int low, int high, int deltaK) {
        for (int i = low + deltaK; i <= high; ++i) {
            if(compare(r[i], r[( i - deltaK)]) < 0) {
                Object temp = r[i];
                int j = i - deltaK;
                for (; (j >= low) && (compare(temp, r[j]) < 0); j -= deltaK) {
                    r[j + deltaK] = r[j];
                }
                r[j + deltaK] = temp;
            }
        }
    }

    public void bubbleSort(Object[] r, int low, int high) {
        int n = high - low + 1;
        for (int i = 1; i < n; ++i) {
            for (int j = low; j <= high - i; ++j) {
                if (compare(r[j], r[j + 1]) > 0) {
                    Object temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(Object[] r, int low, int high) {
        if(low < high) {
            int pa = partition(r, low, high);
            quickSort(r, low, pa - 1);
            quickSort(r, pa + 1, high);
        }
    }

    private int partition(Object[] r, int low, int high) {
        Object pivot = r[low];
        while (low < high) {
            while ((low < high) && (compare(r[high], pivot) >= 0))
                --high;
            r[low] = r[high];
            while ((low < high) && (compare(r[low], pivot) <= 0))
                ++low;
            r[high] = r[low];
        }
        r[low] = pivot;
        return low;
    }

    public void selectSort(Object[] r, int low, int high) {
        for (int i = low; i < high; ++i) {
            int min = i;
            for (int j = i + 1; j <= high; ++j) {
                if (compare(r[j], r[min]) < 0) min = j;
            }
            if (min != i) {
                Object temp = r[min];
                r[min] = r[i];
                r[i] = temp;
            }
        }
    }

    public void heapSort(Object[] r) {
        for (int i = r.length / 2 - 1; i >= 0; --i) {
            heapAdjust(r, i ,r.length);
        }
        for (int j = r.length - 1; j > 0; --j) {
            Object temp = r[0];
            r[0] = r[j];
            r[j] = temp;
            heapAdjust(r, 0 , j);
        }
    }

    private void heapAdjust(Object[] r, int i, int length) {
        Object temp = r[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && compare(r[k], r[k + 1]) < 0) {
                k++;
            }
            if (compare(r[k], temp) > 0) {
                r[i] = r[k];
                r[k] = temp;
                i = k;
            }
            else {
                break;
            }
        }
    }

    public void mergeSort(Object[] r, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(r, low, mid);
            mergeSort(r, mid + 1, high);
            merge(r, low, mid, high);
        }
    }

    private void merge(Object[] a, int low, int mid, int high) {
        int n = high - low + 1;
        Object[] b = new Object[n];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (compare(a[i], a[j]) < 0) {
                b[k++] = a[i++];
            }
            else {
                b[k++] = a[j++];
            }
        }
        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= high) {
            b[k++] = a[j++];
        }
        for (int s = 0; s < b.length; ++s) {
            a[s + low] = b[s];
        }
    }

    public Integer[] intToInteger(int[] a) {
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; ++i)
            b[i] = Integer.valueOf(a[i]);

        return b;
    }

    public boolean equal(Object obj1, Object obj2) {
        return obj1 == obj2;
    }

    public int compare(Object obj1, Object obj2) {
        Integer a = (Integer) obj1;
        Integer b = (Integer) obj2;
        if (a.compareTo(b) < 0) return -1;
        if (a.compareTo(b) == 0) return 0;
        return 1;
    }
}
