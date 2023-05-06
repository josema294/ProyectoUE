package com.example.dameuncoctel.model

import com.example.dameuncoctel.R

class FakeDB {

    private var arraydeCocteles: ArrayList<FakeCoctelDC>

    init {
        arraydeCocteles = ArrayList()
        agregarCoctelesFDB()
    }

    fun getCocteles(): ArrayList<FakeCoctelDC> {


        return arraydeCocteles
    }

    private fun agregarCoctelesFDB() {
        arraydeCocteles.add(
            FakeCoctelDC(
                id = 1,
                nombre = "Mojito",
                foto = R.drawable.mojito, // Reemplazar con el ID de imagen correspondiente
                ingredientes = listOf("Ron", "Menta", "Azúcar", "Lima", "Agua con gas"),
                instrucciones = "Machacar la menta con el azúcar y el zumo de lima. Añadir hielo y verter el ron. Completar con agua con gas y remover."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 2,
                nombre = "Margarita",
                foto = R.drawable.margarita, // Reemplazar con el ID de imagen correspondiente
                ingredientes = listOf("Tequila", "Triple sec", "Zumo de lima", "Sal"),
                instrucciones = "Agitar el tequila, triple sec y zumo de lima con hielo. Verter en una copa con el borde escarchado con sal."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 3,
                nombre = "Cosmopolitan",
                foto = android.R.drawable.ic_menu_gallery, // Reemplazar con el ID de imagen correspondiente
                ingredientes = listOf("Vodka", "Triple sec", "Zumo de arándano", "Zumo de lima"),
                instrucciones = "Agitar todos los ingredientes con hielo y colar en una copa fría."
            )
        )


        arraydeCocteles.add(
            FakeCoctelDC(
                id = 4,
                nombre = "Piña Colada",
                foto = R.drawable.pinacolada,
                ingredientes = listOf("Ron", "Crema de coco", "Zumo de piña", "Hielo"),
                instrucciones = "Mezclar todos los ingredientes con hielo en una batidora y verter en un vaso grande."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 5,
                nombre = "Daiquiri",
                foto = R.drawable.daiquiri,
                ingredientes = listOf("Ron", "Zumo de lima", "Azúcar", "Hielo"),
                instrucciones = "Mezclar todos los ingredientes en una coctelera con hielo y agitar. Colar en una copa fría."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 6,
                nombre = "Gin Tonic",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Ginebra", "Tónica", "Hielo", "Rodaja de limón"),
                instrucciones = "Llenar un vaso con hielo, añadir ginebra y completar con tónica. Remover y adornar con una rodaja de limón."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 7,
                nombre = "Caipirinha",
                foto = R.drawable.caipirinha,
                ingredientes = listOf("Cachaça", "Azúcar", "Lima", "Hielo"),
                instrucciones = "Machacar la lima con el azúcar en un vaso. Añadir hielo picado y verter la cachaça. Remover."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 8,
                nombre = "Bloody Mary",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Vodka",
                    "Zumo de tomate",
                    "Zumo de lima",
                    "Salsa Worcestershire",
                    "Salsa picante",
                    "Sal",
                    "Pimienta",
                    "Hielo"
                ),
                instrucciones = "Mezclar todos los ingredientes en una coctelera con hielo y agitar. Colar en un vaso con hielo y decorar con una ramita de apio."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 10,
                nombre = "Whiskey Sour",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Whisky",
                    "Zumo de limón",
                    "Azúcar",
                    "Clara de huevo",
                    "Hielo"
                ),
                instrucciones = "Mezclar todos los ingredientes en una coctelera y agitar enérgicamente. Colar en un vaso con hielo."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 11,
                nombre = "Manhattan",
                foto = R.drawable.manhattan,
                ingredientes = listOf(
                    "Whisky",
                    "Vermut dulce",
                    "Amargo de Angostura",
                    "Cereza al marrasquino"
                ),
                instrucciones = "Mezclar el whisky, vermut y amargo en una coctelera con hielo. Agitar y colar en una copa fría. Adornar con una cereza."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 12,
                nombre = "Negroni",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Ginebra",
                    "Campari",
                    "Vermut dulce",
                    "Hielo",
                    "Rodaja de naranja"
                ),
                instrucciones = "Mezclar todos los ingredientes en un vaso con hielo. Remover y decorar con una rodaja de naranja."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 13,
                nombre = "Old Fashioned",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Whisky",
                    "Azúcar",
                    "Amargo de Angostura",
                    "Hielo",
                    "Cáscara de naranja"
                ),
                instrucciones = "Disolver el azúcar en una pequeña cantidad de agua en un vaso. Añadir hielo, whisky y amargo. Remover y adornar con la cáscara de naranja."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 14,
                nombre = "Mai Tai",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Ron",
                    "Curaçao de naranja",
                    "Licor de almendra",
                    "Zumo de limón",
                    "Hielo"
                ),
                instrucciones = "Mezclar todos los ingredientes en una coctelera con hielo y agitar. Colar en un vaso con hielo y decorar con una rodaja de limón."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 15,
                nombre = "Pisco Sour",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Pisco",
                    "Zumo de limón",
                    "Azúcar",
                    "Clara de huevo",
                    "Amargo de Angostura",
                    "Hielo"
                ),
                instrucciones = "Mezclar todos los ingredientes excepto el amargo en una coctelera con hielo y agitar. Colar en un vaso sin hielo y añadir unas gotas de amargo de Angostura por encima."
            )
        )


        arraydeCocteles.add(
            FakeCoctelDC(
                id = 16,
                nombre = "Tom Collins",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Ginebra",
                    "Zumo de limón",
                    "Azúcar",
                    "Agua con gas",
                    "Hielo"
                ),
                instrucciones = "Mezclar la ginebra, el zumo de limón y el azúcar en un vaso con hielo. Completar con agua con gas y remover."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 17,
                nombre = "Aperol Spritz",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Aperol",
                    "Prosecco",
                    "Agua con gas",
                    "Hielo",
                    "Rodaja de naranja"
                ),
                instrucciones = "Llenar un vaso con hielo, añadir Aperol, prosecco y agua con gas. Remover y decorar con una rodaja de naranja."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 18,
                nombre = "Sidecar",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Cognac", "Triple sec", "Zumo de limón", "Hielo"),
                instrucciones = "Mezclar todos los ingredientes en una coctelera con hielo y agitar. Colar en una copa fría."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 19,
                nombre = "Vesper",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Ginebra", "Vodka", "Lillet Blanc", "Hielo"),
                instrucciones = "Mezclar todos los ingredientes en una coctelera con hielo y agitar. Colar en una copa fría."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 20,
                nombre = "White Russian",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Vodka", "Licor de café", "Crema", "Hielo"),
                instrucciones = "Verter el vodka y el licor de café en un vaso con hielo. Añadir la crema por encima y remover."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 21,
                nombre = "Mint Julep",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Whisky", "Menta", "Azúcar", "Hielo picado"),
                instrucciones = "Machacar la menta con el azúcar en un vaso. Añadir hielo picado y verter el whisky. Remover."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 22,
                nombre = "Espresso Martini",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Vodka", "Licor de café", "Café espresso", "Azúcar", "Hielo"),
                instrucciones = "Mezclar todos los ingredientes en una coctelera con hielo y agitar. Colar en una copa fría."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 23,
                nombre = "French 75",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Ginebra", "Zumo de limón", "Azúcar", "Champán", "Hielo"),
                instrucciones = "Mezclar la ginebra, el zumo de limón y el azúcar en una coctelera con hielo y agitar. Colar en una copa y completar con champán."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 24,
                nombre = "Dark 'N' Stormy",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Ron oscuro", "Ginger beer", "Zumo de lima", "Hielo"),
                instrucciones = "Llenar un vaso con hielo, añadir el ron oscuro y completar con ginger beer. Remover y exprimir una rodaja de lima"
            )
        )


        arraydeCocteles.add(
            FakeCoctelDC(
                id = 25,
                nombre = "Bramble",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Ginebra",
                    "Zumo de limón",
                    "Azúcar",
                    "Licor de mora",
                    "Hielo"
                ),
                instrucciones = "Mezclar la ginebra, el zumo de limón y el azúcar en un vaso con hielo. Verter el licor de mora por encima y remover."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 26,
                nombre = "Amaretto Sour",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Amaretto",
                    "Zumo de limón",
                    "Azúcar",
                    "Clara de huevo",
                    "Hielo"
                ),
                instrucciones = "Mezclar todos los ingredientes en una coctelera con hielo y agitar enérgicamente. Colar en un vaso con hielo."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 27,
                nombre = "Long Island Iced Tea",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Vodka",
                    "Ginebra",
                    "Ron blanco",
                    "Tequila",
                    "Triple sec",
                    "Zumo de limón",
                    "Azúcar",
                    "Coca-Cola",
                    "Hielo"
                ),
                instrucciones = "Mezclar todos los ingredientes excepto la Coca-Cola en una coctelera con hielo y agitar. Colar en un vaso con hielo y completar con Coca-Cola."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 28,
                nombre = "Moscow Mule",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Vodka",
                    "Ginger beer",
                    "Zumo de lima",
                    "Hielo",
                    "Rodaja de lima"
                ),
                instrucciones = "Llenar un vaso con hielo, añadir vodka y zumo de lima. Completar con ginger beer y remover. Decorar con una rodaja de lima."
            )
        )
        arraydeCocteles.add(
            FakeCoctelDC(
                id = 29,
                nombre = "Sazerac",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf(
                    "Whisky",
                    "Azúcar",
                    "Amargo de Peychaud",
                    "Amargo de Angostura",
                    "Licor de anís",
                    "Cáscara de limón"
                ),
                instrucciones = "Enfriar un vaso y enjuagar con el licor de anís. Mezclar el whisky, el azúcar y los amargos en otro vaso con hielo y remover. Verter la mezcla en el vaso enjuagado con anís. Decorar con la cáscara de limón."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 30,
                nombre = "Bellini",
                foto = android.R.drawable.ic_menu_gallery,
                ingredientes = listOf("Puré de melocotón", "Prosecco"),
                instrucciones = "Verter el puré de melocotón en una copa de champán y llenar con Prosecco. Remover suavemente."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 31,
                nombre = "Martini",
                foto = R.drawable.martini,
                ingredientes = listOf("Ginebra", "Vermut seco", "Aceituna", "Hielo"),
                instrucciones = "Mezclar la ginebra y el vermut seco en una coctelera con hielo y agitar. Colar en una copa de cóctel fría. Decorar con una aceituna."
            )
        )

        arraydeCocteles.add(
            FakeCoctelDC(
                id = 32,
                nombre = "Virgin Piña Colada",
                foto = android.R.drawable.ic_menu_gallery, // Asegúrate de tener una imagen adecuada en tus recursos
                ingredientes = listOf("Jugo de Piña", "Crema de Coco", "Hielo", "Sin"),
                instrucciones = "En una batidora, añade hielo, jugo de piña y crema de coco. Mezcla hasta que esté suave. Sirve en un vaso grande, decora con una rodaja de piña y disfruta."
            )
        )


        // ... Agregar más cócteles siguiendo el mismo patrón
    }

}