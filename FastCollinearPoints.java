
import java.util.Arrays;

public class FastCollinearPoints 
{
	private LineSegment[] lineSegmentArray;
    private int segmentSize;
    private Point[] collinear;
    private int collinearSize;
    private Point[] pts;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new java.lang.NullPointerException();
        /**
         *
         */
        Point[] ptsNullCheck = points.clone();
        /**
         * Checking null points much faster with sorted array,
         * but API doesn't allow us to sort points array.
         * Hence we create ptsNullCheck and sort that.
         */
        Arrays.sort(ptsNullCheck);
        nullPointsCheck(ptsNullCheck);
        checkDuplicatePoints(ptsNullCheck);
        lineSegmentArray = new LineSegment[1];
        segmentSize = 0;
        pts = ptsNullCheck.clone();
        for (int i = 0; i < pts.length; i++) {
            // Sort pts array using comparator, according to the next point in ptsNullCheck.
            Arrays.sort(pts, ptsNullCheck[i].slopeOrder());
            /**
             *  p.slopeTo(p) returns Double.NEGATIVE_INFINITY, p will be zero index in sorted array.
             *  Thus, we start j at 1 so we don't compare the current point to itself.
             */
            for (int j = 1; j < pts.length; j++) {
                // It will usually need 4 point.
                collinear = new Point[4];
                collinearSize = 0;
                double slopeA = pts[0].slopeTo(pts[j]);
                add(pts[0]);
                add(pts[j]);

                /**
                 * Check to see if the next j index would put us outside of
                 * the pts array, then see if the Point at that index has
                 * the same slope as slopeA.
                 * If so, add the Point at that index to our collinear array.
                 */
                while (++j < pts.length && pts[0].slopeTo(pts[j]) == slopeA) {
                    add(pts[j]);
                }
                j--; // Since we increased j above, move j back.
                /**
                 * collinear array keeps the collinear points we have found but
                 * we don't know the endpoints.
                 *
                 * We can't sort collinear array, since it's a ResizingArray, can contains null elements.
                 *
                 * So, copy the points in collinear to sortedCollinear, sort sortedCollinear
                 * then add it's first and last points to segments.
                 */
                if (collinearSize >= 4) {
                    Point[] sortedCollinear = new Point[collinearSize];
                    for (int k = 0; k < collinearSize; k++) {
                        sortedCollinear[k] = collinear[k];
                    }
                    Arrays.sort(sortedCollinear);
                    if (eliminateDup(j)) {
                        add(new LineSegment(sortedCollinear[0],
                                            sortedCollinear[collinearSize - 1]));
                    }
                }
            }
        }

    }

    /**
     * This method allows us to eliminate duplicates. For example; (5,2) and (2,5), one of them will
     * always be smaller than the other point according to compareTo method.
     * <p>
     * <p>
     * This is useful because a line segment can be defined from either direction, but if we don't
     * want duplicates in our segments array, we need to arbitrarily decide not to add from one
     * direction.
     */
    private boolean eliminateDup(int j) {
        for (int k = 0; k < collinearSize - 1; k++)
            if (pts[0].compareTo(pts[j - k]) < 0)
                return false;
        return true;
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
     * Add new LineSegment object to ResizingArray. Also doubles the length of lineSegmentArray when
     * it's full.
     */
    private void add(LineSegment x) {
        if (x == null) throw new NullPointerException();
        if (lineSegmentArray.length == segmentSize)
            resize(lineSegmentArray, 2 * lineSegmentArray.length);
        lineSegmentArray[segmentSize++] = x;
    }

    /**
     * Add new Point object to ResizingArray. Also doubles the length of collinear when it's full.
     */
    private void add(Point x) {
        if (x == null) throw new NullPointerException();
        if (collinear.length == collinearSize)
            resize(collinear, 2 * collinear.length);
        collinear[collinearSize++] = x;
    }

    /**
     * Resizes the array lineSegmentArray to capacity.
     */
    private void resize(LineSegment[] x, int capacity) {
        LineSegment[] copy = new LineSegment[capacity];
        for (int i = 0; i < x.length; i++) copy[i] = x[i];
        lineSegmentArray = copy;
    }

    /**
     * Resizes the array collinear to capacity.
     */
    private void resize(Point[] x, int capacity) {
        Point[] copy = new Point[capacity];
        for (int i = 0; i < x.length; i++) copy[i] = x[i];
        collinear = copy;
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
