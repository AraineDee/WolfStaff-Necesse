import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.SnowWolfMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import net.bytebuddy.asm.Advice;

import java.util.List;

@ModMethodPatch(target = SnowWolfMob.class, name = "getLootTable", arguments = {})
public class SnowWolfMobGetLootTablePatch {

    @Advice.OnMethodExit
    static void onExit(@Advice.This SnowWolfMob mob, @Advice.Return(readOnly = false)LootTable lootTable){
        lootTable = new LootTable(new ChanceLootItem(0.1F, "wolfstaff", 1));
    }
}
