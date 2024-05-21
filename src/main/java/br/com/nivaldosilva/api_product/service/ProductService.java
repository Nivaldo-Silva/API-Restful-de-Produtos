package br.com.nivaldosilva.api_product.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.nivaldosilva.api_product.dto.ProductDTO;
import br.com.nivaldosilva.api_product.model.ProductEntity;
import br.com.nivaldosilva.api_product.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

   @Autowired
   private ProductRepository productRepository;

   @Autowired
   private ModelMapper mapper;


    public Optional<ProductDTO> create(ProductDTO request){
       request.setAvailable(true);
       ProductEntity productEntity = mapper.map(request,ProductEntity.class);
       productRepository.saveAndFlush(productEntity);
       return Optional.of(mapper.map(productEntity, ProductDTO.class));       
    }

    

    public List<ProductDTO> getAll(){

        List<ProductEntity> products = productRepository.findAll();
        List<ProductDTO> responses = new ArrayList<>();
        for(ProductEntity productEntity: products){
            ProductDTO response = mapper.map(productEntity, ProductDTO.class);
            responses.add(response);
        }
        return responses;
    }


    public Optional<ProductDTO> getById(Long id){

   Optional<ProductEntity> product = productRepository.findById(id);
   if (product.isPresent()) {
       return Optional.of(mapper.map(product.get(), ProductDTO.class));        
        }

        return Optional.empty();
    }


    public Optional<ProductDTO> update(Long id, ProductDTO request){

    Optional<ProductEntity> product = productRepository.findById(id);
    if (product.isPresent()) {
        product.get().setDescription(request.getDescription());
        product.get().setPrice(request.getPrice());
        productRepository.save(product.get());
        return Optional.of(mapper.map(product.get(), ProductDTO.class));       
    }
    return Optional.empty();

    }


    public boolean inactive(Long id){
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
           product.get().setAvailable(false);
           productRepository.save(product.get());
           return true;
    }
    return false;

    }

}

