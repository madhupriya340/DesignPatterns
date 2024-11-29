package StructuralDesignPatterns.ProxyPattern;

interface EmployeeDao{
    public void create(String client,Employee emp );
    public void delete(String client, int employeeId);
    public EmployeeDao get(String client, int employeeId);
}
class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client,Employee emp) {
        System.out.println("Created new row in the employee table");
    }

    @Override
    public void delete(String client, int employeeId) {
        System.out.println("deleted  row in the employee table");
    }

    @Override
    public EmployeeDao get(String client, int employeeId) {
        System.out.println("Fetching data from the employee db");
        return new EmployeeDaoImpl();
    
    }
    
}
class EmployeeDaoProxy implements EmployeeDao{
    EmployeeDao employeeDaoObj;
    EmployeeDaoProxy(EmployeeDao employeeDao){
        this.employeeDaoObj=employeeDao;
    }
    @Override
    public void create(String client,Employee emp) {
        if(client.equals("ADMIN")){
            employeeDaoObj.create(client, emp);
        }
        System.out.println("ACCESS DENIED");
    }

    @Override
    public void delete(String client, int employeeId) {
        System.out.println("deleted  row in the employee table");
    }

    @Override
    public EmployeeDao get(String client, int employeeId) {
        System.out.println("Fetching data from the employee db");
        return employeeDaoObj;
    
    }
    
}
class Employee{
    String name;
    Employee(){}
}
public class ProxyPattern {
    public static void main(String[] args) {
        EmployeeDaoProxy employeeDaoProxy= new EmployeeDaoProxy(new EmployeeDaoImpl());
        employeeDaoProxy.create("USER",new Employee());
    }
}
