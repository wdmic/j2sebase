package com;


public class ProductorConsumer {

	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Productor productor = new Productor(ss);
		Consumer consumer = new Consumer(ss);
		new Thread(productor).start();
		new Thread(consumer).start();
		
	}

}

//馒头类
class Wotou{
	int id;
	public Wotou(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Wotou [id=" + id + "]";
	}
	
}

//装馒头的篮子，先进后出，相当于栈
class SyncStack{
	int index = 0;//记录馒头的下标
	Wotou[] wotous = new Wotou[6];
	
	//添加馒头方法
	public synchronized void put(Wotou wotou) {
		//如果装满了，需要wait，直到notify
		while (index == wotous.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		wotous[index] = wotou;
		index ++;
		System.out.println("生产了：" + wotou);
//		System.out.println(index);
	}
	
	//取出馒头
	public synchronized Wotou pop() {
		while (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
//		System.out.println(index);
		index --;
		System.out.println("消费了：" + wotous[index]);
		return wotous[index];
	}
}

//生产者
class Productor implements Runnable{
	
	SyncStack ss;
	public Productor(SyncStack ss) {
		this.ss = ss;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Wotou wotou = new Wotou(i);
			ss.put(wotou);
//			System.out.println("生产了：" + wotou);
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}

//消费者
class Consumer implements Runnable{
	
	SyncStack ss;
	public Consumer(SyncStack ss) {
		this.ss = ss;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Wotou wotou = ss.pop();
//			System.out.println("消费了：" + wotou);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
