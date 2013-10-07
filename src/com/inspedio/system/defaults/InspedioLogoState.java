package com.inspedio.system.defaults;

import com.inspedio.actions.Delay;
import com.inspedio.entity.InsShape;
import com.inspedio.entity.InsSprite;
import com.inspedio.entity.InsState;
import com.inspedio.entity.primitive.InsCallback;
import com.inspedio.system.core.InsGlobal;

public class InspedioLogoState extends InsState{

	int progress = 1;
	int delay = 15*4*progress;
	int bgColor = 0x000000;
	InsShape bg;
	InsSprite logo;
	boolean ready = false;
	
	public void create() {
		this.logo = new InsSprite("/com/inspedio/defaults/logo.png");
		this.bg = new InsShape(InsGlobal.screenWidth / 2, InsGlobal.screenHeight / 2, 400, 400);
		this.bg.setColor(bgColor, true);
		this.bg.setBorder(bgColor, 0);
		
		this.add(this.bg);
		this.add(this.logo);
	}
	
	public void update(){
		super.update();
		if(delay > 0){
			if(delay % progress == 0){
				if(this.bgColor < 0xFFFFFF){
					this.bgColor += 0x040404;
					this.bg.setColor(this.bgColor, true);
				}
			}
			delay--;
		} else {
			if(!ready){
				this.logo.setAction(Delay.create(InsGlobal.game.idealFPS, new InsCallback() {
					public void call() {
						InsGlobal.game.switchState(false);
					}
				}));
				ready = true;
			}
			
		}
	}
	
	
	

}
