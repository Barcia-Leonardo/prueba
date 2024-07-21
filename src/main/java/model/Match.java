package model;

import lombok.Data;
import model.board.*;
import model.player.Player;
import model.player.PlayerGame;
import model.player.TypePlayer;
import model.player.Aggresive;
import model.player.Balanced;
import model.player.Conservative;
import model.support.Difficulty;
import model.board.Bank;
import java.io.Serializable;
import java.util.*;

/**
 * Esta clase representa una partida en el juego.
 *
 * Una partida tiene un estado, un nombre asociado y contiene elementos como el tablero, los jugadores, la dificultad, el banco y las cartas.
 *
 * Implementa métodos para obtener diferentes elementos de la partida, como el tablero, los jugadores, la dificultad, el banco y las cartas.
 *
 * Esta implementación actual proporciona métodos de acceso para obtener diferentes elementos de la partida, pero aún no se implementa la lógica para iniciar o gestionar la partida.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */
@Data
public class Match implements Serializable {
    private Board board;
    private Bank bank;
    private transient Scanner scanner;

    private boolean matchState;

    private String matchName;

    private Difficulty difficulty;

    private List<Card> deck;

    private List<Player> players;

    private Integer limitMoney;

    private boolean saveCard;

    private int countCard;


    public Match() {
        this.board = new Board();
        this.bank = new Bank();
        this.scanner = new Scanner(System.in);
        this.players = new ArrayList<>();
        this.deck = Card.createCardList();
        Collections.shuffle(deck);
        this.saveCard=saveCard;
        this.countCard=countCard;
    }

    public void setDifficulty(Difficulty difficulty, Player humanPlayer) {
        this.difficulty = difficulty;
        this.players = createPlayers(difficulty, humanPlayer);
    }

    private List<Player> createPlayers(Difficulty difficulty, Player humanPlayer) {
        List<Player> players = new ArrayList<>();
        players.add(humanPlayer);

        switch (difficulty) {
            case FACIL:
                players.add(new Balanced("Diego", TypePlayer.BALANCED, 0, new Pawn(0, 35000, true),players));
                players.add(new Conservative("Mavi", TypePlayer.CONSERVATIVE, 0, new Pawn(0, 4500, true),players));
                System.out.println("Se crearon los boots para el juego con los siguientes parametros: " + players);
                break;
            case MEDIO:
                players.add(new Balanced("Diego", TypePlayer.BALANCED, 0, new Pawn(0, 35000, true),players));
                players.add(new Conservative("Mavi", TypePlayer.CONSERVATIVE, 0, new Pawn(0, 35000, true),players));
                players.add(new Aggresive("Ian", TypePlayer.AGGRESSIVE, 0, new Pawn(0, 35000, true),players));
                break;
            case DIFICIL:
                players.add(new Balanced("Diego", TypePlayer.BALANCED, 0, new Pawn(0, 35000, true),players));
                players.add(new Conservative("Mavi", TypePlayer.CONSERVATIVE, 0, new Pawn(0, 35000, true),players));
                players.add(new Conservative("Ian", TypePlayer.CONSERVATIVE, 0, new Pawn(0, 35000, true),players));
                players.add(new Aggresive("Leo", TypePlayer.AGGRESSIVE, 0, new Pawn(0, 5500, true),players));
                break;
            default:
                break;
        }

        return players;
    }

    public List<Player> getPlayers() {return players;}

    public void setTurns() {
        LetterByLetterPrinter.println("Ahora veremos los turnos! Los turnos van de quien " +
                "saque el valor mas alto de los dados");
        for(Player player : players) {
            Dice dice = new Dice();
            Integer valueDices = dice.getTotalDices();
            LetterByLetterPrinter.println(player + " has sacado un " + dice.getDiceOne() + " y " + dice.getDiceTwo() +
                    " un total de: " + valueDices);
            player.setTurn(valueDices);
        }
        Collections.sort(players, Comparator.comparingInt(p -> p.getTurn()));
        Collections.reverse(players);
        LetterByLetterPrinter.println("Los turnos han quedado de la siguiente manera: ");
        for(int i = 0; i < players.size(); i++) {
            LetterByLetterPrinter.println(i+1 + ": " + players.get(i).getplayerName());
        }

    }

    public void executeBox(int position, Player currentPlayer) {
        Box box = board.getBox(position);

        if (box != null) {
            switch (box.getTypeBox()) {
                case PROPERTIE, RAILWAY, SPECIAL:
                    accionPropertyBox(box.getProperty(), currentPlayer);
                    break;
                case TAX:
                    accionTaxBoxAction(currentPlayer, position);
                    break;
                case PRIZE:
                    accionPrizeBoxAction(currentPlayer);
                    break;
                case DESTINY:
                    accionDestinyAction(currentPlayer);
                    break;
                case LUCK:
                    accionLuckAction(currentPlayer);
                    break;
                case FREE:
                    accionFreeAction(position);
                    break;
                case EXIT:
                    accionExitAction();
                    break;
                case GOTOPRISON:
                    accionPrisonAction(currentPlayer);
                    break;

                default:
                    System.out.println("");
                    break;
            }
        } else {
            System.out.println("Error: No se encontró la casilla.");
        }
    }

    public void accionPrisonAction(Player currentPlayer) {
            currentPlayer.getPawn().setActive(false);
            LetterByLetterPrinter.println("Ha caido en prision. Marche preso directamente.");
            currentPlayer.getPawn().setPosition(14);
            currentPlayer.setPrisonTurns(2);
    }

    public void PrisonTurn(Player currentPlayer) {
        LetterByLetterPrinter.println(currentPlayer.getplayerName() + "se encuentra en prisión. Tienes " + currentPlayer.getPrisonTurns() + " turnos restantes en prisión.");
        if (currentPlayer.getTypePlayer() == TypePlayer.HUMAN) {
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1- Pagar la fianza de 1000 para salir");
            System.out.println("2- Utilizar la carta de Suerte o Destino para salir");
            System.out.println("3- No hacer nada y esperar");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    if (currentPlayer.getPlayerGame().getMoney() >= 1000) {
                        currentPlayer.getPlayerGame().payMoney(1000);
                        currentPlayer.getPlayerGame().restPatrimony(1000);
                        currentPlayer.setPrisonTurns(0);
                        LetterByLetterPrinter.println("Has pagado la fianza y has salido de prisión.");
                    } else {
                        LetterByLetterPrinter.println("No tienes suficiente dinero para pagar la fianza.");
                    }
                    break;
                case "2":
                    if (saveCard) {
                        saveCard = false;
                        countCard = 0;
                        currentPlayer.setPrisonTurns(0);
                        LetterByLetterPrinter.println("Has utilizado la carta para salir de prisión.");
                    } else {
                        LetterByLetterPrinter.println("No tienes una carta para salir de prisión.");
                    }
                    break;
                case "3":
                    currentPlayer.decrementPrisonTurns();
                    if (currentPlayer.isPrison()) {
                        LetterByLetterPrinter.println("Debes permanecer en prisión. Te quedan " + currentPlayer.getPrisonTurns() + " turnos.");
                    } else {
                        LetterByLetterPrinter.println("Has cumplido tu condena y has salido de prisión.");
                    }
                    break;
                default:
                    LetterByLetterPrinter.println("Opción no válida. Debes permanecer en prisión.");
                    break;
            }
        } else {
            if (currentPlayer.getPlayerGame().getMoney() >= 2000) {
                currentPlayer.getPlayerGame().payMoney(1000);
                currentPlayer.getPlayerGame().restPatrimony(1000);
                currentPlayer.setPrisonTurns(0);
                LetterByLetterPrinter.println(currentPlayer.getplayerName() + " ha pagado la fianza y ha salido de prisión.");
            } else if (saveCard) {
                saveCard = false;
                countCard = 0;
                currentPlayer.setPrisonTurns(0);
                LetterByLetterPrinter.println(currentPlayer.getplayerName() + " ha utilizado la carta para salir de prisión.");
            } else {
                currentPlayer.decrementPrisonTurns();
                LetterByLetterPrinter.println(currentPlayer.getplayerName() + " debe permanecer en prisión. Le quedan " + currentPlayer.getPrisonTurns() + " turnos.");
            }
        }
    }

    private void accionExitAction() {
        LetterByLetterPrinter.println("Salida");
    }

    private void accionFreeAction(Integer position) {
        if(position.equals(14)){
            LetterByLetterPrinter.println("Ha caido en la comisaria. Aqui descansan los presos");
        } else if (position.equals(28)) {
            LetterByLetterPrinter.println("Estacionamiento libre. Descanse");
        }
    }

    private void accionLuckAction(Player currentPlayer) {
        LetterByLetterPrinter.println("Has caido en una casilla de suerte. Saque una carta");
        Card card = drawCard(TypeCard.LUCK);
        processCardAction(card, currentPlayer);
    }

    private void accionDestinyAction(Player currentPlayer) {
        LetterByLetterPrinter.println("Has caido en una casilla de destino. Saque una carta");
        Card card = drawCard(TypeCard.DESTINITY);
        processCardAction(card, currentPlayer);
    }

    private Card drawCard(TypeCard type) {
        for (Card card : deck) {
            if (card.getType() == type) {
                deck.remove(card);
                return card;
            }
        }
        return null;
    }

    private void processCardAction(Card card, Player currentPlayer) {
        if (card != null) {
            LetterByLetterPrinter.println(card.getDescription());
            PlayerGame playerGame = currentPlayer.getPlayerGame();

            switch (card.getRankCard()) {
                case TAX:
                    if (card.getMount() == 10) {
                        int totalTax = 200 * currentPlayer.getPlayerGame().getChacras() + 1000 * currentPlayer.getPlayerGame().getEstancias();
                        playerGame.payMoney(totalTax);
                        playerGame.restPatrimony(totalTax);
                    } else if (card.getMount() == 20) {
                        int totalTax = 800 * currentPlayer.getPlayerGame().getChacras() + 4000 * currentPlayer.getPlayerGame().getEstancias();
                        playerGame.payMoney(totalTax);
                        playerGame.restPatrimony(totalTax);
                    } else {
                        playerGame.payMoney(card.getMount());
                        playerGame.restPatrimony(card.getMount());
                    }
                    break;
                case PROFIT:
                    if (card.getDescription().contains("cumpleaños")) {
                        int totalProfit = 200 * (players.size() - 1);
                        playerGame.receiveMoney(totalProfit);
                        playerGame.addPatrimony(totalProfit);
                        for (Player player : players) {
                            if (!player.equals(currentPlayer)) {
                                player.getPlayerGame().payMoney(200);
                                player.getPlayerGame().restPatrimony(200);
                            }
                        }
                    } else {
                        playerGame.receiveMoney(card.getMount());
                    }
                    break;
                case MOVE_BOX:
                    movePlayerByCard(card, currentPlayer);
                    break;
                case PRISON:
                    accionPrisonAction(currentPlayer);
                    break;
                case GET_OUT:
                    saveCard=true;
                    countCard=1;
                    break;
                default:
                    break;
            }
        }
    }

    private void movePlayerByCard(Card card, Player currentPlayer) {
        switch (card.getMount()) {
            case 1://Siga hasta la salida
                currentPlayer.getPawn().setPosition(0);
                currentPlayer.getPlayerGame().accionPrizeCollection(5000);
                break;
            case 2://"Vuelva atrás hasta Formosa Zona Sur"
                currentPlayer.getPawn().setPosition(1);
                break;
            case 3://"Haga un paseo hasta la Bodega. Si pasa por la salida cobre 5.000"
                currentPlayer.getPawn().setPosition(16);
                currentPlayer.getPlayerGame().accionPrizeCollection(5000);
                break;
            case 4:// "Siga hasta Buenos Aires. Zona Norte":
                currentPlayer.getPawn().setPosition(40);
                break;
            case 5://"Siga hasta Salta, Zona Norte. Si pasa por la salida cobre 5.000":
                currentPlayer.getPawn().setPosition(13);
                currentPlayer.getPlayerGame().accionPrizeCollection(5000);
                break;
            case 6://"Vuelva tres pasos atrás":
                movePlayerOnBoard(-3, currentPlayer.getPawn());
                break;
            case 7://"Siga hasta Santa Fe, Zona Norte. Si pasa por la salida cobre 5.000":
                currentPlayer.getPawn().setPosition(26);
                currentPlayer.getPlayerGame().accionPrizeCollection(5000);
                break;
            default:
                break;
        }
    }



    private void accionPropertyBox(Property property, Player currentPlayer) {
        if (property != null) {
            System.out.println("Has caído en una propiedad: " + property.viewProperty());
            PlayerGame playerGame = currentPlayer.getPlayerGame();
            TypePlayer typePlayer = currentPlayer.getTypePlayer();
            if (scanner == null) {
                scanner = new Scanner(System.in);
            }
            int ownerIndex = findPropertyOwner(property);
            if (ownerIndex != -1) {
                Player owner = players.get(ownerIndex);
                int rentAmount = calculateRent(property);
                System.out.println("Esta propiedad ya pertenece a " + owner.getplayerName() + ". Debes pagar " + rentAmount + " dinero.");
                playerGame.payMoney(rentAmount);
                playerGame.restPatrimony(rentAmount);
                owner.getPlayerGame().receiveMoney(rentAmount);
            } else {
                playerGame.accionPropertyBuy(property, scanner, typePlayer);
            }
        }
    }

    private int findPropertyOwner(Property property) {
        for (Player player : players) {
            if (player.getPlayerGame().hasProperty(property) != -1) {
                return players.indexOf(player);
            }
        }
        return -1;
    }

    private int calculateRent(Property property) {
        return property.getRentValue();
    }

    private void accionTaxBoxAction(Player currentPlayer, Integer position) {
        Integer taxAmount = 0;
        if(position.equals(4)){taxAmount = 5000;}
        else if(position.equals(41)) {taxAmount = 2000;}
        System.out.println("Has caido en una casilla de impuestos. Debes pagar " + taxAmount + " dinero.");
        currentPlayer.getPlayerGame().accionTaxPayment(taxAmount);
    }

    private void accionPrizeBoxAction(Player currentPlayer) {
        Integer prizeAmount = 2500;
        System.out.println("¡Felicidades! Recibes un premio ganadero por " + prizeAmount);
        currentPlayer.getPlayerGame().accionPrizeCollection(prizeAmount);
    }


    public void movePlayerOnBoard(int steps, Pawn pawn) {
        int currentPosition = pawn.getPosition();
        int newPosition = (currentPosition + steps) % board.getBoxes().size();
        pawn.setPosition(newPosition);
    }


    public List<Property> getPropertiesForUpgrade(Player player) {
        List<Property> propertiesInBoard = board.getProperties();
        List<Property> propertiesPlayer = player.getPlayerGame().getProperties();
        Map<Provinces, Set<Property>> propertiesByProvince = new HashMap<>();
        for (Property property : propertiesInBoard) {
            propertiesByProvince
                    .computeIfAbsent(property.getProvince(), k -> new HashSet<>())
                    .add(property);
        }
        List<Property> propertiesInCompleteProvinces = new ArrayList<>();
        for (Map.Entry<Provinces, Set<Property>> entry : propertiesByProvince.entrySet()) {
            Provinces province = entry.getKey();
            Set<Property> propertiesForProvince = entry.getValue();
            if (propertiesPlayer.containsAll(propertiesForProvince)) {
                for (Property property : propertiesPlayer) {
                    if (propertiesForProvince.contains(property)) {
                        propertiesInCompleteProvinces.add(property);
                    }
                }
            }
        }

        return propertiesInCompleteProvinces;
    }
}