package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish extends Thread {
	int x ;//ͼƬλ��
	int y ;
	int width;//ͼƬ���
	int height;//ͼƬ�߶�
	int step;//�ƶ��ľ���Ӧ����һ�������
	int index;//��ʾ����֡
	BufferedImage image;//����ͼƬ
	BufferedImage[] images;//ͼƬ�飬�洢ͬһ����Ĳ�ͬ�Ķ�����ͼƬ
	//BufferedImage�����������пɷ���ͼ�����ݻ����� �̳���Imageʵ���䷽������Ҫ�����þ��ǽ�ͼƬ���ص��ڴ������в���
	
	public Fish(int name) throws IOException{//���캯��
		//name��ʾ������  ͼƬ������
		images =new BufferedImage[10];//ʵ����ͼƬ��
		for(int i=0;i<images.length;++i){//ͼƬ�������ǰ�fish01_01�����ʽд��  ����ͼƬ�ļ��������鸳ֵ
			if(i==9) {
				if(name<=9)
					images[i]=ImageIO.read(new File("Fish/"+"fish0"+name+"_"+(i+1)+".png"));
				else
					images[i]=ImageIO.read(new File("Fish/"+"fish"+name+"_"+(i+1)+".png"));
			}
			else if(i<9){
				if(name<=9)
					images[i]=ImageIO.read(new File("Fish/"+"fish0"+name+"_0"+(i+1)+".png"));
				else
					images[i]=ImageIO.read(new File("Fish/"+"fish"+name+"_0"+(i+1)+".png"));
				//��Ҫ˵һ�£����Fish�ļ��а��Ƿ�����Ŀ�µ�    ����������Ϊʲô��9����10 ����Ϊ��һ�д�ķ����� "_0"+(i+1) hhh��͵���ˣ��ðɲ�һ��
			}
		}
		image=images[0];//ȡ��һ��ͼƬ��ʵ����
		width=image.getWidth();//��ȡ���
		height=image.getHeight();//��ȡ�߶�
		Random r =new Random();//ʵ���������
		x=r.nextInt(800+width);//��ͼƬ���ó�ʼλ��x
		y=r.nextInt(400+height);//��ͼƬ���ó�ʼλ��y
		step=r.nextInt(5)+2;//��ÿ���ƶ�������λ
		index=0;//��Ϊ�����в�����index��һֱ++�ᳬ�ޣ�����ÿ�ζ�Ҫ����
	}
	public void run(){//������
		while(true){
			//System.out.println(x+","+y);
			move();//����ͼƬ�����������
			try {
				Thread.sleep(150);//����ʱ��������εÿ�����Ҳ���ǻ�֡�Ŀ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void move(){//����һ�� �л�����֡
		image=images[index%(images.length-2)];//��ǰͼƬ���ϸ���
		x=x-step;//����任----���ص�λ��
		index++;//��ͼ
		if(x<=-width){//���ι�����߽�
			outOfBonuds();//Խ�紦��
		}
	}
	public void outOfBonuds(){//Խ�緽��
		x=800;//��λ
		Random r =new Random();
		y=r.nextInt(400+height);//���Ǹı�yλ��
		step=r.nextInt(5)+2;//
	}
}
