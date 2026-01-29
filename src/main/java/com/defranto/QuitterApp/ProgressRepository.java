package com.defranto.QuitterApp;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends ListCrudRepository<Progress, Integer> {
	
}
