import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by MariusDK on 31.03.2017.
 */
public class Algoritm
{
    public void generarePotentialeSoluti(Matrice m,Arbore a)
    {
        Queue<Matrice> coada = new LinkedList<Matrice>();

        coada.add(m);
        //Arbore a=new Arbore();
        Nod x=new Nod();
        x.setVal(m);
        a.setRadacina(x);
        while (!coada.isEmpty())
        {
            Matrice current=coada.remove();
            Nod y=new Nod();
            y.setVal(current);
            //x.setVal(current);
            //System.out.println(current.retCdreapta(current));
            Matrice drp=retCdreapta(current);
            if (valid(drp,y))
            {
                coada.add(retCdreapta(current));
                Nod c=new Nod();
                c.setVal(retCdreapta(current));
                a.addArbore(x,c);
            }
            if (valid(retCStanga(current),x))
            {
                coada.add(retCStanga(current));
                Nod c=new Nod();
                c.setVal(retCStanga(current));
                a.addArbore(x,c);
            }
            if (valid(retCJos(current),x))
            {
                coada.add(retCJos(current));
                Nod c=new Nod();
                c.setVal(retCJos(current));
                a.addArbore(x,c);
            }
            if (valid(retCSus(current),x))
            {
                coada.add(retCSus(current));
                Nod c=new Nod();
                c.setVal(retCSus(current));
                a.addArbore(x,c);
            }
        }
    }
    public Matrice retCdreapta(Matrice tata)
    {
        Matrice fiu=tata;
        int val;
        for (int i=0;i<fiu.getVal().length;i++)
        {
            for (int j=0;j<fiu.getVal().length;j++)
            {
                if (fiu.getVal()[i][j]==0)
                {
                    if (i==fiu.getVal().length-1)
                    {
                        return fiu;
                    }
                    else
                    {
                        val=fiu.getVal()[i+1][j];
                        fiu.getVal()[i+1][j]=0;
                        fiu.getVal()[i][j]=val;
                        return fiu;
                    }
                }
            }
        }
        return fiu;
    }
    public Matrice retCStanga(Matrice tata)
    {
        int val;
        for (int i=0;i<tata.getVal().length;i++)
        {
            for (int j=0;j<tata.getVal().length;j++)
            {
                System.out.println(tata.getVal()[i][j]);
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
    public Matrice retCSus(Matrice tata)
    {
        int val;
        for (int i=0;i<tata.getVal().length;i++)
        {
            for (int j=0;j<tata.getVal().length;j++)
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
    public Matrice retCJos(Matrice tata)
    {
        int val;
        for (int i=0;i<tata.getVal().length;i++)
        {
            for (int j=0;j<tata.getVal().length;j++)
            {
                if (tata.getVal()[i][j]==0)
                {
                    if (j==tata.getVal().length-1)
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
