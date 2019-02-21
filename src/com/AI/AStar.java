package com.AI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class AStar {

    HashMap<String, State> states;
    HashMap<String, State> visitedStates;
    public State startState;
    public State goalState;

    public class State {
        String name;
        int searchHeuristic;
        ArrayList<Action> actions;
        public void addAction(String target, int cost){
            actions.add(new Action(target, cost));
        }

        // state object constructor
        public State(String d, int heuristic){
            name = d;
            searchHeuristic = heuristic;
            actions = new ArrayList();
        }
    }

    public class Action {
        State targetState;
        int pathCost;

        public Action(String t, int c){
            targetState = states.get(t);
            pathCost = c;
        }
    }

    public class Node{
        State state;
        Node parent;
        Action action;
        int pathCost;
        public Node takeAction(Action a){
            Node n = new Node();
            n.parent = this;
            n.state = a.targetState;
            n.action = a;
            n.pathCost = this.pathCost + a.pathCost;
            return n;
        }
    }

    public State addState(String n, int h){
        State s = new State(n, h);
        states.put(n, s);
        return s;
    }

    // path finder
    public boolean aStar() {
        if(startState.name.equals(goalState.name)){
            System.out.println("Start and Goal states are equal");
            return true;
        }
        LinkedList<Node> nodeList = new LinkedList<Node>();

        Node startNode = new Node();
        startNode.state = startState;
        startNode.pathCost = 0;
        nodeList.add(startNode);

        while(!nodeList.isEmpty()){
            int leastValue = 0, nodeValue = 0;
            int leastNode = 0;
            // find next node with least current cost + estimated/guessed further cost
            // note this might be faster if the list is sorted on insert
            for (int i=0; i < nodeList.size(); i++){
                nodeValue = nodeList.get(i).pathCost + nodeList.get(i).state.searchHeuristic;
                if(nodeValue < leastValue || leastValue == 0) {
                    leastNode = i;
                    leastValue = nodeValue;
                }
            }
            Node current = nodeList.get(leastNode);
            nodeList.remove(leastNode);
            System.out.print(current.state.name + " ");
            if(current.state.name.equals(goalState.name)){
                System.out.println(".");
                System.out.println("Goal state reached with " + current.pathCost + " cost");
                System.out.print("Path (from goal to start): ");
                printPath(current);
                return true;
            }
            else {
                visitedStates.put(current.state.name, current.state);
                for(int i = 0; i < current.state.actions.size(); i++) { // right first
                    //for(int i = current.state.actions.size() - 1; i >= 0; i--) { // left first
                    Action a = current.state.actions.get(i);
                    if (visitedStates.get(a.targetState.name) == null){
                        nodeList.add(current.takeAction(a));
                    }
                }
            }
        }
        System.out.println("No path found to goal");
        return false;
    }

    // constructor
    public AStar(){
        states = new HashMap<String, State>();
        visitedStates = new HashMap<String, State>();
    }

    public static void printPath(Node lastNode) {
        Node n = lastNode;
        while (n != null){
            System.out.print(n.state.name + " ");
            n = n.parent;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Boolean pathFound;
        AStar tsp = new AStar();
        AStar.State a;

//Load States
        a = tsp.addState("A", 15);
        //tsp.startState = a;
        a = tsp.addState("B", 13);
        a = tsp.addState("C", 8);
        a = tsp.addState("D", 7);
        a = tsp.addState("E", 8);
        a = tsp.addState("F", 5);
        a = tsp.addState("G", 0);
        //tsp.goalState = a;

//Load Actions
        tsp.states.get("A").addAction("B",6);
       // tsp.states.get("A").addAction("D", 6);
        tsp.states.get("A").addAction("E", 10);
        tsp.states.get("B").addAction("D", 5);
        tsp.states.get("B").addAction("C", 8);
        tsp.states.get("D").addAction("C", 3);
        tsp.states.get("D").addAction("E", 3);
        tsp.states.get("F").addAction("G", 5);
        tsp.states.get("D").addAction("G", 10);
        tsp.states.get("E").addAction("F", 7);
        tsp.states.get("C").addAction("G", 8);

//Input Start State
        while (tsp.startState == null) {
            System.out.println("Enter Start state: ");
            String startName = scan.next();
            tsp.startState = tsp.states.get(startName);
        }
//Input Goal
        while (tsp.goalState == null) {
            System.out.println("Enter Goal state: ");
            String startName = scan.next();
            tsp.goalState = tsp.states.get(startName);
        }

        System.out.println("Trying depth first:");
      //  pathFound = tsp.depthFirst();
        System.out.println("Trying A*:");
        pathFound = tsp.aStar();
    }
}