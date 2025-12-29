class MyCircularQueue {
    int[] arr;
    int count, k;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        count = 0;
        this.k = k;
        arr = new int[k]; 
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            if(rear == k) rear=0;
            arr[rear] = value;
            rear++;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front++;
        count--;
        if(front == k) front = 0;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return arr[rear-1];
    }
    
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(count == k) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
