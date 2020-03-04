package com.uanid.minecraft.event;

import com.uanid.minecraft.domain.entity.RpgStats;
import com.uanid.minecraft.service.StatsService;
import com.uanid.minecraft.domain.entity.StatsPlayer;
import com.uanid.minecraft.service.StatsRunService;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

//@TODO: Material에 묘목 분리된거 반영해야 함
public class BlockEventListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!event.isCancelled()) {
            StatsPlayer sp = StatsService.getStatsPlayer(event.getPlayer().getName());
            Material block = event.getBlock().getType();
            if (block == Material.COAL_ORE || block == Material.IRON_ORE || block == Material.GOLD_ORE || block == Material.DIAMOND_ORE || block == Material.REDSTONE_ORE
                    || block == Material.LAPIS_ORE) {
                for (RpgStats rs : StatsService.StatsSet.ORE) {
                    StatsRunService.BlockBreak(sp, rs, event);
                }
                return;
            }
            //TODO: 일단 빌드만 되게 수정, 나무 묘목들이 모든 타입을 반영하지 못하는 문제가 있음
            if (block == Material.WHEAT || block == Material.WHEAT || block == Material.MELON || block == Material.COCOA || block == Material.SAPLING || block == Material.POTATO || block == Material.CARROT) {
                for (RpgStats rs : StatsService.StatsSet.PLANTS) {
                    StatsRunService.BlockBreak(sp, rs, event);
                }
                return;
            }
            for (RpgStats rs : StatsService.StatsSet.BREAK) {
                StatsRunService.BlockBreak(sp, rs, event);
            }
        }
    }//밀, 감자, 당근, 수박

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.canBuild() && !event.isCancelled()) {
            StatsPlayer sp = StatsService.getStatsPlayer(event.getPlayer().getName());
            Material block = event.getBlock().getType();
            if (block == Material.WHEAT || block == Material.WHEAT || block == Material.MELON_SEEDS || block == Material.COCOA || block == Material.SAPLING) {
                for (RpgStats rs : StatsService.StatsSet.PLANTS) {
                    StatsRunService.BlockPlace(sp, rs, event);
                }
                return;
            }
            for (RpgStats rs : StatsService.StatsSet.PLACE) {
                StatsRunService.BlockPlace(sp, rs, event);
            }
        }
    }

}