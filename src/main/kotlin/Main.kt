fun main(){
    println("Bienvenidos a Puerto Games")



    //Apply =  Me permite  configurar una lista y retornarla
    //Apply agregue  y retorne una lista de productos
    val productos = mutableListOf<Productos>().apply {
        add(Productos("A002", "Audifonos Gamer", "Accesorios", 49990.0, 10))
        add(Productos("A003", "Mouse Gamer", "Accesorios", 30000.0, 5))
        add(Productos("A004", "Play Station 2", "Consolas", 150000.0, 7))
        add(Productos("A005", "Sega Genesis", "Consolas", 100000.0, 3))
    }

    //Agregando con also una nueva peticion
    productos.also {
        println("Catalogo creado con ${it.size} productos")
    }

    println("Catalogo completo de la tienda")
    //WITH nos permite trabajar con un objeto sin repetir su nombre
    //mostrar la lista con un agregado
    with(productos){
        println(this)
        println("Cantidad de productos con with: ${size}\n")

        forEach { producto ->
            println("Codigo: ${producto.id}\n" +
                    "Nombre: ${producto.nombre}\n" +
                    "Categoria: ${producto.Categoria}\n" +
                    "Precio: ${producto.Precio}")
        }

    }

    println("Buscar productos")
    println("Ingresa el Codigo a buscar: ")
    val idBuscar = readln()

    //find va a devolver el producto encontrado, devuelve un null

    val productoEncontrado = productos.find{
        it.id.equals(idBuscar)
    }

    productoEncontrado?.let {
        println("Producto encontrado: ${it.nombre} (Stock actual: ${it.Stock})")

        println("Ingresa la cantidad a comprar: ")
        val cantidadComprar = readln().toIntOrNull() ?: 0


        if (it.Stock > 0) {
            it.Stock -= cantidadComprar
            val venta = it.run {

                "Venta de $cantidadComprar unidades del articulo $nombre realizada con exito.\nStock restante: $Stock"
            }

            println("\n--- COMPROBANTE ---")
            println(venta)

        } else {
            println("Error: No hay suficiente stock o la cantidad ingresada no es válida.")
        }

    } ?: println("Producto no encontrado, intenta con otro código.")


}
