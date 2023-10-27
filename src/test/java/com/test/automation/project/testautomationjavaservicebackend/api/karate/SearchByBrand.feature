Feature: GET Search Cars By Brand

  Scenario: EPSEARCHB001_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaBMW
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHB002_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaKia
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Kia'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHB003_searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaPorche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Porche'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHB004_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Kia'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: EPSEARCHB005_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Porche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Porche'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: EPSEARCHB006_searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaKia_Y_Porche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Kia,Porche'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: EPSEARCHB007_searchCarsByBrands_DebeDevolver9Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia_Y_Porche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Kia,Porche'
    When method get
    Then status 200
    And match response == '#[9]'

  Scenario: EPSEARCHB008_searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueNingunaMarca_DadoQuePorDefectoBuscaraLasTresDisponibles
    Given url baseUrl + '/api/searchBrands'
    And param brands = ''
    When method get
    Then status 200
    And match response == '#[9]'

  Scenario: EPSEARCHB009_searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueElParametroMarcas_DadoQuePorDefectoBuscaraLasTresDisponibles
    Given url baseUrl + '/api/searchBrands'
    When method get
    Then status 200
    And match response == '#[9]'