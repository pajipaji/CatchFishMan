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
	BufferedImage image;
	boolean show;//������ �Ƿ���ʾ�������ķ���
	public Net() throws IOException{
		image =ImageIO.read(new File("Fish/net09.png"));
		show =true;
		x=0;
		y=0;
		width=image.getWidth();
		height=image.getHeight();
	}
	public void moveTo(int a,int b){
		x=a;
		y=b;
	}
	public boolean catchFish(Fish fish){
		//�൱�� ��֪��������� ���Ŀ�� 
		//��֪ ��������   ��Ŀ�� ���� 
		//���������ĵ� ֻҪ����ķ�Χ�� ��ץס ���ڿ��Լ��������
		int dx =x-fish.x;
		int dy =y-fish.y;
		Random random =new Random();
		int n =random.nextInt(20);//����ץ���Ѷ�
		// n 0-99
		return (n<2) &&(dx>=0 && dx<fish.width && dy>=0&& dy<fish.height);
	}
}
