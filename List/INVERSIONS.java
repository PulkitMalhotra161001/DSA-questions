//iB

public int countInversions(ArrayList<Integer> A) {
        int  n=A.size();

    ArrayList<Integer>l=new ArrayList<>();
    l.add(A.get(0));

    int x=0;
    
    for(int i=1;i<A.size();i++)
    {
        int el=A.get(i);
        int index=Collections.binarySearch(l,el);
        if(index<0)
        {
            index=index*-1-1;
             x+=(l.size()-index);
            l.add(index,el);// if element is not in list then calculation of upperbound in java
           
        }
        else
        {// if present then we will add it to most left corner upperbound
            int j=index;
            while(j<l.size()&&l.get(j)==el)
            {
                j++;
            }
            x+=(l.size()-(j));
            l.add((j-1),el);
        }
    }
    return x;
    }
