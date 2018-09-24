class Solution {
  public int compareVersion(String version1, String version2) {
    String[] v1Array = version1.split("\\.");
    String[] v2Array = version2.split("\\.");
    int maxLength = Math.max(v1Array.length, v2Array.length);

    List<Integer> v1List = Stream.of(v1Array).map(Integer::valueOf).collect(Collectors.toList());
    List<Integer> v2List = Stream.of(v2Array).map(Integer::valueOf).collect(Collectors.toList());

    for (int i = 0; i < maxLength; i++) {
      int v1Value = getListValue(v1List, i);
      int v2Value = getListValue(v2List, i);

      if (v1Value > v2Value) {
        return 1;
      } else if (v1Value < v2Value) {
        return -1;
      }
    }

    return 0;
  }

  private int getListValue(List<Integer> list, int index) {
    if (index < list.size()) {
      return list.get(index);
    } else {
      return 0;
    }
  }
}
