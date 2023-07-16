// https://leetcode.com/problems/smallest-sufficient-team/
// mitBask DP
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> skill_index = new HashMap<>();
        for (int i = 0; i < n; ++i)
            skill_index.put(req_skills[i], i);
        
        //create skills array for size all skills bitMask i.e. 2^n
        List<Integer>[] dp = new List[1 << n];
        System.out.println(dp.length);
        //0th skills requires none person
        dp[0] = new ArrayList<>();
        
        //traversing for peoples
        for (int i = 0; i < m; ++i) {
            
            //find bitmask of skills
            int cur_skill = 0;
            for (String s : people.get(i))
                cur_skill |= 1 << skill_index.get(s);
            
            //traverse in skills
            for (int prev = 0; prev < dp.length; ++prev) {
                
                //if this skills is not found then do nothing
                if (dp[prev] == null) continue;
                
                //combine this skills and newPerson skills
                int comb = prev | cur_skill;
                
                //one question may arrise that is we can write cur_skills that require 1 person. That is taken care of by 0th skills require none person and cur_skills requires 1 person. comb = cur_skill and that is null
//                 System.out.println(prev+" "+cur_skill+" => "+comb);
                
                //if newSkills is not yet discovered or prevSkillRequiredPeopls + this person prossess less candidate then currently present candidate in combined skills
                if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
//             print(dp);
        }
        
        //last skills defines all skills and contains minimum candidate
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
        
    }
    void print( List<Integer>[] dp){
        for(int i=0;i<dp.length;i++){
            List<Integer> list = dp[i];
            if(list==null){
                System.out.println("null: "+i);
                continue;
            }
            System.out.print(i+" => ");
            for(Integer j:list){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
