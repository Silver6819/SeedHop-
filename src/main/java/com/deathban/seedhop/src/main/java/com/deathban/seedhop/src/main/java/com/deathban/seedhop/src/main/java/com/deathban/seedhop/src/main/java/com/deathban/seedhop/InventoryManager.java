package com.deathban.seedhop;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import java.io.File;
import java.io.IOException;

public class InventoryManager {
    private static final String CACHE_PATH = "config/seedhop/player_cache.dat";

    public static void guardarInventarioTemporal(ServerPlayerEntity jugador) {
        try {
            File archivoCache = new File(CACHE_PATH);
            
            if (!archivoCache.getParentFile().exists()) {
                archivoCache.getParentFile().mkdirs();
            }

            NbtCompound datosJugador = new NbtCompound();
            datosJugador.putString("PlayerUUID", jugador.getUuidAsString());
            datosJugador.putInt("XPLevel", jugador.experienceLevel);
            datosJugador.putFloat("Health", jugador.getHealth());
            
            NbtCompound tagInventario = new NbtCompound();
            jugador.getInventory().writeNbt(tagInventario);
            datosJugador.put("InventoryData", tagInventario);

            NbtIo.writeCompressed(datosJugador, archivoCache);
            System.out.println("[SeedHop] Archivo caché guardado con éxito.");

        } catch (IOException e) {
            System.err.println("[SeedHop] Error al salvar inventario: " + e.getMessage());
        }
    }
}
