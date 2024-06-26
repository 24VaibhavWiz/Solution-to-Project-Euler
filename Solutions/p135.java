
public final class p135 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p135().run());
	}
	
	
	/* 
	 * Let x = m, y = m - k, z = m - 2k (this is an arithmetic sequence).
	 * By tedious but straightforward algebra, x^2 - y^2 - z^2 = (m - k)(5k - m).
	 * 
	 * For the sequence to have positive descending terms, we require m > 0, k > 0, and 2k < m.
	 * We know y = m - k > 0, so this term in the product (m - k)(5k - m) is positive.
	 * Since we want x^2 - y^2 - z^2 > 0, this means we also require the term (5k - m) > 0, so 5k > m.
	 * Putting these facts together, we have m/5 < k < m/2. Note: k > m/5 is equivalent to k >= floor(m/5) + 1.
	 * 
	 * As for the search range of m, since (m - k) and (5k - m) are both positive integers,
	 * we know that (m - k)(5k - m) >= m - k > m/2. So m/2 < x^2 - y^2 - z^2 < 10^6.
	 * This means we search with 0 < m < 2 * 10^6.
	 */
	
	private static final int LIMIT = Library.pow(10, 6);
	
	public String run() {
		int[] solutions = new int[LIMIT];
		for (int m = 1; m < LIMIT * 2; m++) {
			for (int k = m / 5 + 1; k * 2 < m; k++) {
				long temp = (long)(m - k) * (k * 5 - m);
				if (temp >= solutions.length)
					break;
				solutions[(int)temp]++;
			}
		}
		
		int count = 0;
		for (int x : solutions) {
			if (x == 10)
				count++;
		}
		return Integer.toString(count);
	}
	
}
