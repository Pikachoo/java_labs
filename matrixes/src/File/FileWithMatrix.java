package File;

import Matrix.MatrixElement;
import Matrix.MatrixTemplate;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by nastya on 23.02.14.
 */
public class FileWithMatrix<T extends AbstractList<MatrixElement>>
{
    static int currentIndex = -1;

    private static Integer next(String numbers[])
    {
        ++currentIndex;
        while (currentIndex < numbers.length
                && numbers[currentIndex].equals(""))
            ++currentIndex;
        return currentIndex < numbers.length ? Integer
                .parseInt(numbers[currentIndex]) : null;
    }

    public static String readFileAsString(String fileName)
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
            } finally
            {
                in.close();
            }


        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void writeToFile(String fileName, String text)
    {
        try
        {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try
            {
                out.print(text);
            } finally
            {
                out.close();
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public MatrixTemplate<T> readMatrix(String fileName, T list)
    {
        String text = new String(this.readFileAsString(fileName));

        String[] numbers = text.split("\\D");


        int n = next(numbers), m = next(numbers);

        String data = "";

        data = list.getClass().toString();

        if (data.contains("class java.util.LinkedList"))
        {
            MatrixTemplate<LinkedList<MatrixElement>> matrix = new MatrixTemplate<LinkedList<MatrixElement>>(n, m, new LinkedList<MatrixElement>());
            this.writeInMatrix((MatrixTemplate<T>)matrix, numbers);
            return (MatrixTemplate<T>)matrix;
        }
        else
        {
            MatrixTemplate<ArrayList<MatrixElement>> matrix = new MatrixTemplate<ArrayList<MatrixElement>>(n, m, new ArrayList<MatrixElement>());
            this.writeInMatrix((MatrixTemplate<T>)matrix, numbers);
            return (MatrixTemplate<T>)matrix;
        }


    }
    private void writeInMatrix(MatrixTemplate<T> matrix, String[] numbers)
    {
        int i, j;
        int n = matrix.getRows();
        int m = matrix.getCols();
        int matr[][] = new int[n][m];
        for (i = 0; i < n; i++)
            for (j = 0; j < m; ++j)
                matr[i][j] = next(numbers);

        for (i = 0; i < n; ++i, System.out.println())
            for (j = 0; j < m; ++j)
            {
                matrix.putElement(i, j, matr[i][j]);
            }

    }

    public void writeMatrix(String fileName, MatrixTemplate<T> matrix)
    {
        String stringToFile = matrix.showMatrix();
        this.writeToFile(fileName,stringToFile);
    }

    public static boolean isExists(String fileName)
    {
        File file = new File(fileName);

        return file.exists();
    }


}
