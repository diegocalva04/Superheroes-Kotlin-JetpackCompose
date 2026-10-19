# Informe de validación

Fecha: 18 de octubre de 2026, America/Guayaquil.

## Entorno real

- Android Studio instalado; proyecto Empty Activity aportado por el usuario, ajustado a `com.example.superheroes` y API mínima 24.
- Gradle 9.5.0, AGP 9.3.3, complemento Compose 2.2.10, Compose BOM 2026.02.01, JDK 25 y SDK 37.
- Dispositivo físico Xiaomi 23100RN82L, Android 15/API 35, 720 × 1600 píxeles, densidad 320 dpi, escala de fuente 1, navegación de tres botones.
- La instalación por USB estuvo inicialmente restringida. Después de que el usuario la habilitó, ambos APK se instalaron y la aplicación inició correctamente. No se necesitó emulador.

## Resultados

| Prueba solicitada | Resultado y evidencia |
| --- | --- |
| 1. Sincronización y compilación | Aprobada. Android Studio sincronizó el proyecto y Gradle completó `assembleDebug` y `assembleDebugAndroidTest`. [Registro final](resultados/compilacion.txt). |
| 2. Inicio | Aprobada. Instalación real y arranque de `MainActivity` con `Status: ok`; capturas del teléfono. |
| 3. Seis superhéroes | Aprobada. Las pruebas recorren los seis nombres y descripciones originales; se inspeccionaron sus ilustraciones en las capturas de inicio y final. |
| 4. Desplazamiento | Aprobada. `performScrollTo` alcanza los seis elementos en ambos temas; desplazamiento manual hasta Yasmine con la descripción completa sobre la navegación. |
| 5. Tema claro | Aprobada. [Captura real](evidencias/modo-claro.png), prueba de paleta y recorrido de lista. |
| 6. Tema oscuro | Aprobada. [Captura real](evidencias/modo-oscuro.png), prueba de paleta y recorrido de lista. |
| 7. Barra superior | Aprobada. Prueba de centrado horizontal con tolerancia de 1 dp; título visible al final de la lista. La inspección visual confirma su alineación y tipografía. |
| 8. Barras del sistema | Aprobada en API 35. Estado y navegación cambian de contraste; el fondo continúa detrás de las barras. Al llegar al final, la última tarjeta queda por encima de la navegación. Se verificaron los insets del sistema. |
| 9. Adaptación de pantalla | Aprobada en el teléfono probado, en vertical y horizontal. La columna de texto crece sin superponerse a las imágenes; la lista admite desplazamiento con el espacio reducido. [Horizontal](evidencias/pantalla-horizontal.png). |
| 10. Comparación oficial | Realizada. Se inspeccionaron las capturas clara y oscura del codelab, las láminas de medidas, la lista sin barra y la barra superior. Coinciden paletas, Cabin, radios, elevación, ilustraciones y organización. Los saltos de línea varían por el ancho de 360 dp del teléfono y la navegación de tres botones. No se afirma igualdad de píxeles entre dispositivos distintos. |
| 11. Git | Historial incremental real, títulos y cuerpos en español, sin commits vacíos, sin fechas artificiales y sin importar el historial de Google. Revisión de `git diff`, `git status` y `git log` en las etapas. [Relación](HISTORIAL.md). |
| 12. GitHub | Aprobada. [Repositorio público](https://github.com/diegocalva04/Superheroes-Kotlin-JetpackCompose), rama principal `main`, acceso anónimo HTTP 200. Los 15 commits de la publicación inicial coinciden exactamente con el historial local; ambas referencias apuntaban a `0fa07455cab397356d3bf449811797c4cbee2026`. Este informe y las capturas de GitHub se incorporan en el commit posterior de verificación. |

## Pruebas automatizadas

La ejecución final en el teléfono terminó con **OK (6 tests)**, en 12,981 segundos:

- Contexto Android y paquete correcto, prueba de la plantilla.
- Lectura y desplazamiento por los seis héroes en modo claro.
- Lectura y desplazamiento por los seis héroes en modo oscuro.
- Título centrado horizontalmente.
- Paleta clara oficial con color dinámico desactivado.
- Paleta oscura oficial con color dinámico desactivado.

Se usó AndroidJUnitRunner sobre los APK instalados mediante ADB. [Salida íntegra de la ejecución final](resultados/pruebas-instrumentadas.txt).

`testDebugUnitTest` ejecutó la comprobación básica de la plantilla: 1 prueba y 0 fallos. No se presenta como cobertura funcional de la aplicación.

`lintDebug` terminó con **0 errores y 10 advertencias**: seis por las dimensiones intrínsecas de los vectores oficiales y cuatro sugerencias de actualización de herramientas/dependencias. Se mantuvieron los gráficos originales y las versiones de la plantilla que ya compilan y funcionan. No se desactivaron comprobaciones de lint. [Informe](resultados/lint.txt).

## Recursos y fidelidad

- Los seis XML usados coinciden byte por byte con los extraídos de `Image assets.zip` oficial.
- Los dos TTF coinciden con los distribuidos en la solución oficial de Google; se incorporó la licencia Cabin de Google Fonts.
- Se comprobaron los 58 valores de color contra `Color.kt` de la referencia oficial: sin diferencias.
- Se conservaron nombres y descripciones en inglés. Se usaron las anotaciones de recursos, las formas de 8/16/16 dp, Cabin y los cuatro estilos del tutorial.
- `setUpEdgeToEdge` corresponde al apartado 5, con los literales hexadecimales corregidos a sintaxis Kotlin válida.
- Las tarjetas fijan explícitamente los roles de color originales porque los valores predeterminados de Material 3 evolucionaron. No se añadieron animaciones, botones ni otras funciones.

## Incidencias resueltas

1. Al reducir el mínimo de la plantilla de API 32 a 24, los iconos adaptativos ubicados en `mipmap-anydpi` impedían enlazar los recursos. Se movieron a `mipmap-anydpi-v26`; la compilación inicial pasó después del cambio.
2. Se adaptaron la fábrica de colores de la barra y los destinos de anotaciones para eliminar advertencias de APIs/Kotlin recientes.
3. Un primer análisis lint encontró una excepción interna al analizar las pruebas antes de compilarlas. Después de compilar el APK de pruebas, el análisis completo y su repetición final finalizaron correctamente.
4. Se retiraron los colores sin uso y la etiqueta redundante que lint detectó en la plantilla.

## Alcance y límites

La ejecución se probó en un teléfono API 35, en ambos temas y orientaciones. No se ejecutó en API 24–28 ni en otros fabricantes, tamaños de letra o modalidades de navegación. Esas variantes siguen pendientes de una matriz de dispositivos más amplia; la compatibilidad mínima está declarada y las ramas del codelab se conservaron y revisaron.

Se restauraron el modo nocturno automático y la orientación vertical originales del teléfono después de las capturas. Las evidencias son capturas auténticas de la aplicación y del editor; no son simulaciones ni imágenes del codelab.

## Publicación comprobada

Se creó el repositorio `diegocalva04/Superheroes-Kotlin-JetpackCompose` con visibilidad pública y se ejecutó el push real del historial completo. Se verificaron `visibility: PUBLIC`, la rama predeterminada `main`, la igualdad del SHA local/remoto, los 15 hashes publicados y los 71 archivos de la primera publicación. Una petición HTTP sin credenciales y la sesión del navegador sin iniciar sesión permitieron abrir el repositorio y su historial.

Las capturas [repositorio público](evidencias/github-repositorio.png) e [historial en español](evidencias/github-commits.png) documentan esa publicación inicial. Este commit de documentación añade la evidencia de publicación; por eso sus capturas muestran el commit inmediatamente anterior. La integridad final se comprueba de nuevo después de subir esta documentación.
