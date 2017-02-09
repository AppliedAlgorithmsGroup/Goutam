/**
 * Created by goutamm on 07/02/17.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Solution {
	public static int []  computeDistances(List<ArrayList<Integer>> adjacency,int cur)
	{
		int [] distances = new int[adjacency.size()];
		int current = cur;
		
		List <Integer> queue = new ArrayList<Integer>();
		boolean[] visited = new boolean[adjacency.size()];
		
		queue.add(current);
		for (int i =0; i< distances.length;i++)
		{
			distances[i] = -1;
			visited[i] = false;
		}
		visited[current]=true;
		distances[current] = 0;
		while (!(queue.isEmpty()))
		{
			current = queue.remove(0);
			
			Iterator i = ((ArrayList)adjacency.get(current)).iterator();
			while (i.hasNext())
			{
				int temp = 	(Integer)i.next();
				if (distances[temp]==-1||distances[temp]>distances[current]+6)
				{
					distances[temp] = distances[current] + 6;
					
				}
					
				
				if(visited[temp]==false)
				{
					visited[temp]=true;
					queue.add(temp);
					
				}
					
				
				
				
			}
			
		}
		
		
		return distances;
	}
	
    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);

        int no_of_queries = s.nextInt();
        int no_of_edges,nodes;
        for (int i = 0; i < no_of_queries; i++) {
            nodes = s.nextInt();
            no_of_edges = s.nextInt();
            List<ArrayList<Integer>> currentGraph = new ArrayList<ArrayList<Integer>>();
            for ( int k =0;k <nodes; k++)
            {
            	currentGraph.add(k,new ArrayList<Integer>());
            	
            }
            for (int j = 0; j < no_of_edges; j++) {
            	int start =s.nextInt();
            	int end = s.nextInt();
            	currentGraph.get(start-1).add(end-1);
            	currentGraph.get(end-1).add(start-1);
            }
            int cur = s.nextInt()-1;
            int []distances = computeDistances(currentGraph,cur);
            for (int j=0;j<distances.length;j++)
            {
            	if (j!=cur)
            	System.out.print(distances[j] +" ");
            	
            }
            System.out.print("\n");

        }
    }

}