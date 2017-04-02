import java.util.Scanner;

/**
 * Created by MariusDK on 02.04.2017.
 */
public class Main {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduceti dimensiunea pazalului: ");
        int n=sc.nextInt();
        Integer[][] m=new Integer[n][n];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                System.out.println("a["+i+","+j+"]=");
                m[i][j]=sc.nextInt();
            }
        }
        Matrice a= new Matrice(n,m);
        Arbore ab=new Arbore();

        Algoritm am=new Algoritm();
        am.generarePotentialeSoluti(a,ab);
        ab.printArbore();
    }

}
