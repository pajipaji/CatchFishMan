package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Net {//网
	int x;
	int y;
	int width;
	int height;
	BufferedImage image;
	boolean show;//控制网 是否显示画出来的方法
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
		//相当于 已知网的坐标和 网的宽度 
		//已知 鱼的坐标和   鱼的宽度 计算 
		//当网的中心点 只要在鱼的范围内 就抓住 后期可以加上随机数
		int dx =x-fish.x;
		int dy =y-fish.y;
		Random random =new Random();
		int n =random.nextInt(20);//控制抓捕难度
		// n 0-99
		return (n<2) &&(dx>=0 && dx<fish.width && dy>=0&& dy<fish.height);
	}
}
