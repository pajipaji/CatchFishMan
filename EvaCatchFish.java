package com;

import java.io.IOException;
import javax.swing.JFrame;

public class EvaCatchFish {
	
	public EvaCatchFish() throws IOException, InterruptedException{
		//��������쳣������쳣һ�㷢�����̴߳����У���һ������ִ�е��̱߳��ж�ʱ�ͻ��������쳣
		JFrame win =new JFrame("������� ");//ʵ����һ������
		//win.setUndecorated(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�
		win.setSize(800, 500);//�����С
		win.setLocationRelativeTo(null);//����λ�þ��С����󡢿��ҡ����ϡ�����
		Sea sea =new Sea();//ʵ����һ�����
		win.add(sea);//�ڴ�����������
		win.setVisible(true);
		//�������ÿɼ������ú������𲻴󣬵�����ʾ�Ļ����漰��ˢ���ˣ����Ժ���ӵ����ֻ����ˢ��֮����ʾ����������ӵ���嶯��������ȥ������Ҫ��֮ǰˢ��
		sea.action();//��嶯��
	}

	public static void main(String[] args) throws IOException, InterruptedException{
		new EvaCatchFish();//ʵ����
	}

}

