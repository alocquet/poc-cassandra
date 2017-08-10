package fr.gfi.poc.cassandra.domain;

import lombok.Data;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
@Data
public class Sirene {
    @PrimaryKeyColumn(
      ordinal = 1,
      type = PrimaryKeyType.PARTITIONED,
      ordering = Ordering.DESCENDING)
    private String siren;
//    @PrimaryKeyColumn(
//            ordinal = 2,
//            type = PrimaryKeyType.PARTITIONED,
//            ordering = Ordering.DESCENDING)
    @Indexed
    private String numInterne;
    @Column()
    private String adresseNormLigne1;
}
