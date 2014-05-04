package Matrix;

import java.io.Serializable;

/**
 * Created by nastya on 21.02.14.
 */
public class MatrixElement implements Serializable
{
    private int col;
    private int row;
    private int element;


    public void setCol(int col){
        if (col >= 0)
            this.col = col;
    }
    public int getCol()
    {
        return this.col;
    }

    public void setRow(int row){
        if(row >= 0)
            this.row = row;
    }
    public int getRow()
    {
        return this.row;
    }

    public void setElement(int element)
    {
        this.element = element;
    }
    public int getElement()
    {
        return this.element;
    }

    public boolean isEqual(int col, int row)
    {
        if(this.col == col && this.row == row)
        {
            return true;
        }
        return false;
    }

    public MatrixElement(int row, int col, int element)
    {
        this.col = col;
        this.row = row;
        this.element = element;

    }

}
