package helper;

import java.util.ArrayList;

public class Utilities {
	
	public static int[][] ArrayListTo2Dint(ArrayList<Integer> list, int xSize, int ySize) {
		int[][] newArr = new int[ySize][xSize];
		
		for(int i = 0; i < newArr.length; i ++) {
			for(int j = 0; j < newArr[i].length;j++) {
				int index = i * xSize + j;
				newArr[i][j] = list.get(index);
			}
		}
		return newArr;
	}
	
	public static int[] twoDto1D(int[][] twoDArr) {
		int[] newArr = new int[twoDArr.length * twoDArr[0].length];
		
		for(int i = 0; i < twoDArr.length; i ++) {
			for(int j = 0; j < twoDArr[i].length;j++) {
				int index = i * twoDArr[0].length + j;
				newArr[index] = twoDArr[i][j];
			}
		}
		return newArr;
	}

}
