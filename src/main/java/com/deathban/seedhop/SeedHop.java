package com.deathban.seedhop; 

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import com.mojang.brigadier.arguments.StringArgumentType; 

public class SeedHop implements ModInitializer {
public static final String MOD_ID = "seedhop"; 

@Override
public void onInitialize() {
System.out.println("[SeedHop] Inicializando el puente interdimensional...");
// Registrar el comando /hop [direccion_virtual]
CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
    dispatcher.register(CommandManager.literal("hop")
        .then(CommandManager.argument("direccion", StringArgumentType.string())
            .executes(context -> {
                String direccion = StringArgumentType.getString(context, "direccion");
                
                // Notificar al jugador en el chat
                context.getSource().sendFeedback(() -> 
                    Text.literal("§d[SeedHop] Guardando inventario y saltando hacia: §a" + direccion), 
                    false
                );

                // Aquí el juego llama al gestor para empaquetar y cambiar de mundo
                ServerPlayerEntity jugador = context.getSource().getPlayer();
                if (jugador != null) {
                    InventoryManager.guardarInventarioTemporal(jugador);
                    // Lógica de desvío de servidor virtual
                }
                return 1;
            })
        )
    );
});

}

}

package com.deathban.seedhop; 
package com.deathban.seedhop; 

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import java.io.File;
import java.io.IOException; 

public class InventoryManager {
private static final String CACHE_PATH = "config/seedhop/player_cache.dat"; 

public static void guardarInventarioTemporal(ServerPlayerEntity jugador) { try { File archivoCache = new File(CACHE_PATH);

if (!archivoCache.getParentFile().exists()) { archivoCache.getParentFile().mkdirs(); } NbtCompound datosJugador = new NbtCompound(); datosJugador.putString("PlayerUUID", jugador.getUuidAsString()); datosJugador.putInt("XPLevel", jugador.experienceLevel); datosJugador.putFloat("Health", jugador.getHealth()); NbtCompound tagInventario = new NbtCompound(); jugador.getInventory().writeNbt(tagInventario); datosJugador.put("InventoryData", tagInventario); NbtIo.writeCompressed(datosJugador, archivoCache); System.out.println("[SeedHop] Archivo caché guardado con éxito."); } catch (IOException e) { System.err.println("[SeedHop] Error al salvar inventario: " + e.getMessage()); } 

}

} 


import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import java.io.File;
import java.io.IOException; 

public class InventoryManager {
private static final String CACHE_PATH = "config/seedhop/player_cache.dat"; 

public static void guardarInventarioTemporal(ServerPlayerEntity jugador) { try { File archivoCache = new File(CACHE_PATH);

if (!archivoCache.getParentFile().exists()) { archivoCache.getParentFile().mkdirs(); } NbtCompound datosJugador = new NbtCompound(); datosJugador.putString("PlayerUUID", jugador.getUuidAsString()); datosJugador.putInt("XPLevel", jugador.experienceLevel); datosJugador.putFloat("Health", jugador.getHealth()); NbtCompound tagInventario = new NbtCompound(); jugador.getInventory().writeNbt(tagInventario); datosJugador.put("InventoryData", tagInventario); NbtIo.writeCompressed(datosJugador, archivoCache); System.out.println("[SeedHop] Archivo caché guardado con éxito."); } catch (IOException e) { System.err.println("[SeedHop] Error al salvar inventario: " + e.getMessage()); } 

}

}
{
"schemaVersion": 1,
"id": "seedhop",
"name": "SeedHop",
"version": "1.0.0",
"description": "Viaja entre semillas locales usando direcciones de servidores virtuales con persistencia de inventario.",
"authors": [
"TuNombreOApodo"
],
"contact": {
"homepage": "https://github.com/"
},
"license": "MIT",
"environment": "*",
"entrypoints": {
"main": [
"com.deathban.seedhop.SeedHop"
]
},
"depends": {
"fabricloader": ">=0.15.0",
"minecraft": "~1.21",
"java": ">=21"
}
} 
