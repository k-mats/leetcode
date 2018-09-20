class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList();
    }

    // Define key pads
    Map<Character, List<String>> map = new HashMap<>();
    map.put('2', Arrays.asList("a", "b", "c"));
    map.put('3', Arrays.asList("d", "e", "f"));
    map.put('4', Arrays.asList("g", "h", "i"));
    map.put('5', Arrays.asList("j", "k", "l"));
    map.put('6', Arrays.asList("m", "n", "o"));
    map.put('7', Arrays.asList("p", "q", "r", "s"));
    map.put('8', Arrays.asList("t", "u", "v"));
    map.put('9', Arrays.asList("w", "x", "y", "z"));

    // Initialize queue
    Queue<String> queue = new LinkedList<>();
    char d0 = digits.charAt(0);
    List<String> a0 = map.get(d0);
    for (int i = 0; i < a0.size(); i++) {
      queue.add(a0.get(i));
    }

    for (int i = 1; i < digits.length(); i++) {
      char digit = digits.charAt(i);
      List<String> alphabets = map.get(digit);
      int listSize = queue.size();
      for (int j = 0; j < listSize; j++) {
        String item = queue.poll();
        for (int k = 0; k < alphabets.size(); k++) {
          String newItem = item + alphabets.get(k);
          queue.add(newItem);
        }
      }
    }

    return new ArrayList(queue);
  }
}
