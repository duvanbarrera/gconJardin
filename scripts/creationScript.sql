-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-03-30 02:04:12.631




-- tables
-- Table Pedido
CREATE TABLE `coswgr5`.`Pedido` (
    `id_pedido` int  NOT NULL,
    `estado` char(10)  NOT NULL,
    `fecha_aprobacion` date  NOT NULL,
    CONSTRAINT `Pedido_pk` PRIMARY KEY (`id_pedido`)
);

-- Table PedidoPostreCantidad
CREATE TABLE `coswgr5`.`PedidoPostreCantidad` (
    `Postre_codigo_postre` varchar(10)  NOT NULL,
    `Postre_Reposteria_nit` varchar(15)  NOT NULL,
    `cantidad` int  NOT NULL,
    `Pedido_id_pedido` int  NOT NULL,
    CONSTRAINT `PedidoPostreCantidad_pk` PRIMARY KEY (`Postre_codigo_postre`,`Postre_Reposteria_nit`,`Pedido_id_pedido`)
);

-- Table Postre
CREATE TABLE `coswgr5`.`Postre` (
    `codigo_postre` varchar(10)  NOT NULL,
    `Reposteria_nit` varchar(15)  NOT NULL,
    `nombre` varchar(20)  NOT NULL,
    `precio` int  NOT NULL,
    `descripcion` varchar(30)  NOT NULL,
    `imagen` blob  NULL,
    CONSTRAINT `Postre_pk` PRIMARY KEY (`codigo_postre`,`Reposteria_nit`)
);

-- Table Reposteria
CREATE TABLE `coswgr5`.`Reposteria` (
    `nit` varchar(15)  NOT NULL,
    `nombre` varchar(20)  NOT NULL,
    `rango_cobertura` varchar(20)  NOT NULL,
     `password` varchar(30)  NOT NULL,
    CONSTRAINT `Reposteria_pk` PRIMARY KEY (`nit`)
);



-- foreign keys
-- Reference:  PedidoPostreCantidad_Pedido (table: PedidoPostreCantidad)

ALTER TABLE `coswgr5`.`PedidoPostreCantidad` ADD CONSTRAINT `PedidoPostreCantidad_Pedido` FOREIGN KEY `PedidoPostreCantidad_Pedido` (`Pedido_id_pedido`)
    REFERENCES `coswgr5`.`Pedido` (`id_pedido`);
-- Reference:  PedidoPostreCantidad_Postre (table: PedidoPostreCantidad)

ALTER TABLE `coswgr5`.`PedidoPostreCantidad` ADD CONSTRAINT `PedidoPostreCantidad_Postre` FOREIGN KEY `PedidoPostreCantidad_Postre` (`Postre_codigo_postre`,`Postre_Reposteria_nit`)
    REFERENCES `coswgr5`.`Postre` (`codigo_postre`,`Reposteria_nit`);
-- Reference:  Postre_Reposteria (table: Postre)

ALTER TABLE `coswgr5`.`Postre` ADD CONSTRAINT `Postre_Reposteria` FOREIGN KEY `Postre_Reposteria` (`Reposteria_nit`)
    REFERENCES `coswgr5`.`Reposteria` (`nit`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;



-- End of file.


insert into `coswgr5`.Reposteria values('r1','reposteria','cobertura1','pass1');
