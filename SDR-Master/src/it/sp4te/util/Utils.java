package it.sp4te.util;

import it.sp4te.domain.Complex;
import it.sp4te.domain.Signal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		List<Complex> list = new ArrayList<>();
		BufferedReader in = null;
		Scanner read;
		try {
			in = new BufferedReader(new FileReader(new File(pathIn)));
			read = new Scanner(in);
			
			while(read.hasNext()) {
				String s = read.nextLine();
				String[] tab = s.split("\t");
				double reale = Double.parseDouble(tab[0]);
				double immaginario = Double.parseDouble(tab[1]);
				list.add(new Complex(reale,immaginario));
			}
			read.close();
		} catch(FileNotFoundException e ) {
			;
			
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return new Signal((Complex[]) list.toArray());
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
