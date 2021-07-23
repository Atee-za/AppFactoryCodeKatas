import java.util.Random;

public class Gof {
    private int width, height, generation, random;
    private int[][] board;

    public Gof(int width, int height, int random) {
        this.width = width;
        this.height = height;
        this.generation = 0;
        this.random = random;
        initializeBoard();
    }

    private void initializeBoard(){
        Random rand = new Random();
        this.board = new int[width][height];
        if(random > 0){
            int value;
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    value = rand.nextInt(11);
                    if(value >= 8)
                        this.board[x][y] = 1;
                }
            }
        }
    }

    private void printBoard() {
        System.out.println("---");
        for (int x = 0; x < width; x++) {
            String border = "|  ";
            for (int y = 0; y < height; y++) {
                if (this.board[x][y] == 0) {
                    border += ".  ";
                } else {
                    border += "*  ";
                }
            }
            border += "|";
            System.out.println(border);
        }
        System.out.println("Life Population: "+lifePopulation());
        System.out.println("Generation: "+generation+"\n---\n");
    }

    public void setLifeAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setLifeDead(int x, int y) {
        this.board[x][y] = 0;
    }

    private int numOfNeighbours(int x, int y) {
        int count = 0;
        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }

    private int getState(int x, int y) {
        if (x < 0 || x >= width) return 0;
        if (y < 0 || y >= height) return 0;
        return this.board[x][y];
    }

    private void updateBoard() {
        int[][] newBoard = new int [width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int aliveNeighbours = numOfNeighbours(x, y);

                if (getState(x, y) == 1) {
                    if (aliveNeighbours < 2)
                        newBoard[x][y] = 0; // Less Population
                    else if (aliveNeighbours == 2 || aliveNeighbours == 3)
                        newBoard[x][y] = 1; // Just the Correct Population
                    else
                        newBoard[x][y] = 0; //Over Populated
                } else {
                    if (aliveNeighbours == 3)
                        newBoard[x][y] = 1;
                }
            }
        }
        generation ++;
        this.board = newBoard;
    }

    private String lifePopulation(){
        int sum = 0;
        final double totalBlocks = width*height;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                sum += board[x][y];
            }
        }
        double population = (sum/totalBlocks)*100;
        return String.format("%.2f%s", population,"%");
    }

    public void simulateLife(){
        printBoard();
        updateBoard();
    }
}
