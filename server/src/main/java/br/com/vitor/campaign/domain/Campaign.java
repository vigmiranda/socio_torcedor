package br.com.vitor.campaign.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue
    private Integer id;


    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "heartClub_id")
    private HeartClub heartClub;

    private Date startDate;
    private Date endDate;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public HeartClub getHeartClub() {
        return this.heartClub;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeartClub(HeartClub heartClub) {
        this.heartClub = heartClub;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActual() {
        return this.getEndDate().after(new Date());
    }
}
