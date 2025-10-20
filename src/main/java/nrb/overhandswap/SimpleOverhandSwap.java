package nrb.overhandswap;
import net.fabricmc.api.ClientModInitializer;

public class SimpleOverhandSwap implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[SimpleOverhandSwap] Клиентский мод инициализирован.");
    }
}