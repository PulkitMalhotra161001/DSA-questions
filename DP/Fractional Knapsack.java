//greedy
//comparator class override
//sort by the ratio
//whose item is more expensive
//decending order
class pair_sort implements Comparator<Pair>{
    // @Override
    public int compare(Pair p1,Pair p2){
        double a=(double)p1.value/(double)p1.weight;
        double b=(double)p2.value/(double)p2.weight;
        if(a<b){
            return 1;
        }else if(a>b){
            return -1;
        }
        return 0;
    }
}
class Pair{
    long value;
    long weight;
    public Pair(long value,long weight){
        this.value=value;
        this.weight=weight;
    }
}
class Solution
{
    public double maximumProfit(int N, long C, long w[], long p[])
    {
        //make array
        Pair[] wp=new Pair[N];
        
        for(int i=0;i<N;i++){
            wp[i]=new Pair(p[i],w[i]);
        }
        
        //and sort according expensive(ness)        
        Arrays.sort(wp,new pair_sort());

        double ans=0;
        
        for(Pair i:wp){
            //if we are able to pick this item
            if( C-i.weight >=0){
                //add value
                //and subtrace bag capacity
                C-=i.weight;
                ans+=i.value;
            }
            //we are not able to pick this item
            else{
                //pick it in fraction
                //weight (n item) = value (n items)
                //value (1 item) = value(n item) / weight(n item)
                //capacity remaining (we can't pick full cap, but we can break it down)
                ans+=((double)i.value/i.weight) * C;
                //and leave
                break;
            }
        }
        return ans;
    }
}
