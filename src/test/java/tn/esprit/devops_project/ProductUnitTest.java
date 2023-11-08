package tn.esprit.devops_project.entities;  // Spécifiez le package

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductEntity() {
        Product product = new Product();
        product.setIdProduct(1L);
        product.setTitle("Sample Product");
        product.setPrice(10.0f);
        product.setQuantity(100);
        product.setCategory(ProductCategory.ELECTRONICS);

        assertEquals(1L, (long) product.getIdProduct());
        assertEquals("Sample Product", product.getTitle());
        assertEquals(10.0f, product.getPrice(), 0.01); // Vérifiez avec une tolérance pour les nombres flottants
        assertEquals(100, product.getQuantity());
        assertEquals(ProductCategory.ELECTRONICS, product.getCategory());
    }
}
