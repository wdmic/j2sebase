package com;

public class TestSync implements Runnable {
	Timer timer = new Timer();

	public static void main(String[] args) {
		TestSync ts = new TestSync();
		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(ts);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		timer.add(Thread.currentThread().getName());
	}

}

class Timer {
	private static int num = 0;
	public synchronized void add(String name) {
//		synchronized (this) {
			num ++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println(name + "���ǵ�"+num+ "��ʹ��timer�̵߳�");
//		}
	}
}
