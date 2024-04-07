package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author = wangyilin29
 * @date = 2024/4/7
 **/
public class LeetCode1600 {
    private Node kingNode;
    private Map<String, Node> nodeMap;

    public void ThroneInheritance(String kingName) {
        nodeMap = new HashMap<>();
        kingNode = new Node(null, kingName);
        nodeMap.put(kingName, kingNode);
    }

    public void birth(String parentName, String childName) {
        Node node = nodeMap.get(parentName);
        Node childNode = new Node(node, childName);
        node.childList.add(childNode);
        nodeMap.put(childName, childNode);
    }

    public void death(String name) {
        Node node = nodeMap.get(name);
        node.dead = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        orderList(kingNode, result);
        return result;
    }

    private void orderList(Node node, List<String> result) {
        if (!node.dead) {
            result.add(node.name);
        }
        for (Node child : node.childList) {
            orderList(child, result);
        }
    }

    private static class Node {
        List<Node> childList;
        Node parent;
        boolean dead;
        String name;

        public Node(Node parent, String name) {
            this.parent = parent;
            this.dead = false;
            this.name = name;
            childList = new ArrayList<>();
        }
    }
}
