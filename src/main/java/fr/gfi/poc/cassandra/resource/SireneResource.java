package fr.gfi.poc.cassandra.resource;

import fr.gfi.poc.cassandra.domain.Sirene;
import fr.gfi.poc.cassandra.repository.SireneRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by alocquet on 08/08/17.
 */
@Component
@Path("sirene")
@RequiredArgsConstructor
@Produces("application/json")
public class SireneResource {

    @NonNull
    private final SireneRepository repo;

    /**
     * find all sirene
     *
     * @param numInterne filtered by numInterne
     * @return search result
     */
    @GET
    public List<Sirene> findAll(final @QueryParam("numinterne") String numInterne) {
        if (numInterne != null) {
            return repo.findByNumInterne(numInterne);
        }
        return repo.findAll();
    }

    /**
     * find one sirene
     *
     * @param siren id
     * @return sirene infos
     */
    @GET
    @Path("/{siren}")
    public Sirene findOne(final @PathParam("siren") String siren) {
        return repo.findOne(BasicMapId.id("siren", siren));
    }
}
