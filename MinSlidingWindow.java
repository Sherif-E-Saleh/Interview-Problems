package questions;

public class MinSlidingWindow {

	/*
	 * Given an integer array A of size n. Given an integer k < n. Construct an
	 * array B, such that B[i] = min{A[i], A[i+1], A[i+2], A[i+3], ……., A[i+k]}
	 * Solve in time complexity better than O(nk)
	 * 
	 * you could use heabs, but this is the way I love to do it.
	 */

	public static int[] minSlidingWindow(int[] nums, int k) {

		if (nums.length <= 1 || k == 1) {
			return nums;
		}

		int[] toBeReturned = new int[nums.length - k + 1];
		int min = nums[0];
		int inIndex = 0;
		int in = 0;
		int outIndex = 0;
		int out = 0;
		for (int i = 1; i < k; i++) {
			if (min > nums[i])
				min = nums[i];
		}

		if (k < nums.length) {
			inIndex = k;
			in = nums[inIndex];
			outIndex = 0;
			out = nums[outIndex];
		}
		toBeReturned[0] = min;
		for (int i = 1; i < toBeReturned.length; i++) {
			if (out == min) {
				if (in <= out)
					min = in;
				else {
					min = nums[outIndex + 1];
					for (int j = outIndex + 2; j < inIndex + 1; j++) {
						if (min > nums[j])
							min = nums[j];
					}
				}
			} else {
				if (in < min)
					min = in;
			}
			toBeReturned[i] = min;

			if (inIndex + 1 < nums.length) {
				inIndex = inIndex + 1;
				in = nums[inIndex];
			}
			if (outIndex + 1 < nums.length) {
				outIndex = outIndex + 1;
				out = nums[outIndex];
			}

		}
		return toBeReturned;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 0, 9, 1, 1, 5, 2, 7, 3 };
		int[] b = minSlidingWindow(a, 2);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

}
