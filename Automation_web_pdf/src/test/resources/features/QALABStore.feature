# new feature
# Tags: optional

Feature: Tienda
    @validarPrecio
  Scenario: Validación del Precio de un Producto
      Given estoy en la página de la tienda
      And me logueo con mi direccion de correo electronico "maximopalaciosflo7@gmail.com" y clave "maximopal789"
      When navego a la categoría "Clothes" y subcategoría "Men"
      And hago click en la imagen del primer "Producto"
      And agrego "2" unidades del primer producto al carrito
      Then valido en el popup la confirmación del producto agregado "Producto añadido correctamente a su carrito de compra"
      And valido en el popup que el monto total sea "S/ 38.24"
      And hago click en Finalizar Compra
      When finalizo la compra
      Then valido el título de la página del carrito "CARRITO"
      And vuelvo a validar el cálculo de precios en el carrito que sea "S/ 38.24"