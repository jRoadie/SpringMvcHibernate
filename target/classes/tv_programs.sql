-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2013 at 12:13 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tv_programs`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` longtext,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`rid`, `name`, `description`) VALUES
(1, 'dsfsdf', 'sdfsdf'),
(2, 'vbnvn', 'vbnv');

-- --------------------------------------------------------

--
-- Table structure for table `programs`
--

CREATE TABLE IF NOT EXISTS `programs` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` longtext,
  `active_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`rid`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `programs`
--

INSERT INTO `programs` (`rid`, `code`, `title`, `description`, `active_status`) VALUES
(38, 'dfd hdf h d', ' fddf gdf g', 'd hdhf dg hx', 1),
(42, 'zgsyse r', 'sdg sdh ', 'sdh dhg ', 1),
(43, 'dsfs', 'dsdsfs', 'fdsdfsdf', 1),
(44, ' vnb', 'vbnv', 'vbnvn', 0);

-- --------------------------------------------------------

--
-- Table structure for table `program_has_category`
--

CREATE TABLE IF NOT EXISTS `program_has_category` (
  `program_rid` int(11) NOT NULL,
  `category_rid` int(11) NOT NULL,
  KEY `program_rid` (`program_rid`),
  KEY `category_rid` (`category_rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE IF NOT EXISTS `schedules` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `program_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `duration` float NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `program_id` (`program_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`rid`, `program_id`, `date`, `time`, `duration`) VALUES
(2, 44, '2012-01-12', '03:00:00', 4),
(4, 42, '2012-01-12', '03:30:00', 6),
(6, 43, '2012-01-12', '03:05:00', 4),
(9, 42, '2012-03-11', '03:00:00', 4),
(18, 44, '2012-01-17', '03:30:00', 6),
(19, 38, '2011-11-11', '02:59:00', 5);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `program_has_category`
--
ALTER TABLE `program_has_category`
  ADD CONSTRAINT `program_has_category_ibfk_2` FOREIGN KEY (`category_rid`) REFERENCES `categories` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `program_has_category_ibfk_1` FOREIGN KEY (`program_rid`) REFERENCES `programs` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `schedules_ibfk_1` FOREIGN KEY (`program_id`) REFERENCES `programs` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
