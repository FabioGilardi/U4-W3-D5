package FabioGilardi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loan")
public class Loan {

    //    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "loan_start")
    private LocalDate loanStart;
    @Column(name = "loan_end")
    private LocalDate loanEnd;
    @Column(name = "effective_loan_end")
    private LocalDate effectiveLoanEnd;

    @OneToOne(mappedBy = "loan")
    private Archive element;

    //    HO SCELTO UNA RELAZIONE MANY TO ONE PERCHE' UN UTENTE PUO' AVERE PIU' PRESTITI MA UN PRESTITO SI RIFERISCE AL SINGOLO UTENTE
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //    CONSTRUCTORS
    public Loan(LocalDate loanStart, LocalDate effectiveLoanEnd, User user) {
        this.loanStart = loanStart;
        setLoanEnd(loanStart);
        this.effectiveLoanEnd = effectiveLoanEnd;
        this.user = user;
    }

    public Loan() {
    }

    //    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public LocalDate getLoanStart() {
        return loanStart;
    }

    public void setLoanStart(LocalDate loanStart) {
        this.loanStart = loanStart;
    }

    public LocalDate getLoanEnd() {
        return loanEnd;
    }

    public void setLoanEnd(LocalDate loanEnd) {
        this.loanEnd = this.loanStart.plusDays(30);
    }

    public LocalDate getEffectiveLoanEnd() {
        return effectiveLoanEnd;
    }

    public void setEffectiveLoanEnd(LocalDate effectiveLoanEnd) {
        this.effectiveLoanEnd = effectiveLoanEnd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanStart=" + loanStart +
                ", loanEnd=" + loanEnd +
                ", effectiveLoanEnd=" + effectiveLoanEnd +
                ", element=" + element +
                '}';
    }
}
