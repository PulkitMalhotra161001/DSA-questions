Set<String> set=new HashSet<>();
    public List<String> find_permutation(String S) {
        all_per(S,0,S.length()-1);
        List<String> l=new LinkedList<>();
        for(String i:set)
            l.add(i);
        Collections.sort(l);
        set.clear();
        return l;
    }
    public void all_per(String s, int l, int r){
        if(l==r){
            if(set.contains(s))
                return;
            set.add(s);
            return;
        }
        for(int i=l;i<=r;i++){
            s=swap(s,i,l);   // swap or first lock element
            all_per(s,l+1,r); // & traverse others
            s=swap(s,i,l);   //backtracking
        }
    }
    public String swap(String s, int x, int y){
        char c[]=s.toCharArray();
        char temp=c[x];
        c[x]=c[y];
        c[y]=temp;
        return String.valueOf(c);
    }
