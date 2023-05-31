Feature: Agendar cita
  Scenario: usuario ve los psicologos disponibles
    Given el paciente se encunetra en la plataforma
    When seleccione cita
    Then visualizara a los psicologos disponibles para agendar cita en la plataforma
  Scenario: usuario visualiza informacion de la cita
    Given el usuario se encuntra visualizando la informacion del psicologo
    When cuando haga click en horario disponible
    Then entonces vera la informacion de posible cita a agendar
  Scenario: usuario agenda cita exitosa
    Given el usuario en la visualizacion previa de la cita
    When selecciona el metodo de pago por la cita
    And presiona agendar
    Then la cita con el psicologo es agendada
  Scenario: usuario no agenda cita por saldo insuficiente
    Given el usuario en la visualizacion previa de la cita
    When selecciona el metodo de pago por la cita
    And presiona agendar
    And no cuenta con el dinero necesario en su cuenta bancaria
    Then el sistema muestra un mensaje "Error, saldo insuficiente"