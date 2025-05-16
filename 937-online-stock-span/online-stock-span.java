class StockSpanner {
    public List<Integer> spans;
    public StockSpanner() {
        this.spans = new ArrayList<>();
    }
    
    public int next(int price) {
        int count = 1;
        for(int i = this.spans.size()-1;i>=0;i--){
            if(this.spans.get(i) <= price){
                count+=1;
            }
            else{
                break;
            }
        }
        this.spans.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */