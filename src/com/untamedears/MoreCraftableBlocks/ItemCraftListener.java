/**
 *
 * @author Indivisible0
 * @modifier Pheenixm
 */
package com.untamedears.MoreCraftableBlocks;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ItemCraftListener implements Listener {
    public static MoreCraftableBlocks plugin;

    public ItemCraftListener(MoreCraftableBlocks instance) {
        plugin = instance;
    }

    // Create a method to handle/interact with crafting events.
    @EventHandler
    public void writtenBookItemCraft(CraftItemEvent event) {
        // Get the crafting inventory (3x3 matrix) used to craft the item.
        CraftingInventory craftingInventory = event.getInventory();

        // Get the index of the first (and only) Material.WRITTEN_BOOK used in
        // the recipe.
        int writtenBookIndex = craftingInventory.first(Material.WRITTEN_BOOK);

        // Makes sure the recipe contains a WRITTEN_BOOK.
        if (writtenBookIndex == -1) return;

        // ItemStack represention of the book to be cloned.
        ItemStack initialBook = craftingInventory.getItem(writtenBookIndex);
        ItemStack bookCopy = initialBook.clone();
        
        // Get the player's inventory.
        PlayerInventory playerInventory = event.getWhoClicked().getInventory();

        // Gets the index of the first INK_SACK in the recipe.
        int inkSackIndex = craftingInventory.first(Material.INK_SACK);
        // Gets the index of the first FEATHER in the recipe.
        int featherIndex = craftingInventory.first(Material.FEATHER);
        // Gets the index of the first BOOK in the recipe.
        int bookIndex = craftingInventory.first(Material.BOOK);

        // Makes sure the recipe doesn't contain an INK_SACK, FEATHER, and BOOK.
        if (inkSackIndex == -1 || featherIndex == -1 || bookIndex == -1) {
            HashMap<Integer, ? extends ItemStack> map = craftingInventory
                    .all(Material.BOOK_AND_QUILL);
            int amount = map.size();

            // Check only one BOOK_AND_QUILL is in the crafting matrix.
            if (amount != 2)
                return;

            // Adds the original book to the player's inventory.
            playerInventory.addItem(initialBook);

            // Sets the result of the craft to the copied books.
            event.setCurrentItem(bookCopy);
        }
    }

    // Create a method to handle/interact with crafting events.
    @EventHandler
    public void bookItemCraft(CraftItemEvent event) {
        // Get the crafting inventory (3x3 matrix) used to craft the item.
        CraftingInventory craftingInventory = event.getInventory();

        // Get the index of the first (and only) Material.WRITTEN_BOOK used in
        // the recipe.
        int bookIndex = craftingInventory.first(Material.BOOK_AND_QUILL);

        // Makes sure the recipe contains a WRITTEN_BOOK.
        if (bookIndex == -1) return;

        // ItemStack represention of the book to be cloned.
        ItemStack initialBook = craftingInventory.getItem(bookIndex);
        ItemStack bookCopy = initialBook.clone();
        
        // Get the player's inventory.
        PlayerInventory playerInventory = event.getWhoClicked().getInventory();

        // Gets the index of the first INK_SACK in the recipe.
        int inkSackIndex = craftingInventory.first(Material.INK_SACK);
        // Gets the index of the first FEATHER in the recipe.
        int featherIndex = craftingInventory.first(Material.FEATHER);
        // Gets the index of the first BOOK in the recipe.
        int normalBookIndex = craftingInventory.first(Material.BOOK);

        // Makes sure the recipe doesn't contain an INK_SACK, FEATHER, and BOOK.
        if (inkSackIndex == -1 || featherIndex == -1 || normalBookIndex == -1) {
            HashMap<Integer, ? extends ItemStack> map = craftingInventory
                    .all(Material.BOOK_AND_QUILL);
            int amount = map.size();

            // Check only one BOOK_AND_QUILL is in the crafting matrix.
            if (amount != 2)
                return;

            // Adds the original book to the player's inventory.
            playerInventory.addItem(initialBook);

            // Sets the result of the craft to the copied books.
            event.setCurrentItem(bookCopy);
        }
    }
}