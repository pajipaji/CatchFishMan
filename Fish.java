package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish extends Thread {
	int x ;
	int y ;
	int width;//ͼƬ���
	int height;//ͼƬ�߶�
	int step;//���� Ӧ����һ�������
	int index;//��ʾ ����֡
	BufferedImage image;
	BufferedImage[] images;//����֡
	//  fish01  name��ʾ�� ������  ������ �� ͼƬ���� ����
	public Fish(String name) throws IOException{
		images =new BufferedImage[9];
		for(int i=0;i<images.length;i++){   // fish01_01
			images[i]=ImageIO.read(new File("Fish/"+name+"_0"+(i+1)+".png"));            
		}
		image=images[0];
		width=image.getWidth();//��ȡ���
		height=image.getHeight();
		Random r =new Random();
		x=r.nextInt(800+width);
		y=r.nextInt(400+height);
		step=r.nextInt(5)+2;
		index=0;
	}
	public void run(){//������
		while(true){
			//System.out.println(x+","+y);
			move();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void move(){//����һ�� �л�����֡
		image=images[index%images.length];
		x=x-step;
		index++;
		if(x<=-width){
			outOfBonuds();
		}
	}
	public void outOfBonuds(){//Խ�緽��
		x=800;
		Random r =new Random();
		y=r.nextInt(400+height);
		step=r.nextInt(5)+2;
	}
}
