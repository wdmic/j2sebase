package com;

import java.util.Date;

public class TestInterrupt {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		try {
			Thread.sleep(10000);//���ĸ��߳��У�����sleep���ĸ��߳�˯
		}catch (InterruptedException e){
		}
		//thread.interrupt(); //˭����˭����ϡ�������˯�ŵ�ʱ���Ұ����ϡ�10��������̲߳������ˣ�һ����ˮ�ù�ȥ�����̵߳�sleep����
							//��InterruptedException �쳣
//		thread.flag = false;  //�����������߳�ֹͣ�ˣ���ס�����ײ�Ҫ��������ˮ(interrupt())����Ϊ����catch�����а��Լ���ҵ��д��ȥ
								//Ҳ��һ�ֲ��õı�̷�ʽ�����ǿ����ã����ٱ�stop() ǿ.stop()̫�ֱ��ˣ����ײ�Ҫ�á�
		//thread.stop();	//��סҲ��Ҫ����Thread �� stop()����ȥ�����߳�ֹͣ����Ϊstop��interrupt ���ֱ���ǰ������һ����ˮ��
							//stop��һ�����Ӵ��Դ��ϣ�������������Ϊinterrupt()���뻹�и�catch���飬�и����Ҵ򿪵���Դ�رյĻ��ᣬ��stop������߳���Ҳû����ִ���ˣ�
	}
 
}
class MyThread extends Thread{ //
	boolean flag = true;  //
	public void run(){//��������throws InterruptedException ��Ϊ����run()����д�ķ�������д�ķ��������׳��뱻��д������ͬ���쳣
		while (flag) { //��������дthrows ���У�ֻ��дtry catch 
			System.out.println("==="+new Date()+"===");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return; //return ���߳̽������������߳�һִ�� thread.interrupt()�������߳̽�����������ֻ����ʾinterrupt���������ϲ���
						//�����߳̽�����õķ�������Ϊ�����interrupt��ʽ̫�ֱ��ˣ���catch ��һ��exception����һ�˼Ҵ�һ����Դ��û���ü��أ���ô��
						//����������߳�while(true)�ģ��������߳�ֹͣ����ô�죿�����ֱ�Ӷ���һ��flag ��������true����������ֹͣ��
						//ֱ����main �߳���thread.flag ����false �Ϳ��ԡ�����run()�����ͽ����ˣ�run()����һ�������߳̾ͽ���������һ���򵥵Ŀ��ư취
			}
		}
	}
}