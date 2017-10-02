package br.com.vitor.campaign.repository;

import br.com.vitor.campaign.domain.HeartClub;
import br.com.vitor.campaign.domain.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeartClubRepository extends PagingAndSortingRepository<HeartClub, Integer> {

    Optional<HeartClub> findByName(String name);

}
