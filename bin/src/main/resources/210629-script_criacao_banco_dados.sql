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
   nome                 varchar(0),
   data_nascimento      date,
   email                varchar(0),
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

