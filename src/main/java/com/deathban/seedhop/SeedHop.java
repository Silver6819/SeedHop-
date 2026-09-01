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
