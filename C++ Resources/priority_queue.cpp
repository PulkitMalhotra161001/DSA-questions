#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> mp;
class Point { 
public: 
    int x; 
    int y; 
    Point(int x, int y){
      this->x = x; 
      this->y = y; 
   } 
};
class myComparator { 
public: 
    int operator() (Point& p1, Point& p2) 
    { 
        //max
        return p1.x < p2.x; 
    } 
};
int main() {
    ///max heap
    priority_queue<int> max_pq;
    //min heap
    priority_queue<int, vector<int>, greater<int>> min_pq;
    
    //max pair (considering first value)
    priority_queue<mp> max_pair_pq;
    //min pair (considering first value)
    priority_queue<mp, vector<mp>, greater<mp>> min_pair_pq;
    max_pair_pq.push(make_pair(3,6));
    
    //custom comparator
    priority_queue<Point,vector<Point>, myComparator> custom_pq;
    custom_pq.push(Point(4,5));

    return 0;
}
