import necesse.engine.localization.Localization;
import necesse.engine.network.PacketReader;
import necesse.engine.network.server.FollowPosition;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.summon.summonFollowingMob.attackingFollowingMob.AttackingFollowingMob;
import necesse.gfx.gameFont.FontManager;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTooltips.GameTooltips;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.gfx.gameTooltips.StringTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.PlayerInventorySlot;
import necesse.inventory.item.toolItem.summonToolItem.SummonToolItem;
import necesse.level.maps.Level;

public class WolfStaffToolItem  extends SummonToolItem {
    public WolfStaffToolItem() {
        super("wolfsummon", FollowPosition.WALK_CLOSE, 40, 0.0F, Rarity.RARE, 2.0F, 300);
        this.drawMaxSummons = false;
    }

    public void runSummon(Level level, int x, int y, ServerClient client, int attackHeight, InventoryItem item, PlayerInventorySlot slot, int animAttack, int seed, PacketReader contentReader) {
        AttackingFollowingMob mob = (AttackingFollowingMob) MobRegistry.getMob("wolfsummon", level);
        this.summonMob(client, mob, x, y, attackHeight, item);
    }

    public void draw(InventoryItem item, PlayerMob perspective, int x, int y, boolean inInventory) {
        super.draw(item, perspective, x, y, inInventory);
        if (inInventory) {
            int maxSummons = this.getMaxSummons(item, perspective)/2;
            if (maxSummons > 999) {
                maxSummons = 999;
            }

            if (maxSummons != 1) {
                String amountString = String.valueOf(maxSummons);
                int width = FontManager.bit.getWidthCeil(amountString, tipFontOptions);
                FontManager.bit.drawString((float)(x + 28 - width), (float)(y + 16), amountString, tipFontOptions);
            }
        }

    }

    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective);
        tooltips.remove(0);
        tooltips.add(0, new StringTooltips("Wolf Staff", this.getRarityColor()));

        //tooltips.removeLast();
        int maxSummons = this.getMaxSummons(item, perspective)/2;
        if (maxSummons != 1) {
            tooltips.add(Localization.translate("itemtooltip", "summonslots", "count", maxSummons));
        }

        return tooltips;
    }
}
