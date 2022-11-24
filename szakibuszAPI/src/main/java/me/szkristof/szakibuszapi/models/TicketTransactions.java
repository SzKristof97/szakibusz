package me.szkristof.szakibuszapi.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ticket_transactions")
@NoArgsConstructor
@AllArgsConstructor
public class TicketTransactions {

//<editor-fold default-state="collapsed" desc="Private fields">

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String transactionTime;

    @Column(name = "amount_of_ticket", nullable = false)
    private int amountOfTicket;

    @OneToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "Id")
    private long userId;

    @OneToOne(targetEntity = TicketEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketId", referencedColumnName = "id")
    private long ticketId;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Getters and Setters">

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public int getAmountOfTicket() {
        return amountOfTicket;
    }

    public void setAmountOfTicket(int amountOfTicket) {
        this.amountOfTicket = amountOfTicket;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    //</editor-fold>


}
