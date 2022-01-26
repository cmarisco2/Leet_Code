//? Problem Statement:
// There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

// Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

// This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

// Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

// It's guaranteed that each city can reach city 0 after reorder.

package Arrays;

//* Build own Graph out of 2D array inputs for linear traversal

class Reorder_Routes_to_0 {
    Node [] adj;

    private class Node{
        int vertex;
        Boolean source;
        Node next;
    }

    // public int minReorder(int n, int[][] connections) {

    // }

    public void addEdge(int [] arr){
        Node from = new Node();
        Node to = new Node();
        from.vertex = arr[0];
        to.vertex = arr[1];
        from.source = true;
        to.source = false;
    }
}