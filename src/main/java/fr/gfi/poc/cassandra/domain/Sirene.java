package fr.gfi.poc.cassandra.domain;

import lombok.Data;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table
@Data
public class Sirene {
    @PrimaryKeyColumn(
      ordinal = 1,
      type = PrimaryKeyType.CLUSTERED,
      ordering = Ordering.DESCENDING)
    private String siren;
    @PrimaryKeyColumn(
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING)
    private String numInterne;
    @Column
    private String adresseNormLigne1;
}
