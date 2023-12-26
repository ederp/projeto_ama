-- Tabela de Usuários
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'ESTOQUISTA') NOT NULL
);

-- Tabela de Categorias
CREATE TABLE categorias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    ativo BOOLEAN NOT NULL,
    tipo ENUM('NORMAL', 'ESPECIAL', 'PERSONALIZADO') NOT NULL
);

-- Tabela de Produtos
CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL,
    sku VARCHAR(50) NOT NULL,
    categoria_id INT,
    valor_custo DECIMAL(10, 2) NOT NULL,
    icms DECIMAL(5, 2) NOT NULL,
    valor_venda DECIMAL(10, 2) NOT NULL,
    imagem VARCHAR(255),
    data_cadastro DATE NOT NULL,
    quantidade_estoque INT NOT NULL,
    usuario_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela de Refresh Tokens
CREATE TABLE refreshtoken(
	id INT PRIMARY KEY AUTO_INCREMENT,
	usuario_id INT NOT NULL,
	token VARCHAR(255) NOT NULL,
	expiryDate DATE NOT NULL,
	FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela de auditoria
CREATE TABLE auditoria(
	id INT PRIMARY KEY AUTO_INCREMENT,
	tabela VARCHAR(255) NOT NULL,
	operacao VARCHAR(255) NOT NULL,
	campo VARCHAR(255),
	valor_anterior VARCHAR(255),
	valor_atual VARCHAR(255),
	data_hora DATE NOT NULL,
	nome_usuario VARCHAR(255) NOT NULL
);
