import java.util.Scanner;

public class ConsoleSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Board Width: ");
        int width = sc.nextInt();
        System.out.println("Enter Board Height: ");
        int height = sc.nextInt();
        System.out.println("Do you want the board to be populated with 80% of life? (0 = No/ 1 = Yes): ");
        int random = sc.nextInt();
        System.out.println("Lastly, how many generations do you want to see?: ");
        int generations = sc.nextInt();

        Gol life = new Gol(width, height, random);

        ///*Manually Assigning Life
        life.setLifeAlive(5, 5);
        life.setLifeAlive(5, 4);
        life.setLifeAlive(5, 3);
        life.setLifeAlive(5, 6);
        life.setLifeAlive(5, 7);
        //*/

        //life.jumpTo(6);
        for (int i = 0; i < generations; i++)
            life.updateBoard();
    }

}
