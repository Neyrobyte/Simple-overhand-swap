package nrb.overhandswap.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "handleInputEvents", at = @At("HEAD"))
    private void onHandleInputEvents(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null || client.options == null)
            return;

        // Если нажата клавиша swapHandsKey
        if (client.options.swapHandsKey.wasPressed()) {
            boolean isInventoryOpen = client.currentScreen instanceof HandledScreen;

            if (!isInventoryOpen) {
                // Блокировать действие, не вызывать interactionManage.swapItem()
                client.options.swapHandsKey.setPressed(false);

                // client.player.sendMessage(Text.literal("§cСвап в левую руку заблокирован"), true);
            }
        }
    }
}
