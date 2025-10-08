
package stralgo.pertemuan4;

import java.util.ArrayList;
import java.util.List;

public class EuclidClosestPair {
  List<Point> points;

  class Point {
    double x;
    double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  class Pair {
    Point p1;
    Point p2;
    double distance;

    public Pair(Point p1, Point p2) {
      this.p1 = p1;
      this.p2 = p2;
      double dx = p1.x - p2.x;
      double dy = p1.y - p2.y;
      this.distance = Math.sqrt(dx * dx + dy * dy);
    }
  }

  Pair getClosest(Pair p1, Pair p2) {
    if (p1 == null) {
      return p2;
    }
    if (p2 == null) {
      return p1;
    }
    if (p1.distance < p2.distance) {
      return p1;
    }
    return p2;
  }

  double getXMedian(int left, int right) {
    // when index left + index right is even,
    // means there are an odd number of points
    // so there is a point that is in the median
    // example: 3 & 5 -> middle = 4
    int middle = (left + right) / 2;
    if (left + right % 2 == 0) {
      // just return the x of that point
      return points.get(middle).x;
    }
    // otherwise, means the median is between two points
    // so return the average of the two points
    // example: 3 & 6 -> middle of 4 & 5
    return (points.get(middle).x + points.get(middle + 1).x) / 2;
  }

  Pair euclidClosest(int left, int right) {
    // recursive break: only single point left;
    if (left >= right) {
      return null; // no closest pair
    }
    // when there are more than 2 points
    int mid = (left + right) / 2;
    Pair pair1 = euclidClosest(left, mid);
    Pair pair2 = euclidClosest(mid + 1, right);
    Pair closestPair = getClosest(pair1, pair2); // here we handle the nulls
    // in case closest pair is null, we put infinity
    double r = closestPair == null ? Double.MAX_VALUE : closestPair.distance;
    // get the x median
    double xMedian = getXMedian(left, right);
    // alternative: use one of the center point as median
    // double xMedian = points.get(mid).x;
    // + 1 in case the the mid is not even within the boundary, also ensure not
    // breaking the right boundary
    int leftMergeBoundary = Math.min(mid + 1, right);
    // lets start from mid, we go to the left while the points are still within
    // value of r
    // dont forget that we dont want to get out of the bound 'left'
    while (leftMergeBoundary >= left && points.get(leftMergeBoundary).x >= xMedian - r) {
      leftMergeBoundary--;
    }
    // the left already out of the median - r or index, lets bring it
    // back in range
    leftMergeBoundary++;
    // -1 in case the mid is not even within the boundary, also ensure not breaking
    // the left boundary
    int rightMergeBoundary = Math.max(mid - 1, left);
    // lets start from mid, we go to the right while the points are still within
    // value of r
    // dont forget that we dont want to get out of the bound 'right'
    while (rightMergeBoundary <= right && points.get(rightMergeBoundary).x <= xMedian + r) {
      rightMergeBoundary++;
    }
    // the right already out of the median + r or index, lets bring
    // it back in range
    rightMergeBoundary--;
    // brute force very point within the leftMergeBoundary and rightMergeBoundary in
    // case there are closest pair within median - r to median + r
    for (int i = leftMergeBoundary; i <= rightMergeBoundary; i++) {
      Point p1 = points.get(i);
      for (int j = i + 1; j <= rightMergeBoundary; j++) {
        Point p2 = points.get(j);
        Pair candidate = new Pair(p1, p2);
        // if the candidate is closer, that's the new closest
        if (candidate.distance < r) {
          closestPair = candidate;
          r = candidate.distance;
        }
      }
    }
    return closestPair;
  }

  public EuclidClosestPair() {
    points = new ArrayList<Point>();
    points.add(new Point(1.0, 3.0));
    points.add(new Point(2.0, 7.0));
    points.add(new Point(3.0, 6.0));
    points.add(new Point(5.0, 0.0));
    points.add(new Point(6.0, 4.0));
    points.add(new Point(8.0, 2.0));
    points.add(new Point(9.0, 2.0));
    points.add(new Point(10.0, 7.0));
    Pair closestPair = euclidClosest(0, points.size() - 1);
    System.out.println("The closest pair is");
    System.out.println(closestPair.p1.x + ", " + closestPair.p1.y);
    System.out.println(closestPair.p2.x + ", " + closestPair.p2.y);
    System.out.println("With distance " + closestPair.distance);
  }

  public static void main(String[] args) {
    new EuclidClosestPair();
  }
}