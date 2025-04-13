import java.util.Scanner;

public class HillCipher {
    private static final int SIZE = 3;

    private static void getKeyMatrix(String key, int[][] keyMatrix) {
        for (int i = 0, k = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++, k++)
                keyMatrix[i][j] = key.charAt(k) - 'A';
    }

    private static void matrixMultiply(int[][] result, int[][] mat1, int[][] mat2) {
        for (int i = 0; i < SIZE; i++) {
            result[i][0] = 0;
            for (int j = 0; j < SIZE; j++)
                result[i][0] += mat1[i][j] * mat2[j][0];
            result[i][0] = (result[i][0] % 26 + 26) % 26;
        }
    }

    private static int determinant(int[][] mat, int n) {
        if (n == 1) return mat[0][0];
        int det = 0;
        for (int f = 0, sign = 1; f < n; f++, sign = -sign)
            det += sign * mat[0][f] * determinant(getCofactor(mat, 0, f, n), n - 1);
        return det;
    }

    private static int[][] getCofactor(int[][] mat, int p, int q, int n) {
        int[][] temp = new int[SIZE][SIZE];
        for (int i = 0, row = 0; i < n; i++) {
            if (i == p) continue;
            for (int j = 0, col = 0; j < n; j++) {
                if (j == q) continue;
                temp[row][col++] = mat[i][j];
            }
            row++;
        }
        return temp;
    }

    private static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1) return x;
        return -1;
    }

    private static void inverse(int[][] keyMatrix, int[][] inverseKeyMatrix) {
        int det = determinant(keyMatrix, SIZE);
        int invDet = modInverse(det, 26);
        if (invDet == -1) throw new IllegalArgumentException("Inverse doesn't exist.");

        int[][] adj = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                adj[j][i] = (int) Math.pow(-1, i + j) * determinant(getCofactor(keyMatrix, i, j, SIZE), SIZE - 1);

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                inverseKeyMatrix[i][j] = ((adj[i][j] * invDet) % 26 + 26) % 26;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Encrypt\n2. Decrypt\nChoose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter 3-letter text: ");
        String text = sc.nextLine();
        System.out.print("Enter 9-letter key: ");
        String key = sc.nextLine();

        int[][] keyMatrix = new int[SIZE][SIZE], textVector = new int[SIZE][1], resultMatrix = new int[SIZE][1];
        getKeyMatrix(key, keyMatrix);
        for (int i = 0; i < SIZE; i++) textVector[i][0] = text.charAt(i) - 'A';

        if (choice == 2) {
            int[][] inverseKeyMatrix = new int[SIZE][SIZE];
            inverse(keyMatrix, inverseKeyMatrix);
            matrixMultiply(resultMatrix, inverseKeyMatrix, textVector);
        } else {
            matrixMultiply(resultMatrix, keyMatrix, textVector);
        }

        System.out.print((choice == 1 ? "Ciphertext: " : "Decrypted Message: "));
        for (int i = 0; i < SIZE; i++) System.out.print((char) (resultMatrix[i][0] + 'A'));
        System.out.println();
        sc.close();
    }
}
