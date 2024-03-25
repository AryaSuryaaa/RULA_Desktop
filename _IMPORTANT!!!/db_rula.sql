-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2023 at 05:35 PM
-- Server version: 10.4.27-MariaDB-log
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rula`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_add`
--

CREATE TABLE `t_add` (
  `nik` varchar(100) NOT NULL,
  `la_1` varchar(100) NOT NULL,
  `la_2` varchar(100) NOT NULL,
  `la_3` varchar(100) NOT NULL,
  `lb_1` varchar(100) NOT NULL,
  `pt_1` varchar(100) NOT NULL,
  `op_1` varchar(100) NOT NULL,
  `lh_1` varchar(100) NOT NULL,
  `lh_2` varchar(100) NOT NULL,
  `bd_1` varchar(100) NOT NULL,
  `bd_2` varchar(100) NOT NULL,
  `op_2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `t_data`
--

CREATE TABLE `t_data` (
  `nik` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `umur` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nomor_telephone` varchar(100) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `lama_bekerja` varchar(100) NOT NULL,
  `durasi_bekerja` varchar(100) NOT NULL,
  `jenis_kerja` varchar(100) NOT NULL,
  `keluhan` varchar(100) NOT NULL,
  `sisi_badan` varchar(100) NOT NULL,
  `lengan_atas` varchar(100) NOT NULL,
  `lengan_bawah` varchar(100) NOT NULL,
  `pergelangan_tangan` varchar(100) NOT NULL,
  `putar_pergelangan_tangan` varchar(100) NOT NULL,
  `tambahan_data` varchar(100) NOT NULL,
  `leher` varchar(100) NOT NULL,
  `badan` varchar(100) NOT NULL,
  `kaki` varchar(100) NOT NULL,
  `tambahan_data2` varchar(100) NOT NULL,
  `score_a` varchar(100) NOT NULL,
  `score_b` varchar(100) NOT NULL,
  `score_c` varchar(100) NOT NULL,
  `kerentanan` varchar(100) NOT NULL,
  `final_hasil` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `t_show`
--

CREATE TABLE `t_show` (
  `nik` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `umur` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(100) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `final_score_c` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_add`
--
ALTER TABLE `t_add`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `t_data`
--
ALTER TABLE `t_data`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `t_show`
--
ALTER TABLE `t_show`
  ADD PRIMARY KEY (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
