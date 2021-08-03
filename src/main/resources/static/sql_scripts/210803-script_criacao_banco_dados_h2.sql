/*==============================================================*/
/* DBMS name:      H2                                           */
/* Created on: 2021-08-02                                       */
/*==============================================================*/


drop table if exists contrato;

drop table if exists dados_pessoais;

drop table if exists fiscalizacao;

drop table if exists pagamento;

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
   valor                double not null,
   processo_contratacao varchar(15) not null,
   inteiro_teor         varchar(255),
   primary key (numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: vigencia                                              */
/*==============================================================*/
create table vigencia
(
   id_vigencia          identity not null,
   numero_contrato      int not null,
   ano_contrato         int not null,
   data_inicio          date not null,
   data_fim             date,
   portaria             varchar(255),
   primary key (id_vigencia)
);

/*==============================================================*/
/* Table: dados_pessoais                                        */
/*==============================================================*/
create table dados_pessoais
(
   cpf                  varchar(11) not null,
   nome                 varchar(255),
   data_nascimento      date,
   email                varchar(255),
   primary key (cpf)
);

/*==============================================================*/
/* Table: telefone                                              */
/*==============================================================*/
create table telefone
(
   id_telefone          identity not null,
   cpf                  varchar(11) not null,
   ddi                  varchar(3),
   ddd                  varchar(3),
   numero               varchar(10) not null,
   primary key (id_telefone)
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
/* Table: fiscalizacao                                          */
/*==============================================================*/
create table fiscalizacao
(
   matricula            varchar(6) not null,
   numero_contrato      int not null,
   ano_contrato         int not null,
   id_tipo_fiscal       int not null,
   data_inicio          date not null,
   portaria_inicio      varchar(255),
   data_fim             date,
   portaria_fim         varchar(255),
   primary key (matricula, numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: pagamento                                             */
/*==============================================================*/
create table pagamento
(
   id_pagamento         identity not null,
   matricula            varchar(6) not null,
   numero_contrato      int not null,
   ano_contrato         int not null,
   valor_pagamento      double not null,
   nota_fiscal          blob,
   data_recebimento_definitivo date,
   termo_recebimento_definitivo varchar(255),
   processo_pagamento   varchar(15),
   data_pagamento       date not null,
   ordem_bancaria       blob,
   primary key (id_pagamento)
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
/* Table: tipo_fiscal                                           */
/*==============================================================*/
create table tipo_fiscal
(
   id_tipo_fiscal       int not null,
   descricao            varchar(255),
   primary key (id_tipo_fiscal)
);


alter table fiscalizacao add constraint fk_reference_12 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;

alter table fiscalizacao add constraint fk_reference_14 foreign key (id_tipo_fiscal)
      references tipo_fiscal (id_tipo_fiscal) on delete restrict on update restrict;

alter table fiscalizacao add constraint fk_reference_3 foreign key (matricula)
      references servidor (matricula) on delete restrict on update restrict;

alter table pagamento add constraint fk_reference_10 foreign key (matricula)
      references servidor (matricula) on delete restrict on update restrict;

alter table pagamento add constraint fk_reference_11 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;

alter table preposto add constraint fk_reference_6 foreign key (cpf)
      references dados_pessoais (cpf) on delete restrict on update restrict;

alter table preposto add constraint fk_reference_7 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;

alter table servidor add constraint fk_reference_9 foreign key (cpf)
      references dados_pessoais (cpf) on delete restrict on update restrict;

alter table telefone add constraint fk_reference_8 foreign key (cpf)
      references dados_pessoais (cpf) on delete restrict on update restrict;

alter table vigencia add constraint fk_reference_13 foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato) on delete restrict on update restrict;

