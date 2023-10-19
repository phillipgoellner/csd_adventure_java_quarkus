# Cupcake

## About this kata

Write a program that can build many cakes with many toppings like : "🧁 with 🍫 and 🥜 and 🍓". Each cake is composed of a base cake and zero or more toppings (order matters). Using the same topping multiple times is not allowed, any topping occurring more than once is silently ignored except its first instance.

The different bases are:
* Cupcake (Text is "🧁", price is 1.00€)
* Shortcake (Text is "🍰", price is 2.00€)

The toppings are:
* Chocolate (Text is "🍫", price is 0.10€)
* Nuts (Text is "🥜", price is 0.20€)
* Strawberry (Text is "🍓", price is 0.15€)

Write a function that returns the name of cake and a function that returns the price of cake. The price is composed of the base cake price and topping prices.

### Example in pseudocode

```
var myCake = Strawberry(Nuts(Chocolate(Cupcake())))
myCake.name() // returns "🧁 with 🍫 and 🥜 and 🍓"
myCake.price() // returns 1.45
```

### Possible test cases for the name function

    The name function should return "🧁"
    The name function should return "🍰"
    The name function should return "🧁 with 🍫"
    The name function should return "🍰 with 🍫"
    The name function should return "🍰 with 🍫 and 🥜"
    The name function should return "🍰 with 🥜 and 🍫"

### Possible test cases for the price function

    The price function should return 1€ for "🧁"
    The price function should return 2€ for "🍰"
    The price function should return 1.1€ for "🧁 with 🍫"
    The price function should return 2.1€ for "🍰 with 🍫"
    The price function should return 2.2€ for "🍰 with 🥜"
