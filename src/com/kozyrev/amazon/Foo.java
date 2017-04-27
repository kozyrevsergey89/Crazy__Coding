///*
// * Complete the function below.
// */
//
//static int[] getMinimumDifference(String[] a, String[] b) {
//        int[] answer = new int[a.length];
//        for (int i=0; i<a.length; i++){
//        if (a[i].length() != b[i].length()) {
//        answer[i] = -1;
//        } else {
//        answer[i] = simbolsToAnagram(a[i], b[i]);
//        }
//
//        }
//        return answer;
//
//        }
//
//static int simbolsToAnagram(String a, String b){
//        int res = 0;
//        Map<Character, Integer> map = new HashMap<>(); // we hold all characters counts so it is still linear - N,
//        // and could be 2*N in worst case (if all characters different)
//        // where N is the length of one string
//        for(int i=0; i < a.length(); i++) { // we go through each character of both strings in on for loop
//        // so time complexity is linear and equal to N,
//        // where N is the length of one string
//        char ac = a.charAt(i);
//        char bc = b.charAt(i);
//        if (map.get(ac)==null){
//        map.put(ac, 1);
//        } else {
//        map.put(ac, map.get(ac)+1);
//        }
//
//        if (map.get(bc) == null){
//        map.put(bc, -1);
//        } else {
//        map.put(bc, map.get(bc) - 1);
//        }
//        }
//        for (Integer num : map.values()) {
//        res+=Math.abs(num);
//        }
//        return res/2;
//
//        }
//
