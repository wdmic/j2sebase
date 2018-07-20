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

//��ͷ��
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

//װ��ͷ�����ӣ��Ƚ�������൱��ջ
class SyncStack{
	int index = 0;//��¼��ͷ���±�
	Wotou[] wotous = new Wotou[6];
	
	//�����ͷ����
	public synchronized void put(Wotou wotou) {
		//���װ���ˣ���Ҫwait��ֱ��notify
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
		System.out.println("�����ˣ�" + wotou);
//		System.out.println(index);
	}
	
	//ȡ����ͷ
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
		System.out.println("�����ˣ�" + wotous[index]);
		return wotous[index];
	}
}

//������
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
//			System.out.println("�����ˣ�" + wotou);
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}

//������
class Consumer implements Runnable{
	
	SyncStack ss;
	public Consumer(SyncStack ss) {
		this.ss = ss;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Wotou wotou = ss.pop();
//			System.out.println("�����ˣ�" + wotou);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
