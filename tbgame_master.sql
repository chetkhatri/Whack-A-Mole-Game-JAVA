-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 29, 2014 at 12:05 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbcanvass`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbgame_master`
--

CREATE TABLE IF NOT EXISTS `tbgame_master` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `dte` varchar(35) NOT NULL,
  `points` int(10) NOT NULL,
  `common_hit` int(11) NOT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

--
-- Dumping data for table `tbgame_master`
--

INSERT INTO `tbgame_master` (`game_id`, `uname`, `email`, `dte`, `points`, `common_hit`) VALUES
(8, 'chetkhatri', '', '29/04/14 00:27:03', 19, 8),
(9, 'chetkhatri', '', '29/04/14 00:27:46', 19, 4),
(10, 'Ruchi', '', '29/04/14 00:30:12', 18, 3),
(11, 'Ankit', '', '29/04/14 00:34:40', 20, 2),
(12, 'Ankit', '', '29/04/14 00:46:05', 19, 6),
(13, 'Ankit', '', '29/04/14 00:49:40', 19, 3),
(14, 'Ajay', '', '29/04/14 08:00:04', 18, 8),
(15, 'Sivani', '', '29/04/14 08:20:17', 19, 2),
(16, 'Sivani', '', '29/04/14 08:22:16', 20, 5),
(17, 'Sivani', '', '29/04/14 08:22:48', 20, 9),
(18, 'Ajay', '', '29/04/14 08:24:38', 0, 9),
(19, 'Ajay', '', '29/04/14 08:25:02', 1, 2),
(20, 'Ajay', '', '29/04/14 08:25:29', 4, 7),
(21, 'Ajay', '', '29/04/14 08:26:19', 19, 6),
(41, 'Jalpa', '', '29/04/14 11:33:34', 15, 5),
(40, 'Rajesh', '', '29/04/14 11:21:49', 15, 2),
(39, 'Ankit', '', '29/04/14 11:16:01', 18, 8),
(32, 'Ankit', '', '29/04/14 08:36:53', 13, 8),
(33, 'Ankit', '', '29/04/14 08:37:50', 18, 6),
(34, 'Ankit', '', '29/04/14 08:38:13', 14, 1),
(35, 'Ajay', '', '29/04/14 08:39:49', 17, 9),
(36, 'Ajay', '', '29/04/14 08:43:24', 17, 1),
(37, 'Ajay', '', '29/04/14 08:45:42', 17, 9),
(38, 'Ankit', '', '29/04/14 08:46:45', 19, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
