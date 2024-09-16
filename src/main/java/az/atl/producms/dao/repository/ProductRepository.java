package az.atl.producms.dao.repository;

import az.atl.producms.dao.entity.ProductEntitye;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntitye,Long> {
}
