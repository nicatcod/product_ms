package az.atl.producms.controller;

import az.atl.producms.model.request.SaveProductDto;
import az.atl.producms.model.response.ProductResponseDto;
import az.atl.producms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(productService.getResponseById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody SaveProductDto dto) {
        productService.saveProduct(dto);
        return ResponseEntity.status(CREATED).build();
    }

    @PostMapping("reduce/{id}")
    public ResponseEntity<Void> reduceProductCount(@PathVariable Long id, @RequestParam Integer count) {
        productService.reduceProductCount(id, count);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
