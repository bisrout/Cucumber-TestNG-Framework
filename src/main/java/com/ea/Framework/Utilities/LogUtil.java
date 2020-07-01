package com.ea.Framework.Utilities;

import javax.swing.text.DateFormatter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    //File Format for log name
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format(formatter);
    private BufferedWriter bufferedWriter = null;

    //Create Log File
    public void CreateLogFile()
    {
        try
        {
            File dir = new File("C:\\UdemyCourse_1\\Logs");
            if(!dir.exists())
                dir.mkdir();
            File logfile = new File(dir+"\\"+fileNameFormat+".txt");
            FileWriter fileWriter = new FileWriter(logfile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

        }
        catch(Exception e){
            e.getStackTrace();

        }
    }
    //Write messege within the logs
    public void Write(String message)
    {
        try
        {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
            String dateFormat = date.format(formatter);
            bufferedWriter.write("["+dateFormat+"]"+message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        {

        }
    }

}
