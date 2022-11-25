package me.szkristof.szakibuszapi.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This class represents the user table in the database.
 */
@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    //<editor-fold default-state="collapsed" desc="Private fields">

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false, columnDefinition = "BIGINT UNSIGNED")
    private long Id;

    @Column(name = "username", unique = true, nullable = false, updatable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "create_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp create_time;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Getters and Setters">

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }


    //</editor-fold>
}
