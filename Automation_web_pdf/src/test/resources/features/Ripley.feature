# new feature
# Tags: optional

Feature: Buscador de Productos
    @validarBusqueda
    Scenario: Validación de búsqueda de producto
        Given el usuario está en la página de inicio de Ripley
        When el usuario ingresa "Laptop" en el campo de búsqueda
        Then una lista de resultados
        And valido el primer precio del resultado sea "S/ 1,799"


