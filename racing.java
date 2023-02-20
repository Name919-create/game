import java.util.Scanner;

public class CarRacing {

    static int trackLength = 50;
    static int player1Position = 0;
    static int player2Position = 0;
    static int player1Speed = 0;
    static int player2Speed = 0;
    static int player1Boost = 3;
    static int player2Boost = 3;
    static int player1Score = 0;
    static int player2Score = 0;
    static boolean gameOver = false;

    public static void main(String[] args) {

        System.out.println("Welcome to Car Racing!");

        Scanner input = new Scanner(System.in);

        while (!gameOver) {

            // Player 1 input
            System.out.println("Player 1, press 'a' to move left, 'd' to move right, 'w' to boost");
            String player1Input = input.next();

            if (player1Input.equals("a")) {
                player1Speed--;
            } else if (player1Input.equals("d")) {
                player1Speed++;
            } else if (player1Input.equals("w") && player1Boost > 0) {
                player1Speed += 2;
                player1Boost--;
            }

            // Player 2 input
            System.out.println("Player 2, press 'j' to move left, 'l' to move right, 'i' to boost");
            String player2Input = input.next();

            if (player2Input.equals("j")) {
                player2Speed--;
            } else if (player2Input.equals("l")) {
                player2Speed++;
            } else if (player2Input.equals("i") && player2Boost > 0) {
                player2Speed += 2;
                player2Boost--;
            }

            // Update positions and scores
            player1Position += player1Speed;
            player2Position += player2Speed;
            player1Score++;
            player2Score++;

            // Apply obstacles and power-ups
            applyObstacles();
            applyPowerUps();

            // Check for finish line
            if (player1Position >= trackLength) {
                System.out.println("Player 1 wins!");
                gameOver = true;
            } else if (player2Position >= trackLength) {
                System.out.println("Player 2 wins!");
                gameOver = true;
            }

            // Display track and scores
            displayTrack();

        }
    }

    static void applyObstacles() {
        // Apply random obstacles to slow down players
        if (Math.random() < 0.1) {
            player1Speed -= 2;
            System.out.println("Player 1 hit an obstacle!");
        }
        if (Math.random() < 0.1) {
            player2Speed -= 2;
            System.out.println("Player 2 hit an obstacle!");
        }
    }

    static void applyPowerUps() {
        // Apply random power-ups to speed up players
        if (Math.random() < 0.1) {
            player1Speed += 2;
            System.out.println("Player 1 got a power-up!");
        }
        if (Math.random() < 0.1) {
            player2Speed += 2;
            System.out.println("Player 2 got a power-up!");
        }
    }


    static void displayTrack() {
    
        // Display the track
        for (int i = 0; i < trackLength; i++) {
            if (i == player1Position) {
                System.out.print("1");
            } else if (i == player2Position) {
                System.out.print("2");
            } else {
                System.out.print("-");
            }
        }
    
        // Display scores and boosts
        System.out.println("  Score: " + player1Score + " Boost: " + player1Boost+ "     Score: " + player2Score + " Boost: " + player2Boost);
    }
}


