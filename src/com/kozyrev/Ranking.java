package com.kozyrev;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sergii on 10/13/16.
 */
public class Ranking {
    static class Node{
        long id;
        long[] outlinks;
    }

    Map<Long, Double> rank(int iteration, Set<Node> nodes) {
        Map<Long, Double> map = new HashMap<>();
        for (int i=0; i<iteration; i++) {
            if (i==0) {
                for (Node n : nodes) {
                    map.put(n.id, 1.0/nodes.size());
                }
            } else {
                for (Node n : nodes) {
                    for (long link : n.outlinks) {
                        map.put(link, map.get(link)+map.get(n.id)/n.outlinks.length);
                    }
                }
            }
        }
        return map;
    }
}
