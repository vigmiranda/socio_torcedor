package br.com.vitor.campaign.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "heartClub")
public class HeartClub {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "heartClub", fetch = FetchType.LAZY)
    private List<Person> people;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Person> getPeople() {
        return this.people;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
