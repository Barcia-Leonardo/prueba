package model.player;

import model.board.Pawn;
import model.board.Property;
import model.board.Provinces;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conservative extends Player implements Serializable {

    private int contador = 0;
    public Conservative(String playerName, TypePlayer typePlayer, Integer turn, Pawn pawn, List<Player> players) {
        super(playerName, typePlayer, turn, pawn,players);
    }

    public List<Provinces> listProvincepreferred(){
        List<Provinces> preferredProvinces = new ArrayList<>();
        for (Provinces provinces : Provinces.values()) {
            if(provinces.getNameProvinces().equals("Formosa") ||
              provinces.getNameProvinces().equals("Rio Negro") ||
              provinces.getNameProvinces().equals("Salta")){
                preferredProvinces.add(provinces);
            }
        }
        return preferredProvinces;
    }

  public boolean purchaseDecision(Property property, BigDecimal money) {
      List<Provinces> preferredProvinces = listProvincepreferred();
      if (preferredProvinces.contains(property.getProvince()) ||
              (contador % 5 == 0)) {
          return true;
      } else {
          contador++;
          return false;
      }
  }

    public boolean improvements(Property property,int CostImprovement,int Cash){
        return CostImprovement <=0.3 * Cash;
    }
}
