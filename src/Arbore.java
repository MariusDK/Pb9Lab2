import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by MariusDK on 31.03.2017.
 */
public class Arbore {
    private Nod radacina;
    //private int dimensiune;

    public Arbore() {
        this.radacina = null;
        //this.dimensiune = 0;

    }

    public Arbore(Nod radacina) {
        this.radacina = radacina;
        //this.dimensiune = dimensiune;
    }

    public Nod getRadacina() {
        return radacina;
    }

    public void setRadacina(Nod radacina) {
        this.radacina = radacina;
    }

//    public int getDimensiune() {
//        return dimensiune;
//    }
//
//    public void setDimensiune(int dimensiune) {
//        this.dimensiune = dimensiune;
//    }

//    public void addArbore(Nod Parinte,Nod current)
//    {
//        if (radacina==null)
//        {
//            radacina=current;
//        }else{
//            if(Parinte.getVal()==radacina.getVal())
//            {
//                    radacina.copil.add(current);
//            }
//        else{
//                for (int i = 0; i < radacina.getCopil().size(); i++)
//                {
//                    radacina=radacina.getCopil().get(i);
//                    addArbore(Parinte,current);
//                }
//            }
//        }
//    }
    public boolean addArbore(Nod Parinte,Nod current) {
        Algoritm a=new Algoritm();
        Queue<Nod> queue = new LinkedList<Nod>();
        if (radacina == null) {
            return false;
        }
        queue.clear();
        queue.add(radacina);
        while (!queue.isEmpty())
        {
            Nod nod = queue.remove();
//            System.out.print(node.element + " ");
            if (a.MatriciEgale(nod.getVal(),Parinte.getVal()))
            {
                nod.copil.add(current);
                return false;
            }
            if (nod.getCopil() != null) {
                for (Nod c : nod.getCopil()) {
                    queue.add(c);
                }
            }
        }
        return true;
    }
    //validare pe parcurgere tot bnf



    public void printArbore() {
        Queue<Nod> queue = new LinkedList<Nod>();
        if (radacina == null) {
            System.out.println("Null");
        }
        queue.clear();
        queue.add(radacina);
        while (!queue.isEmpty()) {
            Nod nod = queue.remove();
            nod.getVal().printMatrice();

            if (nod.getCopil() != null) {
                for (Nod c : nod.getCopil()) {
                    queue.add(c);
                }
            }
        }

    }
}
