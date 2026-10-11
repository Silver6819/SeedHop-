# 🌌 SeedHop (Minecraft Mod)

**SeedHop** es un mod desarrollado para Minecraft Java (Fabric API) que revoluciona la forma en la que exploras el juego en solitario. Permite a los jugadores saltar entre mundos y semillas completamente diferentes sin perder su progreso, armaduras, herramientas ni niveles de experiencia.

---

## ✨ Características Principales

* **Persistencia Interdimensional:** Tu personaje conserva su inventario, puntos de vida, niveles y cofre de Ender al cambiar de semilla.
* **Interfaz de Servidor Virtual:** Conéctate a tus mundos locales escribiendo direcciones simuladas en la pestaña multijugador (por ejemplo, `play.deathban.es`).
* **Modo Híbrido Avanzado:**
  * **Offline (Sin Internet):** Genera la semilla localmente en tu dispositivo e inyecta réplicas de las construcciones de la comunidad en coordenadas exactas.
  * **Online (Con Internet):** Detecta el servidor central de la comunidad y te conecta en tiempo real con otros jugadores sincronizando tus recursos.
* **Comando de Viaje Rápido:** Utiliza el comando `/hop [dirección]` desde el chat para saltar a otra semilla sin necesidad de salir al menú principal.
* **Seguridad Integrada:** Sistema anti-duplicación con eliminación automática del caché temporal e inmunidad anti-asfixia al aparecer.

---

## 📁 Estructura del Proyecto

* `SeedHop.java`: El código fuente principal (Main) que inicializa el mod y registra los comandos de viaje.
* `InventoryManager.java`: El gestor de guardado seguro que cifra y empaqueta el inventario en formato NBT (`player_cache.dat`).
* `fabric.mod.json`: Archivo de configuración interna y metadatos del mod para Minecraft.

---

## 🚀 Cómo Empezar
1. Clona este repositorio o descarga el archivo comprimido.
2. Abre el proyecto en tu entorno de desarrollo favorito (IntelliJ IDEA o editores móviles como Jvdroid).
3. Compila el archivo utilizando Gradle para generar tu archivo `.jar`.
