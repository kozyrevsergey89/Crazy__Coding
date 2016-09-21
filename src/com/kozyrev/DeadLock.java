package com.kozyrev;

/**
 * Created by sergii on 9/14/16.
 */
public class DeadLock {

    public static void main(String[] args) {
        final Object object1 = new Object();
        final Object object2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    System.out.println("in thread1 aquired first obj");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("in thread1 waiting second object");
                    synchronized (object2) {
                        System.out.println("in thread1 aquired second obj");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object2) {
                    System.out.println("in thread2 aquired second obj");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("in thread2 waiting first obj");
                    synchronized (object1) {
                        System.out.println("in thread2 aquired first obj");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
