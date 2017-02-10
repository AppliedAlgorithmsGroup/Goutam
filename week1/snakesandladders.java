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
				int temp = 	(((Integer)i.next()).intValue());
				if (temp >0)
				{
					if (distances[temp]==-1||distances[temp]>distances[current]+1)
					{
						
						distances[temp] = distances[current] + 1;
						
					}
				}
				else
				{	
					temp = Math.abs(temp);
					if (distances[temp]==-1||distances[temp]>distances[current])
					{
						distances[temp] = distances[current];
					}
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
        int no_of_snakes,no_of_ladders;
        for (int i = 0; i < no_of_queries; i++) {
            no_of_ladders = s.nextInt();
            List<ArrayList<Integer>> currentGraph = new ArrayList<ArrayList<Integer>>();
            for ( int k =0;k <100; k++)
            {
            	currentGraph.add(k,new ArrayList<Integer>());
            	
            	for (int count =1;count <=6;count ++)
            	{
            		
            		if(k+count<100)
                	{
                		currentGraph.get(k).add(k+count);
                	}
            	}
            
            }
            for (int j = 0; j < no_of_ladders; j++) {
            	int start =s.nextInt();
            	int end = s.nextInt();
            	for (int count =6;count>=1;count--)
            	{
            		if((start-1)-count >= 0)
            		{
            			currentGraph.get((start-1)-count).set(count-1, end-1);
            		}
            		
            	}
            	
            	
            }
            no_of_snakes = s.nextInt();
            for (int j = 0; j < no_of_snakes; j++) {
            	int start =s.nextInt();
            	int end = s.nextInt();
            	for (int count =6;count>=(1);count--)
            	{
            		if((start-1)-count >= 0 )
            		{
            			
            			try{
            				currentGraph.get((start-1)-count).set(count-1, end-1);
            			}
            			catch(Exception e)
            			{
            				System.out.println((start-1));
            				System.out.println(currentGraph.get((start-1)-count));
            				System.out.println(count);
            				System.exit(1);
            			}
            		}
            		
            	}
            	
            }
            
            int []distances = computeDistances(currentGraph,0);

            System.out.print(distances[99] +" ");
            System.out.print("\n");

        }
    }

}