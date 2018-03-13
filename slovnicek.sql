-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Úte 13. bře 2018, 09:30
-- Verze serveru: 5.6.24
-- Verze PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databáze: `slovnik`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `slovnicek`
--

CREATE TABLE IF NOT EXISTS `slovnicek` (
  `id` int(11) NOT NULL,
  `cs` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `en` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `slovni_druh` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Vypisuji data pro tabulku `slovnicek`
--

INSERT INTO `slovnicek` (`id`, `cs`, `en`, `slovni_druh`) VALUES
(1, 'počítač', 'computer', 'podstatné jméno'),
(4, 'plamen', 'flame', 'podstatné jméno'),
(6, 'oheň', 'fire', 'podstatné jméno'),
(7, 'slovo', 'word', ''),
(8, 'léto', 'summer', ''),
(9, 'stůl', 'table', ''),
(10, 'a', 'and', 'spojka'),
(11, 'stůl', 'table', 'podstatné jméno'),
(12, 'pracovat', 'work', 'sloveso'),
(13, 'ona', 'she', 'zájmeno'),
(14, 'on', 'he', 'zájmeno'),
(15, 'it', 'to', 'zájmeno'),
(16, 'oni', 'they', 'zájmeno');

--
-- Klíče pro exportované tabulky
--

--
-- Klíče pro tabulku `slovnicek`
--
ALTER TABLE `slovnicek`
  ADD PRIMARY KEY (`id`), ADD KEY `slovnicek_cs_idx` (`cs`), ADD KEY `slovnicek_en_idx` (`en`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `slovnicek`
--
ALTER TABLE `slovnicek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
