package practice.arrays;

import java.util.Arrays;

public class _27ArrayIsSubsetOfOtherArray {
    /* %%%%%%%%%%%%%%%%%%%%% First Approch %%%%%%%%%%%% 
     T - O(N)
     S - O(N)
    */
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while(T != 0) {
		    String[] params = br.readLine().trim().split(" ");
		    int n1 = Integer.parseInt(params[0]);
		    int n2 = Integer.parseInt(params[1]);
		    String[] a1 = br.readLine().trim().split(" ");
		    String[] a2 = br.readLine().trim().split(" ");
		    boolean flag = true;
		    Set<Integer> set = new HashSet<>(); 
		    for(int i=0;i < n1;i++){
		        set.add(Integer.parseInt(a1[i]));
		    }
		    for(int i=0;i < n2;i++){
		        if(!set.contains(Integer.parseInt(a2[i]))){
		            flag = false;
		            break;
		        }
		    }
		    if(!flag)
                System.out.println("No");
            else 
                System.out.println("Yes");
		    T--;
		}
    }
    /* %%%%%%%%%%%%%%%%%%%%%%%%% Second Appotch %%%%%%%%%%%%*/
    public static void main2 (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while(T != 0) {
		    String[] params = br.readLine().trim().split(" ");
		    int n1 = Integer.parseInt(params[0]);
		    int n2 = Integer.parseInt(params[1]);
		    String[] s1 = br.readLine().trim().split(" ");
		    String[] s2 = br.readLine().trim().split(" ");
		    boolean flag = false;
		    int[] a1;
		    int[] a2;
		    if(n1 >= n2) {
    		    a1 = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
    		    a2 = Arrays.stream(s2).mapToInt(Integer::parseInt).toArray();
		    } else {
    		    a2 = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
    		    a1 = Arrays.stream(s2).mapToInt(Integer::parseInt).toArray();
		    }
		    Arrays.sort(a1);
		    Arrays.sort(a2);
		    int i=0;
		    int j=0;
		    while(i < a1.length && j < a2.length) {
		        if(a2[j] < a1[i]){
		            flag = false;
		            break;
		        } else if(a2[j] > a1[i]){
		            i++;
		            flag = false;
		            continue;
		        } else {
		            i++;
		            j++;
		            flag = true;
		            continue;
		        }
		    }
		    if(j < a2.length)
                System.out.println("No");
		     else if(!flag)
                System.out.println("No");
            else 
                System.out.println("Yes");
		    T--;
		}
	}
}
