package io.github.pieter12345.voidworldgenerator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * VoidWorldGenerator class.
 * This is the main class that will be loaded by Bukkit.
 * @author P.J.S. Kools
 */
public class VoidWorldGenerator extends JavaPlugin {
	
	// getDefaultWorldGenerator will return this plugins generator.
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new VoidChunkGenerator();
	}
	
	private class VoidChunkGenerator extends ChunkGenerator {
		
		@Override
		public List<BlockPopulator> getDefaultPopulators(World world) {
			return Collections.<BlockPopulator>emptyList();
		}
		
		@Override
		public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
			ChunkData chunkData = super.createChunkData(world);
			
			// Set biome.
			for(int x = 0; x < 16; x++) {
				for(int z = 0; z < 16; z++) {
					biome.setBiome(x, z, Biome.PLAINS);
				}
			}
			
			// Return the new chunk data.
			return chunkData;
		}
		
		@Override
		public boolean canSpawn(World world, int x, int z) {
			return true;
		}
		
		@Override
		public Location getFixedSpawnLocation(World world, Random random) {
			return new Location(world, 0, 100, 0);
		}
	}
}
