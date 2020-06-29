// generate a random number within the range of [a, b] with equal probabilities.
class Solution {
	public int random(int a, int b) {
    Random rand = new Random();
    int res = a + rand.nextInt(b - a + 1);
    return res; 
	}
}