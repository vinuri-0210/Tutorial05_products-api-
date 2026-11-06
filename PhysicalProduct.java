package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it has an id, name and price like any product, and just adds weight and dimension.
// A ShoppingCart would NOT pass this test because a cart is not a kind of product; it HAS products (HAS-A relationship).

public class PhysicalProduct extends Product implements Discountable{

    private double discountedPrice;
    private double weightKg;
    private String dimensions;

    // TODO (a): empty no-arg constructor for Jackson
    public PhysicalProduct(){

    }

    // TODO (b): full constructor.
    //           First line must be super(id, name, price);
    //           then assign this.weightKg and this.dimensions

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }


    // TODO (c): getWeightKg() and getDimensions()
    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | weight: " + getWeightKg() + "Kg";
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate,0.20);
        this.discountedPrice = getPrice()*(1-capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
