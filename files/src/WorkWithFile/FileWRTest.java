package WorkWithFile;

/**
 * Created by nastya on 10.04.14.
 */
import  junit.framework.Assert;
import  org.junit.Test;
import  org.apache.log4j.Logger;

import java.util.ArrayList;

public class FileWRTest extends Assert
{
    private static final Logger log = Logger.getLogger(FileWRTest.class);

    @Test

    public void testWrite() throws Exception
    {
        FileWR f = new FileWR();

        f.write("/home/nastya/Desktop/primer","I am here");

        assertEquals(false,f.write("/home/nastya/Desktop/primer","I am here"));

        log.debug("testWrite passed");
    }

}
