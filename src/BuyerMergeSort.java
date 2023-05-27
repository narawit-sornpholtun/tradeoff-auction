import java.util.ArrayList;
import java.util.List;

import model.Buyer;

public class BuyerMergeSort {

    public static List<Buyer> mergeSort(List<Buyer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Buyer> left = mergeSort(list.subList(0, mid));
        List<Buyer> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private static List<Buyer> merge(List<Buyer> left, List<Buyer> right) {
        List<Buyer> merged = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            Buyer leftElement = left.get(leftIndex);
            Buyer rightElement = right.get(rightIndex);

            if (leftElement.bids.compareTo(rightElement.bids) >= 0) {
                merged.add(leftElement);
                leftIndex++;
            } else {
                merged.add(rightElement);
                rightIndex++;
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex));
            rightIndex++;
        }

        return merged;
    }

}
