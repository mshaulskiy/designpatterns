package net.uk.interconnect;

/**
 * Created by mshaulskiy on 31/12/2016.
 */
public class FactoryPattern {

    // 3. Create IDatabase member variable and use it throughout the code
    IDatabase database = FactoryPattern.createDatabase();

    // 4. In the factiry class, have a static method that uses reflection to create the right objrct
    private static IDatabase createDatabase() {
        String databaseClassName = readFromConfig("database-class-name");
        IDatabase database = null;
        try {
            database = (IDatabase) Class.forName(databaseClassName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return database;
    }

    /**
     * The config file has key-value pairs,
     * @param key
     * @return value corresponding to the key specified
     */
    private static String readFromConfig(String key) {
        return null;
    }


}

// 1. Create the interface
interface IDatabase{
    void /* IDBConnection */ connect();
    void /* IDBCommand */ createConmmand(IDBConnection connection);
    IDBResult executeCommand(IDBConnection connection, IDBCommand command);

}

interface IDBConnection {

}

interface IDBCommand {

}

interface IDBResult {

}

// 2. Implement interface twice once for each MS-SQL and Oracle
class MSSQLDatabase implements IDatabase{


    @Override
    public void connect() {

    }

    @Override
    public void createConmmand(IDBConnection connection) {

    }

    @Override
    public IDBResult executeCommand(IDBConnection connection, IDBCommand command) {
        return null;
    }
}

class OracleDatabase implements IDatabase{


    @Override
    public void connect() {

    }

    @Override
    public void createConmmand(IDBConnection connection) {

    }

    @Override
    public IDBResult executeCommand(IDBConnection connection, IDBCommand command) {
        return null;
    }
}



