package week3_stacks_queues;

import java.util.ArrayList;
import java.util.Scanner;

// the source code below are updated to fit with W is quite big (10^6), so with the assistance of AI, I had implemented successfully!
// I guarantee understand all the implementation and self-code by myself;
public class SimpleTextEditorUpgrade {
    static class ResizingStack{
        UndoAction[] s = new UndoAction[1];
        int N = 0;
        public void resize(int capacity){
            UndoAction[] copy = new UndoAction[capacity];
            for(int i = 0; i < N ; i++){
                copy[i] = s[i];
            }
            s = copy;
        }
        public boolean isEmpty(){
            return N == 0;
        }
        public int size(){
            return N ;
        }
        public void push(UndoAction item){
            if(N == s.length){
                resize(2*s.length);
            }
            s[N++] = item;
        }
        public UndoAction pop(){
            if(isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            UndoAction item = s[--N];
            s[N] = null;
            if(N > 0 && N == s.length/4){
                resize(s.length/2);
            }
            return item;
        }
    }
    static class UndoAction{
        private int type;
        private int lengthDelete;
        private String textRestore;
        UndoAction(int type, int lengthDelete){
            this.type = type;
            this.lengthDelete = lengthDelete;
        }
        UndoAction(int type, String textRestore){
            this.type = type;
            this.textRestore = textRestore;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()){
            int Q = input.nextInt();
            ResizingStack stack = new ResizingStack();
            StringBuilder currentText = new StringBuilder();
            java.util.List<Character> res = new ArrayList<Character>();
            for(int i = 0; i < Q ; i++){
                int currentType = input.nextInt();
                if(currentType == 1){
                    String item = input.next();
                    stack.push(new UndoAction(1, item.length()));
                    currentText.append(item);
                }else if(currentType == 2){
                    int k = input.nextInt();
                    String tmp = currentText.substring(currentText.length() - k, currentText.length());
                    stack.push(new UndoAction(2, tmp));
                    currentText.delete(currentText.length() - k, currentText.length());
                }else if(currentType == 3){
                    int k = input.nextInt();
                    res.add(currentText.charAt(k-1));
                }else{
                    UndoAction current = stack.pop();
                    if(current.type == 1){
                        int k = current.lengthDelete;
                        currentText.delete(currentText.length() - k, currentText.length());
                    }else if(current.type == 2){
                        String textRestore =  current.textRestore;
                        currentText.append(textRestore);
                    }
                }
            }
            for(char s : res){
                System.out.println(s);
            }
        }
        input.close();
    }
}
