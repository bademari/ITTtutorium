-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 11. Mai 2021 um 16:22
-- Server-Version: 5.7.33-0ubuntu0.16.04.1
-- PHP-Version: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `Allgold`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `inventory`
--

CREATE TABLE `inventory` (
  `inventoryID` int(10) NOT NULL,
  `stationID` int(10) NOT NULL,
  `productID` int(10) NOT NULL,
  `currentAmount` int(10) NOT NULL,
  `toStoreAmount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `inventory`
--

INSERT INTO `inventory` (`inventoryID`, `stationID`, `productID`, `currentAmount`, `toStoreAmount`) VALUES
(1, 1, 1, 7, 20),
(2, 2, 1, 3, 15),
(3, 3, 1, 18, 20),
(4, 4, 1, 3, 20),
(5, 5, 1, 18, 20),
(6, 6, 1, 3, 15),
(7, 7, 1, 18, 20),
(8, 8, 1, 11, 15),
(9, 9, 1, 18, 20),
(10, 10, 1, 25, 35),
(11, 11, 1, 9, 20),
(12, 12, 1, 4, 10),
(13, 1, 2, 3, 10),
(14, 2, 2, 18, 25),
(15, 3, 2, 3, 15),
(16, 4, 2, 3, 15),
(17, 5, 2, 18, 30),
(18, 6, 2, 3, 10),
(19, 7, 2, 18, 20),
(20, 8, 2, 11, 15),
(21, 9, 2, 18, 25),
(22, 10, 2, 25, 35),
(23, 11, 2, 9, 20),
(24, 12, 2, 4, 10),
(25, 1, 3, 3, 10),
(26, 2, 3, 18, 25),
(27, 3, 3, 5, 15),
(28, 4, 3, 13, 15),
(29, 5, 3, 8, 30),
(30, 6, 3, 3, 10),
(31, 7, 3, 10, 20),
(32, 8, 3, 10, 15),
(33, 9, 3, 16, 25),
(34, 10, 3, 28, 35),
(35, 11, 3, 19, 20),
(36, 12, 3, 4, 10);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `products`
--

CREATE TABLE `products` (
  `productID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` decimal(3,2) NOT NULL,
  `durability` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `products`
--

INSERT INTO `products` (`productID`, `name`, `price`, `durability`) VALUES
(1, 'Milch', '1.00', 14),
(2, 'Emmentaler', '3.95', 60),
(3, 'Gauda', '3.10', 60),
(4, 'Joghurt 100g', '0.50', 7),
(5, 'Quark', '0.90', 10),
(6, 'Joghurt 500g', '2.00', 7),
(7, 'Streichkaese', '1.50', 21),
(8, 'Bergkaese', '5.00', 60);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `refill`
--

CREATE TABLE `refill` (
  `refillID` int(10) NOT NULL,
  `stationID` int(10) NOT NULL,
  `productID` int(10) NOT NULL,
  `amount` int(10) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `sales`
--

CREATE TABLE `sales` (
  `saleID` int(10) NOT NULL,
  `stationID` int(10) NOT NULL,
  `productID` int(10) NOT NULL,
  `sellerID` int(10) NOT NULL,
  `amount` int(10) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `seller`
--

CREATE TABLE `seller` (
  `sellerID` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `vorname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `seller`
--

INSERT INTO `seller` (`sellerID`, `name`, `vorname`) VALUES
(1, 'Automat', 'Verkauf'),
(2, 'Diener', 'Bernhard'),
(3, 'Ludowig', 'Frauke'),
(4, 'Zufall', 'Reiner'),
(5, 'Lang', 'Thomas'),
(6, 'Rensch', 'Anna');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `station`
--

CREATE TABLE `station` (
  `stationID` int(10) NOT NULL,
  `coordsA` varchar(30) NOT NULL,
  `coordsL` varchar(30) NOT NULL,
  `location` varchar(30) NOT NULL,
  `type` varchar(1) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `station`
--

INSERT INTO `station` (`stationID`, `coordsA`, `coordsL`, `location`, `type`, `description`) VALUES
(1, '47.71457225467146', '10.314338207244873', 'Kempten', 'B', 'Firmensitz'),
(2, '47.72426740349347', '10.316848754882812', 'Kempten', 'A', 'Aussenstelle'),
(3, '47.882828716292344', '10.6264343852617', 'Kaufbeuren', 'V', 'Aussenstelle'),
(4, '47.98036221803081', '10.1788330078125', 'Memmingen', 'B', 'Aussenstelle'),
(5, '47.694697038966076', '10.038070678710938', 'Isny', 'A', 'Aussenstelle'),
(6, '47.77941861197757', '10.616891384124756', 'Marktoberdorf', 'A', 'Aussenstelle'),
(7, '47.514634612973694', '10.26755619153846', 'Sonthofen', 'V', 'Aussenstelle'),
(8, '47.41029678060909', '10.275293827580754', 'Oberstdorf', 'A', 'Aussenstelle'),
(9, '47.554643912647045', '10.022393703984562', 'Oberstaufen', 'A', 'Aussenstelle'),
(10, '47.560841627466885', '10.21770143561298', 'Immenstadt', 'A', 'Aussenstelle'),
(11, '47.569648', '10.700432800000044', 'Fuessen', 'B', 'Aussenstelle'),
(12, '47.550241351721596', '9.69220304476039', 'Lindau', 'B', 'Aussenstelle');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventoryID`),
  ADD KEY `stationID` (`stationID`),
  ADD KEY `productID` (`productID`);

--
-- Indizes für die Tabelle `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`);

--
-- Indizes für die Tabelle `refill`
--
ALTER TABLE `refill`
  ADD PRIMARY KEY (`refillID`),
  ADD KEY `stationID` (`stationID`),
  ADD KEY `productID` (`productID`);

--
-- Indizes für die Tabelle `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`saleID`),
  ADD KEY `stationID` (`stationID`),
  ADD KEY `productID` (`productID`),
  ADD KEY `sellerID` (`sellerID`);

--
-- Indizes für die Tabelle `seller`
--
ALTER TABLE `seller`
  ADD PRIMARY KEY (`sellerID`);

--
-- Indizes für die Tabelle `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`stationID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inventoryID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT für Tabelle `products`
--
ALTER TABLE `products`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT für Tabelle `refill`
--
ALTER TABLE `refill`
  MODIFY `refillID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `sales`
--
ALTER TABLE `sales`
  MODIFY `saleID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `seller`
--
ALTER TABLE `seller`
  MODIFY `sellerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT für Tabelle `station`
--
ALTER TABLE `station`
  MODIFY `stationID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`stationID`) REFERENCES `station` (`stationID`),
  ADD CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `products` (`productID`);

--
-- Constraints der Tabelle `refill`
--
ALTER TABLE `refill`
  ADD CONSTRAINT `refill_ibfk_1` FOREIGN KEY (`stationID`) REFERENCES `station` (`stationID`),
  ADD CONSTRAINT `refill_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `products` (`productID`);

--
-- Constraints der Tabelle `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`stationID`) REFERENCES `station` (`stationID`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `products` (`productID`),
  ADD CONSTRAINT `sales_ibfk_3` FOREIGN KEY (`sellerID`) REFERENCES `seller` (`sellerID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
