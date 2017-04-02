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


    public void printMatrice(Matrice tata)
    {
     for (int i=0;i<tata.getVal().length;i++)
     {
         for (int j=0;j<tata.getVal().length;j++)
         {
             System.out.print(val[i][j]+" ");
         }
         System.out.println();
     }
    }
}
