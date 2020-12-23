import java.util.Scanner;


public class Main {

	/**
	* Instagram @wilmg.id
	*
	* Baris = b
	* Kolom = k
	* m = jumlah b
	* n = jumlah k
	*/


	static int total_path(int gridWidth, int gridHeight){

		 
		// Jika User Input baris atau kolom bernilai 0 atau 1
		if (gridWidth == 0 || gridHeight == 0) {

			return 0;
		} else if (gridWidth == 1 || gridHeight == 1) {

			return 1;
		}

		// int[index baris][index kolom]

		int[][] nomorPath = new int[gridWidth][gridHeight];


		for (int b = 0; b < gridWidth; b++ ) {
			
			nomorPath[b][0] = 1; // beri tahu bahwa baris 1 di index pertama itu bernilai 1
		}

		for (int k = 0; k < gridHeight; k++ ) {
			nomorPath[0][k] = 1; // beri tahu bahwa kolom 1 di index pertama itu bernilai 1
		}

		for (int b = 1; b <gridWidth; b++ ) {
			for (int k = 1; k < gridHeight; k++ ) {

				nomorPath[b][k] = nomorPath[b-1][k] + nomorPath[b][k-1];

			}
		}


		return nomorPath[gridWidth - 1][gridHeight - 1];
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Author : Wildan Muhammad Gibran\n");
		System.out.println("Masukan jumlah baris");
		System.out.print("baris = ");
		int inputUser1 = scanner.nextInt();
		System.out.println("\nMasukan jumlah kolom");
		System.out.print("kolom = ");
		int inputUser2 = scanner.nextInt();
		clearCMD(); // untuk merapihkan CMD atau Terminal
		System.out.println("\nBanyak kemungkinan jalan untuk dari top left ke bottom right hanya bisa jalan ke kanan dan ke bawah adalah = ");
		System.out.println("\n Jumlah = "+total_path(inputUser1,inputUser2));


	}

	public static void clearCMD() { 
 		System.out.print("\033[H\033[2J");  
		System.out.flush();  
  	}
}
