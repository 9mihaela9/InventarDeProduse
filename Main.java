package Solution;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Produs> inventar = new ArrayList<>();

        adaugaProdus(inventar, new Produs(1, "Lapte", 3.99, 10));
        adaugaProdus(inventar, new Produs(2,"Lapte Capra",16546,1));
        adaugaProdus(inventar, new Produs(3,"Lapte Vaca",16545,1));

        adaugaProdus(inventar, new Produs(4, "Paine", 1.99, 20));
        adaugaProdus(inventar, new Produs(5, "Ciocolata", 2.49, 15));


        actualizeazaStoc(inventar, 2, 25);

        stergeProdus(inventar, 1);


        List<Produs> produseDisponibile = obtineToateProdusele(inventar);
        System.out.println("Produse disponibile:");
        for (Produs produs : produseDisponibile) {
            System.out.println(produs.getNume());
        }


        String numeProdusCautat = "Paine";
        Produs produsGasit = cautaProdusDupaNume(inventar, numeProdusCautat);
        if (produsGasit != null) {
            System.out.println("Produs găsit: " + produsGasit.getNume());
        } else {
            System.out.println("Produsul nu a fost găsit.");
        }
    }

    public static void adaugaProdus(List<Produs> inventar, Produs produs) {
        inventar.add(produs);
    }

    public static void actualizeazaStoc(List<Produs> inventar, int idProdus, int stocNou) {
        for (Produs produs : inventar) {
            if (produs.getId() == idProdus) {
                produs.setStoc(stocNou);
                break;
            }
        }
    }

    public static void stergeProdus(List<Produs> inventar, int idProdus) {
        Produs produsDeSters = null;
        for (Produs produs : inventar) {
            if (produs.getId() == idProdus) {
                produsDeSters = produs;
                break;
            }
        }
        if (produsDeSters != null) {
            inventar.remove(produsDeSters);
        }
        for(Produs produs:inventar){
            System.out.println("Produs sters"+produs);
            break;
        }
    }

    public static List<Produs> obtineToateProdusele(List<Produs> inventar) {
        return new ArrayList<>(inventar);
    }

    public static Produs cautaProdusDupaNume(List<Produs> inventar, String numeProdus) {
        for (Produs produs : inventar) {
            if (produs.getNume().equalsIgnoreCase(numeProdus)) {
                return produs;
            }
        }
        return null;
    }

}