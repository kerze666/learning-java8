package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Bartek on 17.06.2017.
 */
public class Transaction {

    private Person person;
    private BigDecimal amount;
    private LocalDate tansactionData = LocalDate.now();


    public Transaction(Person person, BigDecimal amount, LocalDate tansactionData) {
        this.person = person;
        this.amount = amount;
        this.tansactionData = tansactionData;
    }

    public Transaction(Person person, BigDecimal amount) {
        this.person = person;
        this.amount = amount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTansactionData() {
        return tansactionData;
    }

    public void setTansactionData(LocalDate tansactionData) {
        this.tansactionData = tansactionData;
    }
}
