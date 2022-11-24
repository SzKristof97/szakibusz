package me.szkristof.szakibuszapi.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.szkristof.szakibuszapi.models.enums.TicketType;

import javax.persistence.*;

@Entity(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {

    //<editor-fold default-state="collapsed" desc="Private fields">

    @Id
    @Column(name = "id", updatable = false, insertable = false, columnDefinition = "BIGINT UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "type", nullable = false, columnDefinition = "ENUM('SINGLE_USE', 'MONTHLY', 'YEARLY')")
    private TicketType type;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Getters and Setters">

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }


    //</editor-fold>
}
