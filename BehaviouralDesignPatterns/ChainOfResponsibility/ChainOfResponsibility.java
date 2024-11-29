package BehaviouralDesignPatterns.ChainOfResponsibility;

interface SupportHandler{
	void handleRequest(Request request);
	void setNextHandler(SupportHandler supportHandler);
}

class Level1SupportHandler implements SupportHandler{
	SupportHandler nextHandler;
	public void setNextHandler(SupportHandler supportHandler){
		this.nextHandler=supportHandler;
	}
	public void handleRequest(Request request){
		if(request.priority==Priority.BASIC){
            System.out.println("Level1 support Request Handled");
		}
		else if(nextHandler!=null){
			nextHandler.handleRequest(request);
		}
	}
}

class Request{
	Priority priority;
	public Request(Priority priority){
		this.priority=priority;
	}
}
enum Priority{
	BASIC, INTERMEDIATE, CRITICAL
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        SupportHandler level1Handler = new Level1SupportHandler();

        level1Handler.setNextHandler(null);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        level1Handler.handleRequest(request1);
        level1Handler.handleRequest(request2);
        level1Handler.handleRequest(request3);
    }
}
