Feature: GET Cars API returns nine cars

  Scenario: EPCARS001 el inventario contiene un listado de nueve carros precargados
    Given url baseUrl + '/api/cars'
    When method get
    Then status 200
    And match response == '#[9]'
