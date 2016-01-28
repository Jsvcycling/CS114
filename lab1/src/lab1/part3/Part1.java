package lab1.part3;

public class Part1 {
	public static void main(String[] args) {
		int[][] data = new int[2][10];
		
		// Insert random integers into the `data` array.
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				data[i][j] = (int)(Math.random() * 1000);
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(data[i][j]);
				System.out.print(" ");
			}
			
			System.out.print("\n");
		}
		
		// Swap the rows of `data`.
		int[] temp = data[0];
		data[0] = data[1];
		data[1] = temp;
		
		// Add an extra line so it looks good
		System.out.print("\n");
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(data[i][j]);
				System.out.print(" ");
			}
			
			System.out.print("\n");
		}
	}
}
