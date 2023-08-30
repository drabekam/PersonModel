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
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        String ID = "";
        String fName = "";
        String lastname = "";
        String title = "";
        int YOB = 0;
        String PersonFile = "";
        boolean stopper = true;

        Scanner in = new Scanner(System.in);

        ArrayList<String> recs = new ArrayList<>();


        //loop and collect data for the person records into the array list

        while(stopper) {

            //get the five data fields

            ID = SafeInput.getNonZeroLenString(in, "Enter the ID");
            fName = SafeInput.getNonZeroLenString(in, "Enter first name");
            lastname = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getRangedInt(in, "enter the year of birth", 1000, 9999);

            PersonFile = ID + ", " + fName + ", " + lastname + ", " + title + ", " + YOB;

            recs.add(PersonFile);

            stopper = SafeInput.getYNConfirm(in, "Do you need to enter another person?");
        }
        {
            // Test data the lines of the file we will write
            //ArrayList <String>recs = new ArrayList<>();


            // uses a fixed known path:
            Path file = Paths.get("/users/andrewdrabek/school/Programming 2/PersonModel/src/PersonTestData.txt");

            // use the toolkit to get the current working directory of the IDE
            // will create the file within the Netbeans project src folder
            // (may need to adjust for other IDE)
            // Not sure if the toolkit is thread safe...
            //File workingDirectory = new File(System.getProperty("user.dir"));
            //Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

            try
            {
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                OutputStream out =
                        new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer =
                        new BufferedWriter(new OutputStreamWriter(out));

                // Finally can write the file LOL!

                for(String rec : recs)
                {
                    writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                    // 0 is where to start (1st char) the write
                    // rec. length() is how many chars to write (all)
                    writer.newLine();  // adds the new line

                }
                writer.close(); // must close the file to seal it and flush buffer
                System.out.println("Data file written!");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }
}