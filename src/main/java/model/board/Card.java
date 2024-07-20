package model.board;

import services.cardInterface;
import java.io.Serializable;
import java.util.ArrayList;

public class Card implements cardInterface, Serializable {
    private TypeCard type;
    private RankCard rankCard;
    private String description;
    private Integer mount;

    public Card(TypeCard type,RankCard rankCard, String description, Integer  mount) {
        this.type = type;
        this.rankCard = rankCard;
        this.description = description;
        this.mount = mount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }

    public RankCard getRankCard() {
        return rankCard;
    }


    public void setRankCard(RankCard rankCard) {
        this.rankCard = rankCard;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return type + ": " + description;
    }

    public static ArrayList<Card> createCardList() {

        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.TAX,"5% de interés sobre cédulas hipotecarias",500 ));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.GET_OUT ,"Con esta tarjeta sale usted de la Comisaria. Conservela hasta utilizarla o venderla", 0));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PRISON ,"Marche preso directamente", 0));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT ,"Devolución de impuesto. Cobre 400", 400));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.TAX ,"Pague su poliza de seguro con 1000", 1000));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT ,"Ha ganado un concurso agricola. Cobre 2000", 2000));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT, "Error en los cálculos del Banco. Cobre 4000", 4000));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.TAX, "Gastos de Farmacia. Paque 1000", 1000));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT, "Ha obtenido un segundo premio de belleza. Cobre 200", 200));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT, "En su cumpleaños. Cobre 200 de cada uno de sus jugadores.", 0));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT,"Ha ganado un concurso agricola. Cobre 2000", 2000));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT,"Heredo 2000",2000));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.PROFIT,"Por venta de acciones cobre 1000",1000));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.MOVE_BOX,"Siga hasta la salida",1));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.MOVE_BOX,"Vuelve atrás hasta Formosa Zona Sur",2));
        cardList.add(new Card(TypeCard.DESTINITY, RankCard.TAX,"Pague 200 de multa o levante una tarjeta de SUERTE",200));//condicional
        cardList.add(new Card(TypeCard.LUCK, RankCard.PRISON,"Marche preso directamente",0));
        cardList.add(new Card(TypeCard.LUCK, RankCard.PROFIT,"Ha ganado la grande. cobre 10.000",10000));
        cardList.add(new Card(TypeCard.LUCK, RankCard.MOVE_BOX,"Haga un paseo hasta la Bodega. Si pasa por la salida cobre 5.000",3));
        cardList.add(new Card(TypeCard.LUCK, RankCard.MOVE_BOX,"Siga hasta Buenos Aires. Zona Norte",4));
        cardList.add(new Card(TypeCard.LUCK, RankCard.MOVE_BOX,"Siga hasta Salta, Zona Norte. Si pasa por la salida cobre 5.000",5));
        cardList.add(new Card(TypeCard.LUCK, RankCard.TAX,"Multa por exceso de velocidad. Pague 300",300));
        cardList.add(new Card(TypeCard.LUCK, RankCard.PROFIT,"Ganó en las carreras. Cobre 3.000",3000));
        cardList.add(new Card(TypeCard.LUCK, RankCard.PROFIT,"Cobre 1.000 por intereses bancarios",1000));
        cardList.add(new Card(TypeCard.LUCK, RankCard.MOVE_BOX,"Siga hasta la salida",1));
        cardList.add(new Card(TypeCard.LUCK, RankCard.TAX,"Pague 3.000 por gastos colegiales",3000));
        cardList.add(new Card(TypeCard.LUCK, RankCard.MOVE_BOX,"Vuelva tres pasos atrás",6));
        cardList.add(new Card(TypeCard.LUCK, RankCard.TAX,"Multa caminera. Pague 400",400));
        cardList.add(new Card(TypeCard.LUCK, RankCard.TAX,"Sus propiedades tienen que ser reparadas. Pague al Banco 500 por cada chacra y 2.500 por cada estancia",20));
        cardList.add(new Card(TypeCard.LUCK, RankCard.TAX,"Por compra de semilla pague al Banco 800 por cada chacra. 4.000 por cada estancia",10));
        cardList.add(new Card(TypeCard.LUCK, RankCard.MOVE_BOX,"Siga hasta Santa Fe, Zona Norte. Si pasa por la salida cobre 5.000",7));
        cardList.add(new Card(TypeCard.LUCK, RankCard.GET_OUT,"Habeas Corpus concedido. Con esta tarjeta sale usted gratuitamente de la Comisaria. Conservela o vendala.",0));
        return cardList;
    }

    public Integer getMount() {
        return mount;
    }

    public void setMount(Integer mount) {
        this.mount = mount;
    }
}
