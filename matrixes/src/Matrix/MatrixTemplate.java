package Matrix;


import java.io.*;
import java.util.*;




/**
 * Created by Admin on 21.02.14.
 */
public class MatrixTemplate< T extends AbstractList<MatrixElement>> implements Serializable
{
    private int cols;
    private int rows;
    private T Matrix;

    public void setCols(int cols)
    {
        if(cols > 0)
            this.cols = cols;
    }
    public  int getCols()
    {
        return this.cols;
    }

    public void setRows(int rows)
    {
        if(rows > 0)
            this.rows = rows;
    }
    public int getRows()
    {
        return this.rows;
    }

    public boolean putElement( int n, int m, int a)
    {
        if (this.isExists(n,m))
            return false;
        if (n > this.getRows()&& n < 0)
            return false;
        if (m > this.getCols() && m < 0)
            return false;
        MatrixElement newElement = new MatrixElement(n, m, a);
        Matrix.add(newElement);
        return true;
    }



    public int getElement(int n, int m)
    {
        if (n > this.getRows()&& n < 0)
            return 0;
        if (m > this.getCols() && m < 0)
            return 0;

        for(MatrixElement item : Matrix)
        {
            if(item.getCol() == m && item.getRow() == n)
            {
                return item.getElement();

            }
        }
        return 0;

    }

    public void setMatrix(T matrix)
    {
        this.Matrix = matrix;
    }
    public T getMatrix()
    {

        return this.Matrix;
    }


    public MatrixTemplate(int n, int m,  T list)
    {
        this.setRows(n);
        this.setCols(m);

        String data = "";

        data = list.getClass().toString();
        if (data.contains("class java.util.LinkedList"))
        {
            Matrix = (T) new LinkedList<MatrixElement>();
        }
        else if (data.contains("class java.util.ArrayList"))
        {
             Matrix = (T) new ArrayList<MatrixElement>();
        }
    }

    public void rand()
    {
        Random rand = new Random();

        for (int j = 0; j < this.getRows(); j++)
        {
            for (int i = 0; i < this.getCols(); i++)
            {
                this.putElement(j, i, rand.nextInt(9));
            }
        }
    }


    public boolean isExists(int col, int row)
    {
        for(MatrixElement item : this.Matrix)
        {
            if(item.isEqual(col, row))
            {
                return true;
            }
        }
        return false;
    }

    public void zero_matrix()
    {
        for(int i = 0; i < this.cols; i++)
        {
            for(int j = 0; j < this.rows; j++)
            {
                this.Matrix.add(new MatrixElement(i,j,0));

            }
        }
    }

    public boolean isEmpty()
    {
        for(MatrixElement item : this.Matrix)
        {
            if( item.getElement() != 0)
            {
                return false;
            }

        }
        return true;
    }



    public String showMatrix()
    {
        String outPutString = "";
        outPutString = outPutString + this.getRows() + " "+ this.getCols()+"\n";
        for (int i = 0; i < this.getRows(); i++)
        {
            for (int j = 0; j < this.getCols(); j++)
            {
                outPutString = outPutString + this.getElement(i, j)+" ";
            }
            outPutString = outPutString + "\n";
        }
        return outPutString;

    }


    public MatrixTemplate mullMatrix(MatrixTemplate B)
    {

        MatrixTemplate C = new MatrixTemplate(this.getRows(), B.getCols(), B.Matrix);
        if(this.cols != B.rows)
            return  null;

        for (int i = 0; i < this.getRows(); i++)
        {
            for (int p = 0; p < B.getCols(); p++)
            {
                int cip = 0;
                for(int j = 0, k = 0; j < this.getCols() && k < B.getRows(); j++, k++)
                {
                    int aij = this.getElement(i, j);
                    int bkp = B.getElement(k, p);
                    cip = cip + (aij * bkp);
                    C.putElement(i, p, cip);

                }
            }
        }
        return C;
    }


    public boolean writeObj(String path)
    {
        try
        {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(path));

            file.writeObject(this);
            file.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();

            return false;
        }

        return true;
    }

    public MatrixTemplate<T> readObj(String path)
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

            MatrixTemplate<T> obj = (MatrixTemplate<T>) in.readObject();

            this.Matrix = obj.Matrix;
            this.cols = obj.cols;
            this.rows = obj.rows;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


}