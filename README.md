## Descripción del problema abordado
El proyecto consiste en el desarrollo de una tienda virtual desde consola utilizando el lenguaje Java. El sistema permite registrar productos, agregarlos a un carrito de compras, aplicar descuentos dinámicos, procesar pagos mediante distintos métodos y notificar automáticamente eventos relacionados con la compra.
El principal objetivo es demostrar la implementación de patrones en un escenario realista de compras virtuales. Para ello, se utilizaron los patrones Strategy, Adapter y Observer, permitiendo que el sistema sea más flexible, mantenible y escalable.

El flujo principal de la aplicación es el siguiente:

1. Crear productos disponibles en la tienda.
2. Agregar productos al carrito de compras.
3. Mostrar los productos seleccionados.
4. Calcular el subtotal de la compra.
5. Aplicar descuentos dinámicos mediante estrategias.
6. Procesar pagos utilizando diferentes métodos.
7. Confirmar la compra.
8. Notificar automáticamente a los observadores registrados.

9. Además, se mejoró la presentación visual de la consola mostrando:
- listado de productos,
- subtotal,
- descuento aplicado,
- total final,
- procesamiento de pago,
- confirmación de compra,
- notificaciones automáticas.

- También se realizó un refactor en la lógica principal mediante el método `completeOrder()`, centralizando todo el flujo de compra dentro de `OrderService`, logrando un código más limpio y organizado.

  ## Strategy
El patrón Strategy se utilizó para aplicar diferentes tipos de descuentos en la compra. Gracias a este patrón, el sistema puede cambiar dinámicamente la estrategia de descuento sin modificar la lógica principal de la tienda.

## Adapter
El patrón Adapter permitió integrar el servicio externo de PayPal al sistema de pagos de la tienda. De esta manera, PayPal puede funcionar junto con otros métodos de pago utilizando una misma interfaz.

## Observer
El patrón Observer se utilizó para enviar notificaciones automáticas después de confirmar una compra. Los observadores se encargan de simular el envío de correos, actualización del inventario y notificaciones al administrador.

## Salida en Consola
<img width="410" height="607" alt="image" src="https://github.com/user-attachments/assets/a8d12c42-9db9-49f5-84c5-7c0dd9e6e52c" />

## Estructura del proyecto
<img width="496" height="924" alt="image" src="https://github.com/user-attachments/assets/c62fed49-0142-46fd-ae41-9d06ed06a5f3" />
