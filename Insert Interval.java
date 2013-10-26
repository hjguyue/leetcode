/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        int flag = 0;
        
		for (Interval interval:intervals) {
			if (newInterval.end < interval.start && flag == 0){
    		    list.add(newInterval);			
    		    flag = 1;
			}
			if (flag == 1 || !intersect(interval, newInterval))
				list.add(interval);
			else
				newInterval = combine(interval, newInterval);
		}
        if(flag == 0)
            list.add(newInterval);
		return list;
    }

    public boolean intersect(Interval i1, Interval i2){
    	if (i1.start > i2.end || i1.end < i2.start)
    		return false;
    	return true;
    }

    public Interval combine(Interval i1, Interval i2){
    	return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
}