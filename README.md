Part 1 – components
!! Variables !!
	→ For the AI section, I make new variables just to make sure everything is precise and nothing is mucky with the pvp section – that is why there are slashes in between as they have the same base function
	
Boolean gameplay / AIGame → adds the crucial gameplay loop to give the player the ability to replay from the main menu and the ability to quit the game at the end of a game
int gamemode → enables the switch case from the user’s input to fill this variable. Connects with the 3 switch case options [pvp, pvAI, quit]
int squaresFilledCounter → initializes the variable at 0 and serves the main purpose of counting how many times the player(s) place a symbol to, if needed, call a tie/draw. 
char currentPlayerTurn / currentTurn → Sets the current player’s turn to x, as the first person to play will always be x. Also helps when discerning who the winner is. Turns to o after every turn 
int playerRole → randomizes which player gets ‘x’ and thus the first turn or ‘o’
int input /Userinput → Stores the numerical value inputted by the user to correlate to where on the gameBoard they want to place it. Is subtracted by 1 to avoid an OutOfBoundException.
String answer /userAnswer → stores the answer given by the user if they wish to play again or not. Is then checked by an if statement to break or continue looping the code. 
boolean AIMove → tracks the AI’s move by updating to true [initialized as false] once placed. Resets when the (squaresFilledCounter < 9) updates to allow it to move again
int i → within the FIRST for loop to check for the AI’s move to pick a corner if there is no option for middle placement 
int i → within the SECOND for loop as a fall back to if the AI somehow has no corners and no middle to go to, it will go to one of the 9 spots on the board

!! Arrays !!
char[] gameBoard → creates the empty slots and the physical board for the game to take place on. Made inside the private static void showGameboard class so we can call upon it anytime we need
char[] boardPlacements → the temporary number display slots marking the squares able to be filled by the user’s input to place their symbol in. Replaced after every user input. 
int[] corners → Created for the AI to choose one of the corners if the middle slot is taken for prime strategy.  

!! Classes !!
private static void showGameboard(char[] gameBoard) → the class created so we can display the gameboard when needed[after every turn], and to have the array for the structure of the board
public static void main(String[] args) → the main class that the rest of the program takes place in just like the regular codes we do


Part 2 – Logic + breakdown
1. Set up the board in the showGameboard class
2. The replay function and the ability to quit in the boolean variable
3. The introduction to the game and the main menu options as we enter the gameplay loop! 
4. Creation of the numerical slots in the gameboard 
5. Switch case is being used here for the different options and gamemodes in the menu [pvp, pvAI, quit, default] → The first is player versus player and initializes the counter and the currentPlayerTurn
6. Randomized role assignment is to choose which player gets the first move at random to keep the game fun and new using Math.random
7. Instructions and main game functions → it sets up the counter to be < 9 so once it’s equal to nine, it calls a draw and ends this main gameplay loop as it can’t continue. It also shows the updated board, gives instructions on how to place the players symbol, and makes sure that input is aligned with the array
8. This section is to put the player into a loop if they choose a square that already has a symbol in it and doesn’t let them out until they choose a different one. 
9. This is just replacing the number in the array to the correct symbol
10. Checks each row, column, and diagonal for a potential 3 in a row using the arrays
11. If there are 3 in a row, this displays a winning message, but if there isn’t, it switches the turn from one symbol to the next, continuing the gameplay
12. Checks if the amount of squares filled in is 9 and if so displays the draw message
13. Asks the user if they would like to play again. The sc.nextLine(); that’s empty directly after clears the enter that the first user input outside of the variable didn’t clear, which then allows to correctly gather and store the user input in a String variable. This variable, answer, is then checked in an if statement, if it is yes then the gameplay loop remains true and if it’s false it quits, the case breaks, and the code ends. 
14. Introduction to the AI gamemode is the same as the pvp one but it creates a new variable for the boolean loop
15. Is the player’s turn and functions the exact same as the one in the pvp section, including the function to keep them in a while loop if they choose a spot that already is taken
16. Only updates the counter and the board placement, making it so there is literally no check or option for the player to win
17. Creates the boolean variable for the AI’s turn tracking 
18. Checks if the AI can make 3 in a row[if there is an “empty” slot] to exit the rest of the if statements 
19. Checks if the AI needs to stop the player from winning [if they have 2 in a row]
20. Always places the symbol in the middle if it can as it’s good strategy 
21. If it can’t go into the middle, it will check a corner listed in the array, another good strategy move
22. Last ditch effort for a draw, so it will place anywhere to end the game
23. Checks each row, column, and diagonal if the AI got 3 in a row
24. Winning message for the AI and updates the counter out of the if statement 
25. Draw statement 
26. Replay function the exact same as the pvp one
27. Manual player quit 
28. Needed default statement 
