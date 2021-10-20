import java.util.Arrays; 

public class BruteCollinearPoints 
{
	private LineSegment[] lineSegmentArray;
    private int segmentSize;
    private Point[] pts;

    // finds all line segments containing 4 or more points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        pts = new Point[points.length];
        for (int i = 0; i < points.length; i++) pts[i] = points[i];
        Arrays.sort(pts);
        nullPointsCheck(points);
        checkDuplicatePoints(points);
        segmentSize = 0;
        // store the segments in ResizingArray
        lineSegmentArray = new LineSegment[1];
        /**
         * The assignment specification says, "For simplicity, we will not
         * supply any input to BruteCollinearPoints that has 5 or more collinear points."
         *
         * So, consider all possible combinations of 4 points,
         * sort them to find endpoints of line segments.
         */
        Point[] subset = new Point[4];
        for (int i = 0; i < pts.length - 3; i++) {
            subset[0] = pts[i];
            for (int j = i + 1; j < pts.length - 2; j++) {
                subset[1] = pts[j];
                for (int k = j + 1; k < pts.length - 1; k++) {
                    subset[2] = pts[k];
                    for (int m = k + 1; m < pts.length; m++) {
                        subset[3] = pts[m];
                        Arrays.sort(subset);
                        double slopeA = subset[0].slopeTo(subset[1]);
                        double slopeB = subset[0].slopeTo(subset[2]);
                        double slopeC = subset[0].slopeTo(subset[3]);
                        if (slopeA == slopeB && slopeB == slopeC) {
                            add(new LineSegment(subset[0], subset[3]));
                        }
                    }
                }
            }
        }
    }

    // Returns the number of line segments
    public int numberOfSegments() {
        return segmentSize;
    }

    /**
     * Resizing array can couse null elements in array LineSegment, to prevent that return a copy of
     * the LineSegment array without null elements.
     */
    public LineSegment[] segments() {
        LineSegment[] copySegment = new LineSegment[segmentSize];
        for (int i = 0; i < segmentSize; i++) copySegment[i] = lineSegmentArray[i];
        return copySegment;
    }

    /**
     * Add new LineSegment object to ResizingArray. Also doubles the length of array when it's
     * full.
     */
    private void add(LineSegment x) {
        if (x == null) throw new NullPointerException();
        if (lineSegmentArray.length == segmentSize)
            resize(lineSegmentArray, 2 * lineSegmentArray.length);
        lineSegmentArray[segmentSize++] = x;
    }

    /**
     * Resizes the array lineSegmentArray to capacity.
     */
    private void resize(LineSegment[] x, int capacity) {
        LineSegment[] copy = new LineSegment[capacity];
        for (int i = 0; i < x.length; i++) copy[i] = x[i];
        lineSegmentArray = copy;
    }

    // Check any null point in array points
    private void nullPointsCheck(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("One of the point in points array is null");
            }
        }
    }

    // Check any duplicate point in array points
    private void checkDuplicatePoints(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0)
                throw new IllegalArgumentException("Duplicated entries in given points");
        }
    }
}
