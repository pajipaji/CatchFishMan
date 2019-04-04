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

public class Sea extends JPanel {//容器

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int score;//分数
	BufferedImage bg;//背景图片
	Fish[] fishs;//鱼的种类！！种类！！啊喂！
	Net net;//把网拿过来
	Fish becatchedfish;
	public Sea() throws IOException{//构造函数
		bg=ImageIO.read(new File("Fish/bg.jpg"));//背景图片实例化
		score=0;//分数清零
		net =new Net();//网实例化
		fishs=new Fish[11];//fishs数组[][]
		for(int i=0;i<fishs.length;i++){//把鱼的种类的名字存进数组
			if(i<9) {
				fishs[i]=new Fish(i+1);
			}
			else{//沙雕鱼包名字还不是有序的，抠图有点不仔细
				fishs[i]=new Fish(i+4);
			}
		}
	}
	Fish one;
	public void catchFishWithNet() throws InterruptedException{//把每一种鱼都和网比较
		for(int i=0;i<fishs.length;i++){//比较的是每一种鱼！！遍历的是11种鱼
			one =fishs[i];
			if(net.catchFish(one)){//在范围内,重叠的鱼也抓走，因为遍历的是每一条鱼
				//变大，变形显示被抓住
				
				one.outOfBonuds();//按越界处理
				score=score+one.width/10;//分数增加
				
			}
		}
	}
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);//Image img, int x, int y,ImageObserver observer一般为null，上传下载的时候用的
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
	//启动游戏开始
	public void action() throws InterruptedException{
		MouseAdapter l = new MouseAdapter() {//匿名内部类

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
				net.moveTo(x, y);//实时位置
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		for(int i=0;i<fishs.length;++i) {
			fishs[i].start();//鱼类继承thread，这里用线程启动
			//Thread类中run()和start()方法的区别如下：
			//run()方法:在本线程内调用该Runnable对象的run()方法，可以重复多次调用；//搭配循环
			//start()方法:启动一个线程，调用该Runnable对象的run()方法，不能多次启动一个线程；
			//start()方法重新创建了一个线程,在main方法执行结束后,由于start()方法创建的线程没有运行结束,
	        //因此主线程未能退出,直到线程thread也执行完毕.这里要注意,默认创建的线程是用户线程(非守护线程)
		}
		while(true) {
			repaint();//重写画板容器，擦除鱼的轨迹
			Thread.sleep(100);//线程休眠，这里表示帧的变化时长
		}
	}

}
