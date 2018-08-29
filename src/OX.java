import java.util.Scanner;

public class OX {
        String [][] table = new String[3][3];
        String player = "X";
        int count = 0;
        int col,row;
        Scanner in = new Scanner(System.in);
        void fill(String [][] table){
            for (int i = 0;i < 3;i++){
                for(int j = 0; j < 3 ;j++){
                    table[i][j] = "-";
                }
            }
        }
        void swapPlayer(String player){
            if(player.equals("X")){
                this.player = "O";
            } else {
                this.player = "X";
            }
        }
        void getTable() {
            int row = 0;
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i);
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + table[i][j]);
                }
                System.out.println();
            }
        }
        void put(){
            for(;;){
                System.out.println(player + (" (col): "));
                col = in.nextInt();
                System.out.println(player + (" (row): "));
                row = in.nextInt();
                if (table[row][col].equals("-")){
                    table[row][col] = player;
                    break;
                } else {
                    System.out.println("try again");
                }
            }
        }
        boolean checkWin(String p){
            boolean rowWin=true,colWin=true,esWin=true,ssWin=true;
            for(int i = 0;i < 3;i++){
               if(!table[i][i].equals(p)){
                   esWin = false;
               }
               if(!table[0+i][2-i].equals(p)){
                   ssWin = false;
               }
            }
            if(esWin || ssWin){
                return true;
            }
            for(int i=0;i < 3;i++){
                rowWin=true;
                colWin=true;
                for(int j=0;j < 3;j++){
                    if (!table[i][j].equals(p)){
                        rowWin = false;
                    }
                    if (!table[j][i].equals(p)){
                        colWin = false;
                    }
                }
            }
            if (rowWin || colWin) {
                return true;
            }
            count++;
            return false;
        }
        void displayWinner(String winner){
            int x=0,o=0,draw=0;
            getTable();
            if(winner.equals("X")) {
                x++;
            }else if(winner.equals("O")) {
                o++;
            }else {
                draw++;
            }
            System.out.println("X win "+x);
            System.out.println("O win "+o);
            System.out.println("Draw "+draw);
        }
        public static void main (String [] args){
            OX ox = new OX();
            ox.fill(ox.table);
            for(;;){
                ox.getTable();
                ox.put();
                if(ox.checkWin(ox.player)){
                    ox.displayWinner(ox.player);
                    break;
                    }
                if(ox.count==9) {
                    ox.displayWinner("Draw");
                    break;
                }
                    ox.swapPlayer(ox.player);
                }
            }
        }


