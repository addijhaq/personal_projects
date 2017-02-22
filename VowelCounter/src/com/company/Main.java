package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Character[] vowels = {'A','E','I','O','U'};
        int vowelcount = 0;
        boolean next = true;
        Scanner s = new Scanner(System.in);

        while(next){
            System.out.println("Please type a word");
            String word = s.nextLine();
            if(word.toLowerCase().equals("exit")){
                System.exit(1);
            }
            for(Character c: word.toCharArray()){
                for (int i = 0; i<vowels.length; i++){
                    if(c.toString().toLowerCase().equals(vowels[i].toString().toLowerCase())){
                    vowelcount+=1;
                    }
                }

            }
            if(vowelcount>1) {
                System.out.println("There are " + vowelcount + " vowels in your word.");
            } else{
                System.out.println("There is 1 vowel in your word");
            }
            vowelcount = 0;
        }

    }
}
