package fr.gfi.poc.cassandra.config;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${cassandra.contact-points:localhost}")
    private String cassandraContactPoints;

    @Value("${cassandra.port:9042}")
    private int cassandraPort;

    @Value("${cassandra.user:}")
    private String cassandraUser;

    @Value("${cassandra.password:}")
    private String cassandraPassword;

    @Override
    protected List<String> getStartupScripts() {
        String script = "CREATE KEYSPACE IF NOT EXISTS poc "
                + "WITH durable_writes = true "
                + "AND replication = { 'replication_factor' : 1, 'class' : 'SimpleStrategy' };";
        return Arrays.asList(script);
    }

    @Override
    protected String getKeyspaceName() {
        return "poc";
    }

    @Override
    protected String getContactPoints() {
        return cassandraContactPoints;
    }

    @Override
    protected int getPort() {
        return cassandraPort;
    }

    @Override
    protected AuthProvider getAuthProvider() {
        return new PlainTextAuthProvider(cassandraUser, cassandraPassword);
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"fr.gfi.poc.cassandra.domain"};
    }
}