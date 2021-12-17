package com.dumas.pedestal.ms.multi.thread.concurrent.simple;

/**
 * @author dumas
 * @date 2021/12/16 5:42 PM
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread.run().");
    }
}

class ThreadTest{
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}


