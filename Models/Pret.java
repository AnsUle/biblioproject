package Models;

import java.time.LocalDate;

public class Pret  {
    private Materiel materiel;
    private Abonne  abonne;
    private LocalDate datePret;
    private LocalDate dateRetour;
    private Boolean enCours;

    //construsteur
    public Pret(Materiel materiel, Abonne abonne) {
        if (!materiel.isDisponible()){
            throw new IllegalArgumentException("Le materiel est indisponible");
        }
        this.materiel = materiel;
        this.abonne = abonne;
        this.datePret = LocalDate.now();
        this.dateRetour = datePret.plusDays(7);//date de retour
        this.enCours = true;
        //materiel indisponible apres le pret
        materiel.setDisponible(false);
    }
    //getters
    public Materiel getMateriel() {
        return materiel;
    }
    public Abonne getAbonne() {
        return abonne;
    }
    public LocalDate getDatePret() {
        return datePret;
    }
    public LocalDate getDateRetour() {
        return dateRetour;
    }
    public Boolean getEnCours() {
        return enCours;
    }
}
