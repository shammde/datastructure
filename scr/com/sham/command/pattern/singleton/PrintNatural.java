package com.sham.command.pattern.singleton;

class PrintOdd implements Runnable {
    int count = -1;
    private Object common;

    PrintOdd(Object common) {
        this.common = common;
    }

    @Override
    public void run() {
        synchronized (common) {
            while (count < 11) {
                try {
                    common.notifyAll();
                    System.out.println(count += 2);
                    common.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}

class PrintEven implements Runnable {

    int count = 0;
    private Object common;

    PrintEven(Object common) {
        this.common = common;
    }

    @Override
    public void run() {
        synchronized (common) {
            while (count < 10) {
                try {
                    common.notifyAll();
                    System.out.println(count += 2);
                    common.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}

public class PrintNatural {
    public static void main(String args[]) {
        Object obj = new Object();
        Runnable r = new PrintOdd(obj);
        Thread printOdd = new Thread(r);

        Runnable r2 = new PrintEven(obj);
        Thread printEven = new Thread(r2);

        printOdd.start();
        printEven.start();

    }

}