# Análisis previo del codelab Superheroes

Se leyeron los seis apartados, todos los fragmentos y las ocho imágenes del codelab en español. Se inspeccionó la rama main oficial en el commit a9a411c9b1494ca9109ada512ce899f67c90be1f. La copia de consulta está fuera del proyecto entregado y no aporta historial Git al proyecto nuevo.

| Apartado | Resultado y archivos | Verificación y etapa Git |
| --- | --- | --- |
| 1. Antes de comenzar | Lista de seis héroes; capturas finales clara y oscura como referencia visual. | Comparar la ejecución auténtica con ambas imágenes. |
| 2. Comenzar | Empty Activity, API mínima 24, paquete com.example.superheroes; Hero con dos StringRes y un DrawableRes; HeroesRepository; strings originales; seis vectores y launcher de Image assets.zip; Cabin regular y negrita. | Compilar e iniciar el proyecto inicial; commits independientes para inicio, recursos, modelo y repositorio. |
| 3. Temas de Material | Color.kt con 29 roles por tema; Shape.kt con 8/16/16 dp; Type.kt con Cabin, bodyLarge 16/24/0,5 sp y displayLarge 30 normal, displayMedium/displaySmall 20 negrita; Theme.kt con color dinámico desactivado. | Comprobar valores, fuentes y cambio del sistema; commits de colores, tipografía y formas/tema. |
| 4. Muestra la lista | HeroesScreen.kt, Card con elevación 2 dp y esquinas 16 dp, Row con padding 16 dp y altura mínima 72 dp, Column de texto con weight(1f), Spacer 16 dp, Box 72 dp con radio 8 dp e Image FillWidth/TopCenter. LazyColumn recibe colección y contentPadding; cada tarjeta lleva margen horizontal 16 dp y vertical 8 dp según la solución main y la captura final. | Verificar textos largos, asociación de imágenes y desplazamiento; commits separados para tarjeta y lista. |
| 5. Barra superior | MainActivity.kt con CenterAlignedTopAppBar, título displayLarge y Scaffold. Theme.kt incorpora setUpEdgeToEdge invocado mediante SideEffect: status transparente, navegación por nivel API, contraste de iconos y WindowCompat. | Revisar título, insets y contraste en claro/oscuro; commits de Scaffold y barras. |
| 6. Solución | Comparación con archivos oficiales, recursos, configuración Gradle y licencias. | Documentar diferencias indispensables; nunca subir la copia oficial como proyecto propio. |

## Decisiones de fidelidad

- La altura de 72 dp corresponde al contenido, con 16 dp de padding alrededor. Se usa sizeIn(minHeight) como la solución; fijar toda la tarjeta a 72 dp recortaría las descripciones.
- La lámina de padding muestra 8 dp junto a la separación; main aplica 8 dp a cada lado vertical del ítem (16 dp entre tarjetas). Se adopta main, que coincide con las capturas finales.
- main incorpora animaciones adicionales de entrada que no exige el codelab. La petición las prohíbe, por lo que no se incorporan.
- main usa enableEdgeToEdge y una configuración parcial en Theme.kt. La petición exige el método completo setUpEdgeToEdge del apartado 5; se implementa ese método.
- La versión Material 3 de la plantilla actual cambia valores predeterminados de superficies. Se fijarán los roles del codelab en las tarjetas y la barra para conservar la apariencia original.
- Los literales mostrados como `0 xFF` en la traducción se escriben como `0xFF` sin cambiar el color.
- Se continúa la plantilla creada por el usuario en App_Superheroes; se conserva su toolchain disponible, ajustando nombre, paquete y SDK mínimo al encargo.

## Fuentes

- https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-superheroes?hl=es-419
- https://github.com/google-developer-training/basic-android-kotlin-compose-training-superheroes/tree/a9a411c9b1494ca9109ada512ce899f67c90be1f
- Recursos descargados: Image assets.zip del repositorio oficial; Cabin distribuida por el proyecto oficial de Google (Google Fonts), con licencia SIL OFL incluida.
- Las imágenes de referencia se conservan únicamente en work/codelab para análisis; no se presentarán como evidencias de la implementación.
