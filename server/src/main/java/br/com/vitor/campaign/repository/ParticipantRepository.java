package br.com.vitor.campaign.repository;

import br.com.vitor.campaign.domain.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Integer> {

    Optional<Participant> findBooksById(Integer id);

}
