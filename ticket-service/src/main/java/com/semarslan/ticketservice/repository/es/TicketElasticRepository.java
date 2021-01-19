package com.semarslan.ticketservice.repository.es;

import com.semarslan.ticketservice.entity.es.TicketEsModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticRepository extends ElasticsearchRepository<TicketEsModel, String> {
}
