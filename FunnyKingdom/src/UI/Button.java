package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;

import java.awt.FontMetrics;

public class Button {

    public int xCor, yCor, Width, Height; 
    String textPart; 
    private Rectangle rectangleButton; 
    private boolean isHovered, mousePressed; 
    private int id; 

    // Constructor: Khởi tạo nút mà không có ID (dành cho nút Menu)
    public Button(int xCor, int yCor, int Width, int Height, String textPart) {
        this.Height = Height;
        this.xCor = xCor;
        this.yCor = yCor;
        this.Width = Width;
        this.textPart = textPart;
        this.id = -1; 
        initBounds(); 
        
    }
    
    // Constructor: Khởi tạo nút với ID (dành cho các ô gạch)
    public Button(int xCor, int yCor, int Width, int Height, String textPart, int id) {
    	
        this.Height = Height;
        this.xCor = xCor;
        this.yCor = yCor;
        this.Width = Width;
        this.textPart = textPart;
        this.id = id; // Gán ID
        initBounds(); // Khởi tạo hình chữ nhật bao quanh nút
        
    }

    // Khởi tạo hình chữ nhật bao quanh nút để kiểm tra va chạm
    private void initBounds() {
        this.rectangleButton = new Rectangle(xCor, yCor, Width, Height);
    }

    // Đặt trạng thái khi di chuột qua nút
    public void setHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }
    
    // Đặt trạng thái khi nút bị nhấn
    public void setMousePressed(boolean mousePressed) {
    	this.mousePressed = mousePressed;
    }
    
    // Đặt lại trạng thái của nút (không bị di chuột và nhấn chuột)
    public void resetButton() {
        isHovered = false;
        mousePressed = false;
    }
    
    // Lấy ID của nút (dùng để truy xuất hình ảnh của ô gạch)
    public int getID() {
    	return id;
    }
    
    public boolean isMouseOver() {
    	return isHovered;
    }
    
    public boolean isMousePressed() {
    	return mousePressed;
    }

    // Phương thức vẽ nút
    public void draw(Graphics g) {
    	
        drawBody(g); 
        drawBorder(g); 
        drawText(g); 
    }
    
    // Vẽ thân nút (thay đổi màu khi di chuột)
    private void drawBody(Graphics g) {           	
        g.setColor(isHovered ? Color.GRAY : Color.WHITE); 
        g.fillRect(xCor, yCor, Width, Height);         
    }

    // Vẽ viền của nút
    public void drawBorder(Graphics g) {
        g.setColor(Color.BLACK); 
        g.drawRect(xCor, yCor, Width, Height); 
        
        // Nếu nút bị nhấn, vẽ thêm viền nhỏ bên trong để tạo hiệu ứng nhấn
        if(mousePressed) {
        	g.drawRect(xCor+1, yCor+1, Width-2, Height-2);
        	g.drawRect(xCor+2, yCor+2, Width-4, Height-4);
        }
    }

    // Vẽ văn bản trên nút
    public void drawText(Graphics g) {
        g.setColor(Color.BLACK); // Màu văn bản đen
        FontMetrics StringSize = g.getFontMetrics();
        int textWidth = StringSize.stringWidth(textPart); 
        int textHeight = StringSize.getAscent(); 
        int textX = xCor + (Width - textWidth) / 2; 
        int textY = yCor + (Height + textHeight) / 2 - StringSize.getDescent();
        g.drawString(textPart, textX, textY); 
    }

    // Trả về hình chữ nhật bao quanh nút để kiểm tra va chạm
    public Rectangle rectangleCheck() {
        return rectangleButton;
    }
}
