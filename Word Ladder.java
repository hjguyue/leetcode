public class Solution {
	// not good enough
	public int ladderLength(String start, String end, HashSet<String> dict) {
		set.clear();
		loopSet.clear();
		
		set.add(start);
		loopSet.add(start);
		
		int count = 0;
		for (String str:dict) {
			if (diff(str, end) <= 1) {
				count++;
				break;
			}
		}
		if (count == 0)
			return 0;
		
		count = 1;
		boolean FIND = true;
		while (FIND) {
			count++;
			FIND = false;
			HashSet<String> insertSet = new HashSet<String>();
			for (String old:loopSet) {
				for (String dic:dict) {
					if (!set.contains(dic) && diff(old, dic) == 1){
						insertSet.add(dic);
						FIND = true;
					}
				}
			}
			set.addAll(insertSet);
			loopSet.clear();
			loopSet.addAll(insertSet);
			dict.removeAll(insertSet);
			if (set.contains(end))
				return count;
			for (String str:set) {
				if (diff(str, end) == 1) {
					return count + 1;
				}
			}
		}
		return 0;
	}

	HashSet<String> set = new HashSet<String>();
	HashSet<String> loopSet = new HashSet<String>();

	public int diff(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (!s1.substring(i, i + 1).equals(s2.substring(i, i + 1))){
				count++;
				if (count >= 2)
					return 2;
			}
		}
		return count;
	}
}