/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        if(intervals.size() == 0)
            return list;

        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval i1, Interval i2){
        		if (i1.start > i2.start)
        			return 1;
        		return -1;
        	}
        });	

        Interval cursor = intervals.get(0);
        for (Interval interval:intervals) {
        	if (cursor.end < interval.start) {
        		list.add(cursor);
        		cursor = interval;
        		continue;
        	}
        	
        	cursor = combine(cursor, interval);	
        	
        }
        list.add(cursor);
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