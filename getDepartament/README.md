#API REST com JAVA  e Spring Boot

- Fazer uma API Rest que disponibilize um endpoint que se possa obter uma lista com suas categorias. As instâncias desses objetos poderam 
ser por Hard Code.

#MODELO DE DOMINIO: 

##(Diagrama de Classes)

-Departamento deverá ter os atributos id e nome;
-Produtos deverá ter os atributos id, nome e preço;

O Resultado esperado deverá ser via metodo GET e o texto devolvido em json.


# STEP BY STEP:

- Acessar o spring initializr para criar o projeto. https://start.spring.io/

- Usar a dependencia do Spring Web neste configuração.

- Importar o projeto na IDE

- Após a IDE atualizar toda a configuração de bibliotecas para o projeto, criar as classes no pacote entidades.

- Criar os pacotes entities e controller.

- Criar as classes com os atributos encapsulados, e os Getters e setters.

- Criar um construtor sem parametros e outro com parametros.

- Na classe do controller que disponibilizara o endpoint, deverá ter as anotation para configurar os recursos: 

	@RestController
	@RequestMapping (value = "/nome_do_endpoint")

- Criar os metodos na classe controller para implementar os objetos, e neste fazer uso da anotation @GetMapping.










