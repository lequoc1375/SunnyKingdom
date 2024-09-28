package helper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class loadSave {
	
	public static BufferedImage getSpiritAtlas() {
		
		BufferedImage Image =  null;
        InputStream is = loadSave.class.getClassLoader().getResourceAsStream("ground/spriteatlas.png");        
        try {
            Image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Image;
	}
	
	//create file
	public static void createFile() {
		File newFile = new File("res/mapText/testnewText.txt");
		
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//create a level file
	public static void creatNewLevel(String name, int[] IDarray) {
		File newLevelFile =  new File("res/mapText/" + name + ".txt");
		
		if(newLevelFile.exists()) {
			System.out.println("The" + name + "is already exists");
			return;
		}
		else {
			try {
				newLevelFile.createNewFile();			
			} catch (IOException e) {
				e.printStackTrace();
			}
			writeToFile(newLevelFile,IDarray);
		}
		
	}
	
	//Write into a file
	private static void writeToFile(File fileName, int[] IDarray) {
		try {
			PrintWriter PW = new PrintWriter(fileName);
			 for(int i : IDarray) {
				 PW.println(i);
			 }
			PW.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void SaveLevel(String name, int[][] iDArray) {
		File newLevelFile =  new File("res/mapText/" + name + ".txt");
		
		if(newLevelFile.exists()) {
			writeToFile(newLevelFile,Utilities.twoDto1D(iDArray));
		}
		else {
			System.out.println("File" + name + " does not exist");
			return;
		}
		
	}
	
	//Read the files
	public static ArrayList<Integer> ReadFile(File file) {
		ArrayList<Integer> list = new ArrayList<>();
		try {
			Scanner SC = new Scanner(file);
			while(SC.hasNextLine() == true) {
				list.add(Integer.parseInt(SC.nextLine()));
			}
			SC.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int[][] GetLevelData(String name) {
		File levelFile = new File("res/mapText/" + name + ".txt");
		if(levelFile.exists() == true) {
			ArrayList<Integer> list =  ReadFile(levelFile);
			return Utilities.ArrayListTo2Dint(list, 30, 20);// return newArr
		}
		else {
			System.out.println("File" + name + " does not exist");
			return null;
		}
	}



}
