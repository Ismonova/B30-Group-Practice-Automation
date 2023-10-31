package B30.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties = new Properties();

    static{
        try {
            //2- open file using FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);

            //close the file in the memory
            file.close();

        }catch(IOException e){

            System.out.println("FILE NOT FOUND WITH GIVEN PATH");
            e.printStackTrace();
        }

        //creat utility method to yse the object to read
//4-Use "properties" Object to read from the file (Read properties)


    }
    public static String getProperty (String keyword) {
        return properties.getProperty(keyword);
    }
}
