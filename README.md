# SGCP - Sistema de Gestão de Contratações Públicas

Os princípios que regem os atos da administração pública são legalidade, impessoalidade, moralidade, eficiência e **publicidade**.

A exigência de licitação nas contratações públicas é feita pela Carta Magna, sendo regulamentada pela Lei nº 8.666/93. O artigo 3º dessa legislação destaca a importante função da licitação ao conferir isonomia de tratamento entre os candidatos, conferindo a impessoalidade necessária para que se eleja a proposta que melhor atenda aos interesses públicos, independente do proponente. A licitação garante, portanto, o respeito aos “[...] princípios básicos da legalidade, da impessoalidade, da moralidade, da igualdade, da publicidade, da probidade administrativa, da vinculação ao instrumento convocatório, do julgamento objetivo e dos que lhes são correlatos”.

Nota-se que, tanto na disposição constitucional, quanto no artigo 3º da Lei nº 8.666/93, há a preocupação em conferir publicidade às contratações públicas, de modo que se possa controlar os atos administrativos. Importante destacar a necessidade de publicidade e transparência dos atos da administração pública, até mesmo como pressuposto para lhes conferir legitimidade, bem como manter a moralidade administrativa em relação a essas contratações. 

:heavy_check_mark: Esse projeto surgiu a partir da dificuldade de obtenção de informações simples sobre as contratações de qualquer órgão público. Esses dados são públicos, porém disponibilizados de forma não estruturada no Diário Oficial da União - DOU.

:heavy_check_mark: O objetivo desse projeto é permitir a fiscalização pela sociedade das contratações públicas, desde a licitação até os pagamentos dos contratos por meio da disponibilização de dados para a geração de informações e conhecimento a respeito das licitações e contratações de determinado órgão público.

:heavy_check_mark: O público alvo desse sistema são os servidores do próprio órgão publico e a população em geral. Os servidores terão à sua disposição uma ferramenta para auxiliá-los na fiscalização das contratações, enquanto que a sociedade poderá acompanhar em um único portal todas as contratações por meio dos seus editais, valores, contratos e pagamentos.

As principais informações a serem disponibilizadas por meio de relatórios e API's são:

* Relação de editais abertos por intervalo de tempo
* Busca de contratos por objeto, número, intervalo de datas ou intervalo de valor
* Detalhes de uma licitação (Número, Objeto, Data de abertura, Histórico do andamento, Grupos, Itens, Vencedor, Contrato, Valor total, Pagamentos, Fiscais)
* Relação de contratos de uma determinada empresa com um órgão público
* Relação de pagamentos de cada contrato
* Relação de contratos fiscalizados por determinado servidor
* Relação de contratos que estão próximos ao vencimento (6 meses)
* Restos a pagar de um contrato

:point_right: A execução de um contrato é sempre acompanhada e fiscalizada por 1 (um) ou mais fiscais do contrato, representantes da Administração especialmente designados conforme requisitos estabelecidos no art. 7º desta Lei, ou pelos respectivos substitutos, cf. Art. 117. da Lei 8.112.

:point_right: Preposto é o representante do contratado na execução do contrato, cf. Art. 118 da Lei 8.112.

:point_right: O objeto do contrato será recebido definitivamente, por servidor ou comissão designada pela autoridade competente, mediante termo detalhado que comprove o atendimento das exigências contratuais, cf. Art. 140 da Lei 8.112.

As principais tecnologias utilizadas no desenvolvimento são

- JavaScript
- Maven
- Java
- Spring Boot
- JPA
- Swagger
- Thymeleaf
- MySQL

<!---
Um levantamento inicial de requisitos originou o seguinte diagrama de classes:

![Diagrama de Classes](./src/main/resources/static/img/sgcp-diagrama_de_classes.png)
-->

:warning: Tendo em vista o tamanho e a complexidade do projeto, bem como a possibilidade de dividi-lo em partes íntegras que tenham valor por si só, optou-se então pela divisão em dois projetos que posteriormente serão integrados. 

A primeira parte cuidará da execução e ficalização do contrato

A segunda parte cuidará da licitação e da formalização do contrato

O Diagrama de Entidades e Relacionamentos da primeira fase:

![DER](./src/main/resources/static/img/210630-sgcp-diagrama_entidades_relacionamentos.png)

Os endpoints para listar, incluir, excluir, alterar e detalhar contratos podem ser
conferidos e testados pelo [Swagger](http://localhost:8080/swagger-ui.html#/contrato-rest-controller)


