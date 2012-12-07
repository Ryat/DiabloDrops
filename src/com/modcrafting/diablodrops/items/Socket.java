package com.modcrafting.diablodrops.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import com.modcrafting.diablodrops.DiabloDrops;
import com.modcrafting.skullapi.lib.Skull;
import com.modcrafting.skullapi.lib.Skull.SkullType;
import com.modcrafting.toolapi.lib.Tool;

public class Socket extends Tool
{

	public Socket(final Material mat)
	{
		super(mat);
		ChatColor color = null;
		switch (DiabloDrops.getInstance().gen.nextInt(3))
		{
			case 1:
				color = ChatColor.RED;
				break;
			case 2:
				color = ChatColor.BLUE;
				break;
			default:
				color = ChatColor.GREEN;
		}
		setName(color + "Socket Enhancement");
		addLore(ChatColor.GOLD + "Put in the bottom of a furnace");
		addLore(ChatColor.GOLD + "with another item in the top");
		addLore(ChatColor.GOLD + "to add socket enhancements.");
		if (mat.equals(Material.SKULL_ITEM))
		{
			Skull sk = new Skull(getHandle());
			SkullType type = SkullType.values()[DiabloDrops.getInstance().gen
					.nextInt(SkullType.values().length)];
			if (type.equals(SkullType.PLAYER))
				sk.setOwner(Bukkit.getServer().getOfflinePlayers()[DiabloDrops
						.getInstance().gen.nextInt(Bukkit.getServer()
						.getOfflinePlayers().length)].getName());
			else
				sk.setSkullType(type);
		}
	}
}
