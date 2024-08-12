//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Appbiblio {
    public static void main(String[] args) {
        try {// creation livre avec info valide
            Livre livre1 = new Livre ("PP1952","Le petit prince",5,"Antoine","Gallimard",1952);

            //affichage des informations sur le livre
            System.out.println(livre1.toString());
            Livre livre2 = new Livre("pp1230","",1,"Antoine","Gallimard",1952);
        } catch (IllegalArgumentException iae) {
            System.out.println("ERREUR : " + iae.getMessage());
        }
        //creation abonne
        try {
            Abonne abonne1 = new Abonne("suleyman", "anna", "anna.suleyman@yahoo.fr", "0607890200");
            System.out.println(abonne1.toString());
            Abonne abonne2 = new Abonne("luc", "pierre", "luc.pierre@luc.fr", "06078902100");
            System.out.println(abonne2.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("ERREUR : " + e.getMessage());
        }
        //creation bibliotecaire
        Bibliotecaire bibliotecaire1 = new Bibliotecaire("anna","suleyman","anna.suleyman@yahoo.fr","0607890200");
        System.out.println(bibliotecaire1.toString());
    }


}