Feature: lista de pacientes
  Scenario: visualizar psicologos
    Given el paciente se encuentra dentro de la plataforma
    When cuando presione el boton psicologos
    Then podra visualizar la seccion psicologos
  Scenario: visualizar psicologos desde la seccion psicologos
    Given el paciente se encuentra en la seccion psicologos
    When mire la pantalla
    Then podra visualizar todos los psicologos disponibles
  Scenario: visualizar informacion del psicologo
    Given el paciente se encuentra en la seccion psicologos
    When presione en el nombre de un psicologo
    Then podra visualizar un formulario con toda la informacion relevante del perfil del psicologo