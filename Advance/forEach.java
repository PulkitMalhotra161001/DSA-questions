HashMap<String, Integer> prices = new HashMap<>();
    
        // insert entries to the HashMap
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        prices.forEach((key, value) -> {
            System.out.println(key + "=" + value + " ");
        });
