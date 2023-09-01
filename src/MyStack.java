public class MyStack<T> {
    T[] data;
    int top = -1;

    public MyStack() {
        data = (T[]) new Object[10];
    }

    public MyStack(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public void push(T e) {
        if (top + 1 >= data.length) {
            resize();
        }

        data[++top] = e;
    }

    public T pop() {
        if (top == -1) throw new ArrayIndexOutOfBoundsException("Empty Stack.");
        return data[top--];
    }

    public T peek(){
        if (top == -1) throw new ArrayIndexOutOfBoundsException("Empty Stack.");
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isExists(T target) {
        for (int i = 0; i< size(); i++) {
            if (data[i] == target) return true;
        }

        return false;
    }

    private void resize() {
        T[] temp = (T[]) new Object[data.length * 2];
        for (int i=0; i<data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
