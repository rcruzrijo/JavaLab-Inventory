package com.lab.inventory.service;

import com.lab.inventory.data.ProductRepository;
import com.lab.inventory.data.entity.Product;
import com.lab.inventory.util.exception.InvalidRequest;
import com.lab.inventory.util.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save (Product product){
        if (product.getDescription() == null || product.getDescription().isEmpty())
            throw new InvalidRequest("Description should not be empty");
        if (product.getSubCategory() == null)
            throw new InvalidRequest("SubCategory of the product should not be empty");
        if (product.getStockControl() == null)
            product.setStockControl(true);
        if (product.getAvailableQty() == null)
            product.setAvailableQty(BigDecimal.valueOf(0.00));
        if (product.getMinQty() == null)
            product.setMinQty(BigDecimal.valueOf(0.00));
        if (product.getMaxQty() == null)
            product.setMaxQty(BigDecimal.valueOf(9999999.00));
        product.setStatus("ACTIVE");

        return productRepository.save(product);
    }

    @Override
    public Product update (Product product) {
        return productRepository
                .findById(product.getId())
                .map(productDB -> {
                    productDB.setDescription(product.getDescription());
                    productDB.setSubCategory(product.getSubCategory());
                    productDB.setStockControl(product.getStockControl());
                    productDB.setAvailableQty(product.getAvailableQty());
                    productDB.setMinQty(product.getMinQty());
                    productDB.setMaxQty(product.getMaxQty());
                    return productRepository.save(productDB);
                }).orElseThrow(()->new NotFound("Product with ID: "+product.getId()+" Not Found!"));
    }

    @Override
    public Product updateStatus (Product product) {
        return productRepository
                .findById(product.getId())
                .map(productDB -> {
                    productDB.setStatus(product.getStatus());
                    return productRepository.save(productDB);
                }).orElseThrow(()->new NotFound("Product with ID: "+product.getId()+" Not Found!"));
    }

    @Override
    public Product patch (Integer id, Map<Object, Object> fields) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Product.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, product.get(), value);
            });
        };
        /*return product;*/
        return productRepository
                .findById(id).
                orElseThrow(()->new NotFound("Product with ID: "+id+" Not Found!"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllActive() {
        return productRepository.getByStatus("ACTIVE");
    }

    @Override
    public List<Product> getAllInactive() {
        return productRepository.getByStatus("INACTIVE");
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new NotFound("Product with id: "+id+" not Found"));

    }

    @Override
    public List<Product> getFiltered(Map<String, String> filters) {
        return productRepository.findAll()
                .stream().filter(product -> filterProduct(product, filters))
                .collect(Collectors.toList());
    }

    private boolean filterProduct(Product product, Map<String, String> filters){
        return filters.keySet().stream().allMatch(filter -> {
            final  String  filterValue = filters.get(filter);
            switch (filter){
                case "status": return filterValue.equals(product.getStatus());
                case "subCategory": return filterValue.equals(product.getSubCategory().getDescription());
                case "category": return filterValue.equals(product.getSubCategory().getCategory().getDescription());
                case "description": return filterValue.contains(product.getDescription());
            }
            return true;
        });
    }

}
