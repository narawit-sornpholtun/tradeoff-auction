package model;

public class WinnerBuyer extends Buyer{

    public Long serviceServerId;
    public Double ask;
    
    public Long getServiceServerId() {
        return serviceServerId;
    }

    public void setServiceServerId(Long serviceServerId) {
        this.serviceServerId = serviceServerId;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    
    @Override
    public String toString() {
        //return "id: "+id+"|bids: "+bids+"|resource: "+resource+"|arrival: "+arrival+"|departure: "+departure +"|ServiceServerId: "+serviceServerId+"|ask: "+ask;
        return "id: "+id+"|bids: "+bids+"|resource: "+resource+"|arrival: "+arrival+"|departure: "+departure +"|ServiceServerId: "+serviceServerId+"|ask: "+ask;
    }
}
