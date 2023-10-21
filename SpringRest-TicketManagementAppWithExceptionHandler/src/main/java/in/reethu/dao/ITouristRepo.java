package in.reethu.dao;

import org.springframework.data.repository.CrudRepository;

import in.reethu.model.Tourist;

public interface ITouristRepo extends CrudRepository<Tourist, Integer> {

}
