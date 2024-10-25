## The Book Club - API

### [The Book Club](http://localhost:8081) - O link está como provisório.

#### O projeto é exclusivamente para [DBServer](https://db.tec.br/).

---

### Ferramentas que foi utilizado?
#### Construido com a estrutura:
:pushpin: [MAVEN](https://maven.apache.org/download.cgi),

:pushpin: [JAVA 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

#### Dependências:
:pushpin: [TestNG](https://mvnrepository.com/artifact/org.testng/testng/7.10.2),

:pushpin: [Rest Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.5.0),

:pushpin: [Allure TestNG](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng/2.29.0),

:pushpin: [Allure Maven](https://mvnrepository.com/artifact/io.qameta.allure/allure-maven/2.14.0),

:pushpin: [Json Schema validator](https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator/5.5.0),

:pushpin: [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.34)

:pushpin: [Hamcrest](https://mvnrepository.com/artifact/org.hamcrest/hamcrest/3.0)

:pushpin: [Java Faker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker/1.0.2)

---
###  Pré-requisitos:
Antes de começar, é necessária a instalar MAVEN em sua máquina as seguintes ferramentas:
- [Git bash](https://git-scm.com).

Como instalando Maven no Windows, fazer a seguinte:
- Primeiro tem que baixar o [Maven version](https://maven.apache.org/download.cgi) versão mais recente.
- Seguir o instrução [Maven install](http://charlesmms.azurewebsites.net/2017/09/04/instalando-maven-no-windows-10/#:~:text=Instalando%20o%20Maven,Program%20Files%5CApache%5Cmaven.)

Agora é Allure, como fazer a instalar e segue passo a passo baixo:
```bash
- Abrir PowerShell do windows, segue o comando:
	`Set-ExecutionPolicy RemoteSigned -Scope CurrentUser`. 

- Vai aparecer alguns opções sim ou nao: 
        [S] 'SIM de portugues' ou [Y] 'YES de ingles'

- Seguida comando:
	iex (new-object net.webclient).downloadstring('https://get.scoop.sh') 
	e realizado instalação.

- Deve instalar os programas `OPENSSH e GIT`, segue PowerShell, o comando: 
	`scoop install openssh`
	depois comando: `scoop install git` 
	apos de instalado de 'scoop install git'  
	se for aparecer "WARN git (version) is already installed."
	segue o comando: 'scoop update git' para atualizar o `git`.

- E utlimo: 
	`scoop install allure`
	
- Quando após execução do projeto:
	abrir a pasta do projeto e botão direita abrir de "git bash".
	comando: `allure serve allure-results`
```
---
#### Baixando o projeto:

Para baixar o projeto, abrir o comando ou dentro IDE:
```bash
git clone https://github.com/TheBookClubDB/TheBookClub-Back/tree/test-api
```
#### Como executar?
Para executar na sua máquina local, o comando ou através de sua IDE:
```bash
mvn clean
```
```bash
mvn test
```
---
#### Screenshot Allure Report:

---
### Postman  :rocket:

- **URL:**

``` 
http://localhost:8081/autor/registro - LocalHost
https://the-book-club-back.onrender.com/autor/registro - Render 
```

### Headers:

- **Key:** Content-Type

- **Value:** application/json

### Body:
- marcação: **raw**
- opção: **JSON**

```json
body:

{
  "nome": "Teste",
  "nascimento": "1973-10-20",
  "genero":"MASCULINO"
}
```

### HTTP Métodos e Status:
:rocket: [What are Http methods?](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods)

:rocket: [HTTP response status code](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

---
*Funciona na minha máquina* :coffee: :rocket:
