HashMap<String, Integer> prices = new HashMap<>();
    
        // insert entries to the HashMap
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        prices.forEach((key, value) -> {
            System.out.println(key + "=" + value + " ");
        });

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    numbers.forEach(x -> System.out.print(x));
    numbers.forEach(System.out::print);
