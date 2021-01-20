import java.util.*;

public class VJ_0907 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        boolean result = true;
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
                if (map.get(a[i]) > k) result = false;
            }
        }

        if (result == true) {
            System.out.println("YES");
            Map<Integer, LinkedList<Integer>> nums = new HashMap<>();
            Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            int maxListSize = 0;
            int maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : entrySet) {
                int times = entry.getValue();
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = 0; i < times; i++) {
                    list.add(i + 1);
                    if (list.size() > maxListSize) {
                        maxListSize = list.size();
                        maxKey = entry.getKey();
                    }
                }
                nums.put(entry.getKey(), list);
            }
            int size = map.size();
            if (maxListSize < k) {
                int need = k - maxListSize;
                Set<Map.Entry<Integer, LinkedList<Integer>>> entrySet1 = nums.entrySet();
                while(need>0){
                    for (Map.Entry<Integer, LinkedList<Integer>> entry : entrySet1) {
                        if (entry.getKey() != maxKey)
                            for (int i = 0; i < entry.getValue().size() && need>0; i++,k--,need--)
                                entry.getValue().set(i,k);
                    }
                }
            }
            int[] resA = new int[a.length];
            for (int i = 0; i < resA.length; i++) {
                resA[i] = nums.get(a[i]).get(0);
                nums.get(a[i]).remove(0);
            }
            for (int i : resA) {
                System.out.print(i + " ");
            }
        } else
            System.out.println("NO");
    }
}
