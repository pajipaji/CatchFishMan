package com;

import java.io.IOException;
import javax.swing.JFrame;

public class EvaCatchFish {

	public EvaCatchFish() throws IOException, InterruptedException{
		JFrame win =new JFrame("≤∂”„¥Ô»À ");
		//win.setUndecorated(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(800, 500);
		win.setLocationRelativeTo(null);
		Pool pool =new Pool();
		win.add(pool);
		win.setVisible(true);
		pool.action();
	}

	public static void main(String[] args) throws IOException, InterruptedException{
		new EvaCatchFish();
	}

}

