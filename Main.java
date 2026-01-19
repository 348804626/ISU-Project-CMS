//NAME: Jordyn Henriques
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    // 1 - Setting up the board
    private static void showGameboard(char[] gameBoard) {
        System.out.println(gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]);
        System.out.println(" - + - + - ");
        System.out.println(gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]);
        System.out.println(" - + - + - ");
        System.out.println(gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //2 - adding the ability to quit
        boolean gameplay = true;

        //3 - Introduction
        while (gameplay) {
            System.out.println("Final Culminating Loading...\n---- Welcome to TIC TAC TOE! ----");
            System.out.println("Please select the CORRESPONDING NUMBER for the GAME-MODE you wish to play!\n>1 For Player vs player\n>2 For Player vs AI\n>3 to QUIT");
            int gamemode = sc.nextInt();


            //4 - the placements for each square on the board
            char[] boardPlacements = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

            //5 - switch case for gamemodes
            switch (gamemode) {
                case 1:
                    System.out.println("Player v player selected");
                    int squaresFilledCounter = 0;
                    char currentPlayerTurn = 'x';


                    //6 - randomized role assignment
                    System.out.println("Decide with you partner who will be player 1 and 2");
                    int playerRole = (int) (Math.random() * (2 - 1 + 1) + 1);
                    System.out.println("Player " + playerRole + " is now 'X' and has the first turn. The other will be 'O'.");


                    //7 - Instructions and main game functions
                    while (squaresFilledCounter < 9) {
                        showGameboard(boardPlacements);
                        System.out.println(currentPlayerTurn + ": " + "Select a square by typing in the correct number to place your icon: ");
                        int input = sc.nextInt() - 1;


                        //8 - if a square is taken
                        while (boardPlacements[input - 1] == 'x' || boardPlacements[input - 1] == 'o') {
                            System.out.println("This space has been taken, please select a different square:");
                            input = sc.nextInt() - 1;
                        }

                        //9 - replacing the number into the current icon x/o
                        boardPlacements[input] = currentPlayerTurn;


                        //10 - checking for 3 in a row !
                        if ((boardPlacements[0] + boardPlacements[1] + boardPlacements[2] == (currentPlayerTurn * 3)) //rows
                                || (boardPlacements[3] + boardPlacements[4] + boardPlacements[5] == (currentPlayerTurn * 3))
                                || (boardPlacements[6] + boardPlacements[7] + boardPlacements[8] == (currentPlayerTurn * 3))
                                || (boardPlacements[0] + boardPlacements[3] + boardPlacements[6] == (currentPlayerTurn * 3)) // columns
                                || (boardPlacements[1] + boardPlacements[4] + boardPlacements[7] == (currentPlayerTurn * 3))
                                || (boardPlacements[2] + boardPlacements[5] + boardPlacements[8] == (currentPlayerTurn * 3))
                                || (boardPlacements[0] + boardPlacements[4] + boardPlacements[8] == (currentPlayerTurn * 3)) // diagonals
                                || (boardPlacements[2] + boardPlacements[4] + boardPlacements[6] == (currentPlayerTurn * 3))
                        ) {
                            //11 - winning message + continuing gameplay w/ switching turns
                            showGameboard(boardPlacements);
                            System.out.println("Player " + currentPlayerTurn + " has won the game!!!");
                            break;
                        } else {
                            squaresFilledCounter++;
                            if (currentPlayerTurn == 'x') {
                                currentPlayerTurn = 'o';
                            } else {
                                currentPlayerTurn = 'x';
                            }
                        }
                    }
                    //12 - draw function
                    if (squaresFilledCounter == 9) {
                        showGameboard(boardPlacements);
                        System.out.println("It's a draw!");
                    }
                    System.out.println("Would you like to play again? Type Yes/No");
                    sc.nextLine();
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("yes")) {
                        gameplay = true;
                    } else {
                        gameplay = false;
                    }
                    break;


                case 2: //AI case
                    System.out.println("Player v AI selected");
                    System.out.println(">Player will be player 1 and thus 'X'\n>AI will be player 2 and 'O'");
                    squaresFilledCounter = 0;
                    char currentTurn = 'x';
                    boolean AIGame = true;

                    while (AIGame && squaresFilledCounter < 9) {
                        showGameboard(boardPlacements);

                        //player's turn
                        System.out.println(currentTurn + ": " + "Select a square by typing in the correct number to place your icon: ");
                        int Userinput = sc.nextInt() - 1;

                        while (boardPlacements[Userinput] == 'x' || boardPlacements[Userinput] == 'o') {
                            System.out.print("This space has been taken, please select a different square: ");
                            Userinput = sc.nextInt() - 1;
                        }
                        //not putting in the ability that the player can win
                        boardPlacements[Userinput] = currentTurn;
                        squaresFilledCounter++;

                        //AI's turn
                        boolean AIMove = false;

                        //checking if the AI can make 3 in a row
                        if (boardPlacements[0] == 'o' && boardPlacements[1] == 'o' && boardPlacements[2] != 'x' && boardPlacements[2] != 'o') {
                            boardPlacements[2] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[0] == 'o' && boardPlacements[2] == 'o' && boardPlacements[1] != 'x' && boardPlacements[1] != 'o') {
                            boardPlacements[1] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[1] == 'o' && boardPlacements[2] == 'o' && boardPlacements[0] != 'x' && boardPlacements[0] != 'o') { //first row
                            boardPlacements[0] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[3] == 'o' && boardPlacements[4] == 'o' && boardPlacements[5] != 'x' && boardPlacements[5] != 'o') {
                            boardPlacements[5] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[3] == 'o' && boardPlacements[5] == 'o' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o') {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[4] == 'o' && boardPlacements[5] == 'o' && boardPlacements[3] != 'x' && boardPlacements[3] != 'o') { //second row
                            boardPlacements[3] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[6] == 'o' && boardPlacements[7] == 'o' && boardPlacements[8] != 'x' && boardPlacements[8] != 'o') {
                            boardPlacements[8] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[6] == 'o' && boardPlacements[8] == 'o' && boardPlacements[7] != 'x' && boardPlacements[7] != 'o') {
                            boardPlacements[7] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[7] == 'o' && boardPlacements[8] == 'o' && boardPlacements[6] != 'x' && boardPlacements[6] != 'o') {  // third row
                            boardPlacements[6] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[0] == 'o' && boardPlacements[3] == 'o' && boardPlacements[6] != 'x' && boardPlacements[6] != 'o') {
                            boardPlacements[6] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[0] == 'o' && boardPlacements[6] == 'o' && boardPlacements[3] != 'x' && boardPlacements[3] != 'o') {
                            boardPlacements[3] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[3] == 'o' && boardPlacements[6] == 'o' && boardPlacements[0] != 'x' && boardPlacements[0] != 'o') { //first column
                            boardPlacements[0] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[1] == 'o' && boardPlacements[4] == 'o' && boardPlacements[7] != 'x' && boardPlacements[7] != 'o') {
                            boardPlacements[7] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[1] == 'o' && boardPlacements[7] == 'o' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o') {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[4] == 'o' && boardPlacements[7] == 'o' && boardPlacements[1] != 'x' && boardPlacements[1] != 'o') { //second column
                            boardPlacements[1] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[2] == 'o' && boardPlacements[5] == 'o' && boardPlacements[8] != 'x' && boardPlacements[8] != 'o') {
                            boardPlacements[8] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[2] == 'o' && boardPlacements[8] == 'o' && boardPlacements[5] != 'x' && boardPlacements[5] != 'o') {
                            boardPlacements[5] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[5] == 'o' && boardPlacements[8] == 'o' && boardPlacements[2] != 'x' && boardPlacements[2] != 'o') { //third column
                            boardPlacements[2] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[0] == 'o' && boardPlacements[4] == 'o' && boardPlacements[8] != 'x' && boardPlacements[8] != 'o') {
                            boardPlacements[8] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[0] == 'o' && boardPlacements[8] == 'o' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o') {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[4] == 'o' && boardPlacements[8] == 'o' && boardPlacements[0] != 'x' && boardPlacements[0] != 'o') { // diagonal1
                            boardPlacements[0] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[2] == 'o' && boardPlacements[4] == 'o' && boardPlacements[6] != 'x' && boardPlacements[6] != 'o') {
                            boardPlacements[6] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[2] == 'o' && boardPlacements[6] == 'o' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o') {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if (boardPlacements[4] == 'o' && boardPlacements[6] == 'o' && boardPlacements[2] != 'x' && boardPlacements[2] != 'o') {
                            boardPlacements[2] = 'o';
                            AIMove = true;


                            //checking if the AI needs to block the player from winning
                        } else if ((!AIMove && boardPlacements[0] == 'x' && boardPlacements[1] == 'x' && boardPlacements[2] != 'x' && boardPlacements[2] != 'o')) {
                            boardPlacements[2] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[0] == 'x' && boardPlacements[2] == 'x' && boardPlacements[1] != 'x' && boardPlacements[1] != 'o')) {
                            boardPlacements[1] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[1] == 'x' && boardPlacements[2] == 'x' && boardPlacements[0] != 'x' && boardPlacements[0] != 'o')) { // first row prevention
                            boardPlacements[0] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[3] == 'x' && boardPlacements[4] == 'x' && boardPlacements[5] != 'x' && boardPlacements[5] != 'o')) {
                            boardPlacements[5] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[3] == 'x' && boardPlacements[5] == 'x' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o')) {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[4] == 'x' && boardPlacements[5] == 'x' && boardPlacements[3] != 'x' && boardPlacements[3] != 'o')) { //second row prevention
                            boardPlacements[3] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[6] == 'x' && boardPlacements[7] == 'x' && boardPlacements[8] != 'x' && boardPlacements[8] != 'o')) {
                            boardPlacements[8] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[6] == 'x' && boardPlacements[8] == 'x' && boardPlacements[7] != 'x' && boardPlacements[7] != 'o')) {
                            boardPlacements[7] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[7] == 'x' && boardPlacements[8] == 'x' && boardPlacements[6] != 'x' && boardPlacements[6] != 'o')) { //third row prevention
                            boardPlacements[6] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[0] == 'x' && boardPlacements[3] == 'x' && boardPlacements[6] != 'x' && boardPlacements[6] != 'o')) {
                            boardPlacements[6] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[0] == 'x' && boardPlacements[6] == 'x' && boardPlacements[3] != 'x' && boardPlacements[3] != 'o')) {
                            boardPlacements[3] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[3] == 'x' && boardPlacements[6] == 'x' && boardPlacements[0] != 'x' && boardPlacements[0] != 'o')) { //first column prevention
                            boardPlacements[0] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[1] == 'x' && boardPlacements[4] == 'x' && boardPlacements[7] != 'x' && boardPlacements[7] != 'o')) {
                            boardPlacements[7] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[1] == 'x' && boardPlacements[7] == 'x' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o')) {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[4] == 'x' && boardPlacements[7] == 'x' && boardPlacements[1] != 'x' && boardPlacements[1] != 'o')) { //second column prevention
                            boardPlacements[1] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[2] == 'x' && boardPlacements[5] == 'x' && boardPlacements[8] != 'x' && boardPlacements[8] != 'o')) {
                            boardPlacements[8] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[2] == 'x' && boardPlacements[8] == 'x' && boardPlacements[5] != 'x' && boardPlacements[5] != 'o')) {
                            boardPlacements[5] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[5] == 'x' && boardPlacements[8] == 'x' && boardPlacements[2] != 'x' && boardPlacements[2] != 'o')) { //third column prevention
                            boardPlacements[2] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[0] == 'x' && boardPlacements[4] == 'x' && boardPlacements[8] != 'x' && boardPlacements[8] != 'o')) {
                            boardPlacements[8] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[0] == 'x' && boardPlacements[8] == 'x' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o')) {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[4] == 'x' && boardPlacements[8] == 'x' && boardPlacements[0] != 'x' && boardPlacements[0] != 'o')) { //diagonal 1
                            boardPlacements[0] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[2] == 'x' && boardPlacements[4] == 'x' && boardPlacements[6] != 'x' && boardPlacements[6] != 'o')) {
                            boardPlacements[6] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[2] == 'x' && boardPlacements[6] == 'x' && boardPlacements[4] != 'x' && boardPlacements[4] != 'o')) {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardPlacements[4] == 'x' && boardPlacements[6] == 'x' && boardPlacements[2] != 'x' && boardPlacements[2] != 'o')) { //diagonal 2
                            boardPlacements[2] = 'o';
                            AIMove = true;


                            //always places 'o' in the middle for more oppurtunities to win on first turn if it can
                        } else if (!AIMove && boardPlacements[4] != 'x' && boardPlacements[4] != 'o') {
                            boardPlacements[4] = 'o';
                            AIMove = true;
                        } else if (!AIMove) {
                            int[] corners = {0, 2, 6, 8}; //make an array for the corners
                            for (int i = 0; i < 4 && !AIMove; i++) {
                                if (boardPlacements[corners[i]] != 'x' && boardPlacements[i] != 'o') {
                                    boardPlacements[corners[i]] = 'o';
                                    AIMove = true;
                                }
                            }
                        }

                        //fill any other square [last ditch effort] for a draw
                        if (!AIMove) {
                            for (int i = 0; i < 9; i++) {
                                if (boardPlacements[i] != 'x' && boardPlacements[i] != 'o') {
                                    boardPlacements[i] = 'o';
                                    AIMove = true;
                                    break;
                                }
                            }
                        }

                        if ((boardPlacements[0] + boardPlacements[1] + boardPlacements[2] == ('o' * 3)) //rows
                                || (boardPlacements[3] + boardPlacements[4] + boardPlacements[5] == ('o' * 3))
                                || (boardPlacements[6] + boardPlacements[7] + boardPlacements[8] == ('o' * 3))
                                || (boardPlacements[0] + boardPlacements[3] + boardPlacements[6] == ('o' * 3)) // columns
                                || (boardPlacements[1] + boardPlacements[4] + boardPlacements[7] == ('o' * 3))
                                || (boardPlacements[2] + boardPlacements[5] + boardPlacements[8] == ('o' * 3))
                                || (boardPlacements[0] + boardPlacements[4] + boardPlacements[8] == ('o' * 3)) // diagonals
                                || (boardPlacements[2] + boardPlacements[4] + boardPlacements[6] == ('o' * 3))
                        ) {
                            showGameboard(boardPlacements);
                            System.out.println("The AI has won the game!!!");
                            break;
                        }
                        squaresFilledCounter++;
                    }
                    if (squaresFilledCounter == 9) {
                        showGameboard(boardPlacements);
                        System.out.println("It's a draw!");
                    }
                        System.out.println("Would you like to play again? [yes/no]");
                        sc.nextLine();
                        String userAnswer = sc.nextLine();
                        if (userAnswer.equalsIgnoreCase("yes")) {
                            AIGame = true;
                        } else {
                            AIGame = false; //quits
                        }
                    break;

                        //manual player quit
                case 3:
                    System.out.println("quitting...");
                    gameplay = false;
                    break;

                    //needed default statement
                default:
                    System.out.println("Invalid option. Quitting program.");
                    break;
            }
        }
        sc.close();
    }
}


