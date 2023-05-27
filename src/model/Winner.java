package model;

import java.util.List;

public class Winner {

    public Long sellerId;

    public Double totalResource, resourceAvailbility;

    public List<Long> buyerIds;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public Double getTotalResource() {
        return totalResource;
    }

    public void setTotalResource(Double totalResource) {
        this.totalResource = totalResource;
    }

    public Double getResourceAvailbility() {
        return resourceAvailbility;
    }

    public void setResourceAvailbility(Double resourceAvailbility) {
        this.resourceAvailbility = resourceAvailbility;
    }
    
    public List<Long> getBuyerIds() {
        return buyerIds;
    }

    public void setBuyerIds(List<Long> buyerIds) {
        this.buyerIds = buyerIds;
    }
}
