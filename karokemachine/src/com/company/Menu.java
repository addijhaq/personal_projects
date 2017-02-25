package com.company;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by addisonulhaq on 2/25/17.
 */
public class Menu {
    private PrintWriter out;
    private Scanner in;

    public Menu(InputStream input, OutputStream output){
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);

    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while(choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        out.println();
        for(int i = 0; i < options.length; i++) {
            int optionNum = i+1;
            out.println(optionNum+") "+options[i]);
        }
        out.println("0) Return to Previous Menu");
        out.println("Q) Quit");
        out.flush();
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();
        if(userInput.toLowerCase().equals("q")){
            System.exit(0);
        }
        try {
            int selectedOption = Integer.valueOf(userInput);
            if(selectedOption == 0){
                choice ="RETURN_TO_PREVIOUS";
                return choice;

            }
            if(selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }

        } catch(NumberFormatException e) {
            // eat the exception, an error message will be displayed below since choice will be null
            System.out.println();
            System.out.println("Please make a valid selection");
            choice = null;
            return choice;
        }
        if(choice == null) {
            out.println("\n*** "+userInput+" is not a valid option ***\n");
        }
        return choice;
    }

    public String getUserInputToString(){
        String userInput = in.nextLine();
        return userInput;
    }
}
