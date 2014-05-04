package WorkWithFile;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import  org.apache.log4j.Logger;

/**
 * Created by nastya on 23.02.14.
 */
public class FileWR
{
    private static final Logger log = Logger.getLogger(FileWR.class);

    public static String read(String fileName)
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try
            {
                String s;
                while ((s = in.readLine()) != null)
                {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            finally
            {
                in.close();
            }


        }
        catch (IOException e)
        {
            log.error(e);
//            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static boolean write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();

            }

            return true;
        }
        catch(IOException e)
        {
            log.error(e);
            return false;
//            throw new RuntimeException(e);

        }

    }


    public String showStatisticsOfChars(String fileName)
    {
        String file = this.read(fileName);
        file = file.toLowerCase();

        int startLength = file.length();

        char[] fileOfChar = file.toCharArray();
        Arrays.sort(fileOfChar);

        String outPutString = "";
        int count = 1;
        for(int i = 0,j=1; j < fileOfChar.length;i++,j++ )
        {
            char currentCharacter = fileOfChar[i];
            char nextCharacter = fileOfChar[j];

            if(currentCharacter <=97 || currentCharacter >=123)
            {
                continue;
            }

           if(currentCharacter != nextCharacter)
           {

               double result = new BigDecimal((double)count/startLength).setScale(2, RoundingMode.UP).doubleValue();
               outPutString = outPutString+fileOfChar[i] + " - "+ result  + "\n";
               count = 1;
           }
            else
           {
               count++;
           }

        }
        return outPutString;
    }



}
