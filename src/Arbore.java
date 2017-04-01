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

    public void addArbore(Nod Parinte,Nod current)
    {
        if (radacina==null)
        {
            radacina=current;
        }else{
            if(Parinte==radacina)
            {
                radacina.copil.add(current);
            }
        else{
                for (int i = 0; i < radacina.copil.size(); i++)
                {
                    radacina=radacina.copil.get(i);
                    addArbore(Parinte,current);
                }
            }
        }
    }
    //validare pe parcurgere tot bnf
    public boolean valid(Matrice s,Nod radacina) {
        Queue<Nod> queue = new LinkedList<Nod>();
        if (radacina == null) {
            return true;
        }
        queue.clear();
        queue.add(radacina);
        while (!queue.isEmpty()) {
            Nod nod = queue.remove();
//            System.out.print(node.element + " ");
            if (nod.getVal() == s) {
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
}
