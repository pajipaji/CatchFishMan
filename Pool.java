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

public class Pool extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int score;
	BufferedImage bg;
	Fish[] fishs;//�ܶ���
	Net net;
	
	public Pool() throws IOException{
		bg=ImageIO.read(new File("Fish/bg.jpg"));
		score=0;
		net =new Net();
		fishs=new Fish[9];
		for(int i=0;i<fishs.length;i++){
			fishs[i]=new Fish("fish0"+(i+1));
		}
	
	}
	//��ÿһ���� �����Ƚ�
	public void catchFishWithNet(){
		for(int i=0;i<fishs.length;i++){
			Fish one =fishs[i];
			if(net.catchFish(one)){
				one.outOfBonuds();
				score=score+one.width/10;
			}
		}
	}
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		g.setColor(Color.WHITE);
		g.drawString("SCORE:"+score, 10, 10);
		
		for(int i=0;i<fishs.length;i++){
			Fish one =fishs[i];
			g.drawImage(one.image, one.x, one.y, null);
		}
		if(net.show==true){
			g.drawImage(net.image, net.x-net.width/2,net.y-net.height/2 ,null);
		}
	}
	//������Ϸ��ʼ
	public void action() throws InterruptedException{
		MouseAdapter l = new MouseAdapter() {//�����ڲ���

			public void mousePressed(MouseEvent e) {
				catchFishWithNet();
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
				net.moveTo(x, y);
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		for(int i=0;i<fishs.length;++i) {
			fishs[i].start();
		}
		while(true) {
			repaint();
			Thread.sleep(100);
		}
	}

}
