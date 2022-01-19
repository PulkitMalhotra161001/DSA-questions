class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
//         Map<String,List<String>> m=new HashMap<>();
//         for(String s:strs){
//             char c[]=s.toCharArray();
//             Arrays.sort(c);
//             String sorted=new String(c);
            
//             if(!m.containsKey(sorted))
//                 m.put(sorted,new LinkedList<>());
            
//             m.get(sorted).add(s);
//         }
        
//         return new LinkedList<>(m.values());
        
        // Map<String, List<String>> m=new HashMap<>();
        // for(String s:strs){
        //     int count[]=new int[26];
        //     for(int i=0;i<s.length();i++){
        //         count[s.charAt(i)-'a']++;
        //     }
        //     String digits=Arrays.toString(count);
        //     List<String> l=m.getOrDefault(digits,new LinkedList<>());
        //     l.add(s);
        //     m.put(digits,l);
        // }
        // return new LinkedList<>(m.values());
        
        Map<Double, List<String>> m=new HashMap<>();
        for(String s:strs){
            double key=primeProdutOfString(s);
            if(!m.containsKey(key))
                m.put(key,new LinkedList<String>());
            m.get(key).add(s);
        }
        return new LinkedList<>(m.values());
        
    }
    
    public static double primeProdutOfString(String s){
        
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
//        				a, b, c, d, e,  f,  g,  h,  i,  j,   k,  l,  m,  n,  o,  p,  q,  r,  s,  t,  u,  v,  w,  x,  y,  z
        double product = 1;
        
        for(int i = 0; i < s.length(); i++){
            product = product * primes[s.charAt(i) - 'a'];
        }
        return product;
    }
}
