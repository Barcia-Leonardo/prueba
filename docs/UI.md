# User Experience

## Game Start
The backend provides a Command Line Interface for user interaction. The player initiates the app from the terminal. If he is not registrated he will have to sign in, and if he is already registrated he will log in. After entering his user info, the player can choose between creating a new game or load an old one. Then, a start menu is displayed in the terminal where the player can select the game mode (only if this is a new game) and will ask if the user wants to win the game when it reach a specific amount of money, if the user accept has to enter the maximum amount of the game. Then it appear 2 messages those will read “type help if you need it” and “type exit if you want to stop playing”.
## During the Game
The backend manages the game logic and provides updates in the terminal about the current game state. Messages are shown in the terminal indicating whose turn it is and what actions are available. 
The player will always have visual info of his total money and properties (and upgrades if its the case), as well it can interacts with the game by entering commands (numbers, "help", "exit" or "save") in the terminal after the player roll dices (obligatory) and land in a box. Depending on the box, the player has diferrents options where it can decide to: 

   -`Type "1" `for buying a property if its on sale, the price of the property will be on screen and if it accepts the amount will be discount from his  money and give it to the bank.

   -`Type "2"` for hypothecate property, if the player wants to sell a property to the bank, then decide which property wants to sale. And the amount of the mortgage will be accredited on his money.

   -`Type “3"` for upgrading property. This option its only available if the player is owner of all the properties in the province, it could be an upgrade of "chacras" or "estancia" the value of the upgrade will be on screen and the amount it will be discount from player's money and give it to the bank. The player has to choose the property upgrading, on screen it will appear an indexed list of the player's properties and type the number of the property for upgrading.

   -`Type “4"` for using special card. This option its only available if the player is in jail and if it already has a special card of lucky or destiny for getting out for free.

   -`Type “5" `for waiting turn in case the player lands on an empty box (rest box, jail box, free tax box) or a box without an owner and doesn't want to buy it. 

   -`Type "exit"` for getting out the game with the last saved.

   -`Type "save"` for saving the game at any moment.

   -`Type "help"` for getting the information of the game (rules and instructions). 

   -The player will PAY RENT anytime it lands on a property owned by other player. This is not a decision. The price of the rent/tax will be on screen and the amount it will be discount from his money and give it to the owner. Also, this will happen if the player has to pay a tax (to the bank or another player) if the card of lucky or destiny indicate to. In case the player couldn't afford the price of the rent or tax, on screen it will appear an indexed list of the player's properties and type the number of the property for hypothecate.

   -If the player get double dices it will roll dices again. But if it gets double dice for the third time in a row, it will automatically go to jail.

The backend processes the commands entered by the player and updates the game state accordingly. Text messages in the terminal are used to notify important events, for example landing on a destiny/lucky/jail box, paying rent, etc.
## End of Game
When a termination condition is met (for example, a player accumulates a certain amount of money, all other players go bankrupt or the user just finish the game), a message is displayed in the terminal announcing the end of the game. A summary is presented in the terminal with final statistics, such as the money accumulated by each player and the properties they owned.

### (Begin Menu)
--_To begin:_
- Sign up
- Sign in

-- _(Sign in Menu) Enter your user:_
- Name

#### User not found... Go to the Begin Menu.

### (Sign up Menu) Enter:
- Name
- Email
- Password
- Nationality
- Age

### (Command Menu)
-- _Game command:_
- Enter "help" at any time in console for getting help with the game.
- Enter "exit" at any time in console for get out the game.
- Enter "save" at any time in console for saving the game.

##### Enter any keys to continue:

### (Menu principal)
#### Continue saved game
--_Continue game:_
 #####   #IDgame

### Start a new game
-- _Select difficult_
   - Easy
   - Medium
   - Hard
 ##### Do you want to win the game when you reach a specific amount of money?: Y/N
  ##### Enter the max amount: BigDecimal.
   ### #newGame

### (Exit Menu)
--_"Exit"_
- Save game:   Y 
- Exit without saving:   N

### (Help Menu)
-- _"Help"_
- Instruction of the game rules.

### (Play menu) 
_--Player turn:_
 - Roll dices() //obligatory
 ##### At any time the player roll the dices, in the console it should be printed his total money and his properties with the upgrades.
       -1 Buy property()

       -2 Hypothecate property() //Select property by index

       -3 Upgrade property() //Select property by index

       -4 Use card()

       -5 Wait turn()

       -Pay rent() //not optional.
