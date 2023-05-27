import java.util.ArrayList;
import java.util.List;

import model.Seller;

public class SellerMergeSort {

    public static List<Seller> mergeSort(List<Seller> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Seller> left = mergeSort(list.subList(0, mid));
        List<Seller> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private static List<Seller> merge(List<Seller> left, List<Seller> right) {
        List<Seller> merged = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            Seller leftElement = left.get(leftIndex);
            Seller rightElement = right.get(rightIndex);
            
            if (leftElement.getCalCompareValue().compareTo(rightElement.getCalCompareValue()) >= 0) {
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
