/* ============================================================================
 * AMES Wholesale Power Market Test Bed (Java): A Free Open-Source Test-Bed
 *         for the Agent-based Modeling of Electricity Systems
 * ============================================================================
 *
 * (C) Copyright 2008, by Hongyan Li, Junjie Sun, and Leigh Tesfatsion
 *
 *    Homepage: http://www.econ.iastate.edu/tesfatsi/AMESMarketHome.htm
 *
 * LICENSING TERMS
 * The AMES Market Package is licensed by the copyright holders (Junjie Sun,
 * Hongyan Li, and Leigh Tesfatsion) as free open-source software under the
 * terms of the GNU General Public License (GPL). Anyone who is interested is
 * allowed to view, modify, and/or improve upon the code used to produce this
 * package, but any software generated using all or part of this code must be
 * released as free open-source software in turn. The GNU GPL can be viewed in
 * its entirety as in the following site: http://www.gnu.org/licenses/gpl.html
 */

// Support.java
// Miscellaneous support methods
// Note: all support methods are set to be static by convention

package amesmarket;

//import java.util.*;
//import java.text.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * Miscellaneous support methods.
 *
 */
public class Support {

	private static final String ZEROES = "000000000000";
	private static final String BLANKS = "            ";
	private static final double TOL = 1.0E-9;

	//public static void printFourCombinedArrays(

	// round off a to n decimal points
	public static double roundOff(double a, int n) {
		double p = Math.pow(10,n);
		a = Math.rint(a*p)/p;
		return a;
	}

	public static double[] roundOff(double[] a, int n) {
		double p = Math.pow(10,n);
		for(int i=0; i<a.length; i++) {
			a[i] = Math.rint(a[i]*p)/p;
		}
		return a;
	}

	public static double[][] roundOff(double[][] a, int n) {
		double p = Math.pow(10,n);
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				a[i][j] = Math.rint(a[i][j]*p)/p;
			}

		}
		return a;
	}


	public static double[][] correctRoundingError(double[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				for(int p=1; p<1.0E6; p=p*10) {
					if(Math.abs((a[i][j]*p)-Math.rint(a[i][j]*p)) < TOL) {
						a[i][j] = Math.rint(a[i][j]*p)/p;
						break;
					}
				}
			}
		}
		return a;
	}

	public static double[] correctRoundingError(double[] a) {
		for(int i=0; i<a.length; i++) {
			for(int p=1; p<1.0E6; p=p*10) {
				if(Math.abs((a[i]*p)-Math.rint(a[i]*p)) < TOL) {
					a[i] = Math.rint(a[i]*p)/p;
					break;
				}
			}
		}
		return a;
	}


	public static double correctRoundingError(double scalar) {
		for(int p=1; p<1.0E6; p=p*10) {
			if(Math.abs((scalar*p)-Math.rint(scalar*p)) < TOL) {
				scalar = Math.rint(scalar*p)/p;
				break;
			}
		}
		return scalar;
	}

	/**
	 * Check if a double is different from another.
	 *
	 * Two values with {@link #TOL} of each other are considered the same.
	 * @param d1
	 * @param d2
	 * @return
	 */
	public final static boolean doubleIsDifferent(double d1, double d2){
		//We don't really need the tolerance as small as TOL.
		//Changed as per request from Dave Woodruff.
		final double tol = 1e-6;

		return doubleIsDifferent(d1, d2, tol);
	}

	/**
	 * Check if a double is different from another.
	 *
	 * Two values with {@link #TOL} of each other are considered the same.
	 * @param d1
	 * @param d2
	 * @return
	 */
	public final static boolean doubleIsDifferent(double d1, double d2, double tol) {
		if(Double.compare(d1, d2) == 0) {
			return false;
		}

		if(Math.abs(d1 - d2) <= tol) {
			return false;
		}

		return true;
	}

	public static double sumArray(double[] ds){
		double acc = 0;
		for (double element : ds) {
			acc+=element;
		}
		return acc;
	}

	/**
	 * Converts a single digit hour to two digits by inserting a 0 in front it.
	 *
	 * @param val int
	 * @return String
	 */
	public static String to2Digits(int val) {
		String s = Integer.toString(val);
		if (s.length()==1) {
			s = "0" + s;
		}
		return s;
	}

	/**
	 * Converts and returns a 2-D array with one column to a 1-D array
	 * @param a double[][]
	 * @return double[]
	 */
	public static double[] toArray1D(double[][] a) {
		double[] b = new double[a.length];
		for(int i=0; i<a.length; i++) {
			b[i] = a[i][0];
		}
		return b;
	}


	/**
	 * Converts and returns a floating point value (X) to a string of size (w)
	 * with a specified number (n) of decimals. If the value of W is negative,
	 * then number is aligned to the left otherwise it is aligned on the right.
	 *
	 * Source: http://www.iro.umontreal.ca/~vaucher/Java/tutorials/Formatting.html
	 *
	 * @param val double
	 * @param n int
	 * @param w int
	 * @return String
	 */
	public static String toString( double val, int n, int w) {
		//rounding
		double incr = 0.5;
		for( int j=n; j>0; j--) {
			incr /= 10;
		}
		val += incr;

		String s = Double.toString(val);
		int n1 = s.indexOf('.');
		int n2 = s.length() - n1 - 1;

		if (n>n2) {
			s = s+ZEROES.substring(0, n-n2);
		} else if (n2>n) {
			s = s.substring(0,n1+n+1);
		}

		if( (w>0) & (w>s.length()) ) {
			s = BLANKS.substring(0,w-s.length()) + s;
		} else if ( (w<0) & ((-w)>s.length()) ) {
			w=-w;
			s = s + BLANKS.substring(0,w-s.length()) ;
		}
		return s;
	}

	public static void printArrayAligned(double []a) {
		for (double element : a) {
			System.out.print("  " + toString(element,2,8)); //elements alignged
			System.out.println();
		}
	}

	// Print Array with 0 decimal points and elements aligned
	public static void printArray0dp(double [][]a) {
		for (double[] element : a) {
			for(int j = 0 ; j<a[0].length; j++) {
				System.out.print("\t" + Math.round(element[j])); //elements aligned
			}
			System.out.println("\t");
		}
		System.out.println();
	}

	public static void print(double[] a, int n) {
		for (double element : a) {
			System.out.print("\t" + roundOff(element,n) + "\n");
		}
	}

	/**
	 * Convert an integer array to a string, using the delim between elements
	 * @param is
	 * @param delim
	 */
	public static String intArrayToString(int[] is, String delim){
		StringBuilder sb = new StringBuilder();
		//add the delim after all but the last element.
		for(int i = 0; i<(is.length-1); i++){
			sb.append(is[i]); sb.append(delim);
		}
		sb.append(is[is.length - 1]);

		return sb.toString();
	}

	//Print the result with side indication of L (lower constraint binding) or
	// U(upper constraint binding) if there is any
	public static void printWithContraints(double [][]a, int n,
			double[]lower, double[]upper) {
		double tol = 0.001;
		for (double[] element : a) {
			for(int j = 0 ; j<a[0].length; j++) {
				//If neither upper or lower constraints binding
				if(((element[j]-lower[j])>tol) && ((upper[j]-element[j])>tol)) {
					System.out.print("\t" + roundOff(element[j],n) + "     ");
				}
				//If lower constraint binding
				else if(((element[j]-lower[j])<tol) && ((upper[j]-element[j])>tol)) {
					System.out.print("\t" + roundOff(element[j],n) + " L" + "   ");
				}
				else if(((element[j]-lower[j])>tol) && ((upper[j]-element[j])<tol)) {
					System.out.print("\t" + roundOff(element[j],n) + " U" + "   ");
				}
				else {
					System.out.println("Something is wrong!");
				}
			}
			System.out.println();
		}
		System.out.println("NOTE: L and U indicate binding lower and upper " +
				"operating capacity constraints, respectively");
		System.out.println();
	}


	public static void print(String[] s) {
		for (String element : s) {
			System.out.print("\t" + element + "     ");
		}
		System.out.println();
	}

	public static void print(String s, int dim) {
		for(int i = 0; i<dim; i++) {
			System.out.print("\t" + s + (i+1) + "     ");
		}
		System.out.println();
	}
	public static void printNonRef(String s, int dim) {
		for(int i = 1; i<dim; i++) {
			System.out.print("\t" + s + (i+1) + "     ");
		}
		System.out.println();
	}

	public static void print2dp(double []a) {
		for (double element : a) {
			System.out.print("\t" + roundOff(element,2));
		}
		System.out.println();
	}

	public static void print2dpByRow(double []a) {
		for (double element : a) {
			System.out.println("\t" + roundOff(element,2));
		}
		System.out.println();
	}


	public static void print4dp(double []a) {
		String strTemp="\t\t";
		for (double element : a) {
			strTemp+=String.format("\t%1$15.4f",element);
			//System.out.print("\t" + roundOff(a[i],4));
		}
		System.out.println(strTemp);
	}


	public static void print(double [][]a, int n) {
		for (double[] element : a) {
			for(int j = 0 ; j<a[0].length; j++) {
				System.out.print("\t" + roundOff(element[j],n) + "     ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public static void print2dp(double [][]a) {
		for (double[] element : a) {
			for(int j = 0 ; j<a[0].length; j++) {
				System.out.print("\t" + roundOff(element[j],2) + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print4dp(double [][]a) {
		for (double[] element : a) {

			String strTemp="\t\t";
			for(int j = 0 ; j<a[0].length; j++) {
				strTemp+=String.format("\t%1$15.4f",element[j]);
				//System.out.print("\t" + roundOff(a[i][j],4) + "\t");
			}
			System.out.println(strTemp);
		}
		System.out.println();
	}

	public static void print6dp(double [][]a) {
		for (double[] element : a) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print("\t" + roundOff(element[j],6) + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}


	// Print Array with 2 decimal points and elements aligned
	public static void printArray2dp(double [][]a) {
		for (double[] element : a) {
			for(int j = 0 ; j<a[0].length; j++) {
				System.out.printf("\t%1$15.2f", roundOff(element[j],2));
			}
			System.out.println();
		}
		System.out.println();
	}

	// Print Array with 4 decimal points and elements aligned
	public static void printArray4dp(double [][]a) {
		for (double[] element : a) {
			for(int j = 0 ; j<a[0].length; j++) {
				System.out.printf("\t%1$15.2f", roundOff(element[j],4));
			}
			System.out.println("");
		}
		System.out.println();
	}

	public static void printArray(int []a) {
		for (int element : a) {
			System.out.print("\t" + element);
			System.out.println();
		}
	}

	public static void printArray(double []a) {
		for (double element : a) {
			System.out.print("\t" + element + "\n");
		}
	}

	public static void printArray(int [][]a) {
		for (int[] element : a) {
			for(int j = 0 ; j<a[0].length; j++) {
				System.out.print("\t" + element[j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printArray(double [][]a) {
		String strTemp="";
		for (double[] element : a) {
			strTemp="";
			for(int j = 0 ; j<a[0].length; j++) {
				strTemp+=String.format("\t%1$15.4f",element[j]);
			}
			System.out.println(strTemp);
		}
		System.out.println();
	}

	public static void printArray(String[] s) {
		String strTemp="";
		for (String element : s) {
			strTemp+=String.format("\t%1$15s",element);
		}
		System.out.println(strTemp);
	}


	/**
	 * Print n lines of empty lines.
	 * Deprecated.  Using "\n" for one empty line.
	 * @param n int
	 */
	public static void printEmptyLines(int n) {
		for(int i=0; i<n; i++) {
			System.out.println();
		}
	}

	/**
	 * Transposes and returns a 2-D array
	 * Note: The return transposed array is independent from the input array,
	 *       i.e., changes in the returned array are not reflected in the input
	 *       array, and vice-versa.
	 * @param a array input
	 * @return transposed array
	 */
	public static double[][] transpose(double[][]a) {
		double [][]b = new double[a[0].length][a.length];
		int I = a.length;
		int J = a[0].length;
		for (int i=0; i<I; i++) {
			for (int j=0; j<J; j++) {
				b[j][i] = a[i][j];
			}
		}
		return b;
	}

	/**
	 * Perform scalar-vector multiplication and return the result.
	 * @param scalar int
	 * @param b double[]
	 * @return double[]
	 */
	public static double[] scalarMult(int scalar, double[] b ) {
		double[] a = new double[b.length];
		for(int i=0; i<b.length; i++) {
			a[i] = scalar*b[i];
		}
		return a;
	}

	/**
	 * Constructs and returns a diagonal 2-D array (squared matrix of size s)
	 *   with 1-D array d on the diagonal entries and zeros on the off-diagonal
	 *   entries.
	 * @param d double[]
	 * @return double[][]
	 */
	public static double[][] diagonalArray(double[] d) {
		double[][] a = new double[d.length][d.length];
		for(int i=0; i<d.length; i++) {
			for(int j=0; j<d.length; j++) {
				if(i==j) {
					a[i][j] = d[i];
				} else {
					a[i][j] = 0.0;
				}
			}
		}
		return a;
	}

	/**
	 * Constructs and returns a diagonal 2-D array (squared matrix of size s)
	 *   with value d on the diagonal entries and zeros on the off-diagonal
	 *   entries.
	 * @param d double
	 * @param s int
	 * @return double[][]
	 */
	public static double[][] diagonalArray(double d, int s) {
		double[][] a = new double[s][s];
		for(int i=0; i<s; i++) {
			for(int j=0; j<s; j++) {
				if(i==j) {
					a[i][j] = d;
				} else {
					a[i][j] = 0.0;
				}
			}
		}
		return a;
	}

	/**
	 * Constructs and returns a 2-D identity array (squared matrix I of size s)
	 * @param s int
	 * @return int[][]
	 */
	public static int[][] identityArray(int s) {
		int[][] a = new int[s][s];
		for(int i=0; i<s; i++) {
			for(int j=0; j<s; j++) {
				if(i==j) {
					a[i][j] = 1;
				} else {
					a[i][j] = 0;
				}
			}
		}
		return a;
	}

	/**
	 * Constructs and returns a zero 2-D array (matrix) of I rows and J columns
	 * @param I int
	 * @param J int
	 * @return double[][]
	 */
	public static double[][] zeroArray(int I, int J) {
		double [][] a = new double[I][J];
		for(int i=0; i<I; i++) {
			for(int j=0; j<J; j++) {
				a[i][j] = 0.0;
			}
		}
		return a;
	}

	/**
	 * Trim the white space for each string in s.
	 * Modifies elements in place.
	 * @param s
	 */
	public static void trimAllStrings(String[] s){
		if(s == null) {
			return;
		}

		for(int i = 0; i < s.length; i++){
			s[i] = (s[i] != null) ? s[i] = s[i].trim() : null;
		}
	}

	//TODO: DOCS
	public static void copyFile(File src, File dest) throws IOException{
		if(!src.exists()) {
			throw new FileNotFoundException(src.getPath());
		}

		if(!dest.exists()) {
			dest.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(src).getChannel();
			destination = new FileOutputStream(dest).getChannel();
			destination.transferFrom(source, 0, source.size());
		}
		finally {
			if(source != null) {
				source.close();
			}
			if(destination != null) {
				destination.close();
			}
		}
	}

	public static void deleteFiles(List<File> files) {
		for(File f : files){
			if (f.exists()) {
				boolean succ = f.delete();
				if(!succ){
					System.err.println("Unable to delete " + f.getPath());
				}
			}
		}
	}

	/**
	 * Search the system path for a program.
	 * TODO-XX: Actually search for the program.
	 * @param string
	 * @return
	 */
	public static File findExecutableInPath(String programName) {
		return new File(programName);
	}

	public static String findExecutableOnPath(String name) {
		for (String dirname : (System.getenv("PATH")).split(File.pathSeparator)) {
			File file = new File(dirname, name);
			if (file.isFile() && file.canExecute()) {
				return file.getAbsolutePath();
			}
		}
		return "psst";
	}

	public static double parseDouble(String string) {
		// TODO Auto-generated method stub
		return Double.parseDouble(string.replace(",", "."));
	}

}
