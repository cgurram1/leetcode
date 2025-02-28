class Bank {
    private long [] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 >= 1 && account1 <= this.balance.length && account2 >= 1 && account2 <= this.balance.length && money <= this.balance[account1-1]){
            this.balance[account1-1]-=money;
            this.balance[account2-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account >= 1 && account <= this.balance.length){
            this.balance[account-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(account >= 1 && account <= this.balance.length && this.balance[account-1] >= money){
            this.balance[account-1]-=money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */