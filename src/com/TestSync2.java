package com;

public class TestSync2 implements Runnable {
	
	int b = 100;
	
	public synchronized void m1() {
		System.out.println("m1");
		b = 1000;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("b:" + b);
	}
	
	public synchronized void m2() throws InterruptedException {
		System.out.println("m2");
		Thread.sleep(2500);
		b = 2000;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestSync2 ts2 = new TestSync2();
		Thread t = new Thread(ts2);
		t.start();
//		Thread.sleep(1000);
		ts2.m2();
		System.out.println(ts2.b);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		m1();
	}

}
