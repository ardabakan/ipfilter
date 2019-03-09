package ipfilter.service;

import ipfilter.IPFilterRepository;
import ipfilter.model.Filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	IPFilterRepository repository;

	@Override
	public boolean checkIfBlackListed(String ipAddress) {

		List<Filter> allFilters = repository.findAll();

		String tempFilterContent = null;
		// implemented a simple blacklist with startsWith
		for (Filter temp : allFilters) {

			tempFilterContent = temp.getFilterContent();

			if (ipAddress.startsWith(tempFilterContent)) {
				return true;
			}

		}

		return false;
	}

}
