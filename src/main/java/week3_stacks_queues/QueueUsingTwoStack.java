package week3_stacks_queues;

public class QueueUsingTwoStack {
    static class ResizingStack{
        Integer[] s = new Integer[1];
        int N = 0;
        public void resize(int capacity){
            Integer[] copy = new Integer[capacity];
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
        public void push(Integer item){
            if(N == s.length){
                resize(2*s.length);
            }
            s[N++] = item;
        }
        public Integer pop(){
            if(isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            Integer item = s[--N];
            s[N] = null;
            if(N > 0 && N == s.length/4){
                resize(s.length/2);
            }
            return item;
        }
        public Integer peek(){
            if(isEmpty()){
                throw new RuntimeException("Stack is empty");
            }
            return s[N-1];
        }
    }
    static class QueueTwoStack {
        private ResizingStack mainStack = new ResizingStack();
        private ResizingStack secondStack = new ResizingStack();

        public void enqueue(int item) {
            mainStack.push(item);
        }
        public int dequeue(){
            transfer();
            return secondStack.pop();
        }
        public int print(){
            transfer();
            return secondStack.peek();
        }
        public void transfer(){
            if(secondStack.isEmpty()){
                while(!mainStack.isEmpty()){
                    secondStack.push(mainStack.pop());
                }
            }
        }
    }

}
