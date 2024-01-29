// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.
// Notes:

// You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

// Example 1:

// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]

// Explanation
// MyQueue myQueue = new MyQueue();
// myQueue.push(1); // queue is: [1]
// myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
// myQueue.peek(); // return 1
// myQueue.pop(); // return 1, queue is [2]
// myQueue.empty(); // return false
 

// Constraints:

// 1 <= x <= 9
// At most 100 calls will be made to push, pop, peek, and empty.
// All the calls to pop and peek are valid.
 

// Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

import java.util.* ; 

class MyQueue {
    Stack<Integer> stack1 ; 
    Stack<Integer> stack2 ; 
    int count ; 
    int top ; 
    public MyQueue() {
        stack1 = new Stack<>( ) ;
        stack2 = new Stack<>() ; 
        count = 0 ;  
    }
    
    public void push(int x) {
        if(count == 0 ){ 
            top = x ; 
        }
        stack1.push(x) ; 
        count++; 
    }
    
    public int pop() { // O(N)
        if(stack1.size()==1){
            count-- ; 
            return stack1.pop() ; 
        } 

        for(int i = 1 ; i< count ; i++){
            stack2.push(stack1.pop() )  ; 
        }
        int res = stack1.pop() ;
        this.top = stack2.peek() ; 
        //System.out.println(stack2.peek());
        count-- ;  
        for(int i=0 ; i < count ; i ++){
            stack1.push(stack2.pop()) ; 
        }
        //System.out.println(stack1) ; 

        return res ; 
    }
    
    public int peek() {
        return this.top ; 
    }
    
    public boolean empty() {    
        return (stack1.isEmpty())?true : false ; 
    }
}
