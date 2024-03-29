package designpatterns.composite;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Championnat extends Element {

    private String nom;

    private Set<Element> elts = new HashSet<>();

    public Championnat(int id, String nom) {
        super(id);
        this.nom = nom;
    }

    @Override
    public String toString() {
        StringBuilder aff = new StringBuilder(getId() + " " + nom + "\n");

        for (Element e : elts) {
            aff.append(e).append("\n");
        }
        return aff + "pricemoney totale " + nom + " = " + totPriceMoney() + "\n";
    }


    @Override
    public BigDecimal totPriceMoney() {
        BigDecimal total = BigDecimal.ZERO;
        for (Element elt : elts) {
            total = total.add(elt.totPriceMoney()) ;
        }
        return total;
    }

    public Set<Element> getElts() {
        return elts;
    }
}
