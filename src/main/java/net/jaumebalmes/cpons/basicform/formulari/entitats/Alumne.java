package net.jaumebalmes.cpons.basicform.formulari.entitats;

import jakarta.persistence.*;

@Entity
public class Alumne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String cognoms;

    @Column(nullable = false, length = 9)
    private String dni;

    @Column(nullable = false)
    private String cicle;

    @Column(nullable = false)
    private String modalitat;

    @Column(nullable = false)
    private String estatPractiques;

    @ManyToOne(optional = true)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getCicle() {
        return cicle;
    }

    public void setCicle(String cicle) {
        this.cicle = cicle;
    }

    public String getModalitat() {
        return modalitat;
    }

    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }

    public String getEstatPractiques() {
        return estatPractiques;
    }

    public void setEstatPractiques(String estatPractiques) {
        this.estatPractiques = estatPractiques;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cognoms='" + cognoms + '\'' +
                ", cicle='" + cicle + '\'' +
                ", modalitat='" + modalitat + '\'' +
                ", estatPractiques='" + estatPractiques + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
