package ipfilter;

import ipfilter.model.Filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPFilterRepository extends JpaRepository<Filter, Long> {

	Filter findById(Integer id);

	Filter findByFilterContent(String filterContent);
}
