package trie;

import java.util.Arrays;
import java.util.List;

public class TrieMain {
    static int count = 1;
    TrieNode root = new TrieNode("root");

    void printNode(TrieNode node, String prefix) {
        if(null == node) {
            return;
        }
        System.out.println(prefix + "  "  + node.data);
        for(TrieNode n : node.getChildren()) {
            printNode(n, prefix + "  : ");
        }
    }

    void addSubTreeFor(final TrieNode node, final String str, final int endIndex) {
        if(endIndex > str.length()) {
            return;
        }

        String substringToAdd = str.substring(0, endIndex);
        if(node.getChildren().add(new TrieNode(substringToAdd))) {
            count++;
        }
        TrieNode addedNode = null;
        for(TrieNode n : node.getChildren()) {
            if (n.getData().equals(substringToAdd)) {
                addedNode = n;
                break;
            }
        }

        addSubTreeFor(addedNode, str, endIndex + 1);
    }

    public static void main(String[] args) {
        final TrieMain trie = new TrieMain();
        final List<String> strings = Arrays.asList("tea", "ted", "ten", "i", "in", "inn");
        for (String string : strings) {
            trie.addSubTreeFor(trie.root, string, 1);
        }
        final String sentence = "The DER and CERT files are provided for convenience and generated using the steps outlined in the Generate Private Key and Self-Signed Certificate section below.";
        for(String string : sentence.split(" ")) {
            trie.addSubTreeFor(trie.root, string, 1);
        }

        System.out.println("Total: " + trie.count);
        trie.printNode(trie.root, "");
    }
}
