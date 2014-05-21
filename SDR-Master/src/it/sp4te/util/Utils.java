package it.sp4te.util;

import it.sp4te.domain.Complex;
import it.sp4te.domain.Signal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {

	public static int mcd(int a, int b) {
		if (a == b)
			return a;
		if(a > b) {
			if (b==0) return a;
			return mcd(b, a % b);
		}
		else return mcd(b,a);
	}
	
	public static Signal leggiCampioni(String pathIn){
		Complex[] arrayIn = new Complex[15000];
		BufferedReader in = null;
		Scanner read;
		try {
			in = new BufferedReader(new FileReader(new File(pathIn)));
			read = new Scanner(in);
			int i = 0;
			while(read.hasNext() && i<15000) {
				String s = read.nextLine();
				String[] tab = s.split("\t");
				double reale = Double.parseDouble(tab[0]);
				double immaginario = Double.parseDouble(tab[1]);
				arrayIn[i] = new Complex(reale, immaginario);
				i++;
				System.out.println(i);
			}
			System.out.println(1);
			read.close();
			System.out.println(1);
		} catch(FileNotFoundException e ) {
			e.printStackTrace();
			
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println(1);
		return new Signal(arrayIn);
	}
	
	public static void scriviCampioni(String pathIn, double[] in){
		FileWriter out = null;
		try {
			out = new FileWriter(new File(pathIn));
			for(int i = 0; i < in.length; i++)
				out.write("" + in[i]);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
