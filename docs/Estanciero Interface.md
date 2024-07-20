# Estanciero Interface

### In this part we perform an interpretation of the abstraction, according to how we propose and interpret the exercise based on our experiences from the previous deliveries made. In our approach we identify five abstractions, showing their corresponding methods and explaining what they do.

1.  **Interface PlayerService:** manage the actions of the player during the game-
    -   Methods:
        -   `manageActions(Player player)`: manage the actions that the player can do in his turn (roll dices, buy properties, etc).
        -   `notifyEvent(String message)`: shows a message of event to the player.

2.  **Interface CardService:** manage the cards of each player
    
    -   Methods:
        -   `executeCardAction(Card card, Player player)`: runs the action of a card asociated to one player.
        -   `readCard()`:reads the card that activates the box, and once returned, places it back.
        -   `putCard()`:Place the card back into the deck at the end of everything.
        -   `random card()`: Shuffle the cards at the beginning of the game.

3. **Interface boxesService:** manage square actions when the pawn positions itself
    -   Methods:
        -   `checkStatus()`: Check if the status of the box.
        -   `getPawn()`: Obtains the pawn that reaches the square to interact with it.
        -   `getTypebox()`:  Check the different types of boxes that exist in the game, such as destination, luck, province, railway, prison.

4. **Interface property:**  manage actions related to properties.
    -   Methods:
        -   `getTypeProperty()`: Gets the different types of properties.
        -   `stateProperty()`: Check the status of the property.
        -   `valueProperty()`: The value of the property according to its type.
        -   `chargeRentValue()`:Verify the income values according to the types.
        -   `upgradeProperty()`:The improvement of the properties is carried out, meeting the requirements.
    
5. **Interface typesUpgrades:** manege of the different updates that can be made.
    -   Methods:
        -   `typeUpgrade()`: Shows the different types of improvements that can be made depending on the conditions.
        -   `stateUpgrade()`: Check if the improvements have already been made.
        -   `valiteUpgrade()`: To acquire a farm, you must obtain a complete province that is owned by that single player, to be able to make the improvement on the property.