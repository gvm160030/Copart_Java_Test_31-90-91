package com.group.copart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The class for finding the length of a longest substring of the same nucleotide
 * Method : findLongestIndex(String nucleotide)
 * return String
 * @author GAURI
 *
 */
public class DnaSequencingFinal {

	public static String findLongestIndex(String nucleotide) {
		int ctr = 1;
		String final1 = "";
		int output = 0;
		for (int i = 0; i < nucleotide.length() - 1; i++) {
			while (i < nucleotide.length() - 1
					&& nucleotide.charAt(i) == nucleotide.charAt(i + 1)) {
				i++;
				ctr++;
			}
			if (ctr > output) {
				output = ctr;
				final1 = nucleotide.charAt(i) + " "
						+ Integer.toString(output);
			}
			ctr = 1;
		}
		return final1;
	}

	public static void main(String[] args) {

		String ch = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Nucleotide sequence:");
		try {
			ch = br.readLine();
			System.out
					.println("Nucleotide and length of the nucleotide chain ");
			String newLine = System.getProperty("line.separator");
			System.out.println("Sample Input : " + newLine + ch + newLine
					+ findLongestIndex(ch));
		} catch (IOException e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
}
