import java.util.PriorityQueue;

class MedianFinder {

  private final PriorityQueue<Integer> maxQueue;
  private final PriorityQueue<Integer> minQueue;

  public MedianFinder() {
    maxQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    minQueue = new PriorityQueue<>();
  }

  public void addNum(int num) {
    // Insert into the smaller half first.
    if (maxQueue.size() == 0 || num <= maxQueue.peek()) {
      maxQueue.add(num);
    } else {
      minQueue.add(num);
    }

    // The different between the size of the 2 heaps should not be more than 1.
    // if this is the case then move one element from the other
    // this is to get the correct elements for the max and min heap to calculate
    // median
    if (minQueue.size() - maxQueue.size() == 2) {
      maxQueue.add(minQueue.poll());
    }
    if (maxQueue.size() - minQueue.size() == 2) {
      minQueue.add(maxQueue.poll());
    }
  }

  public double findMedian() {
    if (maxQueue.size() > minQueue.size()) {
      return maxQueue.peek();
    }

    if (minQueue.size() > maxQueue.size()) {
      return minQueue.peek();
    }

    return (maxQueue.peek() + minQueue.peek()) / 2.0;
  }
}
