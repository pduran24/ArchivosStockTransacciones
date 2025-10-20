# Ejercicio: Procesador de Transacciones y Stock de Tienda

Una cadena de tiendas de electrónica necesita un sistema para consolidar las transacciones diarias (ventas y devoluciones) y generar un informe de estado de inventario al final del día.


## HU-01: Cargar el catálogo de productos
Como gestor de inventario, Quiero que el sistema lea el catálogo maestro de productos desde un fichero productos.csv, Para tener la información de referencia de cada artículo (ID, nombre, precio).

A tener en cuenta:

* El fichero productos.csv usa , como separador.

* Los campos son: productId, productName, category, unitPrice.

* El campo productName puede contener espacios.

## HU-02: Procesar las transacciones del día
Como analista de operaciones, Quiero que el sistema procese dos ficheros de transacciones: ventas.csv y devoluciones.csv, Para registrar todos los movimientos de stock.

A tener en cuenta:

* Ambos ficheros usan , como separador.

* Campos de ventas.csv: timestamp, productId, quantitySold, customerId.

* Campos de devoluciones.csv: timestamp, productId, quantityReturned, reason.

* El campo reason en devoluciones.csv es un texto libre que puede contener comas y otros caracteres, por lo que estará encerrado entre comillas dobles ("). (¡Aquí tienes un desafío de parseo similar al anterior!)

## HU-03: Generar el informe de estado de inventario
Como director de la tienda, Quiero que el sistema genere un informe final inventory_report.json, Para poder tomar decisiones de compra y evaluar el rendimiento de los productos.

A tener en cuenta:

* Se debe asumir que cada producto tiene un stock inicial de 100 unidades al empezar el día.

* Se debe calcular, para cada producto del catálogo:

* Unidades Vendidas Netas: Total de unidades vendidas menos total de unidades devueltas.

* Stock Final: 100 - Unidades Vendidas Netas.

* Ingresos Totales: Unidades Vendidas Netas * unitPrice del producto.

* Estado de Devoluciones: Marcar un producto como "REQUIERE_REVISION" si el total de unidades devueltas (quantityReturned) para ese producto es superior a 5. Si no, el estado es "OK".

* El fichero inventory_report.json debe ser una lista (array) de objetos JSON, donde cada objeto represente un producto con los cálculos realizados.

* Debes usar una librería como Jackson para generar el JSON, que debe estar bien formateado (pretty-printed).
