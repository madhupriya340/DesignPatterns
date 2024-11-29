package CreationalDesignPatterns.Singleton.SingletonLazy;

class DBCOnnection{
    public static DBCOnnection connection= new DBCOnnection();
    private DBCOnnection(){

    }
    public static DBCOnnection getInstance(){
        if(connection==null){
            connection= new DBCOnnection();
            return connection;
        }
        return connection;
    }

}

public class SingletonLazyInitialization {
    public static void main(String[] args) {
        DBCOnnection getConn= DBCOnnection.getInstance();
        System.out.println(getConn);
    }
}
