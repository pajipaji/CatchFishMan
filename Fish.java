package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish extends Thread {
	int x ;
	int y ;
	int width;//图片宽度
	int height;//图片高度
	int step;//步伐 应该是一个随机数
	int index;//表示 动画帧
	BufferedImage image;
	BufferedImage[] images;//动画帧
	//  fish01  name表示的 哪种鱼  哪种鱼 靠 图片名字 区分
	public Fish(String name) throws IOException{
		images =new BufferedImage[9];
		for(int i=0;i<images.length;i++){   // fish01_01
			images[i]=ImageIO.read(new File("Fish/"+name+"_0"+(i+1)+".png"));            
		}
		image=images[0];
		width=image.getWidth();//获取宽度
		height=image.getHeight();
		Random r =new Random();
		x=r.nextInt(800+width);
		y=r.nextInt(400+height);
		step=r.nextInt(5)+2;
		index=0;
	}
	public void run(){//游起来
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
	public void move(){//鱼走一步 切换动画帧
		image=images[index%images.length];
		x=x-step;
		index++;
		if(x<=-width){
			outOfBonuds();
		}
	}
	public void outOfBonuds(){//越界方法
		x=800;
		Random r =new Random();
		y=r.nextInt(400+height);
		step=r.nextInt(5)+2;
	}
}
