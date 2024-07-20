    package model.board;

    import model.support.Zone;
    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;

    /**
     * Esta clase representa el tablero de juego que contiene casillas, tarjetas, propiedades y dados.
     *
     * El tablero contiene una serie de casillas, tarjetas, propiedades y dados que se utilizan durante el juego.
     *
     * @author [GRUPO NUMERO 1: ESTANCIERO]
     * @version 2.0
     */

    public class Board implements Serializable {
        Pawn pawn = new Pawn();

        private List<Box> boxes;

        private int positionPlayer;

        private int numberOfBoxes;

        private List<Property> properties;

        public Board(){
            this.properties = inicializeProperties();
            this.boxes = createBoxes();
            this.numberOfBoxes = boxes.size();
            this.positionPlayer = 0;
        }

        public Board(List<Box> boxes, Pawn pawn) {
            this.boxes = boxes;
            this.numberOfBoxes = boxes.size();
            this.positionPlayer = pawn.getPosition();
        }

        public List<Box> getBoxes() {
            return boxes;
        }

        public Property getProperty(int indice) {
            return properties.get(indice);
        }

        public List<Property> getProperties() {
            return properties;
        }

        public Box getBox(int position) {
            if(position>=0 && position<boxes.size()){
                return boxes.get(position);
            }else{
            return null;}
        }

        public int getPositionPlayer() {
            return pawn.getPosition();
        }

        public ArrayList<Box> createBoxes() {
            ArrayList<Box> boxes = new ArrayList<>();

            boxes.add(new Box(TypeBox.EXIT, null, null)); //0
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(0) , null));//1
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(1) , null));//2
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(2) , null));//3
            boxes.add(new Box(TypeBox.TAX, null, null)); //4 5000 impuestos
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(3) , null));//5
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(4) , null));//6
            boxes.add(new Box(TypeBox.PRIZE, null, null)); //7
            boxes.add(new Box(TypeBox.SPECIAL, properties.get(5), null)); //8 valor de 3800
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(6), null));//9
            boxes.add(new Box(TypeBox.DESTINY, null, null)); //10
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(7), null));//11
            boxes.add(new Box(TypeBox.RAILWAY, properties.get(8), null));//12
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(9), null));//13
            boxes.add(new Box(TypeBox.FREE, null, null)); //14
            boxes.add(new Box(TypeBox.LUCK, null, null)); //15
            boxes.add(new Box(TypeBox.SPECIAL,properties.get(10) , null));//16
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(11), null));//17
            boxes.add(new Box(TypeBox.RAILWAY, properties.get(12), null)); //18
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(13), null));//19
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(14), null));//20
            boxes.add(new Box(TypeBox.FREE, null, null)); //21
            boxes.add(new Box(TypeBox.RAILWAY, properties.get(15), null));//22
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(16), null));//23
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(17), null));//24
            boxes.add(new Box(TypeBox.DESTINY, null, null)); //25
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(18), null));//26
            boxes.add(new Box(TypeBox.RAILWAY, properties.get(19), null));//27
            boxes.add(new Box(TypeBox.FREE, null, null)); //28
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(20), null));//29
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(21), null));//30
            boxes.add(new Box(TypeBox.SPECIAL, properties.get(22), null)); //31
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(23), null));//32
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(24), null));//33
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(25), null));//34
            boxes.add(new Box(TypeBox.GOTOPRISON, null, null)); //35
            boxes.add(new Box(TypeBox.LUCK, null, null)); //36
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(26), null));//37
            boxes.add(new Box(TypeBox.DESTINY, null, null)); //38
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(27), null));//39
            boxes.add(new Box(TypeBox.PROPERTIE, properties.get(28), null));//40
            boxes.add(new Box(TypeBox.TAX, null, null)); //41

            return boxes;
        }

        private List<Property> inicializeProperties() {
            List<Property> properties = new ArrayList<>();

            properties.add(new Property(Provinces.FORMOSA, Zone.SUR, 1000, 40,TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA)); //0
            properties.add(new Property(Provinces.FORMOSA, Zone.CENTRO, 1000,40, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA)); //1
            properties.add(new Property (Provinces.FORMOSA, Zone.NORTE, 1200,80,TypeProperty.ESCRITURA,  TypeUpgradePropertyEnum.VACIA)); //2
            properties.add(new Property(Provinces.RIONEGRO, Zone.SUR, 2000, 110,  TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA)); //3
            properties.add(new Property(Provinces.RIONEGRO, Zone.NORTE,2200, 150, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//4
            properties.add(new Property(Provinces.COMPANY, Zone.PETROLERA, 3800, 500, TypeProperty.COMPAÑIA, TypeUpgradePropertyEnum.VACIA));//5
            properties.add(new Property(Provinces.SALTA, Zone.SUR,2600, 200, TypeProperty.ESCRITURA,TypeUpgradePropertyEnum.VACIA));//6
            properties.add(new Property(Provinces.SALTA, Zone.CENTRO, 2600, 200, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//7
            properties.add(new Property(Provinces.FERROCARRIL,Zone.FERROCARRIL, 3600,500,TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//8
            properties.add(new Property(Provinces.SALTA, Zone.NORTE, 3000, 230, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//9
            properties.add(new Property(Provinces.COMPANY, Zone.BODEGA,3800, 200, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//10
            properties.add(new Property(Provinces.MENDOZA, Zone.SUR,3400, 250, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//11
            properties.add(new Property(Provinces.FERROCARRIL, Zone.FERROCARRIL, 3600, 500,  TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//12
            properties.add(new Property(Provinces.MENDOZA, Zone.CENTRO, 3400, 250,  TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//13
            properties.add(new Property(Provinces.MENDOZA, Zone.NORTE, 3800, 300, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//14
            properties.add(new Property(Provinces.FERROCARRIL, Zone.FERROCARRIL, 3600, 500,  TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//15
            properties.add(new Property(Provinces.SANTAFE, Zone.SUR, 4200, 350, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//16
            properties.add(new Property(Provinces.SANTAFE, Zone.CENTRO, 4200, 350, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//17
            properties.add(new Property(Provinces.SANTAFE, Zone.NORTE, 4600, 400, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//18
            properties.add(new Property(Provinces.FERROCARRIL, Zone.FERROCARRIL, 3600, 500,  TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//19
            properties.add(new Property(Provinces.TUCUMAN, Zone.SUR, 5000, 400, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//20
            properties.add(new Property(Provinces.TUCUMAN, Zone.NORTE, 5400, 450, TypeProperty.ESCRITURA,  TypeUpgradePropertyEnum.VACIA));//21
            properties.add(new Property(Provinces.COMPANY, Zone.INGENIO, 3800, 200, TypeProperty.COMPAÑIA, TypeUpgradePropertyEnum.VACIA));//22
            properties.add(new Property(Provinces.CORDOBA, Zone.SUR, 6000, 500, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//23
            properties.add(new Property(Provinces.CORDOBA, Zone.CENTRO, 6000, 450, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//24
            properties.add(new Property(Provinces.CORDOBA, Zone.NORTE, 6400, 550, TypeProperty.ESCRITURA,  TypeUpgradePropertyEnum.VACIA));//25
            properties.add(new Property(Provinces.BUENOSAIRES, Zone.SUR, 7000, 650, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//26
            properties.add(new Property(Provinces.BUENOSAIRES, Zone.CENTRO, 7000, 650,TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//27
            properties.add(new Property(Provinces.BUENOSAIRES, Zone.NORTE, 7400, 1000, TypeProperty.ESCRITURA, TypeUpgradePropertyEnum.VACIA));//28

            return properties;
        }

    }

