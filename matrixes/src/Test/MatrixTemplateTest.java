package Test;

/**
 * Created by Admin on 28.04.14.
 */

import Matrix.MatrixElement;
import Matrix.MatrixTemplate;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by nastya on 08.04.14.
 */
import  junit.framework.Assert;
import  org.junit.Test;
import  org.apache.log4j.Logger;

import java.util.ArrayList;

public class MatrixTemplateTest extends Assert
{
    private static final Logger log = Logger.getLogger(MatrixTemplateTest.class);

    @Test
    public void testPutElement() throws Exception
    {
        MatrixTemplate<ArrayList<MatrixElement>> A = new MatrixTemplate<ArrayList<MatrixElement>>(5,5,new ArrayList<MatrixElement>());

        A.putElement(1,1,1);

        assertEquals(false,A.putElement(1,1,1));

        log.debug("testPutElement() passed");
    }

    @Test

    public void testIsEmpty() throws Exception
    {
        MatrixTemplate<ArrayList<MatrixElement>> A = new MatrixTemplate<ArrayList<MatrixElement>>(5,5,new ArrayList<MatrixElement>());

        A.zero_matrix();

        assertEquals(true,A.isEmpty());

        log.warn("testIsEmpty() passed");

    }

}

