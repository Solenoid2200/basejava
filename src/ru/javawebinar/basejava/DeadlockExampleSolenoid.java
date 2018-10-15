package ru.javawebinar.basejava;

public class DeadlockExampleSolenoid {

    public static void main (String[] args) {
        final String resource1 = "resource1";
        final String resource2 = "resource2";
        newThreadCreate(resource1, resource2,
                "Thread 1: locked resource 1",
                "Thread 1: locked resource 2");
        newThreadCreate(resource2, resource1,
                "Thread 2: locked resource 2",
                "Thread 2: locked resource 1");
    }

    private static void newThreadCreate (String resource1, String resource2, String info1, String info2) {
        new Thread() {
            public void run () {
                synchronized (resource1) {
                    System.out.println(info1);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    synchronized (resource2) {
                        System.out.println(info2);
                    }
                }
            }
        }.start();
    }

}
