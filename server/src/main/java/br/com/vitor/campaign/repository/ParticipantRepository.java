package br.com.vitor.campaign.repository;

import br.com.vitor.campaign.domain.Campaign;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampaignRepository extends PagingAndSortingRepository<Campaign, Integer> {

    Optional<Campaign> findBooksById(Integer id);

}
