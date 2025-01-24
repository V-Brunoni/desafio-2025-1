# Desafio TI DEV UNOESC 2025/1
CORRESPONDENTE AO EDITAL N. 79/UNOESC-R/2024

Desafio Programador Fullstack Unoesc

Este é o nosso desafio para a vaga de programador Fullstack na Unoesc. Serão testadas as habilidades e qualidade de código ao transformar requisitos limitados em uma aplicação web.

*FAÇA O FORK DESTE REPOSITÓRIO E IMPLEMENTE O DESAFIO. MANTENHA PÚBLICO, POIS QUEREMOS ACOMPANHAR SEUS COMMITS*

Ao concluir o desafio, lembre de enviar um email para recrutamentorh.jba@unoesc.edu.br, ti.coord@unoesc.edu.br e ti.dev@unoesc.edu.br, com seu repositório. Lembre de incluir a documentação para que possamos rodar sua aplicação.

## TECNOLOGIAS OBRIGATÓRIAS
* O escopo de linguagem é aberto, mas a utilização da Orientação a Objetos é um importante critério para a avaliação.
* MySQL 5.7.X+ OU Postgress;
* GIT;

## AVALIAÇÃO
O código será avaliado de acordo com os seguinte critérios:

* Documentação do processo necessário para rodar a aplicação;
* Estrutura do projeto;
* Histórico do GIT;
* Build e execução da aplicação;
* Completude das funcionalidades;
* Qualidade de código (design pattern, manutenibilidade, clareza);
* Boas práticas de UI (Interface com o Usuário);
* Sentido e coerência nas respostas aos questionamentos na entrevista de apresentação do desafio realizada pelo candidato.
OBS: Plágios tendem a ser desclassificados. Atenção com o uso excessivo de IA.

**Estamos buscando desenvolvedores que topam desafios, então mesmo não cumprindo todo os requisitos, seu esforço será reconhecido.**

## DESAFIO
Você terá que desenvolver uma aplicação web responsável por fazer a gestão de cursos. 
Professores associados a um Curso poderão realizar a manutenção de Notas e Frequência de Estudantes devidamente matriculados.
Estudantes associados a um Curso poderão verificar as Notas e Frequência lançadas, separadas por Curso.
Você pode criar um usuario padrão/admin para realizar os cadastros-base.
Todas as Pessoas cadastradas, sejam Estudantes ou Professores, devem ter usuário e senha próprios para realizar login em seus respectivos portais.
Perfis de usuários desejados:
* Professor: Pode lecionar em vários cursos. Pode dar notas e presenças à Alunos que estejam em cursos os quais leciona.
* Estudante: Pode matricular-se em vários cursos. Pode ver notas e presenças lançadas em seus cursos.

Relatórios não são obrigatórios, mas a presença dos mesmos tende a melhorar sua avaliação.

Se aplicar melhorias não previstas no desafio, favor destacá-las.

Em caso de dúvidas quanto a interpretação, você pode entrar em contato pelo email ti.dev@unoesc.edu.br.

## ESCOPO DO DESAFIO

**_Entidade PESSOA_**

Deverá ter as seguintes informações preenchidas MANUALMENTE pelo usuário:
* "id" - int
* "cpf" - String
* "ativo" - boolean
* "usuario" - String
* "senha" - String

Deverá possuir as seguintes informações VINDAS DA API **https://randomuser.me/api/**:
* "nome" - String (valores dos campos "first" + "last" vindos da api)
* "email" - String (valor do campo "email" vindo da api)
* "telefone" - String (valor do campo "phone" vindo da api)

**_Entidade PESSOA_ENDERECO_**
* "id" - int
* "pessoa" - Relacionamento com a classe Pessoa
* "cidade" - String
* "cep" - String
* "rua" - String
* "numero" - int

**_Entidade ESTUDANTE_CURSO_**
* "id" - int
* "estudante" - Relacionamento com a classe Pessoa
* "curso" - Relacionamento com a classe Curso

**_Entidade PROFESSOR_CURSO_**
* "id" - int
* "professor" - Relacionamento com a classe Pessoa
* "curso" - Relacionamento com a classe Curso

**_Entidade CURSO_**
* "id" - int
* "nome" - String
* "assunto" - String
* "encontros" - int

**_Entidade CURSO_NOTA_**
* "id" - int
* "curso" - Relacionamento com a classe Curso
* "estudante" - Relacionamento com a classe EstudanteCurso

**_Entidade CURSO_PRESENCA_**
* "id" - int
* "curso" - Relacionamento com a classe Curso
* "estudante" - Relacionamento com a classe EstudanteCurso
  
Para auxíliar na construção, um modelo resumido.
![image](https://github.com/user-attachments/assets/f7074aab-d03e-46a4-999e-460732a2de7e)


**Regras de Negócio**
1. Ao adicionar uma nova **PESSOA**, o usuário deverá informar os parâmetros manuais. Ao persistir o registro, as demais informações supracitadas deverão ser consultadas e salvas à partir dos dados da API, conforme orientação anterior.
2. No caso de edição de uma **PESSOA**, o usuário deve ser liberado para alterar os dados livremente.
3. Deve possibilitar o relacionamento entre **PESSOA** e UM **PESSOA_ENCERECO**
4. Deve possibilitar o relacionamento de **PESSOA** com VÁRIOS **CURSO** (**ESTUDANTE_CURSO**)
5. Apenas deve realizar a associação anterior, se o **CURSO.status** for igual a 'ATIVO'.
6. Deve possibilitar o relacionamento de **PESSOA** com VÁRIOS **CURSO** (**PROFESSOR_CURSO**)
7. Apenas deve realizar a associação anterior, se o **CURSO.status** for igual a 'ATIVO'.
8. Uma **PESSOA** associada a um **CURSO** como Professor (**PROFESSOR_CURSO**), deve poder lançar VÁRIOS registros de **CURSO_NOTA** para um mesmo **ESTUDANTE_CURSO**
9. Uma **PESSOA** associada a um **CURSO** como Professor (**PROFESSOR_CURSO**), deve poder lançar VÁRIOS registros de **CURSO_PRESENCA** para um mesmo **ESTUDANTE_CURSO**
10. O número de **CURSO_PRESENCA**, para cada **ESTUDANTE_CURSO** não pode ser MAIOR que o valor de **CURSO.encontros**
11. Deve ser possível excluir registros de **CURSO_NOTA** e **CURSO_PRESENCA** APENAS enquanto **CURSO.status** for igual a 'ATIVO'
12. Não deve ser possível excluir qualquer registro que possua qualquer associação.
13. Não deve ser possível inserir qualquer registro idêntico a outro já existente (desconsiderando seu id).
14. O sistema deverá permitir buscar todos os **ESTUDANTE_CURSO** armazenados em sua base, filtrando por **PESSOA.nome** ou **CURSO.nome**. Apresentar os dados de **PESSOA** e **CURSO* dos respectivos registros em lista, de maneira organizada.
15. Todos os campos que necessitem de máscara, devem a ter implementada.
16. A aplicação deve ser protegida por um login, considerando os perfis citados.

