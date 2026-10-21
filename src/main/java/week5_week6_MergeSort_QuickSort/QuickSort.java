package week5_week6_MergeSort_QuickSort;

public class QuickSort {
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static int partition(Comparable[] a, int low, int high){
        int i = low;
        int j = high;
        Comparable v = a[low];
        while(true){
            while(less(a[++i],v)){
                if(i == high) break;
            }
            while(less(v,a[--j])){
                if(j == low) break;
            }
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,low,j);
        return j;
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    //find the k-th lowest element
    public static Comparable select(Comparable[] a, int k){
        //suffle;
        int lo = 0;
        int hi = a.length-1;
        while(hi > lo){
            int j = partition(a, lo, hi);
            if(j > k) hi = j-1;
            else if(j < k) lo = j+1;
            else return a[j];
        }
        return a[k];
    }
    public static void ThreeWayQS(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo; int gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0) exch(a, lt++, i++);
            else if(cmp > 0) exch(a, i, gt--);
            else i++;
        }
        ThreeWayQS(a, lo, lt-1);
        ThreeWayQS(a,gt+1, hi);
    }
}
