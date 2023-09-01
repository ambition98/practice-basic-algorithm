package leetcode;

class MinStack {
    private class Stack {
        Node top;

        public void push(int val) {
            Node newNode = new Node(val);
            if (top == null) {
                newNode.min = val;
            } else {
                newNode.min = Math.min(top.min, val);
                newNode.next = top;
            }
            top = newNode;
        }

        public void pop() {
            top = top.next;
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.min;
        }

        private class Node {
            int val;
            int min;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }
    }
}

