
DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id_proveedor` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_alta` date NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla proveedores';

INSERT INTO `proveedores` VALUES (1,'Coca-cola','1990-01-01',5),(2,'Pepsi','1992-02-02',5),(3,'RedBull','1993-03-03',6),(4,'Coca-cola','1990-01-01',4),(5,'Kas','1999-09-09',5),(7,'RedBull','2018-09-30',7),(8,'Monster','2018-09-30',7),(9,'Mineral','2018-09-30',7),(10,'Gas','2018-09-30',7),(11,'Licor','2018-09-30',7);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;
