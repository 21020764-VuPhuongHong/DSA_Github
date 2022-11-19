import java.util.*;

public class MissingNumber {

    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> missingNumbers = new ArrayList<>();
        Hashtable<Integer, Integer> arrHashTable = new Hashtable<>();
        Hashtable<Integer, Integer> brrHashTable = new Hashtable<>();
        for (Integer i : arr) {
            if (!arrHashTable.containsKey(i)) {
                arrHashTable.put(i, 1);
            } else {
                arrHashTable.put(i, arrHashTable.get(i) + 1);
            }
        }
        for (Integer i : brr) {
            if (!brrHashTable.containsKey(i)) {
                brrHashTable.put(i, 1);
            } else {
                brrHashTable.put(i, brrHashTable.get(i) + 1);
            }
        }
        Enumeration<Integer> enu = brrHashTable.keys();
        while (enu.hasMoreElements()) {
            int key = enu.nextElement();
            if (!Objects.equals(arrHashTable.get(key), brrHashTable.get(key))) {
                missingNumbers.add(key);
            }
        }
        Collections.sort(missingNumbers);
        return missingNumbers;
    }



    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        List<Integer> missingNumbers = new ArrayList<>();
        Collections.sort(arr);
        Collections.sort(brr);
        int j = 0;
        for (int i = 0; i < brr.size(); i++) {
            if (!Objects.equals(brr.get(i), arr.get(j))) {
                if (!missingNumbers.contains(brr.get(i))) {
                    missingNumbers.add(brr.get(i));
                }
            } else {
                if (j < arr.size() - 1) {
                    j++;
                } else {
                    j = 0;
                }
            }
        }
        return missingNumbers;
    }

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> missingNumbers = new ArrayList<>();
        int[] arrFreq = new int[101];
        int[] brrFreq = new int[101];
        int min = Collections.min(brr);

        for (int i = 0; i < arr.size(); i++) {
            arrFreq[arr.get(i) - min]++;
        }

        for (int i = 0; i < brr.size(); i++) {
            brrFreq[brr.get(i) - min]++;
        }

        for (int i = 0; i < arrFreq.length; i++) {
            if (arrFreq[i] != brrFreq[i]) {
                missingNumbers.add(i + min);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> brr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            brr.add(sc.nextInt());
        }
        List<Integer> missingNums;
        missingNums = missingNumbers(arr, brr);
        for (Integer i : missingNums) {
            System.out.print(i + " ");
        }
    }
}