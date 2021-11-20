import java.util.*;

public class _2FindItineraryFromTickets {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		Map<String,Boolean> start = new HashMap<>();
		for(String key : map.keySet()){
		        String src = key;
		        String dest = map.get(key);
		        
		        start.put(dest,false);
		        if(!start.containsKey(src)) {
    		        start.put(key,true);
		        }
		}
		
		String src= null;
		for(String key : start.keySet()) {
		    if(start.get(key)) {
		        src = key;
		        break;
		    }
		}
        
        while(true) {
            if(map.containsKey(src)) {
                System.out.print(src + " -> ");
                src = map.get(src);
            } else {
                System.out.print(src + ".");
                break;
            }
        }
	}
}
