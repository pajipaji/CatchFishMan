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
	BufferedImage image;//图片加载
	boolean show;//控制网 是否显示画出来的方法
	public Net() throws IOException{//构造函数
		image =ImageIO.read(new File("Fish/net09.png"));
		show =true;
		x=0;
		y=0;//初始化网的位置
		width=image.getWidth();//获取图片的宽度和高度
		height=image.getHeight();
	}
	public void moveTo(int a,int b){//网的时实位置
		x=a;
		y=b;
	}
	public boolean catchFish(Fish fish){
		//已知网的坐标、网的宽度、鱼的坐标、鱼的宽度，当网的中心点在鱼的范围内，就抓住 后期可以加上随机数增加难度
		int dx =x-fish.x;
		int dy =y-fish.y;
		Random random =new Random();
		int n =random.nextInt(20);//控制抓捕难度
		//int n=1;
		return (n<2) &&(dx>=0 && dx<fish.width && dy>=0&& dy<fish.height);
		//n增加难度，dx和dy表示网的中心点和鱼的坐标之间的差值
	}
}
