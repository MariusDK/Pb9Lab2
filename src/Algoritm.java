import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by MariusDK on 31.03.2017.
 */
public class Algoritm
{
    public boolean generarePotentialeSoluti(Matrice initiala,Arbore a,Matrice finala)
    {
        Queue<Matrice> coada = new LinkedList<Matrice>();
        coada.add(initiala);
        Nod x=new Nod();
        x.setVal(initiala);
        a.setRadacina(x);
        while (!coada.isEmpty())
        {
            Matrice current=coada.remove();
            Nod y=new Nod();
            y.setVal(current);
            Integer[][] drp=current.copyvalue();
            Matrice next1= new Matrice(drp.length,drp);
            retCdreapta(next1);
            if (valid(next1,x))
            {
                coada.add(next1);
                Nod c=new Nod();
                c.setVal(next1);
                a.addArbore(y,c);
            }
            Integer[][] drp2=current.copyvalue();
            Matrice next2= new Matrice(drp2.length,drp2);
            retCStanga(next2);
            if (valid(next2,x))
            {
                coada.add(next2);
                Nod c=new Nod();
                c.setVal(next2);
                a.addArbore(y,c);
            }
            Integer[][] drp3=current.copyvalue();
            Matrice next3= new Matrice(drp.length,drp3);
            retCJos(next3);
            if (valid(next3,x))
            {
                coada.add(next3);
                Nod c=new Nod();
                c.setVal(next3);
                a.addArbore(y,c);
            }
            Integer[][] drp4=current.copyvalue();
            Matrice next4= new Matrice(drp.length,drp4);
            retCSus(next4);
            if (valid(next4,x))
            {
                coada.add(next4);
                Nod c=new Nod();
                c.setVal(next4);
                a.addArbore(y,c);
            }
            if (bfs(finala,x))
            {
                return true;
            }
        }
        return false;
    }
    public boolean generarePotentialeSolutiGbfs(Matrice initiala,Arbore a,Matrice finala)
    {
        Queue<Matrice> coada = new LinkedList<Matrice>();
        coada.add(initiala);
        Nod x=new Nod();
        x.setVal(initiala);
        a.setRadacina(x);
        while (!coada.isEmpty())
        {
            Matrice current=coada.remove();
            Nod y=new Nod();
            y.setVal(current);
            Integer[][] drp=current.copyvalue();
            Matrice next1= new Matrice(drp.length,drp);
            retCdreapta(next1);
            if (valid(next1,x))
            {
                coada.add(next1);
                Nod c=new Nod();
                c.setVal(next1);
                a.addArbore(y,c);
            }
            Integer[][] drp2=current.copyvalue();
            Matrice next2= new Matrice(drp2.length,drp2);
            retCStanga(next2);
            if (valid(next2,x))
            {
                coada.add(next2);
                Nod c=new Nod();
                c.setVal(next2);
                a.addArbore(y,c);
            }
            Integer[][] drp3=current.copyvalue();
            Matrice next3= new Matrice(drp.length,drp3);
            retCJos(next3);
            if (valid(next3,x))
            {
                coada.add(next3);
                Nod c=new Nod();
                c.setVal(next3);
                a.addArbore(y,c);
            }
            Integer[][] drp4=current.copyvalue();
            Matrice next4= new Matrice(drp.length,drp4);
            retCSus(next4);
            if (valid(next4,x))
            {
                coada.add(next4);
                Nod c=new Nod();
                c.setVal(next4);
                a.addArbore(y,c);
            }
            if (GreedyBfs(finala,x))
            {
                return true;
            }
        }
        return false;
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
                //System.out.println(tata.getVal()[i][j]);
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
            if (MatriciEgale(nod.getVal(),s)) {
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
    public boolean MatriciEgale(Matrice a,Matrice b)
    {
        int k=0;
        for (int i=0;i<a.getDimensiune();i++)
        {
            for (int j=0;j<a.getDimensiune();j++)
            {
                if (a.getVal()[i][j]==b.getVal()[i][j])
                {
                    k++;
                }
            }
        }
        if (k!=(a.getDimensiune()*a.getDimensiune()))
        {
            return false;
        }
        return true;
    }
    public boolean bfs(Matrice s,Nod radacina) {
        Queue<Nod> queue = new LinkedList<Nod>();
        if (radacina == null) {
            return false;
        }
        queue.clear();
        queue.add(radacina);
        while (!queue.isEmpty()) {
            Nod nod = queue.remove();
//            System.out.print(node.element + " ");
            if (MatriciEgale(nod.getVal(),s)) {
                return true;
            }
            if (nod.getCopil() != null) {
                for (Nod c : nod.getCopil()) {
                    queue.add(c);
                }
            }
        }
        return false;
    }
    //distanta Manhattan
    public int Heuristic(Matrice x,Matrice y)
    {
     //ArrayList<Integer> xList=convertMatrix(x);
     //ArrayList<Integer> yList=convertMatrix(y);
     int k=0;
     for (int i=0;i<x.getDimensiune();i++)
     {
         for (int j=0;j<x.getDimensiune();j++)
         {
             if (x.getVal()[i][j]!=0)
             {
                 k= k+Math.abs(i-getI(y,x.getVal()[i][j])) + Math.abs(j-getJ(y,x.getVal()[i][j]));
             }
         }
     }
     return k;
    }
    public int getI(Matrice a,int val)
    {
        if (val==0)
        {
            return 0;
        }
        for (int i=0;i<a.getDimensiune();i++)
        {
            for (int j=0;j<a.getDimensiune();j++)
            {
                if (a.getVal()[i][j]==val)
                {
                 return i;
                }
            }
        }
        return 0;
    }
    public int getJ(Matrice a,int val)
    {
        if (val==0)
        {
            return 0;
        }
        for (int i=0;i<a.getDimensiune();i++)
        {
            for (int j=0;j<a.getDimensiune();j++)
            {
                if (a.getVal()[i][j]==val)
                {
                    return j;
                }
            }
        }
        return 0;
    }
//    public ArrayList<Integer> convertMatrix(Matrice x)
//    {
//        ArrayList<Integer> a=new ArrayList<>();
//        for (int i=0;i<x.getVal().length;i++)
//        {
//            for (int j=0;j<x.getVal().length;j++)
//                if ()
//                a.add(x.getVal()[i][j]);
//        }
//        return a;
//    }
    public boolean GreedyBfs(Matrice s,Nod radacina)
    {
        Stack<Nod> Stiva=new Stack<>();
        if (radacina == null) {
            return false;
        }
        Stiva.add(radacina);
        while (!Stiva.isEmpty()) {
            Nod nod = Stiva.pop();
            if (Heuristic(nod.getVal(),s)==0) {
                return true;
            }

            if (nod.getCopil().size() != 0) {
                Nod c1=nod.getCopil().get(0);
                for (Nod c : nod.getCopil()) {
                    if (Heuristic(c1.getVal(),s)>Heuristic(c.getVal(),s)) {
                        c1=c;
                    }
                }
                Stiva.push(c1);
            }
        }
        return false;

    }
}
