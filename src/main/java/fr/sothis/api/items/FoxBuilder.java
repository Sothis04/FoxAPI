package fr.sothis.api.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FoxBuilder {

    private ItemStack itemStack;
    private String version = Bukkit.getServer().getVersion();

    public ItemStack toItemStack() {
        return itemStack;
    }

    public FoxBuilder(Skull skull) {
        itemStack = skull.getItemStack();
    }

    public FoxBuilder(Skull skull, int amount) {
        itemStack = skull.getItemStack();
        itemStack.setAmount(amount);
    }

    public FoxBuilder(Skull skull, short durability) {
        itemStack = skull.getItemStack();
        itemStack.setDurability(durability);
    }

    public FoxBuilder(Skull skull, int amount, short durability) {
        itemStack = skull.getItemStack();
        itemStack.setAmount(amount);
        itemStack.setDurability(durability);
    }

    public FoxBuilder(FoxBuilder novBuilder) {
        itemStack = novBuilder.toItemStack();
    }

    public FoxBuilder(FoxBuilder novBuilder, int amount) {
        itemStack = novBuilder.toItemStack();
        itemStack.setAmount(amount);
    }

    public FoxBuilder(FoxBuilder novBuilder, short durability) {
        itemStack = novBuilder.toItemStack();
        itemStack.setDurability(durability);
    }

    public FoxBuilder(FoxBuilder novBuilder, int amount, short durability) {
        itemStack = novBuilder.toItemStack();
        itemStack.setAmount(amount);
        itemStack.setDurability(durability);
    }

    public FoxBuilder(ItemStack itemstack) {
        itemStack = itemstack;
    }

    public FoxBuilder(ItemStack itemstack, int amount) {
        itemStack = itemstack;
        itemStack.setAmount(amount);
    }

    public FoxBuilder(ItemStack itemstack, short durability) {
        itemStack = itemstack;
        itemStack.setDurability(durability);
    }

    public FoxBuilder(ItemStack itemstack, int amount, short durability) {
        itemStack = itemstack;
        itemStack.setAmount(amount);
        itemStack.setDurability(durability);
    }

    public FoxBuilder(Material material) {
        itemStack = new ItemStack(material, 1);
    }

    public FoxBuilder(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
    }

    public FoxBuilder(Material material, short durability) {
        itemStack = new ItemStack(material, 1, durability);
    }

    public FoxBuilder(Material material, int amount, short durability) {
        itemStack = new ItemStack(material, amount, durability);
    }

    public ItemMeta getItemMeta() {
        return itemStack.getItemMeta();
    }

    public Material getType() {
        return itemStack.getType();
    }

    public short getDurability() {
        return itemStack.getDurability();
    }

    public FoxBuilder setItemMeta(ItemMeta itemMeta) {
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public FoxBuilder addEnchantment(Enchantment enchantment) {
        itemStack.addEnchantment(enchantment, 1);
        return this;
    }

    public FoxBuilder addEnchantment(Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return this;
    }

    public FoxBuilder addUnsafeEnchantement(Enchantment enchantment) {
        itemStack.addUnsafeEnchantment(enchantment, 1);
        return this;
    }

    public FoxBuilder addUnsafeEnchantement(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public boolean containsEnchantement(Enchantment enchantment) {
        return itemStack.containsEnchantment(enchantment);
    }

    public int getAmount() {
        return itemStack.getAmount();
    }

    public int getEnchantementLevel(Enchantment enchantment) {
        return itemStack.getEnchantmentLevel(enchantment);
    }

    public Map<Enchantment, Integer> getEnchantements() {
        return itemStack.getEnchantments();
    }

    public MaterialData getData() {
        return itemStack.getData();
    }

    public int getMaxStackSize() {
        return itemStack.getMaxStackSize();
    }

    public boolean hasItemMeta() {
        return itemStack.hasItemMeta();
    }

    public boolean isSimilar(ItemStack itemstack) {
        return itemStack.isSimilar(itemstack);
    }

    public FoxBuilder removeEnchantment(Enchantment enchantment) {
        itemStack.removeEnchantment(enchantment);
        return this;
    }

    public boolean equals(ItemStack itemstack) {
        return itemstack.equals(itemstack);
    }

    public FoxBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public FoxBuilder setData(MaterialData materialData) {
        itemStack.setData(materialData);
        return this;
    }

    public FoxBuilder setType(Material material) {
        itemStack.setType(material);
        return this;
    }

    public FoxBuilder setDurability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    public FoxBuilder setDisplayName(String name) {
        getItemMeta().setDisplayName(name);
        setItemMeta(getItemMeta());
        return this;
    }

    public FoxBuilder setUnbreakable() {
        getItemMeta().spigot().setUnbreakable(true);
        setItemMeta(getItemMeta());
        return this;
    }

    public FoxBuilder removeUnbreakable() {
        getItemMeta().spigot().setUnbreakable(false);
        setItemMeta(getItemMeta());
        return this;
    }

    public boolean isUnbreakable() {
        return getItemMeta().spigot().isUnbreakable();
    }

    public String getDisplayName() {
        return getItemMeta().getDisplayName();
    }

    public FoxBuilder setLore(List<String> lore) {
        getItemMeta().setLore(lore);
        setItemMeta(getItemMeta());
        return this;
    }

    public FoxBuilder setLore(String... lore) {
        getItemMeta().setLore(Arrays.asList(lore));
        setItemMeta(getItemMeta());
        return this;
    }

    public FoxBuilder addItemFlags(ItemFlag... itemFlag) {
        getItemMeta().addItemFlags(itemFlag);
        setItemMeta(getItemMeta());
        return this;
    }

    public Set<ItemFlag> getItemFlags() {
        return getItemMeta().getItemFlags();
    }

    public List<String> getLore() {
        return getItemMeta().getLore();
    }

    public boolean hasItemFlags(ItemFlag itemFlag) {
        return getItemMeta().hasItemFlag(itemFlag);
    }

    public boolean hasDisplayName() {
        return getItemMeta().hasDisplayName();
    }

    public boolean hasLore() {
        return getItemMeta().hasLore();
    }

    public FoxBuilder removeItemFlags(ItemFlag... itemFlag) {
        getItemMeta().removeItemFlags(itemFlag);
        setItemMeta(getItemMeta());
        return this;
    }
}
