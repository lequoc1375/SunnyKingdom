package helper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class loadSave {
	
	public static BufferedImage getSpiritAtlas() {
		
		BufferedImage Image =  null;
        InputStream is = loadSave.class.getClassLoader().getResourceAsStream("ground/GRASS+.png");        
        try {
            Image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Image;
	}

}
