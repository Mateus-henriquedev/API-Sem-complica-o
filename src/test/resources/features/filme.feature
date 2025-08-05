#language: pt
@filme
Funcionalidade: CRUD de filme

  Contexto:
    Dado que tenha realizado o login com dados validos
    E que tenha um payload da API de Filme

  @cadastroFilme
  Cenario: Cadastro Filme
    Quando realizo uma requisicao do tipo POST de Filme
    Entao valido que recebo status 201 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
    E armazeno o id que recebo no response de Filme

  @consultaFilme
  Cenario: Consulta Filme
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"

  @alteraFilme
  Cenario: Altercao Filme
    E altero o indice 0 da lista de categorias de filme com os valores
      | tipo | Comedia |
    E altero o indice 1 da lista de categorias de filme com os valores
      | tipo | Terror |
    Quando realizo uma requisicao do tipo PUT de Filme
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Terror"
    E valido que no campo "categorias.tipo[0]" possui o valor "Comedia"

  @excluiFilme
  Cenario: Exclusao Filme
    Quando realizo uma requisicao do tipo Delete de Fillme
    Entao valido que recebo status 200 no response

  @consultaFilmePosExclusao
  Cenario: Consulta Filme apos Exclusao
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que recebo uma lista vazia