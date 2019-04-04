package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish extends Thread {
	int x ;//图片位置
	int y ;
	int width;//图片宽度
	int height;//图片高度
	int step;//移动的距离应该是一个随机数
	int index;//表示动画帧
	BufferedImage image;//加载图片
	BufferedImage[] images;//图片组，存储同一个鱼的不同的动作的图片
	//BufferedImage子类描述具有可访问图像数据缓冲区 继承自Image实现其方法，主要的作用就是将图片加载到内存对其进行操作
	
	public Fish(int name) throws IOException{//构造函数
		//name表示哪种鱼  图片名区分
		images =new BufferedImage[10];//实例化图片组
		for(int i=0;i<images.length;++i){//图片组名字是按fish01_01这个格式写的  遍历图片文件，给数组赋值
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
				//我要说一下，这个Fish文件夹啊是放在项目下的    而且你问我为什么是9不是10 ，因为上一行存的方法是 "_0"+(i+1) hhh我偷懒了，好吧补一下
			}
		}
		image=images[0];//取第一张图片，实例化
		width=image.getWidth();//获取宽度
		height=image.getHeight();//获取高度
		Random r =new Random();//实例化随机数
		x=r.nextInt(800+width);//给图片设置初始位置x
		y=r.nextInt(400+height);//给图片设置初始位置y
		step=r.nextInt(5)+2;//鱼每次移动的像素位
		index=0;//因为下面有操作，index会一直++会超限，所以每次都要归零
	}
	public void run(){//游起来
		while(true){
			//System.out.println(x+","+y);
			move();//鱼鱼图片组遍历动起来
			try {
				Thread.sleep(150);//休眠时间决定鱼游得快慢，也就是换帧的快慢
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void move(){//鱼走一步 切换动画帧
		image=images[index%(images.length-2)];//当前图片不断更新
		x=x-step;//坐标变换----像素点位移
		index++;//换图
		if(x<=-width){//鱼游过最左边界
			outOfBonuds();//越界处理
		}
	}
	public void outOfBonuds(){//越界方法
		x=800;//归位
		Random r =new Random();
		y=r.nextInt(400+height);//但是改变y位置
		step=r.nextInt(5)+2;//
	}
}
