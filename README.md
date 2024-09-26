# TheBookClub-Back 📖

Uma breve descrição do projeto.

## Pré-requisitos

Antes de começar, você precisará ter instalado:

- **Java JDK 17**: Certifique-se de que o JDK 17 está instalado em sua máquina. Você pode baixá-lo [aqui](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) ou utilizar uma versão OpenJDK.
- **Gradle**: O Gradle é usado para gerenciar dependências e executar o projeto. Você pode baixá-lo [aqui](https://gradle.org/install/).
- **Docker**: Para executar o PostgreSQL e o SonarQube, você precisará do Docker instalado. Siga as instruções [aqui](https://docs.docker.com/get-docker/).

## Configuração do Ambiente

  1. **Clone o repositório**

    ```bash
     git clone https://github.com/TheBookClubDB/TheBookClub-Back.git
     cd TheBookClub-Back

2. **Configuração do Docker**

  - Crie um arquivo **.env** na raiz do projeto com as seguintes variáveis de ambiente:

    ```bash
    DB_URL=postgres://{USER}:{PASSWORD}@localhost:5432/{DB}
    POSTGRES_DB=seu_banco
    POSTGRES_USER=seu_usuario
    POSTGRES_PASSWORD=sua_senha
  
    SONAR_JDBC_URL=postgres://{USER}:{PASSWORD}@localhost:5432/{DB}
    SONAR_JDBC_USERNAME=seu_usuario
    SONAR_JDBC_PASSWORD=sua_senha

  - Inicie os containers do PostgreSQL e do SonarQube, executando o **Docker**

    ```bash
    docker-compose up -d
 
4. **Configurando o SonarQube local**

  - Dentro do arquivo **build.gradle** será necessário substituir as variavéis de acesso do Sonar. Pois as variaveis estão apontadas para o SonarClound.
  - **Observação**: Não comitar esse arquivo com essas mundanças.
  - login e senha padrão do sonarqube é "admin"
    
    ```bash
    sonar {
	    properties {
		    property "sonar.projectKey", "seu_project_key"
		    property "sonar.organization", "thebookclubdb"
		    property "sonar.host.url", "http://localhost:9000"
		    property "sonar.login", "seu_login"
		    property "sonar.password", "seu_password"
		    property "sonar.java.binaries", "${project.buildDir}/classes"
		    property "sonar.jacoco.reportPath", "build/reports/jacoco/test/jacocoTestReport.xml"
		    property "sonar.checkstyle.reportPath", "build/reports/checkstyle/main.html"
	    }
    }
    
  - Após o Docker iniciar, você pode acessar o SonarQube em http://localhost:9000.
  - Para executar a análise do SonarQube, use o seguinte comando:

    ```bash
    ./gradlew sonarqube

  - **Observação**:Será necessário configurar projeto localmente caso seja a primeira vez que utilize o sonarlocal.

## Executando o Projeto

5. **Instalação das Dependências**

  - Navegue até a pasta do projeto e execute:

    ```bash
    ./gradlew build
  
  - **Rodando o Aplicativo**: Para executar o projeto, utilize o seguinte comando:

    ```bash
    ./gradlew bootRun

6. **Relatórios do JaCoCo**
  
  - O JaCoCo é utilizado para gerar relatórios de cobertura de testes.
  - Para gerar o relatório, execute:

    ```bash
    ./gradlew clean test jacocoTestReport   // para limpar o relatório, testar e gerar novos relatórios
    ./gradlew jacocoTestReport    // para gerar relatório
    ./gradlw test jacocoTestReport // para testar e gerar relatório

  - **Acessando o Relatório**: O relatório HTML será gerado em **build/reports/jacoco/test/html/index.html**. Abra este arquivo em um navegador para visualizar o relatório.

7. **Checkstyle**

  - O Checkstyle é utilizado para verificar a conformidade do código com as regras de estilo.
  - Executando Checkstyle: Para rodar o Checkstyle, utilize o seguinte comando:
  
    ```bash
    ./gradlew checkstyleMain
    ./gradlew checkstyleTest

  - Os resultados podem ser encontrados em **build/reports/checkstyle/checkstyle.html**. Abra este arquivo em um navegador para visualizar o relatório.
  - Os resultados também pode ser encotrados no próprio terminal de execução.

## BADGES 🚀 
 
**SonarCloud**: [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=TheBookClubDB_TheBookClub-Back&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=TheBookClubDB_TheBookClub-Back)
