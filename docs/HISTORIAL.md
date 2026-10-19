# Historial de desarrollo

Esta relación describe los commits de implementación, pruebas y documentación inicial. El commit que añade la verificación de publicación se consulta en el historial Git completo y en la relación final entregada fuera del repositorio. Todos los commits se crearon durante el desarrollo, sin fechas artificiales ni importación del historial oficial.
## 6d913d7 — chore: inicializar proyecto Android Superheroes con Kotlin y Jetpack Compose

Se registra la plantilla Empty Activity creada por el usuario en Android Studio y se adapta al paquete com.example.superheroes, nombre Superheroes y SDK mínimo API 24. Se conservan Kotlin, Compose, Material 3, el catálogo de versiones y el wrapper Gradle de la plantilla disponible.

Se excluyen configuración local, credenciales, cachés y compilaciones. Los iconos adaptativos se ubican en mipmap-anydpi-v26 para admitir API 24 y 25. La compilación inicial assembleDebug finalizó correctamente. El teléfono conectado rechazó la instalación por una restricción del dispositivo; el inicio todavía no se ha validado.

## a9fc215 — feat: incorporar imágenes oficiales e ícono de la aplicación Superheroes

Se extraen los seis vectores android_superhero1 a android_superhero6 y las capas del icono desde Image assets.zip del repositorio oficial. Se agregan los iconos oficiales para cada densidad, variantes redonda y adaptativa y el recurso de Play Store.

Se conservan los nombres de recursos, los avisos de autoría y las licencias Apache 2.0 y SIL OFL distribuidas por Google. Los recursos adaptativos permanecen limitados a API 26 o superior; API 24 y 25 utilizan iconos por densidad.

## be7210f — feat: crear modelo de datos Hero para representar los superhéroes

Se crea el paquete model y la clase de datos Hero. Sus tres propiedades enteras contienen identificadores de nombre, descripción e imagen, con anotaciones StringRes y DrawableRes para distinguir los tipos de recursos Android y facilitar su comprobación por las herramientas.

## d961e93 — feat: implementar repositorio con los seis héroes y sus recursos

Se incorpora HeroesRepository.heroes con los seis personajes y sus imágenes oficiales en el orden del codelab. strings.xml conserva exactamente los nombres y descripciones ingleses, sin traducciones ni textos incrustados en los componentes de interfaz.

Cada Hero relaciona un recurso de nombre, otro de descripción y el vector correspondiente. La colección queda disponible para construir la lista diferida.

## e7836d2 — feat: configurar paletas de colores para temas claro y oscuro

Color.kt incorpora los valores hexadecimales exactos de los 29 roles de cada paleta del codelab. Theme.kt conecta todos los roles a lightColorScheme y darkColorScheme y selecciona el esquema según el modo del sistema.

Se desactiva el color dinámico de forma predeterminada para conservar el aspecto de las capturas de Google. Se mantiene la opción explícita de colores dinámicos a partir de Android 12. Las formas y la tipografía se incorporarán en sus siguientes etapas.

## fec2bc4 — feat: incorporar tipografía Cabin y estilos Material Design 3

Se añaden Cabin Regular y Cabin Bold de la distribución oficial de Google del ejercicio, sin modificar los archivos de fuente. Se incluye la licencia SIL Open Font License y la atribución del proyecto Cabin obtenidas de Google Fonts.

Type.kt configura bodyLarge a 16 sp con altura de línea de 24 sp y espaciado de 0,5 sp; displayLarge a 30 sp normal y displayMedium y displaySmall a 20 sp en negrita, respetando los valores del codelab.

## 3db1616 — feat: configurar formas y tema visual de la aplicación Superheroes

Se crea Shape.kt con RoundedCornerShape: small de 8 dp y medium y large de 16 dp. SuperheroesTheme aplica conjuntamente las formas, Cabin y los esquemas claro y oscuro mediante MaterialTheme, manteniendo la selección del tema del sistema.

## 34e64ee — feat: implementar tarjetas de superhéroes con imágenes y estilos Material 3

HeroesScreen.kt incorpora HeroListItem con Card de elevación 2 dp y radio 16 dp. Row organiza una Column de textos, separación de 16 dp y una Box de imagen de 72 dp recortada con radio 8 dp; el padding interno es de 16 dp y la altura mínima del contenido de 72 dp.

El nombre utiliza displaySmall y la descripción bodyLarge. La imagen conserva su proporción con FillWidth y alineación superior. Los colores de superficie y contenido se fijan a los roles del codelab para conservar las capturas con la versión actual de Material 3. Se agregan vistas previas clara y oscura.

## a087cfc — feat: implementar lista desplazable de superhéroes mediante LazyColumn

Se crea HeroesList con LazyColumn y claves estables basadas en los recursos del nombre. La colección de seis héroes se representa en el orden del repositorio con márgenes horizontales de 16 dp y padding vertical de 8 dp por tarjeta, como la solución oficial.

La actividad reemplaza el saludo inicial por la lista sobre el fondo del tema. Se admiten contentPadding y Modifier para integrar la barra superior en la siguiente etapa, conservando el desplazamiento y la altura adaptable de las tarjetas.

## 69cb27d — feat: agregar barra superior y organizar la pantalla mediante Scaffold

Se incorpora SuperheroesApp con Scaffold y CenterAlignedTopAppBar. El título Superheroes queda centrado con displayLarge de Cabin; la barra utiliza el fondo y el color de texto del tema para coincidir con la referencia clara y oscura.

HeroesList recibe directamente el padding interno de Scaffold, evitando que las tarjetas queden debajo de la barra superior o de navegación. Se agregan vistas previas completas en ambos modos, sin acciones ni navegación adicionales.

## b0c144d — feat: configurar visualización de borde a borde y barras del sistema

SuperheroesTheme invoca setUpEdgeToEdge mediante SideEffect, siguiendo el apartado 5 del codelab. Se desactiva el ajuste automático de decorado, se hace transparente la barra de estado y se configura la navegación por versiones: transparencia desde API 29, velo claro para API 26 a 28 y oscuro para API 24 y 25.

WindowCompat selecciona iconos claros u oscuros según el tema del sistema. Se centraliza esta configuración en el tema y se elimina la llamada duplicada de la plantilla. Scaffold conserva los insets y el manifiesto utiliza Theme.Superheroes. Las APIs de color antiguas se mantienen por compatibilidad con las versiones solicitadas.

## 1bfea93 — fix: adaptar APIs y anotaciones a las herramientas actuales

Se reemplaza la fábrica obsoleta de colores de CenterAlignedTopAppBar por topAppBarColors sin alterar el aspecto. Las anotaciones de recursos de Hero declaran explícitamente sus destinos de parámetro y campo para eliminar la ambigüedad introducida por Kotlin reciente.

Se eliminan espacios finales de los archivos Gradle generados por la plantilla. Estos ajustes responden a las advertencias observadas durante la compilación y mantienen los componentes, valores y comportamiento del codelab.

## ec9fd70 — test: verificar lista completa, temas y título centrado en Compose

Se agregan cinco pruebas de interfaz: recorrido por los nombres y descripciones de los seis héroes en modo claro y oscuro, permanencia del título al final de la lista, posición horizontal del título y validación de los colores oficiales de fondo y tarjetas con color dinámico desactivado.

Las pruebas instrumentadas compilan correctamente. Después de compilar el APK de pruebas, lintDebug y testDebugUnitTest finalizan correctamente; el fallo interno previo del analizador no vuelve a presentarse. La ejecución en dispositivo se registra por separado cuando la instalación esté disponible.

## e8df830 — chore: retirar recursos de plantilla sin uso detectados por lint

Se elimina colors.xml con los colores morados y turquesas de Empty Activity, ya reemplazados por las paletas oficiales en Color.kt. Se retira la etiqueta redundante de la actividad, que hereda correctamente Superheroes de la aplicación.

Se conservan intactos los vectores oficiales aunque lint recomienda tamaños intrínsecos menores: se dibujan dentro de contenedores de 72 dp y modificarlos impediría conservar los recursos originales. Las sugerencias de actualización de dependencias se documentan sin cambiar el toolchain validado.

## 0fa0745 — docs: documentar implementación, pruebas y evidencias de Superheroes

Se incorporaron README, análisis de los seis apartados, atribuciones, relación del desarrollo e informe de validación. Se añadieron registros de compilación, lint y seis pruebas instrumentadas aprobadas, y capturas auténticas de la aplicación y de Android Studio.
