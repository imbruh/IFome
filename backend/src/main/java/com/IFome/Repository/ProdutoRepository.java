package com.IFome.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IFome.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{

}
