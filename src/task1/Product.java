package task1;

import java.util.Objects;

public class Product {
    String name;
    int price;

    public Product(String name) {
        this.name = name;
        this.price = (int)(Math.random() * 100);
    }

    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + '}';
    }
}
