package br.com.vitor.campaign.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String email;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "heartClub_id")
    private HeartClub heartClub;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HeartClub getHeartClub() {
        return heartClub;
    }

    public void setHeartClub(HeartClub heartClub) {
        this.heartClub = heartClub;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
