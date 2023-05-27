package model;

public class WinnerSeller extends Seller{

    
    public Double capacity,bids, resource;
    public Long buyerId;
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getBids() {
        return bids;
    }

    public void setBids(Double bids) {
        this.bids = bids;
    }

    public Double getResource() {
        return resource;
    }

    public void setResource(Double resource) {
        this.resource = resource;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String toString() {
        return "id: "+getId()+"|ask: "+getAsk()+"|capacity: "+capacity+"|arrival: "+getArrival()+"|departure: "+getDeparture()
        +"id buyer : "+getBuyerId()
        +"|bids: "+getBids()+"|resource: "+getResource() ;
    }

    
}
