/*                                                                                                  
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have 

exactly one solution. 

For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). 
 */


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    // input here
    int[] input = {2, 1, -4, -2};
    int target = -4;
    System.out.println(find3sumCloset(input, target));
  }
  private static List<Integer> find3sumCloset(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 3)
      return new ArrayList<>();
    res.add(new ArrayList<>());
    Set<Integer> numset = new HashSet<>();
    for (int n : nums)
      numset.add(n);
    int[] newnums = new int[numset.size()];
    int pos = 0;
    for (Integer n : numset) {
      newnums[pos] = Integer.valueOf(n);
      pos++;
    }
    Arrays.sort(newnums);
    backtrack(res, new ArrayList<Integer>(), newnums, 0, target, Integer.MAX_VALUE);
    return res.get(0);
  }
  private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start, int target, int minDistance) {
    System.out.println(temp + " " + target + " " + minDistance);
    if (temp.size() > 3)
      return;
    if (temp.size() == 3) {
      int sum = 0;
      for (Integer n : temp) {
        sum += Integer.valueOf(n);
      }
      if (Math.abs(target - sum) == 0 || Math.abs(target - sum) < minDistance) {
        minDistance = Math.abs(target - sum);
        System.out.println(temp + " " + target + " " + minDistance);
        res.set(0, new ArrayList<>(temp));
      }
    }
    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      backtrack(res, temp, nums, i + 1, target, minDistance);
      temp.remove(temp.size() - 1);
    }
    return;
  }
}
