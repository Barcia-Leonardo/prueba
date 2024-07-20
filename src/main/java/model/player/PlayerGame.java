package model.player;

import model.LetterByLetterPrinter;
import model.board.Property;
import model.board.TypeUpgradePropertyEnum;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerGame implements Serializable {

    private Integer money;
    private List<Property> properties;
    private List<Player> players;
    private Integer patrimony;



    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public PlayerGame(List<Player> players) {
        this.players = players;
        this.money = 35000;
        this.properties = new ArrayList<>();
        this.patrimony = 35000;
    }

    public void payMoney(Integer amount) {
        money -= amount;
    }

    public void receiveMoney(Integer amount) {
        money += amount;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public int hasProperty(Property property) {
        return properties.indexOf(property);
    }


    public void accionPropertyBuy(Property property, Scanner scanner, TypePlayer typePlayer) {
        if (property != null) {
            if (typePlayer == TypePlayer.AGGRESSIVE || typePlayer == TypePlayer.BALANCED || typePlayer == TypePlayer.CONSERVATIVE) {
                Player botPlayer = findBotPlayerByType(typePlayer, players);
                boolean decision = false;

                switch (typePlayer) {
                    case AGGRESSIVE:
                        Aggresive aggressiveBot = (Aggresive) botPlayer;
                        decision = aggressiveBot != null && aggressiveBot.purchaseDecision(property, BigDecimal.valueOf(getMoney().intValue()));
                        break;
                    case BALANCED:
                        Balanced balancedBot = (Balanced) botPlayer;
                        decision = balancedBot != null && balancedBot.purchaseDecision(property, BigDecimal.valueOf(getMoney().intValue()));
                        break;
                    case CONSERVATIVE:
                        Conservative conservativeBot = (Conservative) botPlayer;
                        decision = conservativeBot != null && conservativeBot.purchaseDecision(property, BigDecimal.valueOf(getMoney().intValue()));
                        break;
                    default:
                        break;
                }

                if (decision && getMoney().compareTo(property.getValue()) >= 0) {
                    payMoney(property.getValue());
                    addProperty(property);
                    setPatrimony(getMoney());
                    for (Property prop : properties) {
                        addPatrimony(prop.getValue());
                    }
                    System.out.println("¡Felicidades! Has comprado la propiedad.");
                } else if (decision) {
                    System.out.println("No tienes suficiente dinero para comprar esta propiedad.");
                }
            } else {
                System.out.println("¿Deseas comprar esta propiedad? (Y/N)");
                String decision = scanner.nextLine();
                if (decision.equalsIgnoreCase("Y") && getMoney().compareTo(property.getValue()) >= 0) {
                    payMoney(property.getValue());
                    addProperty(property);
                    setPatrimony(getMoney());
                    for (Property prop : properties) {
                        addPatrimony(prop.getValue());
                    }
                    System.out.println("¡Felicidades! Has comprado la propiedad.");
                } else if (decision.equalsIgnoreCase("Y")) {
                    System.out.println("No tienes suficiente dinero para comprar esta propiedad.");
                }
            }
        }
    }

    public void addPatrimony(Integer value) {
        patrimony += value;
    }

    public void restPatrimony(Integer value) {
        patrimony -= value;
    }

    private Player findBotPlayerByType(TypePlayer typePlayer, List<Player> players) {
        for (Player player : players) {
            if (player.getTypePlayer() == typePlayer) {
                return player;
            }
        }
        return null;
    }

    public void accionTaxPayment(Integer taxAmount) {
        payMoney(taxAmount);
        restPatrimony(taxAmount);
    }

    public void accionPrizeCollection(Integer prizeAmount) {
        receiveMoney(prizeAmount);
        addPatrimony(prizeAmount);
    }

    public int getChacras() {
        return 0;
    }

    public int getEstancias() {
        return 0;
    }

    public Integer getPatrimony() {
        return patrimony;
    }

    public void setPatrimony(Integer patrimony) {
        this.patrimony = patrimony;
    }

    public void sellProperty() {
        int propertieIndex = selectPropertie(properties);
        Property propertyToRemove = properties.get(propertieIndex);
        properties.remove(propertieIndex);
        receiveMoney((int) (propertyToRemove.getValue() * 0.5));
        addPatrimony((int) (propertyToRemove.getValue() * 0.5));
        restPatrimony(propertyToRemove.getValue());
        LetterByLetterPrinter.println("Ha vendido su propiedad " + propertyToRemove.viewProperty() + " al banco");
    }

    public int selectPropertie(List<Property> properties) {
        LetterByLetterPrinter.println("Elija el numero de la propiedad que desea: ");
        String sizeOfProperties = String.valueOf(getProperties().size() - 1);
        for (int i = 0; i < getProperties().size(); i++) {
            LetterByLetterPrinter.println(i + ". " + getProperties().get(i).viewProperty());
        }
        LetterByLetterPrinter.println("Su propiedad elegida va a ser.");
        return getValideNumber("[0-" + sizeOfProperties + "]", "0 al " + sizeOfProperties);
    }

    public Integer getValideNumber(String NUMBER_REGEX, String message) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        while (true) {
            System.out.print("Por favor, ingrese un número entre " + message + ": ");
            String input = scanner.next();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre " + message + ": ");
            }
        }
    }

    public void upgradeProperty(List<Property> propertiesToUpgrade) {
        if (!propertiesToUpgrade.isEmpty()) {
            LetterByLetterPrinter.println("Puede mejorar la siguientes propiedades.");
            int indice = selectPropertie(propertiesToUpgrade);
            TypeUpgradePropertyEnum tupe = properties.get(indice).getTypeUpgradeProperty();
            Property propToUpgrade = properties.get(indice);
            switch (tupe){
                case VACIA:
                    propToUpgrade.upgradeProperty(TypeUpgradePropertyEnum.CHACRA);
                    propToUpgrade.setRentValue((int) (propToUpgrade.getRentValue() * 1.5));
                    payMoney(1000);
                    LetterByLetterPrinter.println("Ha mejorado su propiedad a Chacra");
                    break;
                case CHACRA:
                    propToUpgrade.upgradeProperty(TypeUpgradePropertyEnum.DOS_CHACRAS);
                    propToUpgrade.setRentValue((int) (propToUpgrade.getRentValue() * 1.5));
                    payMoney(2000);
                    LetterByLetterPrinter.println("Ha mejorado su propiedad a dos chacras");
                    break;
                case DOS_CHACRAS:
                    propToUpgrade.upgradeProperty(TypeUpgradePropertyEnum.ESTANCIA);
                    propToUpgrade.setRentValue((int) (propToUpgrade.getRentValue() * 1.5));
                    payMoney(3000);
                    LetterByLetterPrinter.println("Ha mejorado su propiedad a Estancia. Mejora maxima");
                    break;
                case ESTANCIA:
                    LetterByLetterPrinter.println("Esta propiedad ha alcanzado la mejora maxima.");
                    break;
                default:
                    throw new IllegalArgumentException("Mejora desconocida");
            }
        }

    }

}
