/**
 * 
 */
package com.group.copart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class to determine the minimum perimeter the cake should have
 * @author GAURI
 *
 */
public class PieceOfCake {
	/*
	 * Method to calculate minimum perimeter for a given area
	 * input : int area
	 * return int 
	*/
	public static int minPeri(int area) {
		int sumMin = Integer.MAX_VALUE;
		for (int i = 1; i <= Math.sqrt(area); i++) {
			if (area % i == 0) {
				if (2 * (i + area / i) < sumMin) {
					sumMin = 2 * (i + area / i);
				}
			}
		}
		return sumMin;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String num = "";
		int res = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the number of cakes:");
		try {
			num = br.readLine();
			/*Read the input given for number of cakes*/
			int cakes = Integer.parseInt(num);
			int[] myIntArray = new int[cakes];
			for (int j = 0; j < cakes; j++) {
				System.out.print("Enter the area:");
				/*Read the input given for areas*/
				String area = br.readLine();
				if (null != area && !"".equals(area)) {
					res = minPeri(Integer.parseInt(area));
					myIntArray[j] = res;
				} else {
					System.out.println("Please Enter the area");
				}
			}
			/*Displaying the output in the expected format*/
			for (int k = 0; k < (myIntArray.length); k++) {
				System.out.println(myIntArray[k]);
			}

		} catch (Exception e) {
			System.out.println("Exception occured");
		}
	}

}
