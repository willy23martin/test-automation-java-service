# Construcción y Pruebas de Software: Proyecto Final Backend: 
# Servicio: test-automation-java-service 

## Description:
Este proyecto tiene como objetivo servir de Backend REST API para un Consesionario de Carros que ofrece las marcas Kia, BMW y Porche.

****

## Objectives:
- Realizar pruebas unitarias y de integración que permitan garantizar una cobertura mínima automática del 85% en setencia y branches.
- Configurar **GitHub Actions** para automatizar el **Continuous Integration (CI)** para cada Pull Request nuevo que incluya algún cambio funcional o hotfix.

****

### Technologies used:
- **Java 17** as a programming language with **maven**.
- **JUnit - Mockito**: Pruebas de componente.
- **Karate**: Pruebas de Integración.
- **JaCoCo**: Reporte de cobertura de código.

****

### How to test it?

- Abra el proyecto y ejecute ``` mvn clean install ```: verifique que los archivos de **target/site/jacoco/index.html** y **target/karate-reports/karate-summary.html** se encuentren disponibles para revisar los resultados de las pruebas de componente (unitarias) y de integración, respectivamente.
- Inicie el proyecto ejecutando el comando ``` mvn spring-boot:run ``` o ejecutando a la clase principal: [TestAutomationJavaServiceBackendApplication.java](src%2Fmain%2Fjava%2Fcom%2Ftest%2Fautomation%2Fproject%2Ftestautomationjavaservicebackend%2FTestAutomationJavaServiceBackendApplication.java)
- Cree un nuevo **Pull Request**, cambiando o añadiendo alguna funcionalidad con sus respectivas pruebas unitarias o de integración (carpeta [karate](src%2Ftest%2Fjava%2Fcom%2Ftest%2Fautomation%2Fproject%2Ftestautomationjavaservicebackend%2Fapi%2Fkarate)) y verifique que el **GitHub Action - CI** haya terminado de ejecutarse correctamente arrojando el resultado de cobertura de sentencia (líneas de código cubiertas por las pruebas).

******

### Results:
- Los resultados demuestran una cobertura del 85% en sentencia y de 75% en branches (ver reporte de JaCoCo).

![JaCoCo Report - 27102023.png](src%2Fmain%2Fresources%2FJaCoCo%20report%2FJaCoCo%20Report%20-%2027102023.png)

- Los reportes de Karate muestran las ejecuciones exitosas de las pruebas de integración para cada uno de los endpoints del backend:
  [karate-summary.html](karate-reports%2Fkarate-summary.html)

![Karate Report - 27102023.png](src%2Fmain%2Fresources%2FKarate%20Report%2FKarate%20Report%20-%2027102023.png)

#### Endpoint: GET /api/cars:
[com.test.automation.project.testautomationjavaservicebackend.api.karate.GetCars.html](karate-reports%2Fcom.test.automation.project.testautomationjavaservicebackend.api.karate.GetCars.html)

#### Endpoint: GET api/search?initialPrice=<>&finalPrice=<>
[com.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByPriceRange.html](karate-reports%2Fcom.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByPriceRange.html)

#### Endpoint: GET /api/searchBrands?brands=<>,<>,<>,…
[com.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByBrand.html](karate-reports%2Fcom.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByBrand.html)

![Karate Report - GET Search Cars By Brand - 27102023.png](src%2Fmain%2Fresources%2FKarate%20Report%2FKarate%20Report%20-%20GET%20Search%20Cars%20By%20Brand%20-%2027102023.png)

******
******
