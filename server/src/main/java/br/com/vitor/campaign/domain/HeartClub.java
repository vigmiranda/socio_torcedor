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
    private List<Participant> participantes;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Participant> getParticipantes() {
        return this.participantes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipantes(List<Participant> participantes) {
        this.participantes = participantes;
    }
}
