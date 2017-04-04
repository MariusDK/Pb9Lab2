import java.util.ArrayList;

/**
 * Created by MariusDK on 31.03.2017.
 */
public class Nod
{
    private Matrice val;
    public ArrayList<Nod> copil;

    public Nod() {
        this.val = null;
        this.copil = new ArrayList<>();
    }
    public Nod(Matrice val, ArrayList<Nod> copil) {

        this.val = val;
        this.copil = copil;
    }

    public Matrice getVal() {
        return val;
    }

    public void setVal(Matrice val) {
        this.val = val;
    }


    public ArrayList<Nod> getCopil() {
        return copil;
    }

    public void setCopil(ArrayList<Nod> copil) {
        this.copil = copil;
    }
//    public void printMatrice()
//    {
//        for (int i=0;i<val.length;i++)
//        {
//            for (int j=0;j<val.length;j++)
//            {
//                System.out.print(val[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
}