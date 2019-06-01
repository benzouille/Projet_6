package fr.banane.projet6.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDao {

    @Inject
    @Named("dataSourceOCscalade")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }
}
