package model;
public class Seller {
    public Long id;
    
    public Double ask, capacity, energy, response, arrival, departure;
    
    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getResponse() {
        return response;
    }

    public void setResponse(Double response) {
        this.response = response;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getArrival() {
        return arrival;
    }

    public void setArrival(Double arrival) {
        this.arrival = arrival;
    }

    public Double getDeparture() {
        return departure;
    }

    public void setDeparture(Double departure) {
        this.departure = departure;
    }

    public Double calCompareValue;

    public Double getCalCompareValue() {
        return ask/(energy*response);
    }

    public void setCalCompareValue(Double calCompareValue) {
        this.calCompareValue = calCompareValue;
    }


    @Override
    public String toString() {
        return "id: "+id+"|ask: "+ask+"|calCompareValue: "+getCalCompareValue()+"|capacity: "+capacity+"|energy: "+energy;
    }
}
