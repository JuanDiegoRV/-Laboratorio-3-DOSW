# -Laboratorio-3-DOSW
# Integrantes
Juan Diego Rodriguez Velasquez
Daniel Felipe Hueso
Maria Paula Rodriguez Muñoz



1 )¿Cuál es la diferencia principal entre una prueba unitaria y una prueba de integración E2E? 

Prueba unitaria:
Este tipo de prueba se centra en validar una parte muypequeña y aislada del sistema, normalmente una
función o un método dentro del código.
Su propósito es confirmar que cada "bloque" del software funciona de forma correcta por sí mismo, 
sin depender de otros módulos. Es como revisar si una pieza individual de un motor funciona antes de armarlo todo.
Ejemplo: probar que una función que suma dos números devuelve el resultado correcto en distintos casos.

Prueba de integración E2E (end-to-end):
En contraste, las pruebas E2E buscan validar el sistema en su conjunto, desde el 
inicio hasta el final, simulando la experiencia de un usuario real. Aquí no se prueba 
solo un bloque, sino cómo interactúan todos los componentes entre sí (base de datos, frontend, backend, APIs, etc.).
La idea es asegurar que todo el flujo funcione bien y entregue el resultado esperado.
Ejemplo: verificar que un usuario puede entrar a la aplicación, iniciar sesión, 
hacer una compra y recibir la confirmación correctamente.


2 ) En Scrum ¿Cuál es el propósito de la Sprint Retrospective y porque es crucial para la mejora continua del equipo? 
En Scrum, el propósito de la Sprint Retrospective es que el equipo reflexione sobre cómo
trabajó durante el Sprint que acaba de terminar, identificando qué cosas funcionaron bien
,qué dificultades se presentaron y qué mejoras se pueden implementar en el próximo Sprint. 
No se trata de evaluar el producto en sí (para eso está la Sprint Review), 
sino de analizar el proceso de trabajo y la colaboración del equipo.

3)Explique la diferencia entre una Épica, una Feature y una historia de Usuario. Proporcione un ejemplo 
de cada una si tenemos un sistema de streaming de video como lo es Netflix. 

las épicas, features e historias de usuario se diferencian por su nivel de detalle y alcance.
Una épica es una iniciativa amplia que representa un objetivo grande del producto y que no puede completarse
en un solo sprint. Por ejemplo, en un sistema como Netflix, una épica sería “implementar la personalización
de la experiencia de usuario”.

De esta épica se desprenden las features, que son funcionalidades específicas que permiten avanzar hacia ese objetivo. 
Un ejemplo sería “sistema de recomendaciones basadas en el historial de visualización”.
Finalmente, las historias de usuario son el nivel más detallado: necesidades concretas
escritas desde la perspectiva del usuario. Un ejemplo sería: “Como usuario, quiero recibir
sugerencias de películas similares a las que ya vi, para descubrir nuevo contenido que me pueda gustar”.

4) ¿Qué es una cobertura de Código (code coverage) y porque una cobertura del 100% no 
garantiza necesariamente que el software esté libre de errores? 

La cobertura de código mide qué porcentaje del código se ejecuta durante las pruebas. 
Aunque se alcance un 100%, esto no garantiza que el software esté libre de errores, 
ya que cubrir el código no implica haber probado todos los escenarios, condiciones
de borde o interacciones entre módulos. En otras palabras, la cobertura indica cantidad
de código probado,pero no asegura la calidad ni la ausencia de fallos lógicos.


5) ¿Qué ventajas tiene el uso de Planning Poker frente a otros métodos de estimación tradicional 
y como ayuda a mejorar la transparencia y compromiso del equipo? 

El Planning Poker ofrece ventajas frente a métodos de estimación tradicionales porque involucra a todo el equipo
en el proceso de estimar, evitando que una sola persona imponga su criterio. Al usar cartas en simultáneo,
se reducen sesgos de autoridad y se fomenta la participación equitativa, lo que suele llevar a estimaciones
más realistas y consensuadas. Además, promueve la transparencia, ya que cada miembro explica sus razones al
haber discrepancias, generando un entendimiento compartido del trabajo. También refuerza el compromiso, porque
las decisiones son tomadas en conjunto, aumentando la responsabilidad colectiva sobre el resultado del Sprint.

6) Menciona los valores de Scrum y explica cual consideras más difícil de aplicar en un equipo. 

Los cinco valores de Scrum son: Compromiso, Coraje, Enfoque, Apertura y Respeto. 
Estos valores guían la forma en que los equipos trabajan y colaboran para alcanzar sus objetivos.

De ellos, el que considero más difícil de aplicar en un equipo es la Apertura. 
Muchas veces, los miembros no se sienten cómodos compartiendo errores,
dudas o bloqueos por miedo a ser juzgados o a generar conflictos. 
Sin embargo, la apertura es fundamental para que haya confianza,
comunicación honesta y una mejora continua real. Cuando no se practica, 
los problemas tienden a ocultarse y el equipo pierde oportunidades de aprender y crecer.