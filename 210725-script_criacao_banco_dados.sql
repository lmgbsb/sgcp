/*==============================================================*/
/* DBMS name:      PostgreSQL                                   */
/* Created on:     25/07/2021 21:07:04                          */
/*==============================================================*/


drop table contrato;

drop table dados_pessoais;

drop table fiscalizacao;

drop table pagamento;

drop table preposto;

drop table servidor;

drop table telefone;

drop table tipo_fiscal;

drop table vigencia;

/*==============================================================*/
/* Table: contrato                                              */
/*==============================================================*/
create table contrato (
   numero_contrato      int4                 not null,
   ano_contrato         int4                 not null,
   objeto               text                 not null,
   data_assinatura      date                 not null,
   valor                numeric              not null,
   processo_contratacao varchar(15)          not null,
   inteiro_teor         char                 null,
   constraint pk_contrato primary key (numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: dados_pessoais                                        */
/*==============================================================*/
create table dados_pessoais (
   cpf                  varchar(11)          not null,
   nome                 varchar(255)         not null,
   data_nascimento      date                 not null,
   email                varchar(255)         null,
   constraint pk_dados_pessoais primary key (cpf)
);

/*==============================================================*/
/* Table: fiscalizacao                                          */
/*==============================================================*/
create table fiscalizacao (
   matricula            varchar(6)           not null,
   numero_contrato      int4                 not null,
   ano_contrato         int4                 not null,
   id_tipo_fiscal       int4                 not null,
   data_inicio          date                 not null,
   portaria_inicio      varchar(15)          null,
   data_fim             date                 null,
   portaria_fim         varchar(15)          null,
   constraint pk_fiscalizacao primary key (matricula, numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: pagamento                                             */
/*==============================================================*/
create table pagamento (
   id_pagamento         serial               not null,
   matricula            varchar(6)           not null,
   numero_contrato      int4                 not null,
   ano_contrato         int4                 not null,
   valor_pagamento      numeric              not null,
   nota_fiscal          varchar(255)         null,
   data_recebimento_definitivo date          not null,
   termo_recebimento_definitivo char         null,
   processo_pagamento   varchar(15)          null,
   data_pagamento       date                 not null,
   ordem_bancaria       varchar(255)         null,
   constraint pk_pagamento primary key (id_pagamento)
);

/*==============================================================*/
/* Table: preposto                                              */
/*==============================================================*/
create table preposto (
   cpf                  varchar(11)          not null,
   numero_contrato      int4                 not null,
   ano_contrato         int4                 not null,
   constraint pk_preposto primary key (cpf, numero_contrato, ano_contrato)
);

/*==============================================================*/
/* Table: servidor                                              */
/*==============================================================*/
create table servidor (
   matricula            varchar(6)           not null,
   cpf                  varchar(11)          not null,
   constraint pk_servidor primary key (matricula)
);

/*==============================================================*/
/* Table: telefone                                              */
/*==============================================================*/
create table telefone (
   id_telefone          serial               not null,
   cpf                  varchar(11)          not null,
   ddi                  int4                 null,
   ddd                  int4                 null,
   numero               int8                 not null,
   constraint pk_telefone primary key (id_telefone)
);

/*==============================================================*/
/* Table: tipo_fiscal                                           */
/*==============================================================*/
create table tipo_fiscal (
   id_tipo_fiscal       serial               not null,
   descricao            varchar(255)         null,
   constraint pk_tipo_fiscal primary key (id_tipo_fiscal)
);

/*==============================================================*/
/* Table: vigencia                                              */
/*==============================================================*/
create table vigencia (
   id_vigencia          serial               not null,
   numero_contrato      int4                 not null,
   ano_contrato         int4                 not null,
   data_inicio          date                 not null,
   data_fim             date                 not null,
   portaria             varchar(15)          null,
   constraint pk_vigencia primary key (id_vigencia)
);

alter table fiscalizacao
   add constraint fk_fiscaliz_reference_contrato foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato)
      on delete restrict on update restrict;

alter table fiscalizacao
   add constraint fk_fiscaliz_reference_tipo_fis foreign key (id_tipo_fiscal)
      references tipo_fiscal (id_tipo_fiscal)
      on delete restrict on update restrict;

alter table fiscalizacao
   add constraint fk_fiscaliz_reference_servidor foreign key (matricula)
      references servidor (matricula)
      on delete restrict on update restrict;

alter table pagamento
   add constraint fk_pagament_reference_servidor foreign key (matricula)
      references servidor (matricula)
      on delete restrict on update restrict;

alter table pagamento
   add constraint fk_pagament_reference_contrato foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato)
      on delete restrict on update restrict;

alter table preposto
   add constraint fk_preposto_reference_dados_pe foreign key (cpf)
      references dados_pessoais (cpf)
      on delete restrict on update restrict;

alter table preposto
   add constraint fk_preposto_reference_contrato foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato)
      on delete restrict on update restrict;

alter table servidor
   add constraint fk_servidor_reference_dados_pe foreign key (cpf)
      references dados_pessoais (cpf)
      on delete restrict on update restrict;

alter table telefone
   add constraint fk_telefone_reference_dados_pe foreign key (cpf)
      references dados_pessoais (cpf)
      on delete restrict on update restrict;

alter table vigencia
   add constraint fk_vigencia_reference_contrato foreign key (numero_contrato, ano_contrato)
      references contrato (numero_contrato, ano_contrato)
      on delete restrict on update restrict;

