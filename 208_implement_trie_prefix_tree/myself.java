class Trie {
  TrieNode root;
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode(' ');
  }

  /**
   * Inserts a word into the trie.
   * O(nm)
   * n: the maximum size of children in a node
   * m: the maximum length of word
   */
  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!current.hasChild(c)) {
        current.addChild(c);
      }
      current = current.getChild(c);
    }
    current.isEndOfWord = true;
  }

  /**
   * Returns if the word is in the trie.
   * O(nm)
   * n: the maximum size of children in a node
   * m: the maximum length of word
   */
  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!current.hasChild(c)) {
        return false;
      }
      current = current.getChild(c);
    }
    return current.isEndOfWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   * O(nm)
   * n: the maximum size of children in a node
   * m: the maximum length of prefix
   */
  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (!current.hasChild(c)) {
        return false;
      }
      current = current.getChild(c);
    }
    return true;
  }
}

class TrieNode {
  public boolean isEndOfWord;
  private char character;
  private List<TrieNode> children;
  private Set<Character> childCharacters;

  public TrieNode(char c) {
    character = c;
    children = new ArrayList<>();
    childCharacters = new HashSet<>();
  }

  // O(1)
  public boolean hasChild(char c) {
    return childCharacters.contains(c);
  }

  // O(1)
  public void addChild(char c) {
    TrieNode node = new TrieNode(c);
    children.add(node);
    childCharacters.add(c);
  }

  // O(n) where n is the maximum size of children (26)
  public TrieNode getChild(char c) {
    for (TrieNode child : children) {
      if (child.character == c) {
        return child;
      }
    }
    return null;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
