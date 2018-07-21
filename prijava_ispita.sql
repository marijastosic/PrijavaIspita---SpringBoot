-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2018 at 03:42 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prijava_ispita`
--

-- --------------------------------------------------------

--
-- Table structure for table `ispit`
--

CREATE TABLE `ispit` (
  `ispit_id` int(11) NOT NULL,
  `nastavnik` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `termin` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ispit`
--

INSERT INTO `ispit` (`ispit_id`, `nastavnik`, `naziv`, `termin`) VALUES
(1, 'Jovana Jovic', 'KI103 Java 1: Osnove programiranja u Javi', '10.03.2018.'),
(2, 'Jovana Jovic', 'KI106 Objektno orijentisano programiranje', '14.04.2018'),
(3, 'Veljko Grkovic', 'KI201 Java 4: Strukture podataka i algoritmi', '19.05.2018.'),
(4, 'Veljko Grkovic', 'KI207 Java 7: Java Enterprise Edition', '14.07.2018.');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'STUDENT');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `active`, `email`, `first_name`, `last_name`, `password`, `user_name`) VALUES
(7, 1, 'mary.mary_94@hotmail.com', 'Marija', 'Stoši?', '$2a$10$88j0gd92HeWc1OnaXuOb..UfpTRUuoKlxzE60cMZw5misMV0r1VWy', '2018');

-- --------------------------------------------------------

--
-- Table structure for table `user_ispit`
--

CREATE TABLE `user_ispit` (
  `user_id` int(11) NOT NULL,
  `ispit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(7, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ispit`
--
ALTER TABLE `ispit`
  ADD PRIMARY KEY (`ispit_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_ispit`
--
ALTER TABLE `user_ispit`
  ADD PRIMARY KEY (`user_id`,`ispit_id`),
  ADD KEY `FK7kkae70tlkjmr12e2t4l5gkor` (`ispit_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ispit`
--
ALTER TABLE `ispit`
  MODIFY `ispit_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_ispit`
--
ALTER TABLE `user_ispit`
  ADD CONSTRAINT `FK7kkae70tlkjmr12e2t4l5gkor` FOREIGN KEY (`ispit_id`) REFERENCES `ispit` (`ispit_id`),
  ADD CONSTRAINT `FKl01cu87dc9s4u5hw9ifxkknbf` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
