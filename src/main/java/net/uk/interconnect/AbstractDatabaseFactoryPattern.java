package net.uk.interconnect;

/**
 * Created by mshaulskiy on 02/01/2017.
 */
public abstract class AbstractDatabaseFactoryPattern {

    abstract IDatabase getDatebase();

    /**
     * The config file has key-value pairs,
     * @param key
     * @return value corresponding to the key specified
     */
    private String readFromConfig(String key){
        return null;
    }

    public static void main(String[] args) {
        AbstractDatabaseFactoryPattern databaseFactory = new MSSQLDatabaseFactory();
        IDatabase database = databaseFactory.getDatebase();
    }

}


class MSSQLDatabaseFactory extends AbstractDatabaseFactoryPattern {

    @Override
    IDatabase getDatebase() {
        return new MSSQLDatabase();
    }
}

class OracleDatabaseFactory extends AbstractDatabaseFactoryPattern {

    @Override
    IDatabase getDatebase() {
        return new OracleDatabase();
    }
}

abstract class AbstractDatabaseFactory {

    abstract IDatabase getDatabaseLite();

    abstract IDatabase getDatabasePro();

    abstract IReadOnlyDatabase getReadOnlyDatabase();

}

interface IReadOnlyDatabase {

}

