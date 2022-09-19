package com.web.banhang.controller;

import com.web.banhang.entity.Product;
import com.web.banhang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/creat")
    public ResponseEntity<Product> creatProduct(@RequestBody Product product){
        Product check = productRepo.findByNameProduct(product.getNameProduct());
        if (check != null){
            throw new StringIndexOutOfBoundsException("Đã có sản phẩm " + check.getNameProduct());
        }
        Product products = productRepo.save(product);
        return ResponseEntity.ok(products);

    }

    @GetMapping("")
    public List<Product> getAllProduct(){
       var ret = productRepo.findAll();
       return ret;
    }
    @GetMapping("/{id}")
    public Product getProductID(@PathVariable Integer id){
      Optional<Product> product = productRepo.findById(id);

      if (product.isPresent() == false){
          throw new EntityNotFoundException(" Không có sản phẩm nào có ID = " + id);
      }
      return product.get();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductID(@PathVariable Integer id){
        if (getProductID(id)==null){
            throw new EntityNotFoundException("Không có sản phầm nào có ID = " + id);
        }
        this.productRepo.deleteById(id);
        return "Thành công";
    }



//    @PutMapping("/update")
//    public Product updateProduct(@RequestBody Product product, @PathVariable Integer id){
//
//    }
}
