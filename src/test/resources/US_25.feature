Feature: visualizar lista de pacientes
  Scenario: psicologo se encuentra a los pacientes satisfactoriamente
    Given el psicologo se encuentra en la bitacora de trabajo
    When haga click en Mis pacientes
    Then podrá visualizar una lista con informacion abreviada de los pacientes
  Scenario: psicologo se encuentra a los pacientes insatisfactoriamente
    Given el psicologo se encuentra en la bitacora de trabajo
    When haga click en Mis pacientes
    And no tenga buena señal de internet
    Then entonces visualizara un mensaje "Error intende de nuevo, por favor"