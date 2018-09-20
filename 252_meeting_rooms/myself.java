class Solution {
  public boolean canAttendMeetings(Interval[] intervals) {
    for (int i = 0; i < intervals.length; i++) {
      Interval interval = intervals[i];
      for (int j = 0; j < intervals.length; j++) {
        if (i == j) continue;
        int start = intervals[j].start;
        if (start >= interval.start && start < interval.end) {
          return false;
        }
      }
    }
    return true;
  }
}
