package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.FontMetrics;

public class Button {

    private int xCor, yCor, Width, Height;
    String textPart;
    private Rectangle rectangleButton;
    private boolean isHovered, mousePressed;

    public Button(int xCor, int yCor, int Width, int Height, String textPart) {
        this.Height = Height;
        this.xCor = xCor;
        this.yCor = yCor;
        this.Width = Width;
        this.textPart = textPart;
        initBounds();
    }

    private void initBounds() {
        this.rectangleButton = new Rectangle(xCor, yCor, Width, Height);
    }

    public void setHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }
    
    public void setMousePressed(boolean mousePressed) {
    	this.mousePressed = mousePressed;
    }
    public void resetButton() {
        isHovered = false;
        mousePressed = false;
    }

    // Vẽ nút
    public void draw(Graphics g) {
        // Body
        drawBody(g);
        // Border
        drawBorder(g);
        // TEXT
        drawText(g);
    }
    
    private void drawBody(Graphics g) {       
        g.setColor(isHovered ? Color.GRAY : Color.WHITE);
        g.fillRect(xCor, yCor, Width, Height);
    }

    public void drawBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(xCor, yCor, Width, Height);
        
        if(mousePressed) {
        	g.drawRect(xCor+1,yCor+1,Width-2,Height-2);
        	g.drawRect(xCor+2,yCor+2,Width-4,Height-4);
        }
    }

    public void drawText(Graphics g) {
        g.setColor(Color.BLACK);
        FontMetrics StringSize = g.getFontMetrics();
        int textWidth = StringSize.stringWidth(textPart);
        int textHeight = StringSize.getAscent();
        int textX = xCor + (Width - textWidth) / 2;
        int textY = yCor + (Height + textHeight) / 2 - StringSize.getDescent();
        g.drawString(textPart, textX, textY);
    }

    public Rectangle rectangleCheck() {
        return rectangleButton;
    }


}
