package CreationalDesignPatterns.Singleton.SingletonDoubleLocking;

class DBCOnnection{
    public static DBCOnnection connection= new DBCOnnection();
    private DBCOnnection(){

    }
    synchronized public static DBCOnnection getInstance(){
        if(connection==null){
            synchronized(DBCOnnection.class){
                if(connection==null){
                    connection= new DBCOnnection();
                    return connection;
                }
            }
            
        }
        return connection;
    }

}

public class SingletonDoubleLocking {
    public static void main(String[] args) {
        DBCOnnection getConn= DBCOnnection.getInstance();
        System.out.println(getConn);
    }
}
