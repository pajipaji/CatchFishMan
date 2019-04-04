package com;

import java.io.IOException;
import javax.swing.JFrame;

public class EvaCatchFish {
	
	public EvaCatchFish() throws IOException, InterruptedException{
		//输入输出异常；这个异常一般发生在线程处理中，当一个正在执行的线程被中断时就会出现这个异常
		JFrame win =new JFrame("捕鱼达人 ");//实例化一个窗体
		//win.setUndecorated(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭
		win.setSize(800, 500);//窗体大小
		win.setLocationRelativeTo(null);//窗体位置居中、靠左、靠右、靠上、靠下
		Sea sea =new Sea();//实例化一个面板
		win.add(sea);//在窗体中添加面板
		win.setVisible(true);
		//窗体设置可见，先用后用区别不大，但是显示的话就涉及到刷新了，所以后添加的组件只能在刷新之后显示，接下来添加的面板动作变来变去，所以要再之前刷新
		sea.action();//面板动作
	}

	public static void main(String[] args) throws IOException, InterruptedException{
		new EvaCatchFish();//实例化
	}

}

