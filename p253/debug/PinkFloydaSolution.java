import java.util.Arrays;

public class PinkFloydaSolution {

    public static void main(String[] args) {

        int[][] intervals = new int[7][];
        intervals[0] = new int[] {1, 5};
        intervals[1] = new int[] {1, 5};
        intervals[2] = new int[] {1, 5};
        intervals[3] = new int[] {8, 10};
        intervals[4] = new int[] {8, 10};
        intervals[5] = new int[] {8, 10};
        intervals[6] = new int[] {8, 10};

        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}
