import java.util.Queue;

/**
 * Created by MariusDK on 31.03.2017.
 */
public class Algoritm
{
    public void generarePotentialeSoluti(Matrice m)
    {
        Queue<Matrice> coada = null;
        coada.add(m);
        Arbore a=new Arbore();
        Nod x=new Nod();
        x.setVal(m);
        a.setRadacina(x);
        while (!coada.isEmpty())
        {
            Matrice current=coada.remove();
            x.setVal(current);
            if (a.valid(current.retCdreapta(current),x))
            {
                coada.add(current.retCdreapta(current));
                Nod c=new Nod();
                c.setVal(current.retCdreapta(current));
                a.addArbore(x,c);
            }
            if (a.valid(current.retCStanga(current),x))
            {
                coada.add(current.retCStanga(current));
                Nod c=new Nod();
                c.setVal(current.retCStanga(current));
                a.addArbore(x,c);
            }
            if (a.valid(current.retCJos(current),x))
            {
                coada.add(current.retCJos(current));
                Nod c=new Nod();
                c.setVal(current.retCJos(current));
                a.addArbore(x,c);
            }
            if (a.valid(current.retCSus(current),x))
            {
                coada.add(current.retCSus(current));
                Nod c=new Nod();
                c.setVal(current.retCSus(current));
                a.addArbore(x,c);
            }
        }
    }














}
