// https://leetcode.com/problems/longest-substring-of-one-repeating-character/

class Solution {
    public int[] longestRepeating(String s, String qc, int[] qi) {
        int n=s.length(), m=qc.length();
        ST tree = new ST(s,n);
        int ans[]=new int[m];
        for(int i=0;i<m;i++){
            tree.update(0,0,n-1,qi[i],qc.charAt(i));
            ans[i]=tree.tree[0].longest;
            // tree.print();
        }
        return ans;
    }
}

class ST{
    Node tree[];
    char s[];
    int i=0;
    ST(String s,int n){
        this.s=s.toCharArray();
        tree=new Node[4*n];
        build(0,0,n-1);
        // print();
    }
    void build(int pos,int l,int r){
        // System.out.println(pos+" "+l+" "+r);
        if(l==r){
            tree[pos]=new Node( s[i++] );
        }else{
            int mid = l+(r-l)/2;
            int li = 2*pos+1;
            int ri = 2*pos+2;
            build(li,l,mid);
            build(ri,mid+1,r);
            tree[pos] = merge(tree[li], tree[ri]);
        }
    }
    void update(int pos,int l,int r,int id,char c){
        // System.out.println(pos+" "+id+" "+l+" "+r);
        if(l==r){
            s[id]=c;
            tree[pos] = new Node(c);
        }else{
            int mid = l+(r-l)/2;
            int li = 2*pos+1;
            int ri = 2*pos+2;
            if(id<=mid)    update(li,l,mid,id,c);
            else    update(ri,mid+1,r,id,c);
            tree[pos] = merge(tree[li], tree[ri]);
        }
    }
    Node merge(Node ln,Node rn){
        boolean equal = ln.rc==rn.lc;
        int longest = Math.max(ln.longest,rn.longest);
        longest = Math.max(longest, equal ? ln.suff + rn.pref : 0);
        char lc = ln.lc;
        char rc = rn.rc;
        int size = ln.size + rn.size;
        int pref = ln.pref + (ln.pref==ln.size && equal ? rn.pref : 0);
        int suff = rn.suff + (rn.suff==rn.size && equal ? ln.suff : 0);
        return new Node(lc,rc,longest,size,pref,suff);
    }
    void print(){
        int fill=0;
        System.out.print("indx: ");
        for(int i=0;i<tree.length;i++){
            if(tree[i]==null)   tree[i]=new Node();
            System.out.print(i+" ");
        }
        System.out.print("\nstrg: ");
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]+" ");
        }
        System.out.print("\n  lc: ");
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i].lc+" ");
        }
        System.out.print("\n  rc: ");
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i].rc+" ");
        }
        System.out.print("\nlong: ");
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i].longest+" ");
        }
        System.out.print("\nsize: ");
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i].size+" ");
        }
        System.out.print("\npref: ");
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i].pref+" ");
        }
        System.out.print("\nsuff: ");
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i].suff+" ");
        }
        System.out.println("\n");
    }
}

class Node{
    char lc='*',rc='*';
    int longest=1,size=1,pref=1,suff=1;
    Node(){}
    Node(char c){
        lc=c;
        rc=c;
    }
    Node(char lc,char rc,int longest,int size,int pref,int suff){
        this.lc=lc;
        this.rc=rc;
        this.longest=longest;
        this.size=size;
        this.pref=pref;
        this.suff=suff;
    }
}
