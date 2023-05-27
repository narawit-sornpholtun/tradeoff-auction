import java.util.ArrayList;
import java.util.List;
import model.WinnerSeller;

public class SellerPaymentMergeSort {

    public static List<WinnerSeller> mergeSort(List<WinnerSeller> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<WinnerSeller> left = mergeSort(list.subList(0, mid));
        List<WinnerSeller> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private static List<WinnerSeller> merge(List<WinnerSeller> left, List<WinnerSeller> right) {
        List<WinnerSeller> merged = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            WinnerSeller leftElement = left.get(leftIndex);
            WinnerSeller rightElement = right.get(rightIndex);

            if (leftElement.ask.compareTo(rightElement.ask) <= 0) {
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
