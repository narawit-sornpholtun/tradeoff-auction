import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Buyer;
//import model.Buyer;
import model.Seller;
import model.Winner;
import model.WinnerBuyer;
import model.WinnerSeller;

//payment
import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            int totalTimeSlot = 2, time = 0;

            List<Buyer> buyers = getCSVReader("buyer", "/Users/narawitsornpholtun/SynologyDrive/Coding/Java/buyer-19.csv");
            List<Seller> sellers = getCSVReader("seller", "/Users/narawitsornpholtun/SynologyDrive/Coding/Java/seller-14.csv");

            List<Buyer> tempBuyers = new ArrayList<Buyer>();
            List<Seller> tempSellers = new ArrayList<Seller>();

            List<Buyer> buyerWinner = new ArrayList<Buyer>();

            //List<Winner> winners = new ArrayList<>();

            List<WinnerBuyer> final_winnerBuyers = new ArrayList<>();
            List<WinnerSeller> final_winnerSellers = new ArrayList<>();

            while(time != totalTimeSlot) {
                System.out.println("######## Time elapsed: " + time +" seconds.. ########");

                //create temp of buyer , by time
                for (Buyer buyer : buyers) {
                    if(buyer.getArrival() <= time &&
                        time <= buyer.getDeparture()){

                            if(final_winnerBuyers.size() > 0){
                                List<WinnerBuyer> result = final_winnerBuyers.stream()
                                    .filter(item -> item.getId().equals(buyer.getId()))
                                    .collect(Collectors.toList());
                                if(result.size() == 0) tempBuyers.add(buyer);

                            /*}
                            else if(tempBuyers.size() > 0){
                                List<Buyer> result = tempBuyers.stream()
                                    .filter(item -> item.getId().equals(buyer.getId()))
                                    .collect(Collectors.toList());
                                if(result.size() == 0) tempBuyers.add(buyer);
                            */
                            }else{
                                tempBuyers.add(buyer);
                            }
                    }
                }

                //for (Buyer buyer : tempBuyers) {
                //    System.out.println(buyer.toString());
                //}

                //create temp of seller , by time
                for (Seller seller : sellers) {
                    if(seller.getArrival() <= time &&
                        time <= seller.getDeparture()){
                            
                            if(tempSellers.size() > 0){
                                List<Seller> result = tempSellers.stream()
                                    .filter(item -> item.getId().equals(seller.getId()))
                                    .collect(Collectors.toList());
                                if(result.size() == 0) tempSellers.add(seller);

                            }else{
                                tempSellers.add(seller);
                            }

                    }
                }
                
                
                
                List<Buyer> buyerSorted = BuyerMergeSort.mergeSort(tempBuyers);
                List<Seller> sellerSorted = SellerMergeSort.mergeSort(tempSellers);

                int countSellerNotWin = 0;
                int sellerInd = 0;

                for (Buyer buyer : buyerSorted) {
                    //System.out.println(buyer.toString());
                    //sort buyer true
                    /*List<Buyer> buyerInWinner = buyerWinner.stream()
                    .filter(item -> item.getId().equals(buyer.getId()))
                    .collect(Collectors.toList());*/

                    while (countSellerNotWin < sellerSorted.size() /*&& buyerInWinner.size() == 0*/) {
                        Seller seller = sellerSorted.get(sellerInd);

                        //System.out.println(seller.toString());
                        //sort seller true

                        if(seller.getAsk() <= buyer.getBids()){
                            if(buyer.getResource() <= seller.getCapacity()){

                                
                                System.out.println(buyer.toString());
                                System.out.println(seller.toString());
                                System.out.println("##########");
                                //buyerWinner.add(buyer);

                                // สร้าง domain matching buyer and seller
                                WinnerBuyer winnerBuyer = new WinnerBuyer();
                                winnerBuyer.setServiceServerId(seller.getId());
                                winnerBuyer.setAsk(seller.getAsk());
                                winnerBuyer.setId(buyer.getId());
                                winnerBuyer.setBids(buyer.getBids());
                                winnerBuyer.setResource(buyer.getResource());
                                winnerBuyer.setArrival(buyer.getArrival());
                                winnerBuyer.setDeparture(buyer.getDeparture());
                                final_winnerBuyers.add(winnerBuyer);

                                WinnerSeller winnerSeller = new WinnerSeller();
                                winnerSeller.setId(seller.getId());
                                winnerSeller.setAsk(seller.getAsk());
                                winnerSeller.setArrival(seller.getArrival());
                                winnerSeller.setDeparture(seller.getDeparture());
                                winnerSeller.setBuyerId(buyer.getId());
                                winnerSeller.setBids(buyer.getBids());
                                winnerSeller.setCapacity(seller.getCapacity()-buyer.getResource());
                                final_winnerSellers.add(winnerSeller);

                                
                                //update temp seller
                                for (Seller seller_update : tempSellers) {
                                    if (seller_update.getId() == seller.getId()) {
                                        seller_update.setCapacity(seller.getCapacity()-buyer.getResource());
                                        break;  // Exit the loop once the seller is found and updated
                                    }
                                }
                            
                                break;
                            }
                        }
                        countSellerNotWin++;
                        sellerInd++;
                    }
                    
                }

                // ########
                //for (Buyer buyer : buyerWinner) {
                //    System.out.println(buyer.toString());
                //}
                tempBuyers.removeAll(tempBuyers);
                Thread.sleep(1000);
                time++;
            }
            /*System.out.println("#########################################");
            for (WinnerBuyer buyer : final_winnerBuyers) {
                System.out.println(buyer.toString());
            }
            System.out.println("#########################################");
            for (WinnerSeller seller : final_winnerSellers) {
                System.out.println(seller.toString());
            }*/
            
            // Payment Section
            time = 0;
            while(time != totalTimeSlot) {

                List<WinnerSeller> winnerSellersSorted = SellerPaymentMergeSort.mergeSort(final_winnerSellers);

                for (WinnerSeller seller : winnerSellersSorted) {
                    System.out.println(seller);
                }
                time++; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List getCSVReader(String type, String path) {
        List list = new ArrayList();
        String line;
        String csvSeparator = ",";// Change this if your CSV file uses a different separator

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // For skip Header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSeparator);
                if("buyer".equals(type)){
                    Buyer buyer = new Buyer();
                        buyer.setId(Long.parseLong(data[0].toString()));
                        buyer.setBids(Double.parseDouble(data[1].toString()));
                        buyer.setResource(Double.parseDouble(data[2].toString()));
                        buyer.setArrival(Double.parseDouble(data[3].toString()));
                        buyer.setDeparture(Double.parseDouble(data[4].toString()));
                    list.add(buyer);

                }else if("seller".equals(type)){
                    Seller seller = new Seller();
                    seller.setId(Long.parseLong(data[0].toString()));
                    seller.setAsk(Double.parseDouble(data[1].toString()));
                    seller.setCapacity(Double.parseDouble(data[2].toString()));
                    seller.setEnergy(Double.parseDouble(data[3].toString()));
                    seller.setResponse(Double.parseDouble(data[4].toString()));
                    seller.setArrival(Double.parseDouble(data[5].toString()));
                    seller.setDeparture(Double.parseDouble(data[6].toString()));
                    list.add(seller);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

