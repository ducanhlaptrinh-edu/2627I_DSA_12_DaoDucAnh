package week3_stacks_queues;

public class EqualStacks {
    static int equalStacks(int[] h1, int[] h2, int[] h3){
        int sumH1 = 0;
        int sumH2 = 0;
        int sumH3 = 0;
        for(int h : h1) sumH1 += h;
        for(int h : h2) sumH2 += h;
        for(int h : h3) sumH3 += h;
        int top1 = 0;
        int top2 = 0;
        int top3 = 0;
        while(!(sumH2 == sumH1 && sumH3 == sumH2)){
            if(sumH1 >= sumH2 && sumH1 >= sumH3){
                sumH1 -= h1[top1++];
            }else if(sumH2 >= sumH3 && sumH2 >= sumH1){
                sumH2 -= h2[top2++];
            }else if(sumH3 >= sumH1 && sumH3 >= sumH2){
                sumH3 -= h3[top3++];
            }
        }
        return sumH1;
    }

    public static void main(String[] args) {
        int[] h1 = {3, 2, 1, 1, 1};
        int[] h2 = {4, 3, 2};
        int[] h3 = {1, 1, 4, 1};

        int result = equalStacks(h1, h2, h3);
        System.out.println("Chiều cao tối đa để 3 chồng bằng nhau là: " + result);
        // the expected result : 5;
    }
}
