package test;

import java.util.ArrayList;
import metier.Trolley;
import util.Reader;
import util.Recherche;

/**
 * Classe permettant de tester la classe Recherche.
 */
public class TestRecherche {
    public static void main(String[] args) throws Exception {    
        Reader r = new Reader("instance_200000.txt", false);

        Recherche sol = new Recherche(r.getOrders(), r.getProducts(),r.getNbBoxesTrolley(), r.getCapaBox().get(0), r.getCapaBox().get(1),r.getInstance());
        ArrayList<Trolley> solutions = sol.lookup();
        System.out.println(solutions);
        System.out.println("Coût de la solution (à vol d'oiseau): " + sol.getCout());
    }
}