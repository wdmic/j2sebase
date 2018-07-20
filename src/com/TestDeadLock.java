package com;

public class TestDeadLock implements Runnable {
	
	int flag = 1;
	//如果不是static修饰，那么在td11和tdl2中分别有o1和o2对象，所以不造成死锁
	static Object o1 = new Object(), o2 = new Object();

	public static void main(String[] args) {
		TestDeadLock tdl1 = new TestDeadLock();
		TestDeadLock tdl2 = new TestDeadLock();
		tdl1.flag = 0;
		tdl2.flag = 1;
		Thread t1 = new Thread(tdl1);
		Thread t2 = new Thread(tdl2);
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		System.out.println("flag:" + flag);
		if (flag == 0) {
			synchronized (o1) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				synchronized (o2) {
					System.out.println("0");
				}
			}
		}
		if (flag == 1) {
			synchronized (o2) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				synchronized (o1) {
					System.out.println("1");
				}
			}
		}
		
	}

}
