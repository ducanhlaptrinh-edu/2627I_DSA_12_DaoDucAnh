package week5_week6_MergeSort_QuickSort;


public class MergeSort {
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo; int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if(i > mid) aux[k] = a[j++];
            else if(j > hi) aux[k] = a[i++];
            else if(less(a[i], a[j])) aux[k] = a[i++];
            else aux[k] = a[j++];
        }
    }
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        int CUTOFF = 10;
        if(hi <= lo) return ;
        int mid = lo + (hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        if(!less(a[mid+1], a[mid])) return;
        merge(a,aux,lo,mid,hi);
    }
    public static void sortBottomUp(Comparable[]a){
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for(int sz = 1; sz < N; sz = sz + sz){
            for(int lo = 0; lo < N-sz; lo = sz+sz){
                merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }
}
