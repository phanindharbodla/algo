package com.demo;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

public class Demo {
    static int ikt = 10;

    public Demo() {
        super();
    }

    public static void main(String[] args) {
        // create 2 bitsets

        int x = 1;
        Scanner in = new Scanner(System.in);
        /*while(x==1) {
            System.out.println(in.nextLine());

        }*/


        String str = "My name is khan and i'm not a terrorist";

        StringTokenizer stk = new StringTokenizer(str);
        String string[] = str.split(" ");

        //while(stk.hasMoreTokens()){
        System.out.println(string[2]);
        //}
        int i = 1;

        BitSet bitset1 = new BitSet(8);
        BitSet bitset2 = new BitSet(8);

        // assign values to bitset1
        bitset1.set(0);
        bitset1.set(1);
        bitset1.set(2);
        bitset1.set(3);
        bitset1.set(4);
        bitset1.set(5);

        // assign values to bitset2
        bitset2.set(2);
        bitset2.set(4);
        bitset2.set(6);
        bitset2.set(8);
        bitset2.set(10);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a - b);
        heap.add(4);
        heap.add(41);
        heap.add(432);
        heap.add(32);
        Integer val;
        HashMap hashMap = new HashMap();
        hashMap = new HashMap();
        while ((val = heap.poll()) != null) {
            System.out.println(val);
        }

        if (bitset1.get(1)) {
            System.out.println("1->true");
        }

        // print the sets
        System.out.println("Bitset1:" + bitset1);
        System.out.println("Bitset2:" + bitset2);

        // get index 1 to 4 of bitset1
        System.out.println("" + bitset1.get(0, 4));

        // get index 2 to 10 of bitset2
        System.out.println("" + (bitset2.get(2, 10)));
        // bitset2.get(0);
        // .and(bitset1);
        System.out.println("" + bitset2);
        SimpleEntry<Integer, Integer> temp = new SimpleEntry<Integer, Integer>(1, 0);

        System.out.println(temp.getKey() + " " + temp.getValue());
        temp = new SimpleEntry<Integer, Integer>(1, 10);
        System.out.println(temp.getKey() + " " + temp.getValue());
    }

    final int howLong(String[] connects, String[] costs) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<State> sta = new Stack<State>();
        int cost[][] = new int[connects.length][costs.length];
        boolean edge[][] = new boolean[connects.length][costs.length];
        boolean vertex[] = new boolean[connects.length];
        int resultT[] = new int[connects.length];

        for (int g = 0; g < connects.length; g++) {
            for (int h = 0; h < costs.length; h++) {
                edge[g][h] = false; /// Assigns the specified boolean value to
                /// each element of the specified array of
                /// booleans.
            }
        }

        for (int i = 0; i < connects.length; i++) {
            if (!connects[i].equals("")) {
                String[] t1 = connects[i].split("\\s");
                String[] t2 = costs[i].split("\\s");
                for (int x = 0; x < t1.length; x++) {
                    cost[i][Integer.parseInt(t1[x])] = Integer.parseInt(t2[x]);

                }

            }
        }
        for (int y = 0; y < cost.length; y++) {
            for (int z = 0; z < cost.length; z++) {
                int result = 0;
                if (!edge[y][z] && cost[y][z] != 0) {
                    sta.push(new State(y, z));
                }
                while (sta.empty() == false) {
                    State s = sta.pop();
                    if (s.x < 0 || s.y < 0 || s.x >= cost.length || s.y >= cost.length || edge[s.x][s.y]
                            || cost[s.x][s.y] == 0)
                        continue;
                    // System.out.print("We are visiting --- ");
                    // System.out.print(s.x);
                    // System.out.print("-");
                    // System.out.print(s.y);

                    if (vertex[s.x] == false) {
                        resultT[s.x] = result;
                        result = result + cost[s.x][s.y];
                        vertex[s.x] = true;
                    } else {
                        result = resultT[s.x];
                        result = result + cost[s.x][s.y];
                    }

                    // System.out.print("---Result:");
                    // System.out.print(result);
                    // System.out.print("---VResult:");
                    // System.out.println(resultT[s.x]);
                    if (vertex[s.y] == false) {
                        al.add(result);

                    }
                    edge[s.x][s.y] = true;

                    for (int k = 0; k < costs.length; k++) {
                        int a = s.y;
                        int b = k;
                        vertex[s.y] = false;
                        for (int j = 0; j < costs.length; j++) {
                            edge[s.y][j] = false;
                        }
                        sta.push(new State(a, b));
                    }
                }
                // System.out.println("out of while --- ");
                for (int j = 0; j < costs.length; j++) {
                    vertex[j] = false;
                }
                // System.out.print(y);
                // System.out.print(" --- ");
                // System.out.println(z);
            }
        }

        int[] ret = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ret[i] = al.get(i).intValue();
        }
        Arrays.sort(ret);
        int duck = 0;
        if (ret.length > 0) {
            duck = ret[ret.length - 1];
        }

        return duck;
    }

    class State extends Demo {
        int x, y;
        boolean z;

        State(int xx, int yy) {
            x = xx;
            y = yy;
        }


        int howLong(String[] connects) {
            return this.howLong(connects, connects);
        }
    }

}
