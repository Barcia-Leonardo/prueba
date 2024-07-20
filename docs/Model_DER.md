
# Proposed resolution of the Estanciero

Group number 1: Estanciero, has proposed the following approach in order to face the next challenge, which is the Estanciero, identifying the following classes as the main ones and their relationships, a **DER model** will be presented.

## Model DER
A resolution of the DER model is proposed, with the functional classes for the Estanciero board game

## Class 

 ### Board
   - Attributes:
        -   boxes: boxes[]
        -  card: card[]
        - property: property[]
        - dice: dice[]
    -   Methods:
        -   getBoxers()
 ### Boxer
   -   Attributes:
        - type_box: types_box{}
        - property: property[]
    -   Methods:
        -   verifyState()
        -  getPawns()
        -  verifyBox()
        - getTypeBox()
 ### Pawn
   -  Attributes:
        -   pawn: integer
        -  money : bigdecimal
        - active : boolean
    -   Methods:
        -   movePawns()
        -   getPlayer()
        - getCard()
        - getProperty()
 ### Card
   -   Attributes: 
        -  description: string
        - card: string
    -   Methods:
        -   setTypeCard()
 ### Bank
   -   Attributes:
        -   bank: string
	    -   money: bigdecimal()
    -   Methods:
        -   getProperty()
### Property
   -   Attributes:
        -   property: string
        -   value: bigdecimal
        -   rent_value: bigdecimal
        -   description: string
    -   Methods:
        -   typeProperties()
        -   sellProperty()
        -   mortProperty()
        -   chargeRent()
        -   typeUpgrade()


 ### Type_Property
-   Attributes:
       -   typeProperty: sring
-   Methods:
       - getTypeProperties()
	 - stateProperty()
	- consultValueProperty()
		 
 ### Dice
-   Attributes:
       -   side: int
  -   Methods:
        -   getDice()
 ### Player
   -   Attributes:
        -   Player: string
    -   Methods:
        -   getTypePlayer()
        -   getTurn()
 ### Matche
   -   Attributes:
        -   stateMatches: boolean
        -   match : string
    -   Methods:
        -   getBoard()
        -   getPlayer()
        -   getDifficulty()
        -   getBank()
        -   getUser()
        -   
 ### Difficulty
   -   Attributes:
        -   difficulty: string
    -   Methods:
        -   getDifficulty()

 ### User
  - Attributes:
       -   Player: string
   -   Methods:
        -   getTypePlayer()
        -   getTurn()

 ### Zone
   - Attributes:
        -   zone: string
    -   Methods:
        -   getZone()
 ### Turn
   -   Attributes:
        -   turn: string
    -   Methods:
        -   getTurn()

 ### Type_player
   -   Attributes:
        -  description: string
    -   Methods:
        -   getTypePlayer()
    
 ### Type_card
-   Attributes:
	  -   typeCard: string     
   -   Methods:
        -   getTypeCard()
        
 ### Type_Upgrad
-   Attributes:
	  -   typeUpgrade: string     
   -   Methods:
        -   getTypeUpgrade()
		-   viewStateProperty()
		-   showUpgradeTypes()

 ### Type_Box
-   Attributes:
	  -   typeBox: string     
   -   Methods:
        - getTypeBox()
		-  viewProperty()

![Modelo Der](http://imgfz.com/i/CuZDol2.jpeg)

