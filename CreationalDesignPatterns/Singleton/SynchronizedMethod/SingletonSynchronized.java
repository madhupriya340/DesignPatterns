package CreationalDesignPatterns.Singleton.SynchronizedMethod;

class DBCOnnection{
    public static DBCOnnection connection= new DBCOnnection();
    private DBCOnnection(){

    }
    synchronized public static DBCOnnection getInstance(){
        if(connection==null){
            connection= new DBCOnnection();
            return connection;
        }
        return connection;
    }

}

public class SingletonSynchronized {
    public static void main(String[] args) {
        DBCOnnection getConn= DBCOnnection.getInstance();
        System.out.println(getConn);
    }
}
