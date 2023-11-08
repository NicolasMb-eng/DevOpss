package tn.esprit.devops_project.controllers; 
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private IProductService productService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testAddProduct() throws Exception {
        Product product = new Product();
        product.setIdProduct(1L);
        product.setTitle("Sample Product");
        product.setPrice(10.0f);
        product.setQuantity(100);
        product.setCategory(ProductCategory.ELECTRONICS);

        when(productService.addProduct(any(), anyLong())).thenReturn(product);

        mockMvc.perform(post("/product/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"idProduct\": 1, \"title\": \"Sample Product\", \"price\": 10.0, \"quantity\": 100, \"category\": \"ELECTRONICS\" }")
        ).andExpect(status().isOk());
    }
}
