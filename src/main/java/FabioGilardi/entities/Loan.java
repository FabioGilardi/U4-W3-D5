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

    //    HO SCELTO UNA RELAZIONE ONE TO ONE PERCHE' IL PRESTITO E' PUO' AVERE UN SOLO ELEMENTO(DA CONSEGNA: LIBRO O RIVISTA), E IL LIBRO PUO APPARTENERE AD UN SINGOLO PRESTITO PER VOLTA(LO STESSO LIBRO NON PUO' ESSERE PRESTATO A PIU' UTENTI CONTEMPORANEAMENTE)
    @OneToOne
    @JoinColumn(name = "element-id")
    private Archive element;

    //    HO SCELTO UNA RELAZIONE MANY TO ONE PERCHE' UN UTENTE PUO' AVERE PIU' PRESTITI MA UN PRESTITO SI RIFERISCE AL SINGOLO UTENTE
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //    CONSTRUCTORS
    public Loan(LocalDate loanStart, LocalDate loanEnd, LocalDate effectiveLoanEnd, Archive element, User user) {
        this.loanStart = loanStart;
        this.loanEnd = loanEnd;
        this.effectiveLoanEnd = effectiveLoanEnd;
        this.element = element;
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
                ", user=" + user +
                '}';
    }
}
