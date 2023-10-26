Feature: GET Search Cars By Brand

  Scenario: searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaBMW
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaKia
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Kia'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: searchCarsByBrands_DebeDevolver3Carros_CuandoSeFiltrePorLaMarcaPorche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Porche'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Kia'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Porche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Porche'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: searchCarsByBrands_DebeDevolver6Carros_CuandoSeFiltrePorLaMarcaKia_Y_Porche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Kia,Porche'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: searchCarsByBrands_DebeDevolver9Carros_CuandoSeFiltrePorLaMarcaBMW_Y_Kia_Y_Porche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Kia,Porche'
    When method get
    Then status 200
    And match response == '#[9]'

  Scenario: searchCarsByBrands_DebeDevolver9Carros_CuandoNoSeEspecifiqueNingunaMarca_DadoQuePorDefectoBuscaraLasTresDisponibles
    Given url baseUrl + '/api/searchBrands'
    And param brands = ''
    When method get
    Then status 200
    And match response == '#[9]'