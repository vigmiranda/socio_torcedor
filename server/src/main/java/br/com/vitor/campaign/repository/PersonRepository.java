package br.com.vitor.campaign.repository;

import br.com.vitor.campaign.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

    Optional<Person> findPersonById(Integer id);

}
