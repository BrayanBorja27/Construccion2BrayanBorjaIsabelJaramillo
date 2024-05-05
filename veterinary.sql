-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2024 a las 06:57:19
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinary`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `mascota` int(11) NOT NULL,
  `propietario` bigint(20) NOT NULL,
  `producto` varchar(30) NOT NULL,
  `valor` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia`
--

CREATE TABLE `historia` (
  `fecha` bigint(20) NOT NULL,
  `mascota` int(11) NOT NULL,
  `medico` bigint(20) NOT NULL,
  `motivo` text NOT NULL,
  `sintomatologia` text NOT NULL,
  `diagnosis` varchar(30) NOT NULL,
  `medicamento` varchar(30) NOT NULL,
  `medicationDosage` varchar(39) NOT NULL,
  `vacunacion` text NOT NULL,
  `alergia` text NOT NULL,
  `procedimiento` text NOT NULL,
  `detalles_procedimientos` text NOT NULL,
  `orden` int(11) NOT NULL,
  `ordercancelation` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historia`
--

INSERT INTO `historia` (`fecha`, `mascota`, `medico`, `motivo`, `sintomatologia`, `diagnosis`, `medicamento`, `medicationDosage`, `vacunacion`, `alergia`, `procedimiento`, `detalles_procedimientos`, `orden`, `ordercancelation`) VALUES
(1710608723616, 2, 111, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 5, 1),
(1710613358250, 3, 111, 'Dermatitis', 'Picazón', 'Z759', 'Dexametasona', '1', 'na', 'na', 'na', 'na', 5, 1),
(1714699193358, 1037641723, 1037641719, 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 29, 0),
(1714733726179, 1037641725, 1234567890, 'Dolor', 'Dolor', 'Dolor', 'N/A', '5', '1037641725', 'N/A', 'Acetaminofen', 'N/A', 30, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `id` int(11) NOT NULL,
  `id_propietario` bigint(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `peso` double NOT NULL,
  `raza` varchar(10) NOT NULL,
  `especie` varchar(10) NOT NULL,
  `caracteristicas` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`id`, `id_propietario`, `nombre`, `edad`, `peso`, `raza`, `especie`, `caracteristicas`) VALUES
(2, 1037641710, 'Lucy', 9, 35, 'criolla', 'perro', 'ninguna'),
(3, 1017180189, 'Mailo', 2, 5, 'criollo', 'perro', 'ninguna'),
(1037641722, 1017641719, 'Fruna', 10, 6, 'Criolla ', 'perro', 'Ninguna'),
(1037641723, 1037641719, 'Nieves', 15, 9, 'Criolla', 'perro', 'Bicolor'),
(1037641725, 987654321, 'Teo', 9, 6, 'schnauzer', 'perro', 'N/A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `id` int(11) NOT NULL,
  `mascota` int(11) NOT NULL,
  `propietario` bigint(20) NOT NULL,
  `medico` bigint(20) NOT NULL,
  `medicamento` varchar(30) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `orden`
--

INSERT INTO `orden` (`id`, `mascota`, `propietario`, `medico`, `medicamento`, `fecha`) VALUES
(5, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(6, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(7, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(8, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(9, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(10, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(11, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(12, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(13, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(14, 2, 1037641719, 1037641719, 'a', '2024-03-16'),
(15, 3, 1037641719, 1037641719, 'Dexametasona', '2024-03-16'),
(17, 2, 1037641719, 1037641719, 'asd', '2024-05-02'),
(18, 2, 1037641719, 1037641719, 'e', '2024-05-02'),
(19, 2, 1037641719, 1037641719, 'a', '2024-05-02'),
(20, 2, 1037641719, 1037641719, 'a', '2024-05-02'),
(21, 2, 1037641719, 1037641719, 'ñ', '2024-05-02'),
(22, 2, 1037641719, 1037641719, 'ñ', '2024-05-02'),
(23, 2, 1037641719, 1037641719, 'a', '2024-05-02'),
(24, 2, 1037641719, 1037641719, 'a', '2024-05-02'),
(25, 2, 1037641719, 1037641719, 'p', '2024-05-02'),
(26, 2, 1037641719, 1037641719, 'a', '2024-05-02'),
(27, 1037641722, 1037641719, 1037641719, 'q', '2024-05-02'),
(28, 1037641722, 1037641719, 1037641719, 'w', '2024-05-02'),
(29, 1037641723, 1037641719, 1037641719, 'u', '2024-05-02'),
(30, 1037641725, 1234567890, 1234567890, 'Acetaminofen', '2024-05-03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `cedula` bigint(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `edad` int(3) NOT NULL,
  `role` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`cedula`, `nombre`, `edad`, `role`, `username`, `password`) VALUES
(1221, 'juan', 21, 'Dueño', 'Dueño', 'Dueño'),
(12345678, 'Diana Rojas', 30, 'Administrador', 'DianaRojas', '123456'),
(987654321, 'Paola Alejandra Cano', 36, 'Dueño', 'Dueño', 'Dueño'),
(1017180189, 'Juan Carlos Campillo Vargas', 35, 'Medico Veterinario', 'JuanCampillo', '123456'),
(1017270721, 'Armando Esteban Gonzalez Velasquez', 24, 'Vendedor', 'EstebanGonzalez', '123456'),
(1017641719, 'Diana Maria Posada', 0, 'Dueño', 'Dueño', 'Dueño'),
(1031741819, 'Patricia Taborda', 0, 'Dueño', 'Dueño', 'Dueño'),
(1037641710, 'cristina rojas', 0, 'Dueño', 'Dueño', 'Dueño'),
(1037641719, 'Isabel Jaramillo Rojas', 25, 'Medico Veterinario', 'isabel', '123456'),
(1234567890, 'Brian Alejandro Ramirez', 32, 'Medico Veterinario', 'Briam', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`id`, `username`, `role`) VALUES
(100, 'isabel', 'Medico Veterinario'),
(101, 'isabel', 'Medico Veterinario'),
(102, 'isabel', 'Medico Veterinario'),
(103, 'isabel', 'Medico Veterinario'),
(104, 'isabel', 'Medico Veterinario'),
(105, 'isabel', 'Medico Veterinario'),
(106, 'isabel', 'Medico Veterinario'),
(107, 'isabel', 'Medico Veterinario'),
(108, 'isabel', 'Medico Veterinario'),
(109, 'isabel', 'Medico Veterinario'),
(110, 'isabel', 'Medico Veterinario'),
(111, 'isabel', 'Medico Veterinario'),
(112, 'isabel', 'Medico Veterinario'),
(113, 'isabel', 'Medico Veterinario'),
(114, 'isabel', 'Medico Veterinario'),
(115, 'isabel', 'Medico Veterinario'),
(116, 'isabel', 'Medico Veterinario'),
(117, 'isabel', 'Medico Veterinario'),
(118, 'isabel', 'Medico Veterinario'),
(119, 'isabel', 'Medico Veterinario'),
(120, 'isabel', 'Medico Veterinario'),
(121, 'isabel', 'Medico Veterinario'),
(122, 'isabel', 'Medico Veterinario'),
(123, 'isabel', 'Medico Veterinario'),
(124, 'isabel', 'Medico Veterinario'),
(125, 'isabel', 'Medico Veterinario'),
(126, 'isabel', 'Medico Veterinario'),
(127, 'isabel', 'Medico Veterinario'),
(128, 'isabel', 'Medico Veterinario'),
(129, 'isabel', 'Medico Veterinario'),
(130, 'isabel', 'Medico Veterinario'),
(131, 'isabel', 'Medico Veterinario'),
(132, 'isabel', 'Medico Veterinario'),
(133, 'isabel', 'Medico Veterinario'),
(134, 'isabel', 'Medico Veterinario'),
(135, 'DianaRojas', 'Administrador'),
(136, 'isabel', 'Medico Veterinario'),
(137, 'isabel', 'Medico Veterinario'),
(138, 'isabel', 'Medico Veterinario'),
(139, 'isabel', 'Medico Veterinario'),
(140, 'isabel', 'Medico Veterinario'),
(141, 'isabel', 'Medico Veterinario'),
(142, 'isabel', 'Medico Veterinario'),
(143, 'isabel', 'Medico Veterinario'),
(144, 'isabel', 'Medico Veterinario'),
(145, 'isabel', 'Medico Veterinario'),
(146, 'isabel', 'Medico Veterinario'),
(147, 'isabel', 'Medico Veterinario'),
(148, 'isabel', 'Medico Veterinario'),
(149, 'isabel', 'Medico Veterinario'),
(150, 'isabel', 'Medico Veterinario'),
(151, 'isabel', 'Medico Veterinario'),
(152, 'isabel', 'Medico Veterinario'),
(153, 'isabel', 'Medico Veterinario'),
(154, 'isabel', 'Medico Veterinario'),
(155, 'isabel', 'Medico Veterinario'),
(156, 'isabel', 'Medico Veterinario'),
(157, 'isabel', 'Medico Veterinario'),
(158, 'isabel', 'Medico Veterinario'),
(159, 'isabel', 'Medico Veterinario'),
(160, 'DianaRojas', 'Administrador'),
(161, 'Briam', 'Medico Veterinario'),
(162, 'Briam', 'Medico Veterinario'),
(163, 'Briam', 'Medico Veterinario'),
(164, 'Briam', 'Medico Veterinario'),
(165, 'Briam', 'Medico Veterinario'),
(166, 'Briam', 'Medico Veterinario'),
(167, 'Briam', 'Medico Veterinario'),
(168, 'Briam', 'Medico Veterinario'),
(169, 'Briam', 'Medico Veterinario'),
(170, 'Briam', 'Medico Veterinario'),
(171, 'Briam', 'Medico Veterinario'),
(172, 'Briam', 'Medico Veterinario'),
(173, 'Briam', 'Medico Veterinario'),
(174, 'Briam', 'Medico Veterinario'),
(175, 'Briam', 'Medico Veterinario'),
(176, 'Briam', 'Medico Veterinario'),
(177, 'Briam', 'Medico Veterinario'),
(178, 'Briam', 'Medico Veterinario'),
(179, 'Briam', 'Medico Veterinario'),
(180, 'Briam', 'Medico Veterinario'),
(181, 'Briam', 'Medico Veterinario'),
(182, 'Briam', 'Medico Veterinario'),
(183, 'Briam', 'Medico Veterinario'),
(184, 'Briam', 'Medico Veterinario'),
(185, 'Briam', 'Medico Veterinario'),
(186, 'Briam', 'Medico Veterinario'),
(187, 'Briam', 'Medico Veterinario'),
(188, 'Briam', 'Medico Veterinario'),
(189, 'Briam', 'Medico Veterinario'),
(190, 'Briam', 'Medico Veterinario'),
(191, 'Briam', 'Medico Veterinario'),
(192, 'Briam', 'Medico Veterinario'),
(193, 'EstebanGonzalez', 'Vendedor'),
(194, 'EstebanGonzalez', 'Vendedor'),
(195, 'Briam', 'Medico Veterinario'),
(196, 'EstebanGonzalez', 'Vendedor'),
(197, 'Briam', 'Medico Veterinario'),
(198, 'Briam', 'Medico Veterinario'),
(199, 'EstebanGonzalez', 'Vendedor'),
(200, 'EstebanGonzalez', 'Vendedor'),
(201, 'EstebanGonzalez', 'Vendedor'),
(202, 'EstebanGonzalez', 'Vendedor'),
(203, 'EstebanGonzalez', 'Vendedor'),
(204, 'EstebanGonzalez', 'Vendedor'),
(205, 'EstebanGonzalez', 'Vendedor'),
(206, 'EstebanGonzalez', 'Vendedor'),
(207, 'EstebanGonzalez', 'Vendedor'),
(208, 'EstebanGonzalez', 'Vendedor'),
(209, 'EstebanGonzalez', 'Vendedor'),
(210, 'EstebanGonzalez', 'Vendedor'),
(211, 'EstebanGonzalez', 'Vendedor'),
(212, 'EstebanGonzalez', 'Vendedor'),
(213, 'EstebanGonzalez', 'Vendedor'),
(214, 'EstebanGonzalez', 'Vendedor'),
(215, 'EstebanGonzalez', 'Vendedor'),
(216, 'EstebanGonzalez', 'Vendedor'),
(217, 'EstebanGonzalez', 'Vendedor');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `factura_mascota` (`mascota`),
  ADD KEY `factura_propietario` (`propietario`);

--
-- Indices de la tabla `historia`
--
ALTER TABLE `historia`
  ADD PRIMARY KEY (`fecha`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `propietario` (`id_propietario`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`id`),
  ADD KEY `orden_mascota` (`mascota`),
  ADD KEY `orden_propietario` (`propietario`),
  ADD KEY `orden_veterinario` (`medico`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1037641726;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=218;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_mascota` FOREIGN KEY (`mascota`) REFERENCES `mascota` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_propietario` FOREIGN KEY (`propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`id_propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `orden_mascota` FOREIGN KEY (`mascota`) REFERENCES `mascota` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orden_propietario` FOREIGN KEY (`propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orden_veterinario` FOREIGN KEY (`medico`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
