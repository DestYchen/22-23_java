public class TestPractice16 {
    public static final String DIVIDER = "\n----------------------------------\n";

    public static void main(String[] args) {

        Order order_2 = new TableOrder();

        Order order = new InternetOrder();

        Drink water = new Drink("Water", "Much wet", DrinkEnumType.WATER, 5);
        Dish pelmeni = new Dish("Pelmeni", "Really hot", 5);
        Drink brandy = new Drink("One shot", "37.5%", DrinkEnumType.BRANDY, 9, 37.5);
        Dish pizza = new Dish("Pizza", "So round!", 20);
        Drink blackTea = new Drink("Tea", "So tasty", DrinkEnumType.BLACK_TEA, 2);

        Drink champagne = new Drink("Champagne", "Gaziki)", DrinkEnumType.CHAMPAGNE, 20, 20);
        Drink water_2 = new Drink("Water", "Much more wet", DrinkEnumType.WATER, 5);
        Drink vodka = new Drink("Vodka", "40%", DrinkEnumType.VODKA, 15, 40);
        Dish meat = new Dish("Meat", "Rare", 50);
        Dish pasta = new Dish("Pasta", "Bolognese", 15);

        order_2.add(champagne);
        order_2.add(water_2);
        order_2.add(vodka);
        order_2.add(meat);
        order_2.add(pasta);

        order.add(water);
        order.add(pelmeni);
        order.add(brandy);
        order.add(pizza);
        order.add(blackTea);

        System.out.println(DIVIDER + "Internet order:");
        //System.out.println(order.getCustomer());

        for (MenuItem item : order.getItems())
            System.out.println(item);

        System.out.println(DIVIDER + "Table order:");

        for (MenuItem item : order_2.getItems())
            System.out.println(item);

        System.out.println(DIVIDER + "Sorted by cost (descending):");

        for (MenuItem item : order.sortedItemsByCostDesc())
            System.out.println(item);

        System.out.println("Total cost: $" + order.costTotal());

        order.remove("Pelmeni");
        System.out.println(DIVIDER + "Removed Pelmeni, new total cost: $" + order.costTotal());

        System.out.println("As is:");

        for (MenuItem item : order.getItems())
            System.out.println(item);



        InternetOrdersManager manager = new InternetOrdersManager();
        manager.add(order);
        manager.add(order);

        TableOrdersManager manager_2 = new TableOrdersManager();
        manager_2.add(order_2, 1);

        System.out.println(DIVIDER + "Manager's first order's first item:\n\t" + manager.remove().getItems()[0]);
        System.out.println(DIVIDER + "Table manager's order cost summary:\n\t" + manager_2.ordersCostSummary());
    }
}
