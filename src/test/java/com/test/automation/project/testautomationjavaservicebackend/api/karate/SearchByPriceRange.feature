Feature: GET Search Cars By Price Range

  Scenario: searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroNoSuperaLos100Millones
    Given url baseUrl + '/api/search'
    And param initialPrice = 0.0
    And param finalPrice = 100000000.0
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroEstribaEntre100MillonesY200Millones
    Given url baseUrl + '/api/search'
    And param initialPrice = 100000000.0
    And param finalPrice = 200000000.0
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: searchCarsByPriceRange_DebeRetornarUnaListaConTresCarros_CuandoElPrecioDelCarroSupereLos200Millones
    Given url baseUrl + '/api/search'
    And param initialPrice = 200000000.0
    And param finalPrice = 1000000000.0
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: searchCarsByPriceRange_DebeRetornarUnaListaCon6Carros_CuandoElPrecioDelCarroSupereLos100Millones
    Given url baseUrl + '/api/search'
    And param initialPrice = 100000000.0
    And param finalPrice = 1000000000.0
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: searchCarsByPriceRange_DebeRetornarUnaListaVacia_CuandoElPrecioDelCarroSeaInferiorA50Millones
    Given url baseUrl + '/api/search'
    And param initialPrice = 0.0
    And param finalPrice = 50000000.0
    When method get
    Then status 200
    And match response == '#[0]'

  Scenario: searchCarsByPriceRange_DebeRetornarUnaListaCon9Carros_CuandoElPrecioDelCarroSupereLos50Millones
    Given url baseUrl + '/api/search'
    And param initialPrice = 50000000.0
    And param finalPrice = 1000000000.0
    When method get
    Then status 200
    And match response == '#[9]'

  Scenario: searchCarsByPriceRange_DebeLanzarUnIllegalArgumentException_CuandoElPrecioInicialDelCarroSupereAlPrecioFinalParaFiltrar
    Given url baseUrl + '/api/search'
    And param initialPrice = 1000000000.0
    And param finalPrice = 50000000.0
    When method get
    Then status 400
    And match karate.toString(response) contains "Bad Request"