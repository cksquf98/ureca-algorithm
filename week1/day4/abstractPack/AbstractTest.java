package com.ureca.abstractPack;

import java.awt.font.ShapeGraphicAttribute;

public class AbstractTest {

	public static void main(String[] args) {
		Shape s;
		
		s = new Triangle();
		s.draw();
		
		s = new Circle();
		s.draw();
		
		s = new Rectangle();
		s.draw();
		
	}

}
