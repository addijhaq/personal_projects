package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);

	System.out.println("Please type in a word to check if it is indeed a palindrome.");

	String word = s.nextLine().toLowerCase();

	char[] forward = word.toCharArray();
	char[] backward = new char[word.length()];
	for (int i = 0, j=word.length()-1;i<word.length(); i++,j-- ){
	    backward[i] = forward[j];
    }
    String forwardWord = new String(forward);
    String backwardWord = new String(backward);


    if(forwardWord.equals(backwardWord)){
        System.out.println("the word is a palindrome");
    }else {
        System.out.println("the word is not a palindrome");
    }


    }
}
