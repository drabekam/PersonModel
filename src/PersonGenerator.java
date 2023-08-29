import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;



public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<String> userList = new ArrayList<>();
        String userInput = "";


        userInput = String.valueOf(SafeInput.getInt(in, "Enter number and then when you are done enter done"));
        userList.add(userInput);

        while (!userInput.equalsIgnoreCase("done")) {

            userInput = in.nextLine();

            if (!userInput.equalsIgnoreCase("done")) {
                userList.add(userInput);
            } else {
                break;
            }

        }

        System.out.println("Entered Numbers:");
        for (String number : userList){
            System.out.println(number);


        }
    }
}