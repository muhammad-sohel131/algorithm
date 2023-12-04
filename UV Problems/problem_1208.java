/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectProblems;


import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Sohel
 */
class Security implements Comparable<Security> {
    int src,dest, security;
    Security(int src, int dest, int security){
        this.src = src;
        this.dest = dest;
        this.security = security;
    }

    @Override
    public int compareTo(Security o) {
        return Integer.compare(this.security, o.security);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security s = (Security) o;
        return (this.src == s.src && this.dest == s.dest) || (this.src == s.dest && this.dest == s.src);
    }

    @Override
    public int hashCode() {
        // Ensure consistent hash code regardless of the order of src and dest
        return Objects.hash(Math.min(src, dest), Math.max(src, dest));
    }
}
public class Problem_1208 {
    static Queue<Security> queue = new PriorityQueue();
    static Set<Security> set = new LinkedHashSet();
    static int leader[];
    
    static void union(int src, int dest){
        if(leader[src] < leader[dest]){
            leader[dest] = leader[src];
        }else {
            leader[src] = leader[dest];
        }
    }
    
    static void findMst(Queue<Security> queue, int nodes){
        List<Security> taken = new ArrayList();
        while(taken.size() < nodes - 1 && !queue.isEmpty()){
            Security s = queue.poll();
            int src = s.src;
            int dest = s.dest;
            
            if(leader[src] != leader[dest]){
                union(src,dest);
                taken.add(s);
            }
        }
        
        for(Security t : taken){
            System.out.println( (char)(t.src + 65) +"-" + (char)(t.dest + 65) + " " + t.security);
        }
    }
    
    public static void main(String[] args) {
        File file = new File("C:/Users/Sohel/Desktop/projectsProblems/problems_1208.txt");
        try {
            Scanner sc = new Scanner(file);
            int test = sc.nextInt();
            for(int t = 1; t <= test; t++){
                int nodes = sc.nextInt();
                leader = new int[nodes];
                for(int row = 0; row < nodes; row++){
                    leader[row] = row;
                    for(int col = 0; col < nodes; col++){
                        int s = sc.nextInt();
                        if(s != 0){
                            Security se = new Security(row,col,s);
                            if(set.add(se)){
                                queue.add(se);
                            }
                        }
                    }
                }
                
                System.out.println("Case " + t + " :");
                findMst(queue,nodes);
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
