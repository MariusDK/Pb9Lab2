/**
 * Created by MariusDK on 31.03.2017.
 */
public class Matrice {
    private int dimensiune;
    private Integer[][] val;

    public Matrice(int dimensiune, Integer[][] val) {
        this.dimensiune = dimensiune;
        this.val = val;
    }

    public Matrice() {

        this.dimensiune = 0;
        this.val = null;
    }
    public Matrice(int dimensiune) {

        this.dimensiune = dimensiune;
        this.val = null;
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
    public Integer[][] copyvalue()
    {
        Integer[][] mat=new Integer[dimensiune][dimensiune];

            for (int i=0;i<val.length;i++)
            {
                for (int j=0;j<val.length;j++)
                {
                    mat[i][j]=val[i][j];
                }
            }

       return mat;
    }

    public void setVal(Integer[][] val) {
        this.val = val;
    }


    public void printMatrice()
    {
     for (int i=0;i<val.length;i++)
     {
         for (int j=0;j<val.length;j++)
         {
             System.out.print(val[i][j]+" ");
         }
         System.out.println();
     }
        System.out.println();
    }
}
