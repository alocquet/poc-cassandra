package fr.gfi.poc.cassandra.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

import fr.gfi.poc.cassandra.domain.Sirene;
import fr.gfi.poc.cassandra.repository.SireneRepository;
import fr.gfi.poc.cassandra.repository.SireneRestRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by alocquet on 08/08/17.
 */
@Component
@Path("sirene")
@RequiredArgsConstructor
@Produces( "application/json" )
public class SireneResource {

    @NonNull
    private final SireneRepository repo;

    @NonNull
    private final SireneRestRepository repoRest;

    @GET
    public Iterable<Sirene> findAll(@QueryParam("page") final int page,
                                    @QueryParam("size") final int size){
        return repo.findAll();
    }

    @GET
    @Path("/loop")
    public Iterable<Sirene> findAllLoop(){
        return repoRest.findAll();
    }
}
