#language:pt
@categoria
Funcionalidade: Consulta Categoria

  Cenario: Realizar consulta com sucesso
    Dado que tenha realizado o login com dados validos
    E que tenha um payload da API de Categoria
    Quando realizo uma requisicao do tipo GET
    Entao valido que recebo status 200 no response
    E valido que no campo "tipo[2]" possui o valor "Terror"

  Cenario: Realizar Consulta Categoria sem o token
    Quando realizo uma requisicao do tipo GET
    Entao valido que recebo status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"

  Cenario: Realizar Consulta Categoria com token invalido
    Quando altero o campo "Authorization" do header de categorias com o valor "invalido"
    E realizo uma requisicao do tipo GET
    Entao valido que recebo status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"

  Cenario: Verificar o primeiro e ultimo indice
    Dado que tenha realizado o login com dados validos
    E que tenha um payload da API de Categoria
    Quando realizo uma requisicao do tipo GET
    Entao valido que recebo status 200 no response
    E valido que no campo "tipo[0]" possui o valor "Aventura"
    E valido que no campo "tipo[7]" possui o valor "Thriller"