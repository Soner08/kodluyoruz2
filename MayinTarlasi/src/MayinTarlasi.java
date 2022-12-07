import java.util.Random;
import java.util.Scanner;
public class MayinTarlasi {
    int [] [] harita;
    int [] [] tahta;
    int row, col;
    int maxMayınSayısı;
    boolean isOyun=true;
    Random rnd = new Random();
    Scanner scan = new Scanner(System.in);
    MayinTarlasi(int row, int col){
        this.row = row;
        this.col = col;
        harita = new int[row][col];
        tahta = new int[row][col];
        maxMayınSayısı=row*col/4;
    }
    public void run() {
        int win = 0;
        prepare();
        System.out.println("Mayınların Konumu");
        print(harita);
        System.out.println("=========================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");
        while (isOyun) {
            System.out.print("Satır Giriniz : ");
            int selRow = scan.nextInt();
            System.out.print("Sütun Giriniz : ");
            int selCol = scan.nextInt();
            if (selRow < 0 || selCol < 0 || selRow > row - 1 || selCol > col - 1) {
                System.out.println("Geçerli bir konum girmediniz !");
                break;
            } else if (harita[selRow][selCol] == 0) {

                if ((selRow > 0) && (harita[selRow - 1][selCol] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if ((selCol > 0) && (harita[selRow][selCol - 1] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if ((selRow < row - 1) && (harita[selRow + 1][selCol] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if ((selCol < col - 1) && (harita[selRow][selCol + 1] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if ((selRow > 0 && selCol > 0) && (harita[selRow - 1][selCol - 1] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if ((selRow > 0 && selCol < col - 1) && (harita[selRow - 1][selCol + 1] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if ((selRow < row - 1 && selCol > 0) && (harita[selRow + 1][selCol - 1] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if ((selRow < row - 1 && selCol < col - 1) && (harita[selRow + 1][selCol + 1] == 1)) {
                    tahta[selRow][selCol]++;
                }
                if (tahta[selRow][selCol] == 0) {
                    tahta[selRow][selCol] = -2;
                }
                win++;
                printB(tahta);
                if (win == (row * col) - maxMayınSayısı) {
                    System.out.println("Kazandınız");
                    break;
                }
            }
            if (harita[selRow][selCol] == 1) {
                isOyun = false;
                System.out.println("Game Over");
                print(harita);
            }

        }


    }

    public void prepare() {
        int rndR, rndC;
        int mineCount = 0;
        while (mineCount < maxMayınSayısı) {
            rndR = rnd.nextInt(row);
            rndC = rnd.nextInt(col);
            if (harita[rndR][rndC] == 0) {
                harita[rndR][rndC] = 1;
                mineCount++;

            }

        }

    }
    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }


    }

    public void printB(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.print(" - ");
                } else if (arr[i][j] > 0) {
                    System.out.print(arr[i][j]);

                } else if (arr[i][j] == -2) {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }


    }
}


