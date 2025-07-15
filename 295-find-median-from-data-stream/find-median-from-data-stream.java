class MedianFinder {
    public PriorityQueue<Integer> maxPeek;
    public PriorityQueue<Integer> minPeek;

    public MedianFinder() {
        this.maxPeek = new PriorityQueue<>();
        this.minPeek = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxPeek.isEmpty() && minPeek.isEmpty()){
            minPeek.add(num);
        }
        else if(num < minPeek.peek()){
            minPeek.add(num);
        }
        else{
            maxPeek.add(num);
        }
        if(minPeek.size() - maxPeek.size() > 1){
            maxPeek.add(minPeek.poll());
        }
        else if(maxPeek.size() - minPeek.size() > 1){
            minPeek.add(maxPeek.poll());
        }
    }
    
    public double findMedian() {
        if(minPeek.size() == maxPeek.size()){
            return ((double)minPeek.peek() + maxPeek.peek())/2;
        }
        else if(minPeek.size() > maxPeek.size()){
            return minPeek.peek();
        }
        return maxPeek.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */