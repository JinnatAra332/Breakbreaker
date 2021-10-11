package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import handlers.MouseHandler;
import parts.Ball;
import parts.Brick;
import parts.Paddle;

public class MainMenu {

	private Rectangle[] bounds = {new Rectangle(65, 295, 210, 45),
								  new Rectangle(65, 345, 210, 45)};
	private Image titleScreenForeground;
	private Image titleScreenBackground;
	
	
	public MainMenu() {
		titleScreenForeground = new ImageLoader(ImageLoader.titleForeground).getImage();
		titleScreenBackground = new ImageLoader(ImageLoader.titleScreenBackground).getImage();
	}
	public void tick() {
		for(int i = 0; i < bounds.length; i++) {
			if(bounds[i].contains(Controller.mousePoint) && MouseHandler.MOUSEDOWN) {
				MouseHandler.MOUSEDOWN = false;
				if(i == 0) {
					Controller.switchStates(Controller.STATE.PICKLEVEL);
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(titleScreenBackground, 0, 0, Frame.WIDTH, Frame.WIDTH, null);
		g.setColor(Color.black);
		g.drawImage(titleScreenForeground, 0, 0, Frame.WIDTH, Frame.WIDTH, null);
	}
}
