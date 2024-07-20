package model.board;

import services.typeUpgradesInterface;

public class TypeUpgradeProperty implements typeUpgradesInterface {

    private String type;
    private Object stateProperty;


    public TypeUpgradeProperty(String type, Object stateProperty) {
        this.type = type;
        this.stateProperty = stateProperty;
    }

    public TypeUpgradeProperty(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getTypeUpgrade() {
        return type;
    }

    @Override
    public Object viewStateProperty() {

        return stateProperty;
    }

    @Override
    public Object showUpgradeType() {

        return "Tipo de mejora: " + type;
    }

    @Override
    public String toString(){
        return "Tipo de mejora: " + type + " Estado de Propiedad: " + stateProperty;
    }
}
