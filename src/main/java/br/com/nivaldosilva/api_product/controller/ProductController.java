package br.com.nivaldosilva.api_product.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.nivaldosilva.api_product.dto.ProductDTO;
import br.com.nivaldosilva.api_product.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductDTO request){

    Optional<ProductDTO> response = productService.create(request);
    if (response.isPresent()) {
        return new ResponseEntity<>(response.get(),HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}


@GetMapping
public ResponseEntity<List<ProductDTO>> getAll(){
    return ResponseEntity.ok(productService.getAll()); 
}


@GetMapping("/{id}")
public ResponseEntity<ProductDTO> getById(@PathVariable("id") Long id){
     Optional<ProductDTO> response = productService.getById(id);

     if (response.isPresent()) {
        return ResponseEntity.ok(response.get());
     }
     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}

@PutMapping("/{id}")
public ResponseEntity<ProductDTO> update(@PathVariable("id") Long id,@RequestBody @Valid ProductDTO request){
    Optional<ProductDTO> response = productService.update(id, request);

    if (response.isPresent()) {
        return ResponseEntity.ok(response.get());
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> inactive(@PathVariable("id") Long id){
    boolean inactive = productService.inactive(id);
    return inactive
             ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
             : new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

}
