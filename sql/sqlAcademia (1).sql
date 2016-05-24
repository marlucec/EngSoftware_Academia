DROP TABLE Interesse;
DROP TABLE Aluno;
DROP TABLE PlanoDesconto;
DROP TABLE TipoPlanoDesconto;
DROP TABLE Modalidade;
DROP TABLE Mensalidade;
DROP TABLE Estado;

CREATE TABLE Modalidade (
    codigo INT NOT NULL AUTO_INCREMENT, 
	nome VARCHAR(50) NOT NULL,	
	PRIMARY KEY (codigo)
) ENGINE=INNODB;

CREATE TABLE Estado (
    codigo INT NOT NULL AUTO_INCREMENT, 
	descricao VARCHAR(30) NOT NULL,	
	PRIMARY KEY (codigo)
) ENGINE=INNODB;

CREATE TABLE Aluno (
    codigo INT NOT NULL AUTO_INCREMENT, 
	matricula VARCHAR(30) NOT NULL,	
    nome VARCHAR(100) NOT NULL,		
	email VARCHAR(50) NULL,	
	cpf VARCHAR(20) NULL,	
	sexo VARCHAR(1) NULL,	
	telefone VARCHAR(25) NULL,	
	dataNascimento DATE NULL,	
	dataCadastro DATE NULL,
	estadoAluno_fk INT NOT NULL,
	FOREIGN KEY (estadoAluno_fk) 
        REFERENCES estado(codigo),
	PRIMARY KEY (codigo)
) ENGINE=INNODB;

CREATE TABLE Interesse (
    codigo INT NOT NULL AUTO_INCREMENT, 
    aluno_fk INT NOT NULL,
	modalidade_fk INT NOT NULL,
	PRIMARY KEY (codigo),
    FOREIGN KEY (aluno_fk) 
        REFERENCES aluno(codigo),
	FOREIGN KEY (modalidade_fk) 
        REFERENCES Modalidade(codigo)
) ENGINE=INNODB;

CREATE TABLE Mensalidade (
    codigo INT NOT NULL AUTO_INCREMENT, 
	valor DOUBLE NOT NULL,	
	multa DOUBLE NOT NULL,	    
	vencimento DATE NULL,	
	pagamento DATE NULL,
	PRIMARY KEY (codigo)
) ENGINE=INNODB;

CREATE TABLE TipoPlanoDesconto (
    codigo INT NOT NULL AUTO_INCREMENT, 
	nome VARCHAR(25) NOT NULL,	
	PRIMARY KEY (codigo)
) ENGINE=INNODB;

CREATE TABLE PlanoDesconto (
    codigo INT NOT NULL AUTO_INCREMENT, 
	valor DOUBLE NOT NULL,	
	tipo_fk INT NOT NULL,
	PRIMARY KEY (codigo)
) ENGINE=INNODB;

INSERT INTO Estado (descricao) VALUES ("Matriculado");
INSERT INTO Estado (descricao) VALUES ("Trancado");
INSERT INTO Estado (descricao) VALUES ("Abandonado");

INSERT INTO aluno (matricula, nome, email, cpf, sexo, telefone, dataNascimento, dataCadastro, estadoAluno_fk) VALUES ("20160505", "Katyelen", "katyelenjf@gmail.com", "08950752611", "F", "32 98829-3197", "1987-08-20", "2016-05-10", 1);
INSERT INTO aluno (matricula, nome, email, cpf, sexo, telefone, dataNascimento, dataCadastro, estadoAluno_fk) VALUES ("20160506", "Elena", "e@gmail.com", "", "F", "32 ", null, "2016-05-10", 1);
INSERT INTO aluno (matricula, nome, email, cpf, sexo, telefone, dataNascimento, dataCadastro, estadoAluno_fk) VALUES ("20160507", "Marluce", "m@gmail.com", "", "F", "32 ", null, "2016-05-10", 1);

INSERT INTO Modalidade (nome) VALUES ("Dança");
INSERT INTO Modalidade (nome) VALUES ("Kangoo");
INSERT INTO Modalidade (nome) VALUES ("Spinning");

INSERT INTO TipoPlanoDesconto (nome) VALUES ("Basico");
INSERT INTO TipoPlanoDesconto (nome) VALUES ("Trimestral");
INSERT INTO TipoPlanoDesconto (nome) VALUES ("Diamante");

INSERT INTO PlanoDesconto (valor, tipo_fk) VALUES (100, (select codigo from TipoPlanoDesconto where nome = "Basico"));
INSERT INTO PlanoDesconto (valor, tipo_fk) VALUES (80, (select codigo from TipoPlanoDesconto where nome = "Trimestral"));
INSERT INTO PlanoDesconto (valor, tipo_fk) VALUES (150, (select codigo from TipoPlanoDesconto where nome = "Diamante"));

INSERT INTO interesse (aluno_fk, modalidade_fk) VALUES (
	(select codigo from aluno where matricula = "20160505"), 
	(select codigo from Modalidade where nome = "Dança"));
	
INSERT INTO interesse (aluno_fk, modalidade_fk) VALUES (
	(select codigo from aluno where matricula = "20160505"), 
	(select codigo from Modalidade where nome = "Kangoo"));
	
INSERT INTO interesse (aluno_fk, modalidade_fk) VALUES (
	(select codigo from aluno where matricula = "20160506"), 
	(select codigo from Modalidade where nome = "Spinning"));	

INSERT INTO interesse (aluno_fk, modalidade_fk) VALUES (
	(select codigo from aluno where matricula = "20160507"), 
	(select codigo from Modalidade where nome = "Kangoo"));