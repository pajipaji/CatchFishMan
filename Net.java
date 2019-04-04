package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Net {//��
	int x;
	int y;
	int width;
	int height;
	BufferedImage image;//ͼƬ����
	boolean show;//������ �Ƿ���ʾ�������ķ���
	public Net() throws IOException{//���캯��
		image =ImageIO.read(new File("Fish/net09.png"));
		show =true;
		x=0;
		y=0;//��ʼ������λ��
		width=image.getWidth();//��ȡͼƬ�Ŀ�Ⱥ͸߶�
		height=image.getHeight();
	}
	public void moveTo(int a,int b){//����ʱʵλ��
		x=a;
		y=b;
	}
	public boolean catchFish(Fish fish){
		//��֪�������ꡢ���Ŀ�ȡ�������ꡢ��Ŀ�ȣ����������ĵ�����ķ�Χ�ڣ���ץס ���ڿ��Լ�������������Ѷ�
		int dx =x-fish.x;
		int dy =y-fish.y;
		Random random =new Random();
		int n =random.nextInt(20);//����ץ���Ѷ�
		//int n=1;
		return (n<2) &&(dx>=0 && dx<fish.width && dy>=0&& dy<fish.height);
		//n�����Ѷȣ�dx��dy��ʾ�������ĵ���������֮��Ĳ�ֵ
	}
}
