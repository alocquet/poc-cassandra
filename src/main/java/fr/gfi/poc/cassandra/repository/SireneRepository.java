package fr.gfi.poc.cassandra.repository;

import fr.gfi.poc.cassandra.domain.Sirene;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alocquet on 08/08/17.
 */
@Repository
public interface SireneRepository extends CassandraRepository<Sirene> {

    @Query("SELECT * FROM Sirene LIMIT 100")
    List<Sirene> findAll();

}
