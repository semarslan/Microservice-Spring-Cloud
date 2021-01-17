package com.semarslan.accountservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${springcloud.cassandra.keyspace.name}")
    private String keyspaceName;
    @Value("${springcloud.cassandra.contact.point}")
    private String contactPoint;
    @Value("${springcloud.cassandra.port}")
    private int port;
    @Value("${springcloud.cassandra.username}")
    private String username;

    @Value("${springcloud.cassandra.password}")
    private String passwd;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setUsername(username);
        clusterFactoryBean.setPassword(passwd);
        return clusterFactoryBean;
    }
}
