// Focus on only the start times and end times

class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    int arraySize = intervals.length;
    int[] starts = new int[arraySize];
    int[] ends = new int[arraySize];

    for (int i = 0; i < arraySize; i++) {
      starts[i] = intervals[i].start;
      ends[i] = intervals[i].end;
    }

    Arrays.sort(starts);
    Arrays.sort(ends);

    int rooms = 0;
    int maxRooms = 0;
    int startIndex = 0;
    int endIndex = 0;

    while (startIndex < arraySize) {
      if (starts[startIndex] < ends[endIndex]) {
        rooms++;
        startIndex++;
        if (rooms > maxRooms) {
          maxRooms = rooms;
        }
      } else {
        rooms--;
        endIndex++;
      }
    }

    return maxRooms;
  }
}
