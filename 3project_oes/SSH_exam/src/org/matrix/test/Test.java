package org.matrix.test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i=0;
		abc:while(i<10){
			for(int j=0;j<10;j++){
				if(i==3){
					break abc;
				}
			}
			i++;
		}
		System.out.println(i);
	}
	
}
