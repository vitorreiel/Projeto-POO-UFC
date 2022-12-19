-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Mar-2021 às 19:43
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `concessionaria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE `admin` (
  `Senha` varchar(50) DEFAULT NULL,
  `Login` varchar(30) DEFAULT NULL,
  `Cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`Senha`, `Login`, `Cod`) VALUES
('21232f297a57a5a743894a0e4a801fc3', 'admin', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `Cod` int(11) NOT NULL,
  `Primeiro_Nome` varchar(50) DEFAULT NULL,
  `Segundo_Nome` varchar(50) DEFAULT NULL,
  `Ultimo_Nome` varchar(50) DEFAULT NULL,
  `CPF` varchar(50) DEFAULT NULL,
  `RG` varchar(50) DEFAULT NULL,
  `Login` varchar(50) DEFAULT NULL,
  `Senha` varchar(50) DEFAULT NULL,
  `CNH` varchar(100) DEFAULT NULL,
  `Cidade` varchar(100) DEFAULT NULL,
  `Estado` varchar(100) DEFAULT NULL,
  `FK_Funcionario_Cod` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`Cod`, `Primeiro_Nome`, `Segundo_Nome`, `Ultimo_Nome`, `CPF`, `RG`, `Login`, `Senha`, `CNH`, `Cidade`, `Estado`, `FK_Funcionario_Cod`) VALUES
(7, 'Jonas', 'Jonas', 'Oliveira', '999.999.999-99', '999.999.999-99', 'jonas', 'e4c968b16ceecf3ffe6f7c616328fa4a', '999.99999.99-9', 'morada Nova', 'Ce', NULL),
(8, 'vitor', 'reiel', 'lima', '999.999.999-99', '888.888.888-88', 'vitor', '320652e3afe3d17415897504813abf7b', '777.77777.77-7', 'morada nova', 'ceará', NULL),
(10, 'Walber', 'Viana', 'Viana', '888.888.888-88', '999.999.999-99', 'walber', '90130b0f4a12b5ea53f26b1091d1007c', '777.77777.77-7', 'cidade', 'Ceará', NULL),
(11, 'Arthur', 'Santos', 'Filho', '777.777.777-77', '666.666.666-66', 'arthur', '68830aef4dbfad181162f9251a1da51b', '333.33333.33-3', 'Morada Nova', 'Ceará', NULL),
(12, 'José', 'Luciano', 'Lima', '333.333.333-33', '777.777.777-77', 'luciano', '55fadfd036b568d4b2d5796ee444caa0', '263.45726.45-2', 'Morada Nova', 'Ceará', NULL),
(13, 'João', 'Victor', 'Silva', '234.234.234-23', '982.367.489-72', 'joaov', '002fab77b699817d748ba6554e225ef6', '982.37498.23-7', 'Fortaleza', 'Ceará', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `FK_Cliente_Cod` int(11) DEFAULT NULL,
  `FK_Veiculos_Cod` int(11) DEFAULT NULL,
  `Forma_Pagamento` varchar(50) DEFAULT NULL,
  `ServicosAdicionais` varchar(200) DEFAULT NULL,
  `Desconto` varchar(40) DEFAULT NULL,
  `Valor_Total` varchar(40) DEFAULT NULL,
  `Chassi` varchar(50) DEFAULT NULL,
  `cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `compra`
--

INSERT INTO `compra` (`FK_Cliente_Cod`, `FK_Veiculos_Cod`, `Forma_Pagamento`, `ServicosAdicionais`, `Desconto`, `Valor_Total`, `Chassi`, `cod`) VALUES
(NULL, NULL, '330000', '33000', '330000', '33000', '000002', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `Cod` int(11) NOT NULL,
  `Senha` varchar(50) DEFAULT NULL,
  `RG` varchar(50) DEFAULT NULL,
  `Login` varchar(50) DEFAULT NULL,
  `CPF` varchar(50) DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `NumeroPIS` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`Cod`, `Senha`, `RG`, `Login`, `CPF`, `nome`, `NumeroPIS`) VALUES
(16, '53bd7880cbf6fffa6f083b60d4814b15', '298.347.923-74', 'reiel', '234.873.294-79', 'Reiel', '238.47392.47-8'),
(17, '90130b0f4a12b5ea53f26b1091d1007c', '283.746.238-74', 'walber', '234.234.234-33', 'Walber', '234.23423.42-3'),
(18, '9c5ddd54107734f7d18335a5245c286b', '324.234.234-24', 'jonas', '283.746.238-74', 'Jonas', '236.74572.36-4');

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculos`
--

CREATE TABLE `veiculos` (
  `Cod` int(11) NOT NULL,
  `Modelo` varchar(100) DEFAULT NULL,
  `Ano` varchar(10) DEFAULT NULL,
  `Fabricante` varchar(100) DEFAULT NULL,
  `Cor` varchar(50) DEFAULT NULL,
  `Chassi` varchar(50) DEFAULT NULL,
  `Preco` varchar(20) DEFAULT NULL,
  `Promocao` varchar(50) DEFAULT NULL,
  `Data_Promocao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `veiculos`
--

INSERT INTO `veiculos` (`Cod`, `Modelo`, `Ano`, `Fabricante`, `Cor`, `Chassi`, `Preco`, `Promocao`, `Data_Promocao`) VALUES
(7, 'Ka', '2018', 'Ford', 'amarelo', '8880', '38.000,00', NULL, NULL),
(8, 'Celta', '2018', 'Chevrolet', 'Branco', '234234234', '25.000,00', NULL, NULL),
(9, 'Civic', '2013/2014', 'Honda', 'Preto', '23423423', '55.000,00', NULL, NULL),
(10, 'HB20', '2009/2010', 'Hyundai', 'Preto', '23645732', '30.000,00', NULL, NULL),
(11, 'Corolla', '2007', 'Toyota', 'Prata', '2342345', '30.000,00', NULL, NULL),
(12, 'Hilux SW4', '2016/2017', 'Toyota', 'Branco', '2734699', '265.800,00', NULL, NULL),
(13, 'A3', '2019', 'AUDI', 'Prata', '3487879', '225.000,00', NULL, NULL),
(14, '488 GTB', '2017', 'Ferrari', 'Branca', '9879898', '2.690.000,00', NULL, NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Cod`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Cod`),
  ADD KEY `FK_Cliente_1` (`FK_Funcionario_Cod`);

--
-- Índices para tabela `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`cod`),
  ADD KEY `FK_compra_0` (`FK_Cliente_Cod`),
  ADD KEY `FK_compra_1` (`FK_Veiculos_Cod`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Cod`);

--
-- Índices para tabela `veiculos`
--
ALTER TABLE `veiculos`
  ADD PRIMARY KEY (`Cod`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `admin`
--
ALTER TABLE `admin`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `compra`
--
ALTER TABLE `compra`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de tabela `veiculos`
--
ALTER TABLE `veiculos`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_Cliente_1` FOREIGN KEY (`FK_Funcionario_Cod`) REFERENCES `funcionario` (`Cod`);

--
-- Limitadores para a tabela `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `FK_compra_0` FOREIGN KEY (`FK_Cliente_Cod`) REFERENCES `cliente` (`Cod`),
  ADD CONSTRAINT `FK_compra_1` FOREIGN KEY (`FK_Veiculos_Cod`) REFERENCES `veiculos` (`Cod`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
