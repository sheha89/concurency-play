package vending.machine;

import java.util.List;

/**
 * Decleare public API for Vending Machine
 * @author Shehan
 */
public interface VendingMachine {
    long selectItemAndGetPrice(Item item);
    void insertCoin(Coin coin);
    List<Coin> refund();
    Bucket<Item, List<Coin>> collectItemAndChange();
    void reset();
}
