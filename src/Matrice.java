/**
 * Created by MariusDK on 31.03.2017.
 */
public class Matrice {
    private int dimensiune;
    private Integer[][] val;


    public Matrice() {

        this.dimensiune = 0;
        this.val = null;
    }
    public Matrice(int dimensiune, Integer[][] val) {

        this.dimensiune = dimensiune;
        this.val = val;
    }

    public int getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(int dimensiune) {
        this.dimensiune = dimensiune;
    }

    public Integer[][] getVal() {
        return val;
    }

    public void setVal(Integer[][] val) {
        this.val = val;
    }

    public Matrice retCdreapta(Matrice tata)
    {
        int val;
        for (int i=0;i<tata.getVal().length;i++)
        {
            for (int j=0;j<tata.getVal().length;i++)
            {
                if (tata.getVal()[i][j]==0)
                {
                    if (j==0)
                    {
                        return tata;
                    }
                    else
                    {
                        val=tata.getVal()[i][j+1];
                        tata.getVal()[i][j+1]=0;
                        tata.getVal()[i][j]=val;
                        return tata;
                    }
                }
            }
        }
        return tata;
    }
    public Matrice retCStanga(Matrice tata)
    {
        int val;
        for (int i=0;i<tata.getVal().length;i++)
        {
            for (int j=0;j<tata.getVal().length;i++)
            {
                if (tata.getVal()[i][j]==0)
                {
                    if (j==0)
                    {
                        return tata;
                    }
                    else
                    {
                        val=tata.getVal()[i][j-1];
                        tata.getVal()[i][j-1]=0;
                        tata.getVal()[i][j]=val;
                        return tata;
                    }
                }
            }
        }
        return tata;
    }
    public Matrice retCSus(Matrice tata)
    {
        int val;
        for (int i=0;i<tata.getVal().length;i++)
        {
            for (int j=0;j<tata.getVal().length;i++)
            {
                if (tata.getVal()[i][j]==0)
                {
                    if (i==0)
                    {
                        return tata;
                    }
                    else
                    {
                        val=tata.getVal()[i-1][j];
                        tata.getVal()[i-1][j]=0;
                        tata.getVal()[i][j]=val;
                        return tata;
                    }
                }
            }
        }
        return tata;
    }
    public Matrice retCJos(Matrice tata)
    {
        int val;
        for (int i=0;i<tata.getVal().length;i++)
        {
            for (int j=0;j<tata.getVal().length;i++)
            {
                if (tata.getVal()[i][j]==0)
                {
                    if (i==tata.getVal().length-1)
                    {
                        return tata;
                    }
                    else
                    {
                        val=tata.getVal()[i-1][j];
                        tata.getVal()[i-1][j]=0;
                        tata.getVal()[i][j]=val;
                        return tata;
                    }
                }
            }
        }
        return tata;
    }





}
