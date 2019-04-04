package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sea extends JPanel {//����

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int score;//����
	BufferedImage bg;//����ͼƬ
	Fish[] fishs;//������࣡�����࣡����ι��
	Net net;//�����ù���
	Fish becatchedfish;
	public Sea() throws IOException{//���캯��
		bg=ImageIO.read(new File("Fish/bg.jpg"));//����ͼƬʵ����
		score=0;//��������
		net =new Net();//��ʵ����
		fishs=new Fish[11];//fishs����[][]
		for(int i=0;i<fishs.length;i++){//�������������ִ������
			if(i<9) {
				fishs[i]=new Fish(i+1);
			}
			else{//ɳ��������ֻ���������ģ���ͼ�е㲻��ϸ
				fishs[i]=new Fish(i+4);
			}
		}
	}
	Fish one;
	public void catchFishWithNet() throws InterruptedException{//��ÿһ���㶼�����Ƚ�
		for(int i=0;i<fishs.length;i++){//�Ƚϵ���ÿһ���㣡����������11����
			one =fishs[i];
			if(net.catchFish(one)){//�ڷ�Χ��,�ص�����Ҳץ�ߣ���Ϊ��������ÿһ����
				//��󣬱�����ʾ��ץס
				
				one.outOfBonuds();//��Խ�紦��
				score=score+one.width/10;//��������
				
			}
		}
	}
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);//Image img, int x, int y,ImageObserver observerһ��Ϊnull���ϴ����ص�ʱ���õ�
		g.setColor(Color.WHITE);
		g.drawString("SCORE:"+score, 10, 10);
		for(int i=0;i<fishs.length;i++){
			Fish one1 =fishs[i];
			g.drawImage(one1.image, one1.x, one1.y, null);
		}
		if(net.show==true){
			g.drawImage(net.image, net.x-net.width/2,net.y-net.height/2 ,null);
		}
	}
	//������Ϸ��ʼ
	public void action() throws InterruptedException{
		MouseAdapter l = new MouseAdapter() {//�����ڲ���

			public void mousePressed(MouseEvent e) {
				try {
					catchFishWithNet();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				net.show=true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				net.show=false;
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				net.moveTo(x, y);//ʵʱλ��
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		for(int i=0;i<fishs.length;++i) {
			fishs[i].start();//����̳�thread���������߳�����
			//Thread����run()��start()�������������£�
			//run()����:�ڱ��߳��ڵ��ø�Runnable�����run()�����������ظ���ε��ã�//����ѭ��
			//start()����:����һ���̣߳����ø�Runnable�����run()���������ܶ������һ���̣߳�
			//start()�������´�����һ���߳�,��main����ִ�н�����,����start()�����������߳�û�����н���,
	        //������߳�δ���˳�,ֱ���߳�threadҲִ�����.����Ҫע��,Ĭ�ϴ������߳����û��߳�(���ػ��߳�)
		}
		while(true) {
			repaint();//��д����������������Ĺ켣
			Thread.sleep(100);//�߳����ߣ������ʾ֡�ı仯ʱ��
		}
	}

}
