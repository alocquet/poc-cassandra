package fr.gfi.poc.cassandra.repository;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.gfi.poc.cassandra.domain.Sirene;

/**
 * Proxy to the current WS using Feign
 */
@FeignClient(name="sirene", url = "http://localhost:8080/api" )
public interface SireneRestRepository {
	
	@RequestMapping(method = RequestMethod.GET, value = "/sirene")
	List<Sirene> findAll();
}
