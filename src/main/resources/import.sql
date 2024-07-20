----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--insert de tipos de carta

INSERT INTO type_cards (id_type_card, type) VALUES (1, 'suerte');
INSERT INTO type_cards (id_type_card, type) VALUES (2, 'destino');
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---insert cartas

INSERT INTO cards (id_card, id_type_card, description) VALUES (2, 1, 'Ha ganado la grande. Cobre 10000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (3, 1, 'Haga un paseo hasta la Bodega. Si pasa por la salida cobre 5000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (4, 1, 'Siga hasta Buenos Aires, Zona Norte');
INSERT INTO cards (id_card, id_type_card, description) VALUES (5, 1, 'Siga hasta Salta, Zona Norte. Si pasa por salida cobre 5000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (6, 1, 'Multa por exceso de velocidad. Pague 300');
INSERT INTO cards (id_card, id_type_card, description) VALUES (7, 1, 'Ganó en las carreras. Cobre 3000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (8, 1, 'Cobre 1000 por intereses bancarios');
INSERT INTO cards (id_card, id_type_card, description) VALUES (9, 1, 'Siga hasta la salida');
INSERT INTO cards (id_card, id_type_card, description) VALUES (10, 1, 'Pague 3000 por gastos colegiales');
INSERT INTO cards (id_card, id_type_card, description) VALUES (11, 1, 'Vuelva tres pasos atrás');
INSERT INTO cards (id_card, id_type_card, description) VALUES (12, 1, 'Multa caminera. Pague 400');
INSERT INTO cards (id_card, id_type_card, description) VALUES (13, 1, 'Sus propiedades tienen que ser reparadas. Pague al Banco 500 por cada chacra y 2500 por cada estancia');
INSERT INTO cards (id_card, id_type_card, description) VALUES (14, 1, 'Por compra de semilla pague al Banco 800 por cada chacra. 4000 por cada estancia');
INSERT INTO cards (id_card, id_type_card, description) VALUES (15, 1, 'Siga hasta Santa Fe, Zona Norte. Si pasa por la salida cobre 5000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (16, 1, 'Habeas Corpus concedido. Con esta tarjeta sale usted gratuitamente de la Comisaria. Conservala o vendala.');
INSERT INTO cards (id_card, id_type_card, description) VALUES (17, 2, '5% de interes sobre cedulas hipotecarias. Cobre 500');
INSERT INTO cards (id_card, id_type_card, description) VALUES (18, 2, 'Con esta tarjeta sale usted de la Comisaria. Conservela hasta utilizarla o vendala.');
INSERT INTO cards (id_card, id_type_card, description) VALUES (19, 2, 'Marche preso directamente');
INSERT INTO cards (id_card, id_type_card, description) VALUES (20, 2, 'Devolucion de impuesto. Cobre 400');
INSERT INTO cards (id_card, id_type_card, description) VALUES (21, 2, 'Pague su poliza de seguro con 1000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (22, 2, 'Ha ganado un concurso agricola. Cobre 2000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (23, 2, 'Error en los calculos del Banco. Cobre 4000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (24, 2, 'Gastos de Farmacia. Pague 1000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (25, 2, 'Ha obtenido un segundo premio de belleza. Cobre 200');
INSERT INTO cards (id_card, id_type_card, description) VALUES (26, 2, 'En su cumpleaños.Cobre 200 de cada uno de sus jugadores.');
INSERT INTO cards (id_card, id_type_card, description) VALUES (27, 2, 'Ha ganado un concurso agricola. Cobre 2000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (28, 2, 'Hereda 2000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (29, 2, 'Por venta de acciones cobre 1000');
INSERT INTO cards (id_card, id_type_card, description) VALUES (30, 2, 'Siga hasta la salida');
INSERT INTO cards (id_card, id_type_card, description) VALUES (31, 2, 'Vuelve atrás hasta Formosa Zona Sur');
INSERT INTO cards (id_card, id_type_card, description) VALUES (32, 2, 'Pague 200 de multa o levante una tarjeta de SUERTE');
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--INSERT tipo de propiedades
INSERT INTO type_properties (id_type_property, type_property) VALUES (1, 'escritura');
INSERT INTO type_properties (id_type_property, type_property) VALUES (2, 'ferrocarril');
INSERT INTO type_properties (id_type_property, type_property) VALUES (3, 'compañia');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---INSERT ZONAS

INSERT INTO Zone (id_zone, zone) VALUES (1, 'zona sur');
INSERT INTO Zone (id_zone, zone) VALUES (2, 'zona centro');
INSERT INTO Zone (id_zone, zone) VALUES (3, 'zona norte');
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---INSERT PROPIEDADES

INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (1, 1, CAST(1000.00 AS Decimal(10, 2)), CAST(40.00 AS Decimal(10, 2)), 1, 'Prov. Formosa Zona Sur', NULL, 1);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (2, 1, CAST(1000.00 AS Decimal(10, 2)), CAST(40.00 AS Decimal(10, 2)), 2, 'Prov. Formosa Zona Centro', NULL, 1);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (3, 1, CAST(1200.00 AS Decimal(10, 2)), CAST(80.00 AS Decimal(10, 2)), 3, 'Prov. Formosa Zona Norte', NULL, 1);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (5, 1, CAST(2000.00 AS Decimal(10, 2)), CAST(110.00 AS Decimal(10, 2)), 1, 'Prov. Rio Negro Zona Sur', NULL, 2);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (6, 1, CAST(2200.00 AS Decimal(10, 2)), CAST(150.00 AS Decimal(10, 2)), 3, 'Prov. Rio Negro Zona Norte', NULL, 2);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (8, 3, CAST(5000.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, 'Compañia petrolera', NULL, NULL);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (9, 1, CAST(2600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), 1, 'Prov. Salta Zona Sur', NULL, 3);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (11, 1, CAST(2600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), 2, 'Prov. Salta Zona Centro', NULL, 3);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (12, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), NULL, 'Ferrocarril General Belgrano', NULL, NULL);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (13, 1, CAST(3000.00 AS Decimal(10, 2)), CAST(230.00 AS Decimal(10, 2)), 3, 'Prov. Salta Zona Norte', NULL, 3);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (16, 3, CAST(3600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, 'Bodega (compañia)', NULL, NULL);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (17, 1, CAST(3400.00 AS Decimal(10, 2)), CAST(250.00 AS Decimal(10, 2)), 1, 'Prov. Mendoza Zona Sur', NULL, 4);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (18, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), NULL, 'Ferrocarril General San Marti', NULL, NULL);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (19, 1, CAST(3400.00 AS Decimal(10, 2)), CAST(250.00 AS Decimal(10, 2)), 2, 'Prov. Mendoza Zona Centro', NULL, 4);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (20, 1, CAST(3800.00 AS Decimal(10, 2)), CAST(300.00 AS Decimal(10, 2)), 3, 'Prov. Mendoza Zona Norte', NULL, 4);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (22, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, 'Ferrocarril General Mitre', NULL, NULL);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (23, 1, CAST(4200.00 AS Decimal(10, 2)), CAST(350.00 AS Decimal(10, 2)), 1, 'Prov. Santa Fe Zona Sur', NULL, 5);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (24, 1, CAST(4200.00 AS Decimal(10, 2)), CAST(350.00 AS Decimal(10, 2)), 2, 'Prov. Santa Fe Zona Centro', NULL, 5);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (26, 1, CAST(4600.00 AS Decimal(10, 2)), CAST(400.00 AS Decimal(10, 2)), 3, 'Prov. Santa Fe Zona Norte', NULL, 5);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (27, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), NULL, 'Ferrocarril General Urquiza', NULL, NULL);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (29, 1, CAST(5000.00 AS Decimal(10, 2)), CAST(400.00 AS Decimal(10, 2)), 1, 'Prov. Tucuman Zona Sur', NULL, 6);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (30, 1, CAST(5400.00 AS Decimal(10, 2)), CAST(450.00 AS Decimal(10, 2)), 3, 'Prov. Tucuman Zona Norte', NULL, 6);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (31, 3, CAST(5000.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, 'Ingenio (compañia)', NULL, NULL);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (32, 1, CAST(6000.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), 1, 'Prov. Cordoba Zona Sur', NULL, 7);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (33, 1, CAST(6000.00 AS Decimal(10, 2)), CAST(450.00 AS Decimal(10, 2)), 2, 'Prov. Cordoba Zona Centro', NULL, 7);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (34, 1, CAST(6400.00 AS Decimal(10, 2)), CAST(550.00 AS Decimal(10, 2)), 3, 'Prov. Cordoba Zona Norte', NULL, 7);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (37, 1, CAST(7000.00 AS Decimal(10, 2)), CAST(650.00 AS Decimal(10, 2)), 1, 'Prov. Buenos Aires Zona Sur', NULL, 8);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (39, 1, CAST(7000.00 AS Decimal(10, 2)), CAST(650.00 AS Decimal(10, 2)), 2, 'Prov. Buenos Aires Zona Centro', NULL, 8);
INSERT INTO properties (id_property, id_type_property, value, rent_value, id_zone, descripcion, id_type_upgrade, id_province) VALUES (40, 1, CAST(7400.00 AS Decimal(10, 2)), CAST(1000.00 AS Decimal(10, 2)), 3, 'Prov. Buenos Aires Zona Norte', NULL, 8);
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---INSERT PROVINCIAS

INSERT INTO Provinces (id_province, province_name) VALUES (1, 'Formosa');
INSERT INTO Provinces (id_province, province_name) VALUES (2, 'Rio Negro');
INSERT INTO Provinces (id_province, province_name) VALUES (3, 'Salta');
INSERT INTO Provinces (id_province, province_name) VALUES (4, 'Mendoza');
INSERT INTO Provinces (id_province, province_name) VALUES (5, 'Santa Fe');
INSERT INTO Provinces (id_province, province_name) VALUES (6, 'Tucuman');
INSERT INTO Provinces (id_province, province_name) VALUES (7, 'Cordoba');
INSERT INTO Provinces (id_province, province_name) VALUES (8, 'Buenos Aires');
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--INSERT TIPO DE BOX

INSERT INTO type_boxes (id_type_box, type) VALUES (1, 'property');
INSERT INTO type_boxes (id_type_box, type) VALUES (2, 'destiny');
INSERT INTO type_boxes (id_type_box, type) VALUES (3, 'luck');
INSERT INTO type_boxes (id_type_box, type) VALUES (4, 'tax');
INSERT INTO type_boxes (id_type_box, type) VALUES (5, 'free');
INSERT INTO type_boxes (id_type_box, type) VALUES (6, 'go to prison');
INSERT INTO type_boxes (id_type_box, type) VALUES (7, 'exit');


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--TIPO DE UPGRADE

INSERT INTO Type_upgrades (id_type_upgrade, type_upgrade) VALUES (1, 'chacra');
INSERT INTO Type_upgrades (id_type_upgrade, type_upgrade) VALUES (2, 'estancia');