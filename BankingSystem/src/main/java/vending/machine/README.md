Read more: https://javarevisited.blogspot.com/2016/06/design-vending-machine-in-java.html#ixzz6PEdS1jsG

Read more: https://javarevisited.blogspot.com/2016/06/java-object-oriented-analysis-and-design-vending-machine-part-2.html#ixzz6PEpjK7AQ
 Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
 Allow user to select products Coke(25), Pepsi(35), Soda(45)
 Allow user to take refund by canceling the request.
 Return selected product and remaining change if any
 Allow reset operation for vending machine supplier.


Read more: https://javarevisited.blogspot.com/2016/06/design-vending-machine-in-java.html#ixzz6PEqUrzUK

1) High-level Design
Includes overview of the problem, not necessary if you are writing this as part of the test because evaluator should be familiar with problem specification. Important if your design document is intended for someone who is not very familiar with the problem domain.

    - Main interface, classes and Exceptions
          - VendingMachine - an interface which defines public API of VendingMachine
          - VendingMachineImpl - a general purpose implementation of VendingMachine interface
          - Inventory - A type-safe inventory for holding objects, which is an ADAPTER or WRAPPER over java.util.Map
          - Item - type-safe Enum to represent items supported by vending machine.
          - Coin - type-safe Enum to represent coins, which is acceptable by vending machine.
          - Bucket - A Holder class for holding two types together.
          - SoldOutException - thrown when user selects a product which is sold out
          - NotSufficientChangeException - thrown when Vending machine doesn't have enough change to support the current transaction.

          - NotFullPaidException - thrown when the user tries to collect an item, without paying the full amount.
     
    - Data structures used
          - Map data structure is used to implement cash and item inventories.
          - The List is used to returning changes because it can contain duplicates, i.e. multiple coins of the same denomination.

   
    - Motivation behind design decisions
         - Factory design pattern is used to encapsulate creation logic of VendingMachine.
         - Adapter pattern is used to create Inventory by wrapping java.util.Map
         - java.lang.Enum is used to represent Item and Coins, because of following benefits
                - compile time safety against entering an invalid item and invalid coin.
                - no need to write code for checking if selected item or entered coin is valid.
                - reusable and well encapsulated.
         - long is used to represent price and totalSales, which are the amount because we are dealing in cents.
           Not used BigDecimal to represent money, because the vending machine can only hold limited amount, due to finite capacity of coin inventory.

         -

2) Low Leven Design
    - Methods
        -  The getChange() method uses a greedy algorithm to find out whether we have sufficient coins to support an amount.

    - Initialization
         - When Vending Machine will be created, it's initialized with default cash and item inventory. current with quantity 5 for each coin and item.



2) Testing Strategy
   - Three primary test cases to testWithExactPrice(), testWithMorePrice() and testRefund() to cover general usecase.
   - Negative test cases like testing SoldOutException, NotSufficientChangeException or NotFullPaidException
   -

3) Benefits
   - The design uses Abstraction to create reusable, small classes which are easier to read and test.
   - Encapsulating Items and Coins on their respective class makes it easy to add new Coins and Items.
   - Inventory is general purpose class and can be used elsewhere, It also encapsulates all inventory operations.

4) Assumption
   - Vending Machine is single-threaded, only one user will operate at a time.
   - A call to reset() will reset item and balance i.e. make them zero.

Read more: https://javarevisited.blogspot.com/2016/06/java-object-oriented-analysis-and-design-vending-machine-part-2.html#ixzz6PEqCduLq