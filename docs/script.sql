USE [master]
GO
/****** Object:  Database [grupo_1_estanciero]    Script Date: 4/5/2024 21:15:47 ******/
CREATE DATABASE [grupo_1_estanciero]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'grupo_1_estanciero', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\grupo_1_estanciero.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'grupo_1_estanciero_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\grupo_1_estanciero_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [grupo_1_estanciero] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [grupo_1_estanciero].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [grupo_1_estanciero] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET ARITHABORT OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [grupo_1_estanciero] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [grupo_1_estanciero] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [grupo_1_estanciero] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET  ENABLE_BROKER 
GO
ALTER DATABASE [grupo_1_estanciero] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [grupo_1_estanciero] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [grupo_1_estanciero] SET  MULTI_USER 
GO
ALTER DATABASE [grupo_1_estanciero] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [grupo_1_estanciero] SET DB_CHAINING OFF 
GO
ALTER DATABASE [grupo_1_estanciero] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [grupo_1_estanciero] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [grupo_1_estanciero] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [grupo_1_estanciero] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [grupo_1_estanciero] SET QUERY_STORE = ON
GO
ALTER DATABASE [grupo_1_estanciero] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [grupo_1_estanciero]
GO
/****** Object:  Table [dbo].[banks]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[banks](
	[id_bank] [int] NOT NULL,
	[id_property] [int] NULL,
	[money] [decimal](10, 2) NULL,
 CONSTRAINT [pk_banks] PRIMARY KEY CLUSTERED 
(
	[id_bank] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[boards]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[boards](
	[id_board] [int] NOT NULL,
	[id_box] [int] NULL,
	[id_card] [int] NULL,
	[id_dice] [int] NULL,
 CONSTRAINT [pk_board] PRIMARY KEY CLUSTERED 
(
	[id_board] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[boxes]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[boxes](
	[id_box] [int] NOT NULL,
	[id_pawns] [int] NULL,
	[id_type_box] [int] NULL,
	[id_property] [int] NULL,
 CONSTRAINT [pk_boxes] PRIMARY KEY CLUSTERED 
(
	[id_box] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cards]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cards](
	[id_card] [int] NOT NULL,
	[id_type_card] [int] NULL,
	[description] [varchar](200) NULL,
 CONSTRAINT [pk_cards] PRIMARY KEY CLUSTERED 
(
	[id_card] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dices]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dices](
	[id_dice] [int] NOT NULL,
	[side] [int] NULL,
	[number_dice] [int] NULL,
 CONSTRAINT [pk_dices] PRIMARY KEY CLUSTERED 
(
	[id_dice] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dificulties]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dificulties](
	[id_dificulty] [int] NOT NULL,
	[dificulty] [varchar](25) NULL,
 CONSTRAINT [pk_dificulties] PRIMARY KEY CLUSTERED 
(
	[id_dificulty] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[matches]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[matches](
	[id_match] [int] NOT NULL,
	[id_board] [int] NULL,
	[id_player] [int] NULL,
	[id_dificulty] [int] NULL,
	[id_bank] [int] NULL,
	[id_user] [int] NULL,
 CONSTRAINT [pk_matches] PRIMARY KEY CLUSTERED 
(
	[id_match] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pawns]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pawns](
	[id_pawn] [int] NOT NULL,
	[id_player] [int] NULL,
	[id_card] [int] NULL,
	[id_property] [int] NULL,
	[money] [decimal](10, 2) NULL,
	[active] [bit] NULL,
 CONSTRAINT [pk_pawns] PRIMARY KEY CLUSTERED 
(
	[id_pawn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[players]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[players](
	[id_player] [int] NOT NULL,
	[id_type_player] [int] NULL,
	[id_turn] [int] NULL,
 CONSTRAINT [pk_players] PRIMARY KEY CLUSTERED 
(
	[id_player] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[properties]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[properties](
	[id_property] [int] NOT NULL,
	[id_type_property] [int] NULL,
	[value] [decimal](10, 2) NULL,
	[rent_value] [decimal](10, 2) NULL,
	[id_zone] [int] NULL,
	[descripcion] [varchar](150) NULL,
	[id_type_upgrade] [int] NULL,
	[id_province] [int] NULL,
 CONSTRAINT [pk_properties] PRIMARY KEY CLUSTERED 
(
	[id_property] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Provinces]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Provinces](
	[id_province] [int] IDENTITY(1,1) NOT NULL,
	[province_name] [varchar](25) NULL,
 CONSTRAINT [pk_provinces] PRIMARY KEY CLUSTERED 
(
	[id_province] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Turns]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Turns](
	[id_turn] [int] NOT NULL,
	[shift_turn] [varchar](25) NULL,
 CONSTRAINT [pk_turns] PRIMARY KEY CLUSTERED 
(
	[id_turn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[type_boxes]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[type_boxes](
	[id_type_box] [int] NOT NULL,
	[type] [varchar](50) NULL,
 CONSTRAINT [pk_type_box] PRIMARY KEY CLUSTERED 
(
	[id_type_box] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[type_cards]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[type_cards](
	[id_type_card] [int] NOT NULL,
	[type] [varchar](50) NULL,
 CONSTRAINT [pk_type_cards] PRIMARY KEY CLUSTERED 
(
	[id_type_card] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Type_players]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type_players](
	[id_type_player] [int] NOT NULL,
	[description] [varchar](50) NULL,
 CONSTRAINT [pk_type_player] PRIMARY KEY CLUSTERED 
(
	[id_type_player] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[type_properties]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[type_properties](
	[id_type_property] [int] NOT NULL,
	[type_property] [varchar](50) NULL,
 CONSTRAINT [pk_type_properties] PRIMARY KEY CLUSTERED 
(
	[id_type_property] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Type_upgrades]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type_upgrades](
	[id_type_upgrade] [int] NOT NULL,
	[type_upgrade] [varchar](50) NULL,
 CONSTRAINT [pk_type_upgrade] PRIMARY KEY CLUSTERED 
(
	[id_type_upgrade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id_user] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[e_mail] [varchar](50) NULL,
	[nationality] [varchar](50) NULL,
	[age] [int] NULL,
	[id_match] [int] NULL,
 CONSTRAINT [pk_users] PRIMARY KEY CLUSTERED 
(
	[id_user] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Zone]    Script Date: 4/5/2024 21:15:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Zone](
	[id_zone] [int] NOT NULL,
	[zone] [varchar](50) NULL,
 CONSTRAINT [pk_zone] PRIMARY KEY CLUSTERED 
(
	[id_zone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[banks] ([id_bank], [id_property], [money]) VALUES (1, NULL, CAST(99999999.99 AS Decimal(10, 2)))
GO
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (0, NULL, 7, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (1, NULL, 1, 1)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (2, NULL, 1, 2)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (3, NULL, 1, 3)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (4, NULL, 4, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (5, NULL, 1, 5)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (6, NULL, 1, 6)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (7, NULL, 4, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (8, NULL, 1, 8)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (9, NULL, 1, 9)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (10, NULL, 2, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (11, NULL, 1, 11)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (12, NULL, 1, 12)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (13, NULL, 1, 13)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (14, NULL, 5, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (15, NULL, 3, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (16, NULL, 1, 16)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (17, NULL, 1, 17)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (18, NULL, 1, 18)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (19, NULL, 1, 19)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (20, NULL, 1, 20)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (21, NULL, 5, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (22, NULL, 1, 22)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (23, NULL, 1, 23)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (24, NULL, 1, 24)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (25, NULL, 2, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (26, NULL, 1, 26)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (27, NULL, 1, 27)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (28, NULL, 5, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (29, NULL, 1, 29)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (30, NULL, 1, 30)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (31, NULL, 1, 31)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (32, NULL, 1, 32)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (33, NULL, 1, 33)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (34, NULL, 1, 34)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (35, NULL, 6, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (36, NULL, 3, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (37, NULL, 1, 37)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (38, NULL, 2, NULL)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (39, NULL, 1, 39)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (40, NULL, 1, 40)
INSERT [dbo].[boxes] ([id_box], [id_pawns], [id_type_box], [id_property]) VALUES (41, NULL, 4, NULL)
GO
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (1, 1, N'Marche preso directamente')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (2, 1, N'Ha ganado la grande. Cobre 10000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (3, 1, N'Haga un paseo hasta la Bodega. Si pasa por la salida cobre 5000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (4, 1, N'Siga hasta Buenos Aires, Zona Norte')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (5, 1, N'Siga hasta Salta, Zona Norte. Si pasa por salida cobre 5000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (6, 1, N'Multa por exceso de velocidad. Pague 300')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (7, 1, N'Ganó en las carreras. Cobre 3000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (8, 1, N'Cobre 1000 por intereses bancarios')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (9, 1, N'Siga hasta la salida')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (10, 1, N'Pague 3000 por gastos colegiales')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (11, 1, N'Vuelva tres pasos atrás')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (12, 1, N'Multa caminera. Pague 400')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (13, 1, N'Sus propiedades tienen que ser reparadas. Pague al Banco 500 por cada chacra y 2500 por cada estancia')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (14, 1, N'Por compra de semilla pague al Banco 800 por cada chacra. 4000 por cada estancia')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (15, 1, N'Siga hasta Santa Fe, Zona Norte. Si pasa por la salida cobre 5000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (16, 1, N'Habeas Corpus concedido. Con esta tarjeta sale usted gratuitamente de la Comisaria. Conservala o vendala.')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (17, 2, N'5% de interes sobre cedulas hipotecarias. Cobre 500')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (18, 2, N'Con esta tarjeta sale usted de la Comisaria. Conservela hasta utilizarla o vendala.')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (19, 2, N'Marche preso directamente')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (20, 2, N'Devolucion de impuesto. Cobre 400')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (21, 2, N'Pague su poliza de seguro con 1000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (22, 2, N'Ha ganado un concurso agricola. Cobre 2000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (23, 2, N'Error en los calculos del Banco. Cobre 4000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (24, 2, N'Gastos de Farmacia. Pague 1000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (25, 2, N'Ha obtenido un segundo premio de belleza. Cobre 200')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (26, 2, N'En su cumpleaños.Cobre 200 de cada uno de sus jugadores.')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (27, 2, N'Ha ganado un concurso agricola. Cobre 2000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (28, 2, N'Hereda 2000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (29, 2, N'Por venta de acciones cobre 1000')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (30, 2, N'Siga hasta la salida')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (31, 2, N'Vuelve atrás hasta Formosa Zona Sur')
INSERT [dbo].[cards] ([id_card], [id_type_card], [description]) VALUES (32, 2, N'Pague 200 de multa o levante una tarjeta de SUERTE')
GO
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (1, 1, 1)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (2, 2, 1)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (3, 3, 1)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (4, 4, 1)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (5, 5, 1)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (6, 6, 1)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (7, 1, 2)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (8, 2, 2)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (9, 3, 2)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (10, 4, 2)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (11, 5, 2)
INSERT [dbo].[dices] ([id_dice], [side], [number_dice]) VALUES (12, 6, 2)
GO
INSERT [dbo].[dificulties] ([id_dificulty], [dificulty]) VALUES (1, N'Dificil')
INSERT [dbo].[dificulties] ([id_dificulty], [dificulty]) VALUES (2, N'Medio')
INSERT [dbo].[dificulties] ([id_dificulty], [dificulty]) VALUES (3, N'Facil')
GO
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (1, 1, CAST(1000.00 AS Decimal(10, 2)), CAST(40.00 AS Decimal(10, 2)), 1, N'Prov. Formosa Zona Sur', NULL, 1)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (2, 1, CAST(1000.00 AS Decimal(10, 2)), CAST(40.00 AS Decimal(10, 2)), 2, N'Prov. Formosa Zona Centro', NULL, 1)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (3, 1, CAST(1200.00 AS Decimal(10, 2)), CAST(80.00 AS Decimal(10, 2)), 3, N'Prov. Formosa Zona Norte', NULL, 1)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (5, 1, CAST(2000.00 AS Decimal(10, 2)), CAST(110.00 AS Decimal(10, 2)), 1, N'Prov. Rio Negro Zona Sur', NULL, 2)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (6, 1, CAST(2200.00 AS Decimal(10, 2)), CAST(150.00 AS Decimal(10, 2)), 3, N'Prov. Rio Negro Zona Norte', NULL, 2)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (8, 3, CAST(5000.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, N'Compañia petrolera', NULL, NULL)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (9, 1, CAST(2600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), 1, N'Prov. Salta Zona Sur', NULL, 3)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (11, 1, CAST(2600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), 2, N'Prov. Salta Zona Centro', NULL, 3)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (12, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), NULL, N'Ferrocarril General Belgrano', NULL, NULL)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (13, 1, CAST(3000.00 AS Decimal(10, 2)), CAST(230.00 AS Decimal(10, 2)), 3, N'Prov. Salta Zona Norte', NULL, 3)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (16, 3, CAST(3600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, N'Bodega (compañia)', NULL, NULL)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (17, 1, CAST(3400.00 AS Decimal(10, 2)), CAST(250.00 AS Decimal(10, 2)), 1, N'Prov. Mendoza Zona Sur', NULL, 4)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (18, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), NULL, N'Ferrocarril General San Martin', NULL, NULL)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (19, 1, CAST(3400.00 AS Decimal(10, 2)), CAST(250.00 AS Decimal(10, 2)), 2, N'Prov. Mendoza Zona Centro', NULL, 4)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (20, 1, CAST(3800.00 AS Decimal(10, 2)), CAST(300.00 AS Decimal(10, 2)), 3, N'Prov. Mendoza Zona Norte', NULL, 4)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (22, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, N'Ferrocarril General Mitre', NULL, NULL)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (23, 1, CAST(4200.00 AS Decimal(10, 2)), CAST(350.00 AS Decimal(10, 2)), 1, N'Prov. Santa Fe Zona Sur', NULL, 5)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (24, 1, CAST(4200.00 AS Decimal(10, 2)), CAST(350.00 AS Decimal(10, 2)), 2, N'Prov. Santa Fe Zona Centro', NULL, 5)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (26, 1, CAST(4600.00 AS Decimal(10, 2)), CAST(400.00 AS Decimal(10, 2)), 3, N'Prov. Santa Fe Zona Norte', NULL, 5)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (27, 2, CAST(3600.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), NULL, N'Ferrocarril General Urquiza', NULL, NULL)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (29, 1, CAST(5000.00 AS Decimal(10, 2)), CAST(400.00 AS Decimal(10, 2)), 1, N'Prov. Tucuman Zona Sur', NULL, 6)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (30, 1, CAST(5400.00 AS Decimal(10, 2)), CAST(450.00 AS Decimal(10, 2)), 3, N'Prov. Tucuman Zona Norte', NULL, 6)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (31, 3, CAST(5000.00 AS Decimal(10, 2)), CAST(200.00 AS Decimal(10, 2)), NULL, N'Ingenio (compañia)', NULL, NULL)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (32, 1, CAST(6000.00 AS Decimal(10, 2)), CAST(500.00 AS Decimal(10, 2)), 1, N'Prov. Cordoba Zona Sur', NULL, 7)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (33, 1, CAST(6000.00 AS Decimal(10, 2)), CAST(450.00 AS Decimal(10, 2)), 2, N'Prov. Cordoba Zona Centro', NULL, 7)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (34, 1, CAST(6400.00 AS Decimal(10, 2)), CAST(550.00 AS Decimal(10, 2)), 3, N'Prov. Cordoba Zona Norte', NULL, 7)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (37, 1, CAST(7000.00 AS Decimal(10, 2)), CAST(650.00 AS Decimal(10, 2)), 1, N'Prov. Buenos Aires Zona Sur', NULL, 8)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (39, 1, CAST(7000.00 AS Decimal(10, 2)), CAST(650.00 AS Decimal(10, 2)), 2, N'Prov. Buenos Aires Zona Centro', NULL, 8)
INSERT [dbo].[properties] ([id_property], [id_type_property], [value], [rent_value], [id_zone], [descripcion], [id_type_upgrade], [id_province]) VALUES (40, 1, CAST(7400.00 AS Decimal(10, 2)), CAST(1000.00 AS Decimal(10, 2)), 3, N'Prov. Buenos Aires Zona Norte', NULL, 8)
GO
SET IDENTITY_INSERT [dbo].[Provinces] ON 

INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (1, N'Formosa')
INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (2, N'Rio Negro')
INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (3, N'Salta')
INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (4, N'Mendoza')
INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (5, N'Santa Fe')
INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (6, N'Tucuman')
INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (7, N'Cordoba')
INSERT [dbo].[Provinces] ([id_province], [province_name]) VALUES (8, N'Buenos Aires')
SET IDENTITY_INSERT [dbo].[Provinces] OFF
GO
INSERT [dbo].[type_boxes] ([id_type_box], [type]) VALUES (1, N'propertie')
INSERT [dbo].[type_boxes] ([id_type_box], [type]) VALUES (2, N'destiny')
INSERT [dbo].[type_boxes] ([id_type_box], [type]) VALUES (3, N'luck')
INSERT [dbo].[type_boxes] ([id_type_box], [type]) VALUES (4, N'tax')
INSERT [dbo].[type_boxes] ([id_type_box], [type]) VALUES (5, N'free')
INSERT [dbo].[type_boxes] ([id_type_box], [type]) VALUES (6, N'go to prison')
INSERT [dbo].[type_boxes] ([id_type_box], [type]) VALUES (7, N'exit')
GO
INSERT [dbo].[type_cards] ([id_type_card], [type]) VALUES (1, N'suerte')
INSERT [dbo].[type_cards] ([id_type_card], [type]) VALUES (2, N'destino')
GO
INSERT [dbo].[Type_players] ([id_type_player], [description]) VALUES (1, N'human')
INSERT [dbo].[Type_players] ([id_type_player], [description]) VALUES (2, N'bot')
GO
INSERT [dbo].[type_properties] ([id_type_property], [type_property]) VALUES (1, N'escritura')
INSERT [dbo].[type_properties] ([id_type_property], [type_property]) VALUES (2, N'ferrocarril')
INSERT [dbo].[type_properties] ([id_type_property], [type_property]) VALUES (3, N'compañia')
GO
INSERT [dbo].[Type_upgrades] ([id_type_upgrade], [type_upgrade]) VALUES (1, N'chacra')
INSERT [dbo].[Type_upgrades] ([id_type_upgrade], [type_upgrade]) VALUES (2, N'estancia')
GO
INSERT [dbo].[Zone] ([id_zone], [zone]) VALUES (1, N'zona sur')
INSERT [dbo].[Zone] ([id_zone], [zone]) VALUES (2, N'zona centro')
INSERT [dbo].[Zone] ([id_zone], [zone]) VALUES (3, N'zona norte')
GO
ALTER TABLE [dbo].[banks]  WITH CHECK ADD  CONSTRAINT [fk_bank_properties] FOREIGN KEY([id_property])
REFERENCES [dbo].[properties] ([id_property])
GO
ALTER TABLE [dbo].[banks] CHECK CONSTRAINT [fk_bank_properties]
GO
ALTER TABLE [dbo].[boards]  WITH CHECK ADD  CONSTRAINT [fk_board_box] FOREIGN KEY([id_box])
REFERENCES [dbo].[boxes] ([id_box])
GO
ALTER TABLE [dbo].[boards] CHECK CONSTRAINT [fk_board_box]
GO
ALTER TABLE [dbo].[boards]  WITH CHECK ADD  CONSTRAINT [fk_board_card] FOREIGN KEY([id_card])
REFERENCES [dbo].[cards] ([id_card])
GO
ALTER TABLE [dbo].[boards] CHECK CONSTRAINT [fk_board_card]
GO
ALTER TABLE [dbo].[boards]  WITH CHECK ADD  CONSTRAINT [fk_boards_dice] FOREIGN KEY([id_dice])
REFERENCES [dbo].[dices] ([id_dice])
GO
ALTER TABLE [dbo].[boards] CHECK CONSTRAINT [fk_boards_dice]
GO
ALTER TABLE [dbo].[boxes]  WITH CHECK ADD  CONSTRAINT [fk_boxes_pawns] FOREIGN KEY([id_pawns])
REFERENCES [dbo].[pawns] ([id_pawn])
GO
ALTER TABLE [dbo].[boxes] CHECK CONSTRAINT [fk_boxes_pawns]
GO
ALTER TABLE [dbo].[boxes]  WITH CHECK ADD  CONSTRAINT [fk_boxes_proerty] FOREIGN KEY([id_property])
REFERENCES [dbo].[properties] ([id_property])
GO
ALTER TABLE [dbo].[boxes] CHECK CONSTRAINT [fk_boxes_proerty]
GO
ALTER TABLE [dbo].[boxes]  WITH CHECK ADD  CONSTRAINT [fk_boxes_type] FOREIGN KEY([id_type_box])
REFERENCES [dbo].[type_boxes] ([id_type_box])
GO
ALTER TABLE [dbo].[boxes] CHECK CONSTRAINT [fk_boxes_type]
GO
ALTER TABLE [dbo].[cards]  WITH CHECK ADD  CONSTRAINT [fk_card_type] FOREIGN KEY([id_type_card])
REFERENCES [dbo].[type_cards] ([id_type_card])
GO
ALTER TABLE [dbo].[cards] CHECK CONSTRAINT [fk_card_type]
GO
ALTER TABLE [dbo].[matches]  WITH CHECK ADD  CONSTRAINT [fk_matches_bank] FOREIGN KEY([id_bank])
REFERENCES [dbo].[banks] ([id_bank])
GO
ALTER TABLE [dbo].[matches] CHECK CONSTRAINT [fk_matches_bank]
GO
ALTER TABLE [dbo].[matches]  WITH CHECK ADD  CONSTRAINT [fk_matches_board] FOREIGN KEY([id_board])
REFERENCES [dbo].[boards] ([id_board])
GO
ALTER TABLE [dbo].[matches] CHECK CONSTRAINT [fk_matches_board]
GO
ALTER TABLE [dbo].[matches]  WITH CHECK ADD  CONSTRAINT [fk_matches_diculties] FOREIGN KEY([id_dificulty])
REFERENCES [dbo].[dificulties] ([id_dificulty])
GO
ALTER TABLE [dbo].[matches] CHECK CONSTRAINT [fk_matches_diculties]
GO
ALTER TABLE [dbo].[matches]  WITH CHECK ADD  CONSTRAINT [fk_matches_players] FOREIGN KEY([id_player])
REFERENCES [dbo].[players] ([id_player])
GO
ALTER TABLE [dbo].[matches] CHECK CONSTRAINT [fk_matches_players]
GO
ALTER TABLE [dbo].[matches]  WITH CHECK ADD  CONSTRAINT [fk_matches_users] FOREIGN KEY([id_user])
REFERENCES [dbo].[users] ([id_user])
GO
ALTER TABLE [dbo].[matches] CHECK CONSTRAINT [fk_matches_users]
GO
ALTER TABLE [dbo].[pawns]  WITH CHECK ADD  CONSTRAINT [fk_pawn_card] FOREIGN KEY([id_card])
REFERENCES [dbo].[cards] ([id_card])
GO
ALTER TABLE [dbo].[pawns] CHECK CONSTRAINT [fk_pawn_card]
GO
ALTER TABLE [dbo].[pawns]  WITH CHECK ADD  CONSTRAINT [fk_pawn_player] FOREIGN KEY([id_player])
REFERENCES [dbo].[players] ([id_player])
GO
ALTER TABLE [dbo].[pawns] CHECK CONSTRAINT [fk_pawn_player]
GO
ALTER TABLE [dbo].[pawns]  WITH CHECK ADD  CONSTRAINT [fk_pawn_properties] FOREIGN KEY([id_property])
REFERENCES [dbo].[properties] ([id_property])
GO
ALTER TABLE [dbo].[pawns] CHECK CONSTRAINT [fk_pawn_properties]
GO
ALTER TABLE [dbo].[players]  WITH CHECK ADD  CONSTRAINT [fk_player_turn] FOREIGN KEY([id_turn])
REFERENCES [dbo].[Turns] ([id_turn])
GO
ALTER TABLE [dbo].[players] CHECK CONSTRAINT [fk_player_turn]
GO
ALTER TABLE [dbo].[players]  WITH CHECK ADD  CONSTRAINT [fk_player_type] FOREIGN KEY([id_type_player])
REFERENCES [dbo].[Type_players] ([id_type_player])
GO
ALTER TABLE [dbo].[players] CHECK CONSTRAINT [fk_player_type]
GO
ALTER TABLE [dbo].[properties]  WITH CHECK ADD  CONSTRAINT [fk_properties_provincias] FOREIGN KEY([id_province])
REFERENCES [dbo].[Provinces] ([id_province])
GO
ALTER TABLE [dbo].[properties] CHECK CONSTRAINT [fk_properties_provincias]
GO
ALTER TABLE [dbo].[properties]  WITH CHECK ADD  CONSTRAINT [fk_properties_type] FOREIGN KEY([id_type_property])
REFERENCES [dbo].[type_properties] ([id_type_property])
GO
ALTER TABLE [dbo].[properties] CHECK CONSTRAINT [fk_properties_type]
GO
ALTER TABLE [dbo].[properties]  WITH CHECK ADD  CONSTRAINT [fk_properties_upgrades] FOREIGN KEY([id_type_upgrade])
REFERENCES [dbo].[Type_upgrades] ([id_type_upgrade])
GO
ALTER TABLE [dbo].[properties] CHECK CONSTRAINT [fk_properties_upgrades]
GO
ALTER TABLE [dbo].[properties]  WITH CHECK ADD  CONSTRAINT [fk_properties_zone] FOREIGN KEY([id_zone])
REFERENCES [dbo].[Zone] ([id_zone])
GO
ALTER TABLE [dbo].[properties] CHECK CONSTRAINT [fk_properties_zone]
GO
USE [master]
GO
ALTER DATABASE [grupo_1_estanciero] SET  READ_WRITE 
GO
