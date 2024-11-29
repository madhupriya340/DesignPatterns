package CreationalDesignPatterns.Singleton.SingletonEager;

class DBCOnnection{
    public static DBCOnnection connection= new DBCOnnection();
    private DBCOnnection(){

    }
    public static DBCOnnection getInstance(){
        return connection;
    }

}
public class SingletonEagerInitialization {
    public static void main(String[] args) {
        DBCOnnection getConn= DBCOnnection.getInstance();
        System.out.println(getConn);

    }
}
