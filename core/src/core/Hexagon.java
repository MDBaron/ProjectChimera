package core;

import java.awt.Polygon;

public class Hexagon {
	private Polygon hex;
	private int xCoords[], yCoords[];
	private int xPoint, yPoint;
	private int side, h, r, a, b;
	
	public Hexagon(int xPoint, int yPoint, int side, int orientation){
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		xCoords = new int[6];
		yCoords = new int[6];
		this.h = ((int)Math.sin(Math.toRadians(30.0)) * side);
		this.r = ((int)Math.cos(Math.toRadians(30.0)) * side);
		this.a = 2 * r;
		this.b = side + (2 * h);
		this.side = side;
		try {
			this.hex = generateHex(orientation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//constructor
	
	private Polygon generateHex(int orientation) throws Exception{
		
		switch(orientation){
		case 0://Set hexagonal points by Flat orientation
			xCoords[0] = (xPoint);
			yCoords[0] = (yPoint);
			xCoords[1] = (xPoint + side);
			yCoords[1] = (yPoint);
			xCoords[2] = (xPoint + side + h);
			yCoords[2] = (yPoint + r);
			xCoords[3] = (xPoint + side);
			yCoords[3] = (yPoint + r + r);
			xCoords[4] = (xPoint);
			yCoords[4] = (yPoint + r + r);
			xCoords[5] = (xPoint - h);
			yCoords[5] = (yPoint + r);
			break;
		case 1://Set hexagonal points by Pointy orientation
			xCoords[0] = (xPoint);
			yCoords[0] = (yPoint);
			xCoords[1] = (xPoint + r);
			yCoords[1] = (yPoint + h);
			xCoords[2] = (xPoint + r);
			yCoords[2] = (yPoint + side + h);
			xCoords[3] = (xPoint);
			yCoords[3] = (yPoint + side + h + h);
			xCoords[4] = (xPoint - r);
			yCoords[4] = (yPoint + side + h);
			xCoords[5] = (xPoint - r);
			yCoords[5] = (yPoint + h);
			break;
			/*
		case 2://Set hexagonal points by orientation
			xCoords[0] = (xPoint);
			yCoords[0] = (yPoint);
			xCoords[1] = ();
			yCoords[1] = ();
			xCoords[2] = ();
			yCoords[2] = ();
			xCoords[3] = ();
			yCoords[3] = ();
			xCoords[4] = ();
			yCoords[4] = ();
			xCoords[5] = ();
			yCoords[5] = ();
			break;
		case 4://Set hexagonal points by orientation
			xCoords[0] = (xPoint);
			yCoords[0] = (yPoint);
			xCoords[1] = ();
			yCoords[1] = ();
			xCoords[2] = ();
			yCoords[2] = ();
			xCoords[3] = ();
			yCoords[3] = ();
			xCoords[4] = ();
			yCoords[4] = ();
			xCoords[5] = ();
			yCoords[5] = ();
			break;
			*/
		default:
			throw new Exception("No HexOrientation defined for Hex object.");
		}//orientation switch
		
		return new Polygon(xCoords, yCoords,6);
	}//hex
	
	public Polygon getHex(){
		return hex;
	}//getHex
}
