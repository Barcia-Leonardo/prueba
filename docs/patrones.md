
# Design patterns
These are the design patterns that we have thought would be useful for our project since they solve different problems


## 1-Builder:


This interface defines a contract to construct **_different types of properties_** in a flexible manner, allowing the creation of properties with different characteristics without exposing their internal complexity.

## 2-Mediator:


This interface defines a contract to **_mediate interactions between the different components of the game_**, such as players, properties and the bank, facilitating communication and reducing direct dependencies.

## 3-Strategy:


This interface defines a contract to **_represent different game strategies_** that can be adopted by virtual players, such as conservative, balanced and aggressive, encapsulating the specific behavior of each strategy.


## 4-State:

This interface defines a contract to **_represent the different states a player may be in during the game_**, such as being in jail, at the exit or on one's own property, encapsulating the behavior corresponding to each state.


## 5-Observer:

This interface defines a contract so **_that interested objects can subscribe and receive notifications about important events that occur in the game_**, such as turn changes or player actions.

## 6-Factory Method:

This interface defines a contract to **_create different types of game-related objects, such as properties and cards_**, allowing flexible and decoupled creation of these elements.


## 7-Singleton:

No specific interface is defined for **_this pattern, as its goal is to ensure that there is only one instance of certain objects in the entire game_**, such as the board or the bank or the player, providing a global access point to these instances.
