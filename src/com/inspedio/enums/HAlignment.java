package com.inspedio.enums;

import javax.microedition.lcdui.Graphics;

public class HAlignment extends InsEnum{
	
	public static final HAlignment LEFT = new HAlignment("LEFT", 0, Graphics.LEFT);
	public static final HAlignment CENTER = new HAlignment("CENTER", 1, Graphics.HCENTER);
	public static final HAlignment RIGHT = new HAlignment("RIGHT", 2, Graphics.RIGHT);

	public int anchor;
	
	protected HAlignment(String Name, int Value, int AnchorPoint) {
		super(Name, Value);
		this.anchor = AnchorPoint;
	}

}
