package FabioGilardi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    //    ATTRIBUTES
//    HO PENSATO CHE IL TESSER NUMBER CORRISPONDA ALL'ID DELL'UTENTE IN QUANTO LA TESSERE VIENE ASSEGNATA ALLA REGISTRAZIONE DELL'UTENTE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tesserNumber;
    private String name;
    private String surname;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private List<Loan> loanList;

    //    CONSTRUCTOR
    public User(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public User() {

    }

    //    GETTERS AND SETTERS
    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public long getTesserNumber() {
        return tesserNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "User{" +
                "tesserNumber=" + tesserNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", loanList=" + loanList +
                '}';
    }
}
