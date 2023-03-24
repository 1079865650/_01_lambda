package com.thread;


class Account{
    private String actno;
    private double balance;
//    public Account(String s, double v){
//    }


    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withdraw(double money){
        synchronized (this){
            double before = this.getBalance();
            double after = before - money;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }
}

class AccountThread extends Thread{
    private Account act;
    public AccountThread(Account act){
        this.act = act;
    }
    public void run(){
        double money = 5000;
        act.withdraw(money);
        System.out.println(Thread.currentThread().getName() + "对" + act.getActno() + "取锁" + money + "成功, 余额" + act.getBalance());
    }
}



public class Test {
    public static void main(String[] args) {
        Account act = new Account("act-001", 1000);  // 刚才的满参构造器没有 this. 所以 balance为空
        AccountThread t1 = new AccountThread(act);
        AccountThread t2 = new AccountThread(act);

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

    }
}
