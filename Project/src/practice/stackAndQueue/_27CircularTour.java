package practice.stackAndQueue;

public class _27CircularTour {
    // O(n),O(1)
    int tour(int petrol[], int distance[])
    {
		int deficit=0, start=0,sum=0;
    	for(int i=0;i<petrol.length;i++){
    	    sum+=petrol[i]-distance[i];
    	    if(sum<0){
    	        start=i+1;
    	        deficit+=sum;
    	        sum=0;
    	    }
    	    
    	}
    	return (sum+deficit)>=0 ? start :-1;
    }
}
