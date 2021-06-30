/*==============================================================*/
/* DBMS name:      MySQL                                        */
/* Created on:     29/06/2021 18:58:24                          */
/*==============================================================*/


drop table if exists contrato;

drop table if exists fiscalizacao;

drop table if exists pagamento;

drop table if exists pessoa;

drop table if exists preposto;

drop table if exists servidor;

drop table if exists telefone;

drop table if exists tipo_fiscal;

drop table if exists vigencia;

/*==============================================================*/
/* Table: contrato                                              */
/*==============================================================*/
create table contrato
(
   numero_contrato      int not null,
   ano_contrato         int not null,
   objeto               text not null,
   data_assinatura      date not null,
   valor                float(0) not null,
   processo_contratacao varchar(0) not null,
   inteiro_teor         blob,
   primary key (numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: fiscalizacao                                          */
/*==============================================================*/
create table fiscalizacao
(
   matricula            varchar(6) not null,
   numero_contrato      int not null,
   ano_contrato         int not null,
   id_tipo_fiscal       int not null,
   data_inicio          date not null,
   portaria_inicio      blob,
   data_fim             date,
   portaria_fim         blob,
   primary key (matricula, numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: pagamento                                             */
/*==============================================================*/
create table pagamento
(
   id_pagamento         int not null,
   matricula            varchar(6) not null,
   numero_contrato      int not null,
   ano_contrato         int not null,
   nota_fiscal          blob,
   data_recebimento_definitivo date,
   termo_recebimento_definitivo blob,
   processo_pagamento   varchar(0),
   data_pagamento       date,
   ordem_bancaria       blob,
   primary key (id_pagamento)
);

/*==============================================================*/
/* Table: pessoa                                                */
/*==============================================================*/
create table pessoa
(
   cpf                  varchar(11) not null,
   nome                 varchar(255),
   data_nascimento      date,
   email                varchar(255),
   primary key (cpf)
);

/*==============================================================*/
/* Table: preposto                                              */
/*==============================================================*/
create table preposto
(
   cpf                  varchar(11) not null,
   numero_contrato      int not null,
   ano_contrato         int not null,
   primary key (cpf, numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: servidor                                              */
/*==============================================================*/
create table servidor
(
   matricula            varchar(6) not null,
   cpf                  varchar(11) not null,
   primary key (matricula)
);

/*==============================================================*/
/* Table: telefone                                              */
/*==============================================================*/
create table telefone
(
   id_telefone          int not null,
   cpf                  varchar(11) not null,
   ddi                  varchar(3),
   ddd                  varchar(3),
   numero               varchar(10) not null,
   primary key (id_telefone)
);

/*==============================================================*/
/* Table: tipo_fiscal                                           */
/*==============================================================*/
create table tipo_fiscal
(
   id_tipo_fiscal       int not null,
   descricao            varchar(0),
   primary key (id_tipo_fiscal)
);

/*==============================================================*/
/* Table: vigencia                                              */
/*==============================================================*/
create table vigencia
(
   id_vigencia          int not null,
   numero_contrato      int not null,
   ano_contrato         int not null,
   data_inicio          date not null,
   data_fim             date not null,
   portaria             blob,
   primary key (id_vigencia)
);

alter table fiscalizacao add constraint FK_reference_12 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;

alter table fiscalizacao add constraint FK_reference_14 foreign key (id_tipo_fiscal)
      references tipo_fiscal (id_tipo_fiscal) on delete restrict on update restrict;

alter table fiscalizacao add constraint FK_reference_3 foreign key (matricula)
      references servidor (matricula) on delete restrict on update restrict;

alter table pagamento add constraint FK_reference_10 foreign key (matricula)
      references servidor (matricula) on delete restrict on update restrict;

alter table pagamento add constraint FK_reference_11 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;

alter table preposto add constraint FK_reference_6 foreign key (cpf)
      references pessoa (cpf) on delete restrict on update restrict;

alter table preposto add constraint FK_reference_7 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;

alter table servidor add constraint FK_reference_9 foreign key (cpf)
      references pessoa (cpf) on delete restrict on update restrict;

alter table telefone add constraint FK_reference_8 foreign key (cpf)
      references pessoa (cpf) on delete restrict on update restrict;

alter table vigencia add constraint FK_reference_13 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;



--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES ('','Dr. Chaim Blick','2011-01-29','adams.andres@example.org'),('1','Santiago Upton','1994-06-07','jking@example.org'),('2445805','Elsa Cassin','1982-12-25','prudence40@example.com'),('29','Prof. Wilford Koss','1986-09-09','annie96@example.com'),('3','Clyde Kerluke','2009-03-28','hbednar@example.org'),('362583','Mattie Thiel','2013-07-16','schneider.irving@example.com'),('377296266','Prof. Laverna Zboncak','2018-01-19','imogene12@example.net'),('389853329','Oswaldo Marks','2017-08-15','glen.braun@example.org'),('4','Prof. Olin Tremblay','1978-05-20','irwin47@example.org'),('42118588','Prof. Ricky Stroman','2017-12-23','john90@example.net'),('46738','Faustino O\'Conner','1989-04-04','max33@example.org'),('57448','Ashlee Sporer','1977-11-03','lemke.jessie@example.com'),('663355','Florine Williamson','1978-01-11','goyette.nettie@example.org'),('6815528','Alivia Yundt','2014-09-03','maye93@example.com'),('706','Marcos Smitham','1987-03-03','kertzmann.kristian@example.net'),('75','Eladio Keeling','2014-06-05','nikko94@example.org'),('7505124','Mrs. Lavinia Pfeffer I','1971-04-26','mariane.lesch@example.org'),('7591','Ruben Jaskolski','2005-01-17','lowe.clementine@example.net'),('786','Ofelia Barrows','2019-09-21','belle40@example.com'),('9835','Prof. Deangelo Heathcote','1979-06-16','krista.wilderman@example.net');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
