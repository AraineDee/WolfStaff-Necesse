import necesse.engine.network.PacketReader;
import necesse.engine.network.server.FollowPosition;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.summon.summonFollowingMob.attackingFollowingMob.AttackingFollowingMob;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.InventoryItem;
import necesse.inventory.PlayerInventorySlot;
import necesse.inventory.item.toolItem.summonToolItem.SummonToolItem;
import necesse.level.maps.Level;

public class WolfStaffToolItem  extends SummonToolItem {
    public WolfStaffToolItem() {
        super("wolfsummon", FollowPosition.WALK_CLOSE, 40, 0.0F, Rarity.RARE, 2.0F, 300);
    }

    public void runSummon(Level level, int x, int y, ServerClient client, int attackHeight, InventoryItem item, PlayerInventorySlot slot, int animAttack, int seed, PacketReader contentReader) {
        AttackingFollowingMob mob = (AttackingFollowingMob) MobRegistry.getMob("wolfsummon", level);
        this.summonMob(client, mob, x, y, attackHeight, item);
    }

    //I have no texture for this yet so Im using the wire texture as a stand-in
    @Override
    public void loadItemTextures(){this.itemTexture = GameTexture.fromFile("items/wire");}
}
