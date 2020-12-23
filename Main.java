import java.util.Scanner;


public class Main {

	static int total_path(int gridWidth, int gridHeight){

		/* jika user input nilai gridWidth-nya atau gridHeight-nya adalah
		   0 atau 1 */

		if (gridWidth == 0 || gridHeight == 0) {

			return 0; // nilai 0 karena ga ada baris dan kolom
		} else if (gridWidth == 1 || gridHeight == 1) {

			return 1; // nilai 1 karena hannya ada 1 jalan
		}

		// buat panjang baris dan panjang kolomnya
		// int[index baris][index kolom]

		int[][] nomorPath = new int[gridWidth][gridHeight]; 

		for (int b = 0; b < gridWidth; b++ ) {
			
			nomorPath[b][0] = 1; /* beri nilai cell di index 0 nya baris
									adalah 1 , harus 1*/
		}

		for (int k = 0; k < gridHeight; k++ ) {
			nomorPath[0][k] = 1; /* beri nilai cell di index 0 nya kolom
									adalah 1 , harus 1. */
		}

		for (int b = 1; b <gridWidth; b++ ) {
			for (int k = 1; k < gridHeight; k++ ) {

				nomorPath[b][k] = nomorPath[b-1][k] + nomorPath[b][k-1]; 
				/* di kurangi 1 agar cell-cell di index 0 tidak terbawa
				   karena di atas sudah di berikan nilai cell-cell di index 0 
				   yaitu bernilai 1
				*/ 
			}
		}
		return nomorPath[gridWidth - 1][gridHeight - 1];
		// di kurangi 1 karena ini dalam index serta index itu di mulai dari 0. 
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Masukan jumlah baris !");
		System.out.print("baris = ");
		int inputUser1 = scanner.nextInt();  // input user gridWidth
		System.out.println("\nMasukan jumlah kolom !");
		System.out.print("kolom = "); 
		int inputUser2 = scanner.nextInt(); // input user gridHeight
		clearCMD(); // untuk center View di CMD/Terminal
		System.out.print("\nBanyak kemungkinannya = ");
		System.out.println("\n Jumlah = "+total_path(inputUser1,inputUser2));


	}

	public static void clearCMD() { 
 		System.out.print("\033[H\033[2J");  
		System.out.flush();  
  	}
}
