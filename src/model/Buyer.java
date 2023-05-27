package model;
public class Buyer {
    public Long id;
    
    public Double bids, resource, arrival, departure;

    public void setDeparture(Double departure) {
        this.departure = departure;
    }

    public void setArrival(Double arrival) {
        this.arrival = arrival;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDeparture() {
        return departure;
    }

    public Double getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return "id: "+id+"|bids: "+bids+"|resource: "+resource+"|arrival: "+arrival+"|departure: "+departure;
    }
}
