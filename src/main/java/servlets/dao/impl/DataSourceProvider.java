package servlets.dao.impl;


import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {

    private static MysqlDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setServerName("u3y93bv513l7zv6o.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("cgy7wi5ylgn0w04a");
            dataSource.setUser("peayqn98emob8vni");
            dataSource.setPassword("vqan4nxqkb38zwb6");
    }
		return dataSource;
    }

}