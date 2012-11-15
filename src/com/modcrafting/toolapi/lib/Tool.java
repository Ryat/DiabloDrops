package com.modcrafting.toolapi.lib;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.ItemStack;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTagString;

import org.bukkit.Material;
import org.bukkit.craftbukkit.inventory.CraftItemStack;

public class Tool extends CraftItemStack implements ToolInterface
{
	private NBTTagCompound tag;

	public Tool(Material mat)
	{
		super(mat, 1);
		ItemStack mitem = this.getHandle();
		if (mitem.tag == null)
		{
			mitem.tag = new NBTTagCompound();
		}
		this.tag = mitem.tag;
	}

	public Tool(ItemStack item)
	{
		super(item);
		ItemStack mitem = this.getHandle();
		if (mitem.tag == null)
		{
			mitem.tag = new NBTTagCompound();
		}
		this.tag = mitem.tag;
	}

	public Tool(org.bukkit.inventory.ItemStack source) {
		super(((CraftItemStack) source).getHandle());
		ItemStack mitem = this.getHandle();
		if (mitem.tag == null)
		{
			mitem.tag = new NBTTagCompound();
		}
		this.tag = mitem.tag;
	}

	@Override
	public String getName()
	{
		NBTTagCompound nc = tag.getCompound("display");
		if (nc != null)
		{
			String s = nc.getString("Name");
			if (s != null)
				return s;
		}
		return null;
	}

	@Override
	public void setName(String name)
	{
		NBTTagCompound ntag = new NBTTagCompound();
		NBTTagString p = new NBTTagString(name);
		p.setName(name);
		p.data = name;
		ntag.set("Name", p);
		ntag.setString("Name", name);
		tag.setCompound("display", ntag);
	}

	@Override
	public Integer getRepairCost()
	{
		return tag.getInt("RepairCost");
	}

	@Override
	public void setRepairCost(Integer i)
	{
		tag.setInt("RepairCost", i);
	}

	@Override
	public void setLore(List<String> lore)
	{
		
		NBTTagCompound ntag = tag.getCompound("display");
		if(ntag==null) ntag = new NBTTagCompound("display");
		NBTTagList p = new NBTTagList("Lore");
		for (String s : lore)
		{
			p.add(new NBTTagString("", s));
		}
		ntag.set("Lore", p);
		tag.setCompound("display", ntag);
	}

	@Override
	public String[] getLore()
	{
		NBTTagList list = tag.getCompound("display").getList("Lore");
		ArrayList<String> strings = new ArrayList<String>();
		String[] lores = new String[] {};
		for (int i = 0; i < strings.size(); i++)
			strings.add(((NBTTagString) list.get(i)).data);
		strings.toArray(lores);
		return lores;
	}
	
	@Override
	public void setLore(String string) {
		NBTTagCompound ntag = tag.getCompound("display");
		if(ntag==null) ntag = new NBTTagCompound("display");
		NBTTagList p = new NBTTagList("Lore");
		p.add(new NBTTagString("", string));
		ntag.set("Lore", p);
		tag.setCompound("display", ntag);
	}
}
