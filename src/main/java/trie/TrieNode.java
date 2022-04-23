package trie;

import java.util.HashSet;
import java.util.Set;

public class TrieNode {
    final String data;
    final Set<TrieNode> children = new HashSet<>();

    TrieNode(final String data) {
        this.data = data;
    }

    String getData() {
        return this.data;
    }

    Set<TrieNode> getChildren() {
        return this.children;
    }

    public void printNodeAndChildren() {
        System.out.println("this: " + this.data);
        for(TrieNode n : this.children) {
            System.out.print("(child) " + n.data + " ");
        }
    }

    @Override
    public boolean equals(Object other) {
        return ((TrieNode)other).getData().equals(this.data);
    }

    @Override
    public int hashCode() {
        return this.data.hashCode();
    }
}
