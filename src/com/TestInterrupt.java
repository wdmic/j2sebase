package com;

import java.util.Date;

public class TestInterrupt {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		try {
			Thread.sleep(10000);//在哪个线程中，调用sleep，哪个线程睡
		}catch (InterruptedException e){
		}
		//thread.interrupt(); //谁调用谁被打断。叫做你睡着的时候，我把你打断。10秒过后，主线程不高兴了，一盆凉水泼过去，子线程的sleep函数
							//抛InterruptedException 异常
//		thread.flag = false;  //这样就让子线程停止了，记住，轻易不要给人泼凉水(interrupt())，因为你在catch语句块中把自己的业务写进去
								//也是一种不好的编程方式。但是可以用，至少比stop() 强.stop()太粗暴了，轻易不要用。
		//thread.stop();	//记住也不要调用Thread 的 stop()方法去让子线程停止，因为stop比interrupt 还粗暴。前者是泼一盆凉水，
							//stop是一根棒子打脑袋上，立刻死掉。因为interrupt()起码还有个catch语句块，有个把我打开的资源关闭的机会，你stop是这个线程再也没机会执行了，
	}
 
}
class MyThread extends Thread{ //
	boolean flag = true;  //
	public void run(){//不能在这throws InterruptedException 因为这里run()是重写的方法，重写的方法不能抛出与被重写方法不同的异常
		while (flag) { //所以这里写throws 不行，只能写try catch 
			System.out.println("==="+new Date()+"===");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return; //return 则线程结束。所以主线程一执行 thread.interrupt()，则子线程结束。但是这只是演示interrupt方法，以上不是
						//让子线程结束最好的方法。因为你这个interrupt方式太粗暴了，你catch 了一个exception，万一人家打开一个资源，没来得及关，怎么办
						//如果这种子线程while(true)的，想让子线程停止，怎么办？如程序，直接定义一个flag 变量等于true，你想让他停止，
						//直接在main 线程中thread.flag 等于false 就可以。这样run()方法就结束了，run()方法一结束，线程就结束。这是一个简单的控制办法
			}
		}
	}
}